package com.teachmeskills.task_2.resource.model.authentication;

import com.teachmeskills.task_2.resource.exception.WrongLoginException;
import com.teachmeskills.task_2.resource.exception.WrongPasswordException;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private static final Map<String, String> users = new HashMap<>();

    public static boolean signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.contains(" ") || login.length() > 20) {
            throw new WrongLoginException("Wrong login ...");
        }
        if (password.contains(" ") || password.length() > 20 || !containsDigit(password)) {
            throw new WrongPasswordException("Wrong password...");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords mismatch...");
        }
        if (users.containsKey(login)) {
            throw new WrongLoginException("You are already signed up...");
        } else {
            users.putIfAbsent(login, password);
            return true;
        }
    }

    public static void displayUsers() {
        int counter = 0;
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(++counter + ". " + entry.getKey());
        }
    }

    private static boolean containsDigit(String password) {
        for (Character symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }
}