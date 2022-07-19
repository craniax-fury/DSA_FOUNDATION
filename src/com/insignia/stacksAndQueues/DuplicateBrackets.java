package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();

            Stack<Character> stack = new Stack<>();
            for (int index = 0; index < input.length(); index++) {

                if (input.charAt(index) != ')') {
                    stack.push(input.charAt(index));
                }else{                    
                    if(stack.peek()=='('){
                        System.out.println(true);
                        return;
                    }

                    while(stack.peek()!='('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }

            System.out.println(false);

        }
    }
}