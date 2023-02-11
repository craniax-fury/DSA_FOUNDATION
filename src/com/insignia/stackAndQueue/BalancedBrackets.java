package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalancedBracket(String input) {

        if (input.equals("")) {
            return false;
        }

        char[] ic = input.toCharArray();

        Stack<Character> stack = new Stack<>();

        int index = 1;
        stack.push(ic[0]);

        Map<Character,Character> map  = new HashMap<>();
        
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        while (index!=ic.length) {

            if (ic[index] == '(' || ic[index] == '{' || ic[index] == '[' ){
                stack.push(ic[index]);
            
            } else if (ic[index] == ')'  || ic[index] == '}' || ic[index] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char openBracket = map.get(ic[index]);

                    while (!stack.isEmpty() && stack.peek() != openBracket) {
                        stack.pop();
                    }

                    if(stack.isEmpty()){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
            index++;
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            System.out.println(isBalancedBracket(input));
        }
    }
}