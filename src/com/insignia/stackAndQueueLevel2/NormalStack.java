package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NormalStack {

    public static class CustomStack {
        int[] data;
        int tos;

        CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        public int size() {
            return tos + 1;
        }

        public void push(int val) {
            if (tos < data.length - 1) {
                data[tos] = val;
                tos += 1;
            } else {
                System.out.println("Stack overflow");
            }
        }

        public int pop() {
            if (tos == -1) {
                return -1;
            }

            return data[tos--];

        }

        public int top() {
            return data[tos];
        }   
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
    }
}
