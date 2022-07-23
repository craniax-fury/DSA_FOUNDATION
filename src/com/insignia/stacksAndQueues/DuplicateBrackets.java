package com.insignia.stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * (, any other character -> push
 * if ) if(stack.peek=='(') then return false;
 * else pop all until '(', come out of loop then pop '(' )
 */
public class DuplicateBrackets {

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            char[] inputChars = input.toCharArray();
            for(Character character:inputChars){
                if(character!=')'){
                    stack.push(character);
                }else{
                    if(stack.size()!=0 && stack.peek()=='('){
                        System.out.println(true);
                        return;
                    }

                    while(stack.size()!=0 && stack.peek()!='('){
                        stack.pop();
                    }

                    stack.pop();
                }
            }

            System.out.println(false);

        }
    }
}