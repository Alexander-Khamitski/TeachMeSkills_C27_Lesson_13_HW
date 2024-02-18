package com.teachMeSkills.lesson13.homework.task1_2.exception;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
