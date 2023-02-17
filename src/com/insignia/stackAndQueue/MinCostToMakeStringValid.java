package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinCostToMakeStringValid {

    public static void minCost(String[] input) {
        
        Stack<String> stack = new Stack<>();

        int index=1;

        stack.push(input[0]);

        while(index!=input.length){
            if(input[index].equals("{")){
                stack.push(input[index]);
                index+=1;
            
            }else{
                if(!stack.isEmpty() && stack.peek().equals("{")){
                    stack.pop();
                }else{
                    stack.push(input[index]);
                }

                index+=1;
            }
        }

        System.out.println(stack.size()/2);

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] inChars = br.readLine().toCharArray();

            if(inChars.length%2!=0){
                System.out.println("Cannot balance");
                return;
            }

            String[] input = new String[inChars.length];
            
            for (int index = 0; index < inChars.length; index++) {
                input[index] = String.valueOf(inChars[index]);
            }

            System.out.print("Min Cost: ");
            minCost(input);
        }
    }
}