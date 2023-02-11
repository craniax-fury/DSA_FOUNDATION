package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

class Pair {
    int data;
    int index;

    Pair(int data, int index) {
        this.data = data;
        this.index = index;
    }
}

public class SlidingWindowMax {

    public static void slidingWindowMax(int[] input, int k) {
        int[] nextGreateIndex = nextGreaterEleIndexOnRight(input);
        int[] output = new int[input.length-k];

        int index = 0;

        while (index <= input.length - 1 - k) {

            if (nextGreateIndex[index] == index) {
                output[index] = input[nextGreateIndex[index]];

            } else if (nextGreateIndex[index] < (index + k)) {
                int temp = nextGreateIndex[index];

                while (temp!=nextGreateIndex[temp] && nextGreateIndex[temp] < index + k) {
                    temp = nextGreateIndex[temp];
                }

                output[index] = input[temp];

            } else {
                output[index] = input[index];
            }

            index += 1;
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=input.length - k;i<=input.length-1;i++){
            maxQueue.add(input[i]);
        }

        for (int val : output) {
            System.out.print(val+" ");
        }

        System.out.print(maxQueue.poll());

    }

    private static int[] nextGreaterEleIndexOnRight(int[] input) {

        int index = 0;
        int[] output = new int[input.length];

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(input[index], index));
        index += 1;

        while (index <= input.length - 1) {
            while (!stack.isEmpty() && input[index] > stack.peek().data) {
                output[stack.pop().index] = index;
            }

            stack.push(new Pair(input[index], index));

            index += 1;
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            output[pair.index] = pair.index;
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

        int k = Integer.parseInt(br.readLine());

        slidingWindowMax(a, k);
    }
}
