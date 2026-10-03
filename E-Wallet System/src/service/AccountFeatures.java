package service;
import model.Account;

public interface AccountFeatures {
    public void deposit(Account acc);
    public void withdraw(Account acc);
    public void transfer(Account acc);
    public void showProfileDetails(Account account);
    public void changePassword(Account account);
    public void removeAccount(Account account);

    public void viewAllAccounts();
    public void deactivateAccount();
    public void deleteAccountByAdmin();

    public void showTransactionHistory(Account account);

}

