package model;
import java.util.List;
import java.util.ArrayList;


public class EWalletSystem {
    public final String walletName ="El-Z0Z Wallet";
    private static List<Account> accounts = new ArrayList<>();

    public String getName(){
        return walletName;
    }

    public void setAccounts(Account acc){
        accounts.add(acc);
    }

    public List<Account> getAccounts(){
        return accounts;
    }
}
