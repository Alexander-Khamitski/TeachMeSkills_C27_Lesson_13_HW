package com.teachMeSkills.lesson13.homework.task1_1.validator;

import com.teachMeSkills.lesson13.homework.task1_1.exception.WrongLoginException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isPasswordValid(String password, String confirmPassword) {
        try {
            isPasswordLengthValid(password);
        } catch (WrongLoginException e) {
            System.out.println("Unexpected password length.");
            return false;
        }

        try {
            isPasswordContainsSpace(password);
        } catch (WrongLoginException e) {
            System.out.println("Password contains spaces.");
            return false;
        }

        try {
            isPasswordContainsNumbers(password);
        } catch (WrongLoginException e) {
            System.out.println("Password does not contain numbers.");
            return false;
        }

        try {
            isPasswordAndConfirmPasswordMatch(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Password does not match confirm password value.");
            return false;
        }
        return true;
    }

    private static void isPasswordLengthValid(String password) throws WrongLoginException {
        if (password.length() < 20 || password.length() == 0) {
            System.out.println("User entered password with valid length.");
        } else {
            throw new WrongLoginException("Unexpected password length.");
        }
    }

    private static void isPasswordContainsSpace(String password) throws WrongLoginException {
        if (!password.contains(" ")) {
            System.out.println("User entered password without spaces.");
        } else {
            throw new WrongLoginException("Password contains spaces.");
        }
    }

    private static void isPasswordContainsNumbers(String password) throws WrongLoginException {
        Pattern p = Pattern.compile("[1-9]");
        Matcher m = p.matcher(password);
        if (m.find()) {
            System.out.println("User entered password with numbers.");
        } else {
            throw new WrongLoginException("Password does not contain numbers.");
        }
    }

    private static void isPasswordAndConfirmPasswordMatch(String password, String confirmPassword) throws WrongLoginException {
        if (password.equals(confirmPassword)) {
            System.out.println("User confirmed password successfully.");
        } else {
            throw new WrongLoginException("Password does not match confirm password value.");
        }
    }
}
