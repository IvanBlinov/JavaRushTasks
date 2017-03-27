package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vanya on 05.03.2017.
 */
public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String text = "";
        boolean isInput = false;
        do {
            try {
                text = bufferedReader.readLine();
                isInput = true;
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        } while (!isInput);
        return text;
    }

    public static int readInt() {
        int number = 0;
        boolean isInput = false;
        do {
            try {
                number = Integer.parseInt(readString());
                isInput = true;
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        } while (!isInput);
        return number;
    }

}
