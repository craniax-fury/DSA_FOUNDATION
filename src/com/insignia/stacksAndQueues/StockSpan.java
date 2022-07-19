package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int input_length = sc.nextInt();
            int[] input = new int[input_length];

            for (int input_index = 0; input_index < input_length; input_index++) {
                input[input_index] = sc.nextInt();
            }

            int[] output = new int[input_length];

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            output[0] = 1;

            for (int index = 1; index < input_length; index++) {

                while (stack.size() > 0 && (input[stack.peek()] < input[index])) {
                    stack.pop();
                }

                if (stack.size() > 0) {
                    output[index] = index - stack.peek();

                } else {
                    output[index] = index + 1;

                }

                stack.push(index);
            }
            System.out.println("____________________________");

            for (int val : output) {
                System.out.println(val);
            }
        }
    }
}