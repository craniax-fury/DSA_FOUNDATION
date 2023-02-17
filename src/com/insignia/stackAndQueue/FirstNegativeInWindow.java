package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class FirstNegativeInWindow {

    public static void firstNegativeIntegerInWindow(int[] arr, int k) {

        boolean isNegativeExist = false;
        int index = 0;

        if (k > arr.length) {
            return;
        }

        Stack<Integer> output = new Stack<>();

        int temp=index;

        while (temp < k) {
            if (arr[temp] < 0) {
                output.push(temp);
                isNegativeExist = true;
                break;
            }

            temp++;
        }

        if (!isNegativeExist) {
            output.push(-1);
        }

        index+=1;

        while (index <= arr.length - k) {
            if (output.peek() >= index) {
                output.push(output.peek());
            } else {
                isNegativeExist = false;

                temp = index;

                while(temp < index + k && temp < arr.length) {
                    if (arr[temp] < 0) {
                        output.push(temp);
                        isNegativeExist = true;
                        break;
                    }

                    temp++;
                }

                if(!isNegativeExist){
                    output.push(-1);
                }
            }

            index+=1;

        }

        for (int ele : output) {
            if (ele == -1) {
                System.out.print(0 + " ");
            } else {
                System.out.print(arr[ele] + " ");
            }
        }

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(br.readLine());
            }

            int k = Integer.parseInt(br.readLine());

            firstNegativeIntegerInWindow(arr, k);
        }
    }
}