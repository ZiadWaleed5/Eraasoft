package service;


public interface ValidationService {
    public boolean isUserNameValid(String userName);
    public boolean isPasswordValid(String password);
    public boolean isPhoneNumberValid(String phoneNumber);
    public boolean isAgeValid(int age);
    }
