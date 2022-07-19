package com.insignia.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            String input_string = sc.nextLine();

            char[] input = input_string.toCharArray();

            Stack<String> prefixOprndStack = new Stack<>();
            Stack<String> postfixOprndStack = new Stack<>();

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
                            String preOpernd1 = prefixOprndStack.pop();
                            String preOpernd2 = prefixOprndStack.pop();

                            String postOpernd1 = postfixOprndStack.pop();
                            String postOpernd2 = postfixOprndStack.pop();

                            char operator = operatorStack.pop();

                            prefixOprndStack.push(evaluatePrefix(preOpernd1, operator, preOpernd2));
                            postfixOprndStack.push(evaluatePostfix(postOpernd1, operator, postOpernd2));

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
                            String preOpernd1 = prefixOprndStack.pop();
                            String preOpernd2 = prefixOprndStack.pop();

                            String postOpernd1 = postfixOprndStack.pop();
                            String postOpernd2 = postfixOprndStack.pop();

                            char operator = operatorStack.pop();

                            prefixOprndStack.push(evaluatePrefix(preOpernd1, operator, preOpernd2));
                            postfixOprndStack.push(evaluatePostfix(postOpernd1, operator, postOpernd2));
                        }
                        operatorStack.push(input[index]);
                    } else if (input[index] != ')') {
                        operatorStack.push(input[index]);
                    }
                } else {
                    prefixOprndStack.push(String.valueOf(input[index]));
                    postfixOprndStack.push(String.valueOf(input[index]));
                }
            }

            while (operatorStack.size() > 0) {
                String preOpernd1 = prefixOprndStack.pop();
                String preOpernd2 = prefixOprndStack.pop();

                String postOpernd1 = postfixOprndStack.pop();
                String postOpernd2 = postfixOprndStack.pop();

                char operator = operatorStack.pop();

                prefixOprndStack.push(evaluatePrefix(preOpernd1, operator, preOpernd2));
                postfixOprndStack.push(evaluatePostfix(postOpernd1, operator, postOpernd2));
            }

            System.out.println("__________________________________");
            System.out.println("prefix ----> " + prefixOprndStack.peek());
            System.out.println("postfix ----> " + postfixOprndStack.peek());

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

    private static String evaluatePrefix(String oper1, Character operator, String oper2) {
        if (operator == '-') {
            return "-" + oper2 + oper1;
        } else if (operator == '+') {
            return "+" + oper2 + oper1;
        } else if (operator == '*') {
            return "*" + oper2 + oper1;
        } else if (operator == '/') {
            return "/" + oper2 + oper1;
        }
        return "";
    }

    private static String evaluatePostfix(String oper1, Character operator, String oper2) {
        if (operator == '-') {
            return oper2 + oper1 + "-";
        } else if (operator == '+') {
            return oper2 + oper1 + "+";
        } else if (operator == '*') {
            return oper2 + oper1 + "*";
        } else if (operator == '/') {
            return oper2 + oper1 + "/";
        }
        return "";
    }
}