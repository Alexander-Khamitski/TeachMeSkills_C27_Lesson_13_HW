package com.teachMeSkills.lesson13.homework.task1_1.run;

import com.teachMeSkills.lesson13.homework.task1_1.service.RegistrationService;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Confirm password: ");
        String confirmPassword = scanner.nextLine();
        System.out.println("Is registration successful: " + RegistrationService.doRegistration(login, password, confirmPassword));
    }
}
