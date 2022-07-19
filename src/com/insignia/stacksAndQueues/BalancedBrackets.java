package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();

            Stack<Character> stack = new Stack<>();
            
            for (int index = 0; index < input.length(); index++) {

                if (input.charAt(index) == '(' || input.charAt(index) == '{' || input.charAt(index) == '[') {
                    stack.push(input.charAt(index));
                }else if(input.charAt(index) == ')'){                    
                    if(stack.peek()!='('){
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                    
                }else if(input.charAt(index) == '}'){                    
                    if(stack.peek()!='{'){
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                    
                }else if(input.charAt(index) == ']'){                    
                    if(stack.peek()!='['){
                        System.out.println(false);
                        return;
                    }else{
                        stack.pop();
                    }
                    
                }
            }

            System.out.println(!(stack.size()>0));
        }
    }
}