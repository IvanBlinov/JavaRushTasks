package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* 
Генератор паролей
*/
public class Solution {

    static ArrayList<String> usedPasses = new ArrayList<>();
    static String chars;

    static {
        String digits = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        chars = digits + letters + letters.toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        String pass = generatePass();
        while (!checkPass(pass)) {
            pass = generatePass();
        }
        stream.write(pass.getBytes());
        return stream;
    }

    public static String generatePass() {
        String pass = "";
        for (int i = 0; i < 8; i++) {
            pass += chars.charAt((int)(Math.random()*chars.length()));
        }
        return pass;
    }

    public static boolean checkPass(String pass) {
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";
        String betaRegex = ".*[a-z].*";

        if (pass.matches(numRegex) && pass.matches(alphaRegex) && pass.matches(betaRegex)) {
            if (!usedPasses.contains(pass)) {
                usedPasses.add(pass);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}