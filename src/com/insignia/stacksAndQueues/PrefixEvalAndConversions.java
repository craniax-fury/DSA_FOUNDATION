package com.insignia.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalAndConversions {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String inputString = sc.nextLine();
            char[] input = inputString.toCharArray();

            Stack<Integer> operndStack = new Stack<>();
            Stack<String> infixOperndStack = new Stack<>();
            Stack<String> postfixOperndStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>(); 

            List<Character> operatorsList = new ArrayList<>();
            operatorsList.add('/');
            operatorsList.add('*');
            operatorsList.add('+');
            operatorsList.add('-');

            for (int index = input.length-1; index >=0; index--) {
                if (input[index] == ' ') {
                    continue;
                }
               if (operndStack.size() >= 2 && operatorsList.contains(input[index])) {
                    /**
                     * pop the operands from operand stack and apply the operator
                     */
                    int opernd2 = operndStack.pop();
                    int opernd1 = operndStack.pop();

                    String infixOpernd2 = infixOperndStack.pop();
                    String infixOpernd1 = infixOperndStack.pop();

                    String prefixOpernd2 = postfixOperndStack.pop();
                    String prefixOpernd1 = postfixOperndStack.pop();
                 
                    operndStack.push(evaluateValue(opernd1, input[index], opernd2));
                    infixOperndStack.push(evaluateInfixExpression(infixOpernd1, input[index], infixOpernd2));
                    postfixOperndStack.push(evaluatePostfixExpression(prefixOpernd1, input[index], prefixOpernd2));

                } else if (operatorsList.contains(input[index])) {
                    operatorStack.push(input[index]);

                } else {
                    operndStack.push(input[index] - '0');
                    infixOperndStack.push(String.valueOf(input[index]));
                    postfixOperndStack.push(String.valueOf(input[index]));
                }

            }

            System.out.println(operndStack.peek());
            System.out.println(infixOperndStack.peek());
            System.out.println(postfixOperndStack.peek());

        }
    }

    private static String evaluatePostfixExpression(String opernd1, char operator, String opernd2) {
        if (operator == '*') {
            return opernd2 + opernd1+"*";
        } else if (operator == '/') {
            return  opernd2 + opernd1+"/";
        } else if (operator == '+') {
            return opernd2 + opernd1+"+";
        } else if (operator == '-') {
            return opernd2 + opernd1+"-";
        }
        return "";
    }

    private static String evaluateInfixExpression(String opernd1, char operator, String opernd2) {
        if (operator == '*') {
            return "(" + opernd2 + "*" + opernd1 + ")";
        } else if (operator == '/') {
            return "(" + opernd2 + "/" + opernd1 + ")";
        } else if (operator == '+') {
            return "(" + opernd2 + "+" + opernd1 + ")";
        } else if (operator == '-') {
            return "(" + opernd2 + "-" + opernd1 + ")";
        }
        return "";
    }

    private static Integer evaluateValue(int opernd1, char operator, int opernd2) {
        if (operator == '*') {
            return opernd2 * opernd1;
        } else if (operator == '/') {
            return opernd2 / opernd1;
        } else if (operator == '+') {
            return opernd2 + opernd1;
        } else if (operator == '-') {
            return opernd2 - opernd1;
        }
        return -99999;
    }
}
