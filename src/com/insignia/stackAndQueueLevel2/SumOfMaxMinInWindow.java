package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SumOfMaxMinInWindow {

    public static int sommiw(int[] input, int k) {

        int ans = 0;

        Stack<Integer> max = new Stack<>();
        Stack<Integer> min = new Stack<>();

        int index = 0;

        max.push(0);
        min.push(0);

        index=1;

        while (index != k) {
            if (input[index] > max.peek()) {
                max.pop();
                max.push(index);
            }

            if (input[index] < min.peek()) {
                min.pop();
                min.push(index);
            }

            index += 1;
        }

        if (!max.isEmpty()) {
            ans += input[max.peek()];
        }

        if (!min.isEmpty()) {
            ans += input[min.peek()];
        }

        while (index != input.length) {

            if (!max.isEmpty() && max.peek() >= index - k + 1) {
                if (input[index] > input[max.peek()]) {
                    max.pop();
                    max.push(index);
                }
            }else {
                if(!max.isEmpty()){
                    max.pop();
                }

                max.push(index);
            }

            if (!min.isEmpty() && min.peek() >= index - k + 1) {
                if (input[index] < input[min.peek()]) {
                    min.pop();
                    min.push(index);
                }
            }else{
                if(!min.isEmpty()){
                    min.pop();
                }

                min.push(index);
            }

            ans += input[max.peek()] + input[min.peek()];

            index += 1;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];

            for (int index = 0; index < n; index++) {
                input[index] = Integer.parseInt(br.readLine());
            }

            int k = Integer.parseInt(br.readLine());

            System.out.println(sommiw(input, k));
        }
    }
}