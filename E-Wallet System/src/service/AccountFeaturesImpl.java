package service;
import exceptions.*;
import model.Account;
import model.EWalletSystem;
import java.util.Scanner;
import java.util.Optional;

public class AccountFeaturesImpl implements AccountFeatures {
    Scanner s = new Scanner(System.in);
    private EWalletSystem wallet = new EWalletSystem();

    public void deposit(Account acc){

        System.out.println("Enter your moneeeeey");
        double amount = s.nextDouble();

        if (amount < 100 || amount % 100 != 0)
            throw new InvalidAmountException("Error: Amount must be at least 100 and in multiples of 100.");

        double totalBalance = amount + acc.getBalance();

        acc.setBalance(totalBalance);

        System.out.println("Deposit successful! Your current balance is: " + acc.getBalance());
        acc.getHistory().add("Deposited: " + amount + " | New Balance: " + acc.getBalance());
    }

    public void withdraw(Account acc){

        System.out.println("Enter your moneeeeey");
        double amount = s.nextDouble();

        if (amount < 100 || amount % 100 != 0)
            throw new InvalidAmountException("Error: Amount must be at least 100 and in multiples of 100.");

        if (amount > acc.getBalance())
            throw new InsufficientBalanceException("Error: Insufficient balance! Your current balance is: " + acc.getBalance());

        double totalBalance = acc.getBalance() - amount ;

        acc.setBalance(totalBalance);

        System.out.println("Withdrawal successful! Your current balance is: " + acc.getBalance());
        acc.getHistory().add("Withdrew: " + amount + " | New Balance: " + acc.getBalance());
    }

    public void transfer(Account account){
        s.nextLine();

        System.out.println("enter the name you will transfer to:");
        String recievedName = s.nextLine();
        System.out.println("enter the phone number you will transfer");
        String recievedPhoneNumber = s.next();

        if (account.getUserName().equals(recievedName) || account.getPhoneNumber().equals(recievedPhoneNumber)) {
            throw new InvalidTransferException("Ant kda bthazr ya m3lm (You can't transfer to yourself)");
        }

        Optional <Account> recievedAccount = wallet.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(recievedName) && acc.getPhoneNumber().equals(recievedPhoneNumber))
                .findFirst();

        if (recievedAccount.isEmpty())
            throw new AccountNotFoundException("Error: Account not found! Please check the receiver's name and phone number.");

        System.out.println("enter the amount you will transfer");
        double amount = s.nextDouble();

        if (amount < 100 || amount % 100 != 0)
            throw new InvalidAmountException("Error: Amount must be at least 100 and in multiples of 100.");

        if (amount > account.getBalance())
            throw new InsufficientBalanceException("Error: Insufficient balance! Your current balance is: " + account.getBalance());

        double transferedBalance = account.getBalance() - amount;
        account.setBalance(transferedBalance);

        double recievedBalance = recievedAccount.get().getBalance() + amount;
        recievedAccount.get().setBalance(recievedBalance);

        System.out.println("Transfer successful! You sent " + amount + " to " + recievedName);
        System.out.println("Your current balance is: " + account.getBalance());

        // بنسجل العملية عند اللي بيبعت
        account.getHistory().add("Transferred: " + amount + " to " + recievedName);
        // وبنسجلها كمان عند اللي بيستقبل عشان لو فتح حسابه يلاقيها
        recievedAccount.get().getHistory().add("Received: " + amount + " from " + account.getUserName());

    }

    public void showProfileDetails(Account account){
        System.out.println("\n\n               Account Data");
        System.out.println("User name: "+ account.getUserName());
        System.out.println("Password:  "+ account.getPassword());
        System.out.println("Phone number:  "+ account.getPhoneNumber());
        System.out.println("Balance:  "+ account.getBalance());
        System.out.println("Age:  "+ account.getAge());

    }

    public void changePassword(Account account){
        ValidationServiceImpl validation = new ValidationServiceImpl();

        System.out.println("Enter your current password");
        String currentPassword = s.next();

        boolean isCurrentPassword = account.getPassword().equals(currentPassword);

        if (! isCurrentPassword)
            throw new WrongPasswordException("Error: Wrong current password");

        while(true) {

            System.out.println("Enter the new password");
            String newPasword = s.next();

            if (newPasword.equals(currentPassword)) {
                System.out.println("ya3ni ant 3ayz t8air el password f tktb el 2dem tany");
                continue; // دي هترجعه لأول اللوب عشان يطلب منه الباسورد الجديد تاني
            }

            try {

                validation.isPasswordValid(newPasword);
                account.setPassword(newPasword);
                System.out.println("Password changed successfully!");
                break;

            } catch (WeakPasswordException e) {

                System.out.println(e.getMessage());
            }
        }


    }

    public void removeAccount(Account account){

        System.out.println("Ant 3ayz tms7 el account bta3k a7r klam ??? (ah/la2)");
        String removal = s.next();

        if (removal.equals("la2"))
            return;

        wallet.getAccounts().remove(account);
        System.out.println("Account deleted successfully!");
    }


    public void viewAllAccounts() {
        System.out.println("\n\n     All Accounts in System ");
        for (Account acc : wallet.getAccounts()) {
            String role = acc.isAdmin() ? "ADMIN" : "USER";
            String status = acc.isActive() ? "Active" : "Inactive";
            System.out.println("Username: " + acc.getUserName() + " -> Role: " + role + " -> Status: " + status + " -> Balance: " + acc.getBalance());
        }
        System.out.println("\n\n");
    }

    public void deactivateAccount() {
        s.nextLine();
        System.out.println("Enter the username of the account to deactivate:");
        String targetUser = s.nextLine();

        Optional<Account> targetAccount = wallet.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(targetUser))
                .findFirst();

        if (targetAccount.isPresent()) {
            if (targetAccount.get().isAdmin()) {
                System.out.println("Error: You cannot deactivate an Admin account!");
                return;
            }
            targetAccount.get().setActive(false);
            System.out.println("Account '" + targetUser + "' has been deactivated successfully.");
        } else {
            System.out.println("Error: Account not found.");
        }
    }

    public void deleteAccountByAdmin() {
        s.nextLine();
        System.out.println("Enter the username of the account to delete:");
        String targetUser = s.nextLine();

        Optional<Account> targetAccount = wallet.getAccounts().stream()
                .filter(acc -> acc.getUserName().equals(targetUser))
                .findFirst();

        if (targetAccount.isPresent()) {
            if (targetAccount.get().isAdmin()) {
                System.out.println("Error: You cannot delete an Admin account!");
                return;
            }
            wallet.getAccounts().remove(targetAccount.get());
            System.out.println("Account '" + targetUser + "' has been deleted successfully.");
        } else {
            System.out.println("Error: Account not found.");
        }
    }

    public void showTransactionHistory(Account account) {
        System.out.println("\n--- Transaction History ---");
        if (account.getHistory().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : account.getHistory()) {
                System.out.println(transaction);
            }
        }
        System.out.println("---------------------------\n");
    }
}
