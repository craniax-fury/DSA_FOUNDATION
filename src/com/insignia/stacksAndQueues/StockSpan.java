package com.insignia.stacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input_length = Integer.parseInt(reader.readLine());
            int[] input = new int[input_length];

            for (int input_index = 0; input_index < input_length; input_index++) {
                input[input_index] = Integer.parseInt(reader.readLine());
            }

            int[] output = new int[input_length];

            Stack<Integer> stack = new Stack<>();

            for (int index = 0; index < input_length; index++) {
                if (stack.size() == 0) {
                    stack.push(index);
                    output[0]=1;
                } else if (input[stack.peek()] >= input[index]) {
                    output[index] = index - stack.peek();
                    stack.push(index);
                } else if (input[stack.peek()] < input[index]) {
                    while (stack.size() > 0 && input[stack.peek()] < input[index]) {
                        if (output[stack.peek()] == 0) {
                            output[stack.pop()] = index;
                        } else {
                            stack.pop();
                        }
                    }

                    if (stack.size() != 0) {
                        output[index] = index - stack.peek();
                    } else {
                        output[index] = index+1;
                    }

                    stack.push(index);
                }
            }

            for (int val : output) {
                System.out.println(val);
            }
        }
    }
}