package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterOnRight {

    public static int[] nextGreaterOnRight(int[] input) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] output = new int[input.length];

        if (input.length == 0) {
            return output;
        }

        Stack<Integer> stack = new Stack<>();

        int index = 1;

        stack.push(input[0]);

        while (index != input.length) {
            if (input[index] > stack.peek()) {

                while (!stack.isEmpty() && stack.peek() < input[index]) {
                    int key = stack.pop();
                    map.put(key, input[index]);
                }

                stack.push(input[index]);

            } else {
                stack.push(input[index]);
            }

            index++;
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        index=0;

        for (int key : input) {
            output[index] = map.get(key);
            index++;
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

        int[] output = nextGreaterOnRight(a);

        for(int val:output){
            System.out.println(val);
        }
        
    }
}
