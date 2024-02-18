package com.teachMeSkills.lesson13.homework.task1_2.validator;

import com.teachMeSkills.lesson13.homework.task1_2.exception.WrongLoginException;

public class LoginValidator {

    public static boolean isLoginValid(String login) {
        char[] loginChars = login.toCharArray();

        try {
            isLoginLengthValid(loginChars);
        } catch (WrongLoginException e) {
            System.out.println("Unexpected login length.");
            return false;
        }

        try {
            isLoginLContainsSpace(loginChars);
        } catch (WrongLoginException e) {
            System.out.println("Login contains spaces.");
            return false;
        }

        return true;
    }

    private static void isLoginLengthValid(char[] login) throws WrongLoginException {
        if (login.length < 20 || login.length == 0) {
            System.out.println("User entered login with valid length.");
        } else {
            throw new WrongLoginException("Unexpected login length.");
        }
    }

    private static void isLoginLContainsSpace(char[] login) throws WrongLoginException {
        for (char c : login) {
            if (Character.isSpaceChar(c)) {
                throw new WrongLoginException("Login contains spaces.");
            }
        }
        System.out.println("User entered login without spaces.");
    }
}
