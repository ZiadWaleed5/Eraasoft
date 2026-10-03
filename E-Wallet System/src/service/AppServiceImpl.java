package service;

import exceptions.*;

import model.Account;

import java.util.Objects;
import java.util.Scanner;

public class AppServiceImpl implements AppService {
    private AccountServiceImpl accountService = new AccountServiceImpl();
    private ValidationServiceImpl validationService = new ValidationServiceImpl();
    private AccountFeaturesImpl accountFeatures = new AccountFeaturesImpl();
    Scanner s = new Scanner(System.in);

    public void start(){
        System.out.println("Azayk ya m3lm 3aml eh :)");
        int counter = 0;

        while(true) {
            System.out.println("pls choose");
            System.out.println("1.sign up   2.log in   3.exit  ");

            int choose = s.nextInt();
            s.nextLine();

            switch (choose) {
                case 1:
                    signUp(); // خد بالك انا حاطط ()logIn جوا ()signUp   عشان ال UX تكون احسن من غير م يعيد اللوب
                    break;
                case 2:
                    logIn();  //  لو عمل ()logIn يدخل بقي ع البروفايل علطول هتلاقي الميثود دي جو}
                    break;
                case 3:
                    System.out.println("enjooooooooy :):):)");
                    return;     // عشان يخرج برا الميثود كلها مش اللوب بس عشان كدا مكتبتش brea;
                default:
                    System.out.println("Invalid choice");
                    counter++;
            }

            if (counter==4) {
                System.out.println("b2alk sa3a 3mal tdos 8ld" );
                break;
            }
        }
    }

    private boolean signUp(){
        String userName = "";
        String password = "";
        String phoneNumber = "";
        int age = 0;

        while (true) {
            System.out.println("pls enter your username");
            userName = s.nextLine();
            try {
                if (validationService.isUserNameValid(userName))
                    break;
            } catch(InvalidUsernameException e){
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("pls enter your password");
            password = s.next();
            try {
                if (validationService.isPasswordValid(password))
                    break;
            } catch(WeakPasswordException e){
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("pls enter your phone number");
            phoneNumber = s.next();
            try {
                if (validationService.isPhoneNumberValid(phoneNumber))
                    break;
            } catch(InvalidPhoneNumberException e){
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("pls enter your age");
            age = s.nextInt();
            s.nextLine();

            try {
                if (validationService.isAgeValid(age))
                    break;
            } catch(UnderageException e){
                System.out.println(e.getMessage());
            }
        }

        Account acc = new Account(userName, password, phoneNumber, age);

        boolean isAccountCreated = accountService.createAccount(acc);

        if(isAccountCreated) {
            System.out.println("Pro your account is created successfully \npls log in");
            logIn();
            return true;
        }
        else {
            System.out.println("Sorry pro there is same username. pls change it");
            return false;
        }

    }

    private boolean logIn(){
        System.out.println("pls enter your username");
        String userName = s.nextLine();

        System.out.println("pls enter your password");
        String password = s.next();

        Account accountExist = accountService.accountExistByUserNameAndPassword(userName, password);

        if(! Objects.isNull(accountExist)) {

            if (!accountExist.isActive()) {
                System.out.println("Sorry, your account has been deactivated (Inactive).");
                return false;
            }

            if (accountExist.isAdmin()) {
                System.out.println("Welcome to the Admin Control Panel!");
                adminProfile();
                return true;
            }

            System.out.println("Hello Pro");
            accountExist.getHistory().add("Successful Login.");
            mainProfile(accountExist);
            return true;

        } else {
            System.out.println("Sorry username or password is wrong");
            return false;
        }
    }

    private void mainProfile(Account acc) {
        int counter = 0;
        while (true) {
            System.out.println("\n========== Main Menu ==========");
            System.out.println("[1] Deposit");
            System.out.println("[2] Withdraw");
            System.out.println("[3] Transfer");
            System.out.println("[4] Show Profile Details");
            System.out.println("[5] Show Transaction History");
            System.out.println("[6] Change Password");
            System.out.println("[7] Remove Account");
            System.out.println("[8] Logout");
            System.out.println("[9] Exit");
            System.out.println("===============================");

            System.out.println("Please choose an option:");
            int choice = s.nextInt();

            switch (choice) {
                case 1:

                    try {
                        accountFeatures.deposit(acc);

                    } catch(InvalidAmountException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    try {
                        accountFeatures.withdraw(acc);

                    } catch(InvalidAmountException | InsufficientBalanceException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    try {
                        accountFeatures.transfer(acc);

                    } catch(InvalidTransferException | AccountNotFoundException |
                            InvalidAmountException | InsufficientBalanceException e){

                        System.out.println(e.getMessage());
                    }

                    break;

                    /*

كنت ممكن تقول RuntimeException بدل م احدد كل دول بس اني احدد الحاجة احسن ك performance
                                 بدل م يدور ف كل الاكسبشنز اللي موجودة

                          catch(RuntimeException){
                                System.out.println(e.getMessage());
                  نفس ال output هيطلع بس كدا هدور ف كل الاكسبشنز عشان اشوف المناسب   }

                    */

                case 4:
                    accountFeatures.showProfileDetails(acc);
                    break;

                case 5:
                    accountFeatures.showTransactionHistory(acc);
                    break;

                case 6:

                    try {
                        accountFeatures.changePassword(acc);

                    } catch(WrongPasswordException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 7:
                    accountFeatures.removeAccount(acc);
                    return;

                case 8:
                    System.out.println("Logging out...");
                    return; // الـ return هنا هتقفل البروفايل وترجعك للقائمة الرئيسية بتاعتك
                case 9:
                    System.out.println("Exit");
                    System.exit(0); // الـ exit هنا هتقفل البروفايل و ال app كله مش هترجع لل ()start زي ال log out
                default:
                    System.out.println("Invalid choice, please try again.");
                    counter++;
            }

            if (counter ==4){
                    System.out.println("Ya3m ar7mny b2a w a5tar mn om el list t3btny m3ak");
                    break;
            }
        }
    }

    private void adminProfile() {
        while (true) {
            System.out.println("\n========== Admin Panel ==========");
            System.out.println("[1] View All Accounts");
            System.out.println("[2] Deactivate an Account (Inactive)");
            System.out.println("[3] Delete an Account");
            System.out.println("[4] Logout");
            System.out.println("=================================");

            System.out.println("Please choose an option:");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    accountFeatures.viewAllAccounts();
                    break;
                case 2:
                    accountFeatures.deactivateAccount();
                    break;
                case 3:
                    accountFeatures.deleteAccountByAdmin();
                    break;
                case 4:
                    System.out.println("Logging out from Admin Panel");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
