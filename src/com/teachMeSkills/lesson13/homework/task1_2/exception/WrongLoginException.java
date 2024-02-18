package com.teachMeSkills.lesson13.homework.task1_2.exception;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
