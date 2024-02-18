package com.teachMeSkills.lesson13.homework.task1_1.service;

import com.teachMeSkills.lesson13.homework.task1_1.validator.LoginValidator;
import com.teachMeSkills.lesson13.homework.task1_1.validator.PasswordValidator;

public class RegistrationService {

    public static boolean doRegistration(String login, String password, String confirmPassword) {
        return LoginValidator.isLoginValid(login) && PasswordValidator.isPasswordValid(password, confirmPassword);
    }
}
