package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair {
    int data;
    int index;

    Pair(int data, int index) {
        this.data = data;
        this.index = index;
    }
}

public class StockSpan {

    public static int[] stockSpan(int[] input) {
        int[] output = new int[input.length];

        if (input.length == 0) {
            return output;
        }

        Stack<Pair> stack = new Stack<>();

        int index = input.length - 2;

        stack.push(new Pair(input[input.length - 1], input.length - 1));

        while (index >= 0) {
            if (input[index] > stack.peek().data) {

                while (!stack.isEmpty() && stack.peek().data < input[index]) {
                    Pair pair = stack.pop();
                    output[pair.index] = pair.index - index;
                }

                stack.push(new Pair(input[index], index));

            } else {
                stack.push(new Pair(input[index], index));
            }

            index--;
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            output[pair.index] = pair.index + 1;
        }

        return output;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] output = stockSpan(a);

        for (int val : output) {
            System.out.println(val);
        }

    }
}
