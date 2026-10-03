package service;

import exceptions.InvalidUsernameException;
import exceptions.WeakPasswordException;
import exceptions.InvalidPhoneNumberException;
import exceptions.UnderageException;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean isUserNameValid(String userName) {
        if (userName == null || userName.isBlank()) {
            throw new InvalidUsernameException("Username cannot be empty or null.");
        }

        if (userName.length() < 3) {
            throw new InvalidUsernameException("Username must be at least 3 characters long.");
        }

        if (!userName.matches("^[A-Z][a-zA-Z]*(?: [a-zA-Z]+)+$")) {
            throw new InvalidUsernameException("Username must start with an uppercase letter, contain only letters, and have exactly one space between names (e.g., 'Ziad Waleed').");
        }

        return true;
    }

    @Override
    public boolean isPasswordValid(String password) {
        if (password == null || password.isBlank()) {
            throw new WeakPasswordException("Password cannot be empty.");
        }

        if (password.length() < 8) {
            throw new WeakPasswordException("Password must be at least 8 characters long.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new WeakPasswordException("Password must contain at least one uppercase letter.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new WeakPasswordException("Password must contain at least one lowercase letter.");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new WeakPasswordException("Password must contain at least one number.");
        }

        return true;
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new InvalidPhoneNumberException("Phone number cannot be empty.");
        }

        if (!phoneNumber.startsWith("010") &&
                !phoneNumber.startsWith("011") &&
                !phoneNumber.startsWith("012") &&
                !phoneNumber.startsWith("015")) {
            throw new InvalidPhoneNumberException("Invalid Egyptian phone number. It must start with 010, 011, 012, or 015.");
        }

        return true;
    }

    @Override
    public boolean isAgeValid(int age) {
        if (age < 18) {
            throw new UnderageException("Age must be 18 or older to create an account.");
        }

        return true;
    }
}