package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMax {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int window_size = sc.nextInt();

            int input_length = sc.nextInt();

            int[] input = new int[input_length];

            for (int input_index = 0; input_index < input_length; input_index++) {
                input[input_index] = sc.nextInt();
            }
            
            System.out.println("__________________________");

            int rightOutput[] = nextGreaterEleOnRight(input_length, input);

            int j = 0;

            for (int i = 0; i < input_length - window_size; i++) {
                if (j < i) {
                    j = i;
                }

                while (rightOutput[j] < i + window_size) {

                    j = rightOutput[j];

                }
                System.out.print(" " + input[j]);

            }

        }
    }

    private static int[] nextGreaterEleOnRight(int input_length, int[] input) {
        int[] output = new int[input_length];

        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < input_length; index++) {

            while (stack.size() > 0 && (input[stack.peek()] < input[index])) {
                output[stack.peek()] = index;
                stack.pop();
            }
            stack.push(index);
        }

        while (stack.size() > 0) {
            output[stack.peek()] = input_length;
            stack.pop();
        }

        return output;
    }
}