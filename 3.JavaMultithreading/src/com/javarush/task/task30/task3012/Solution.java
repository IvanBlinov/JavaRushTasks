package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int num = new Integer(number);
        String expr = "";
        int ost;
        boolean isAdd = false;
        while (number >= 1) {
            ost = number % 3;
            if (number / 3 < 1) {
                if (ost == 2) {
                    expr = "+-" + expr;
                } else if (ost == 1) {
                    expr = "+" + expr;
                } else {
                    expr = "0" + expr;
                }
            } else {
                if (ost == 2) {
                    isAdd = true;
                    expr = "-" + expr;
                } else if (ost == 1) {
                    expr = "+" + expr;
                } else {
                    expr = "0" + expr;
                }
            }
            number = number / 3;
            if (isAdd) {
                number += 1;
                isAdd = false;
            }
        }

        String result = num + " =";
        for (int i = expr.length() - 1; i >= 0; i--) {
            if (expr.charAt(i) == '+') {
                result += " + " + (int)Math.pow(3, expr.length() - (i + 1));
            } else if (expr.charAt(i) == '-') {
                result += " - " + (int)Math.pow(3, expr.length() - (i + 1));
            }
        }
        System.out.println(result);
    }
}