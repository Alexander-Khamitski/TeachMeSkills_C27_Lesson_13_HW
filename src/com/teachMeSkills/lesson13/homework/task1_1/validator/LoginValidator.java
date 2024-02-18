package com.teachMeSkills.lesson13.homework.task1_1.validator;

import com.teachMeSkills.lesson13.homework.task1_1.exception.WrongLoginException;

public class LoginValidator {

    public static boolean isLoginValid(String login) {
        try {
            isLoginLengthValid(login);
        } catch (WrongLoginException e) {
            System.out.println("Unexpected login length.");
            return false;
        }

        try {
            isLoginLContainsSpace(login);
        } catch (WrongLoginException e) {
            System.out.println("Login contains spaces.");
            return false;
        }
        return true;
    }

    private static void isLoginLengthValid(String login) throws WrongLoginException {
        if (login.length() < 20 || login.length() == 0) {
            System.out.println("User entered login with valid length.");
        } else {
            throw new WrongLoginException("Unexpected login length.");
        }
    }

    private static void isLoginLContainsSpace(String login) throws WrongLoginException {
        if (!login.contains(" ")) {
            System.out.println("User entered login without spaces.");
        } else {
            throw new WrongLoginException("Login contains spaces.");
        }
    }
}
