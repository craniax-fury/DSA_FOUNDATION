package com.insignia.stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();

            char[] inputChars = input.toCharArray();

            for (Character character : inputChars) {
                if (character == '[' || character == '{' || character == '(') {
                    stack.push(character);
                } else if (character == ')') {
                    if (stack.size()==0 || stack.peek() != '(') {
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                }else if(character=='}'){
                    if(stack.size()==0 || stack.peek()!='{'){
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                }else if(character==']'){
                    if(stack.size()==0 || stack.peek()!='['){
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(stack.size()!=0){
                System.out.println(false);
            }else{
                System.out.println(true);
            }
        }
    }
}