package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementOnRightAgain {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int input_length = sc.nextInt();
            int[] input = new int[input_length];

            for (int index = 0; index < input_length; index++) {
                input[index] = sc.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int[] output = new int[input_length];
            
            stack.push(0);

            for (int index = 1; index < input_length; index++) {

                while(stack.size()>0 && !(input[stack.peek()]>input[index])){
                    output[stack.peek()]=input[index];
                    stack.pop();
                }

                stack.push(index);
            }

            while(stack.size()>0){
                output[stack.peek()]=-1;
                stack.pop();
            }

            for(int val:output){
                System.out.println(val);
            }
        }
    }
} 