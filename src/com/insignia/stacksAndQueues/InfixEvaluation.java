package com.insignia.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            String input_string = sc.nextLine();

            char[] input = input_string.toCharArray();

            Stack<Integer> operandStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();

            Map<Character, Integer> precedenceMap = new HashMap<>();

            precedenceMap.put('+', 1);
            precedenceMap.put('-', 1);
            precedenceMap.put('*', 2);
            precedenceMap.put('/', 2);

            for (int index = 0; index < input.length; index++) {
                if (input[index] == ' ') {
                    continue;
                }
                if (precedenceMap.get(input[index]) != null || isBracket(input[index])) {

                    if (input[index] == ')') {
                        // pop until )from operator, and operand stainput[index]k pop, operator stack
                        // pop, operand
                        // stack pop then operand stack push the result
                        while (operatorStack.size() > 0 && operatorStack.peek() != '(') {
                            operandStack.push(evaluate(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
                        }
                        operatorStack.pop();
                    }

                    if (operatorStack.size() > 0 && (isNotBracket(input[index]) && isNotBracket(operatorStack.peek()))
                            &&
                            precedenceMap.get(input[index]) <= precedenceMap.get(operatorStack.peek())) {
                        // pop until stack.peek has precedence greater than input[index]
                        while (operatorStack.size() > 0
                                && isNotBracket(operatorStack.peek())
                                && !(precedenceMap.get(input[index]) > precedenceMap.get(operatorStack.peek()))) {
                            operandStack.push(evaluate(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
                        }
                        operatorStack.push(input[index]);
                    } else if (input[index] != ')') {
                        operatorStack.push(input[index]);
                    }
                } else {
                    operandStack.push(input[index] - '0');
                }
            }

            while (operatorStack.size() > 0) {
                operandStack.push(evaluate(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
            }

            System.out.println("__________________________________");
            System.out.println(operandStack.peek());
        }
    }

    private static boolean isNotBracket(char c) {

        if (c == '(' || c == ')') {
            return false;
        }
        return true;

    }

    private static boolean isBracket(char c) {

        if (c == '(' || c == ')') {
            return true;
        }
        return false;

    }

    private static Integer evaluate(Integer oper1, Character operator, Integer oper2) {
        if (operator == '-') {
            return oper2 - oper1;
        } else if (operator == '+') {
            return oper2 + oper1;
        } else if (operator == '*') {
            return oper2 * oper1;
        } else if (operator == '/') {
            return oper2 / oper1;
        }
        return -99999;
    }
}