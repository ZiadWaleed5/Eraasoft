package service;
import model.EWalletSystem;
import model.Account;
import java.util.Optional;


public class AccountServiceImpl implements AccountService{

    private EWalletSystem wallet = new EWalletSystem();
    // عاملها private عشان محدش يقدر يغير اي حاجة زي مثلا ممكن يخلي ال balance ب مليون
    // و اصلا مكريت ال variable دا عشان احط الاكونتات الجديدة ف الليست بتاعة ال wallet


    public AccountServiceImpl() {
        Account admin = new Account("IAM", "IAM123", "01000000000", 30);
        admin.setAdmin(true);
        wallet.setAccounts(admin);
    }


    public boolean createAccount(Account account){
        //هنا بنشوف لو الاكونت جديد و مش موجود ف بكريته و بدخله ف الليست
        boolean isAccountExist = wallet.getAccounts().stream().anyMatch(acc -> acc.getUserName()
           .equals(account.getUserName()) || acc.getPhoneNumber().equals(account.getPhoneNumber()));

        if(! isAccountExist) {
            wallet.setAccounts(account);
            return true;
        }

        return false;
    }

    public Account accountExistByUserNameAndPassword(String userName, String password){
        // هنا بقي بتاكد ان الاكونت موجود معايا ف اليست ف الاسم و الباسورد
        Optional<Account> accountExist = wallet.getAccounts().stream().filter(acc -> acc.getUserName()
                .equals(userName) && acc.getPassword().equals(password)).findAny();

        if (accountExist.isPresent())
            return accountExist.get();

        return null;

    }
}
