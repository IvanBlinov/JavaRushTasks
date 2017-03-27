package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            String s = args[0];
            int max = 2;
            if (s.startsWith("0")) System.out.println(8);
            else if (s.toLowerCase().startsWith("0x")) System.out.println(16);
            else if (s.toLowerCase().startsWith("0b")) System.out.println(2);
            else {
                for (int i = 0; i < s.length(); i++) {
                    char symb = s.charAt(i);
                    if (symb >= 48 && symb <= 57) {
                        max = Math.max(max, symb - 47);
                    } else if (symb >= 65 && symb <= 90) {
                        max = Math.max(max, symb - 54);
                    } else if (symb >= 97 && symb <= 122) {
                        max = Math.max(max, symb - 86);
                    } else {
                        System.out.println("incorrect");
                        return;
                    }
                }
            }

            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}