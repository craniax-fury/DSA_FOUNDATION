package com.insignia.stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SlidingWindowMax {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input_length = Integer.parseInt(reader.readLine());
            int[] input = new int[input_length];

            for (int index = 0; index < input_length; index++) {
                input[index] = Integer.parseInt(reader.readLine());
            }
            int window = Integer.parseInt(reader.readLine());


            int[] ngr = getNextGreaterElementOnTheRight(input_length, input);

            for (int index = 0; index <= input_length-window; index++) {
                if (ngr[index] == -1 || ngr[index] > index + window-1) {
                    System.out.println(input[index]);
                } else if (ngr[index] <= index + window-1) {
                    int temp_prev = index;
                    int temp_curr = index;
                    while (ngr[temp_curr] <= index + window-1) {
                        if (ngr[temp_curr] == -1) {
                            break;
                        }
                       
                         else {
                            temp_prev = ngr[temp_curr];
                            temp_curr = ngr[temp_curr];
                        }
                    }

                    System.out.println(input[temp_prev]);
                }
            }
        }
    }

    private static int[] getNextGreaterElementOnTheRight(int input_length, int[] input) {
        Stack<Integer> stack = new Stack<>();

        int[] ngr = new int[input_length];

        for (int index = 0; index < input_length; index++) {
            if (stack.size() == 0) {
                stack.push(index);

            } else if (input[index] < input[stack.peek()]) {
                stack.push(index);

            } else if (input[stack.peek()] < input[index]) {
                while (stack.size() > 0 && input[stack.peek()] < input[index]) {
                    ngr[stack.pop()] = index;
                }

                stack.push(index);
            }
        }

        while (stack.size() != 0) {
            ngr[stack.pop()] = -1;
        }

        return ngr;
    }
}