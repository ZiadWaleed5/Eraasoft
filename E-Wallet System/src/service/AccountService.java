package service;
import model.Account;


public interface AccountService {
    public boolean createAccount(Account account);
    public Account accountExistByUserNameAndPassword(String userName, String password);

}
