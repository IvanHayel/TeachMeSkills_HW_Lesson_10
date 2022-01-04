package com.teachmeskills.task_2;

import com.teachmeskills.task_2.resource.exception.AuthenticationException;
import com.teachmeskills.task_2.resource.model.authentication.Authentication;

/**
 * Create a class containing a static method.
 * (read and understand how a static method differs from a non-static method - discuss in the lesson if necessary)
 * This method takes three parameters as input:
 * login
 * password
 * confirmPassword
 * All fields are of the String data type.
 * Login must be less than 20 characters and must not contain spaces.
 * If login does not meet these requirements, a WrongLoginException should be thrown.
 * Password must be less than 20 characters long, must not contain a space, and must contain at least one digit.
 * Also password and confirmPassword must be equal.
 * If password does not meet these requirements, a WrongPasswordException must be thrown.
 * WrongPasswordException and WrongLoginException are custom exception classes with two constructors - one by default, the other taking the exception message and passing it to the constructor of the Exception class.
 * The method returns true if the values are correct or false otherwise.
 */

public class Task2 {
    public static void main(String[] args) {
        String correctLogin = "guest";
        String correctPassword = "Qwerty1";
        String wrongLogin = "D DOS";
        String wrongPassword = "31415926535897932384626433832795028841971693993751058209749445923078164062862";
        String anotherPassword = "somepassword12";

        signUp(correctLogin, correctPassword, correctPassword);
        signUp(wrongLogin, correctPassword, correctPassword);
        signUp(correctLogin, wrongPassword, wrongPassword);
        signUp(correctLogin, correctPassword, anotherPassword);
        signUp("Kali", "sudo12", "sudo12");
        signUp("Kali", "msf1", "msf1");

        System.out.println("\nList of users:");
        Authentication.displayUsers();
    }

    private static void signUp(String login, String password, String confirmPassword) {
        try {
            Authentication.signUp(login, password, confirmPassword);
        } catch (AuthenticationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}