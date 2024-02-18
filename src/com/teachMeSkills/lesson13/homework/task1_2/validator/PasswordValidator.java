package com.teachMeSkills.lesson13.homework.task1_2.validator;

import com.teachMeSkills.lesson13.homework.task1_2.exception.WrongLoginException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isPasswordValid(String password, String confirmPassword) {
        char[] passwordChars = password.toCharArray();
        char[] confirmPasswordChars = confirmPassword.toCharArray();

        try {
            isPasswordLengthValid(passwordChars);
        } catch (WrongLoginException e) {
            System.out.println("Unexpected password length.");
            return false;
        }

        try {
            isPasswordContainsSpace(passwordChars);
        } catch (WrongLoginException e) {
            System.out.println("Password contains spaces.");
            return false;
        }

        try {
            isPasswordContainsNumbers(passwordChars);
        } catch (WrongLoginException e) {
            System.out.println("Password does not contain numbers.");
            return false;
        }

        try {
            isPasswordAndConfirmPasswordMatch(passwordChars, confirmPasswordChars);
        } catch (WrongLoginException e) {
            System.out.println("Password does not match confirm password value.");
            return false;
        }

        return true;
    }

    private static void isPasswordLengthValid(char[] password) throws WrongLoginException {
        if (password.length < 20 || password.length == 0) {
            System.out.println("User entered password with valid length.");
        } else {
            throw new WrongLoginException("Unexpected password length.");
        }
    }

    private static void isPasswordContainsSpace(char[] password) throws WrongLoginException {
        for (char c : password) {
            if (Character.isSpaceChar(c)) {
                throw new WrongLoginException("Password contains spaces.");
            }
        }
        System.out.println("User entered password without spaces.");
    }

    private static void isPasswordContainsNumbers(char[] password) throws WrongLoginException {
        for (char c : password) {
            if (Character.isDigit(c)) {
                System.out.println("User entered password with numbers.");
                return;
            }
        }
        throw new WrongLoginException("Password does not contain numbers.");
    }

    private static void isPasswordAndConfirmPasswordMatch(char[] password, char[] confirmPassword) throws WrongLoginException {
        if (password.length != confirmPassword.length) {
            throw new WrongLoginException("Password does not match confirm password value.");
        } else {
            for (int i = 0; i < password.length; i++) {
                if (password[i] != confirmPassword[i]) {
                    throw new WrongLoginException("Password does not match confirm password value.");
                }
            }
        }
        System.out.println("User confirmed password successfully.");
    }
}
