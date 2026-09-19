package model;

public class Account {
    private boolean isAdmin;
    private boolean isActive;

    private String userName;
    private String password;
    private double balance;
    private String phoneNumber;
    private int age;

    public Account(String userName, String password, String phoneNumber, int age){
        setUserName(userName);
        setPassword(password);
        this.balance = 0.0;
        setPhoneNumber(phoneNumber);
        setAge(age);
        this.isAdmin = false;
        this.isActive = true;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }


    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }


    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }


    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }


    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setAdmin(boolean isAdmin){
    this.isAdmin = isAdmin;
    }
    public boolean isAdmin(){
        return isAdmin;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public boolean isActive(){
        return isActive;
    }

}
