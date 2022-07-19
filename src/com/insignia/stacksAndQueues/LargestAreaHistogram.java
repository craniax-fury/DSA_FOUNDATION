package com.insignia.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args) {
        int maxArea = 0;

        try (Scanner sc = new Scanner(System.in)) {
            int input_length = sc.nextInt();
            int[] input = new int[input_length];

            for (int input_index = 0; input_index < input_length; input_index++) {
                input[input_index] = sc.nextInt();
            }

            int rightOutput[] = nextSmallerEleOnRight(input_length, input);
            int leftOutput[] = nextSmallerEleOnLeft(input_length, input);

            for (int i = 0; i < input_length; i++) {
                int distance = rightOutput[i] - leftOutput[i] -1;

                int area = input[i] * distance;

                maxArea = area > maxArea ? area : maxArea;
            }
        }

        System.out.println(maxArea);
    }

    private static int[] nextSmallerEleOnLeft(int input_length, int[] input) {
        int[] output = new int[input_length];

        Stack<Integer> stack = new Stack<>();

        for (int index = input_length - 1; index >= 0; index--) {

            while (stack.size() > 0 && (input[stack.peek()] > input[index])) {
                output[stack.peek()] = index;
                stack.pop();
            }

            
        }

        while (stack.size() > 0) {
            output[stack.peek()] = input_length;
            stack.pop();
        }

        return output;
    }

    private static int[] nextSmallerEleOnRight(int input_length, int[] input) {
        int[] output = new int[input_length];

        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < input_length; index++) {

            while (stack.size() > 0 && (input[stack.peek()] > input[index])) {
                output[stack.peek()] =index;
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