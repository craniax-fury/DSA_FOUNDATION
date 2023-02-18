package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DuplicateBrackets {

    public static boolean isDuplicateBracket(String input) {

        if (input.equals("")) {
            return false;
        }

        char[] ic = input.toCharArray();

        Stack<Character> stack = new Stack<>();

        int index = 1;
        stack.push(ic[0]);

        while (index!=ic.length) {

            if (ic[index] != ')') {
                stack.push(ic[index]);
            } else if (ic[index] == ')') {
                if (stack.peek() == '(') {
                    return true;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }

                    stack.pop();
                }
            }
            index++;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            System.out.println(isDuplicateBracket(input));
        }
    }
}