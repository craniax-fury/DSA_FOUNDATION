package com.insignia.stackAndQueueLevel2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pair {
    int data;
    int index;

    Pair(int data, int index) {
        this.data = data;
        this.index = index;
    }
}

public class LargestAreaHist {

    public static void largestArea(int[] input) {
        int area = 0;

        for (int index = 0; index <= input.length - 1; index++) {

            int leftIndex = nextSmallerEleIndexOnLeft(input, index);
            int rightIndex = nextSmallerEleIndexOnRight(input, index);

            int tempArea = input[index] * ((rightIndex - index) + (index - leftIndex) - 1);

            if (tempArea > area) {
                area = tempArea;
            }
        }

        System.out.println(area);

    }

    public static int nextSmallerEleIndexOnRight(int[] input, int index) {
        if (input.length == 0 || index >= input.length - 1) {
            return index;
        }

        int data = input[index];

        index++;

        while (index <= input.length - 1 && input[index] >= data) {
            index++;
        }

        if (index > input.length - 1) {
            return input.length;
        }

        return index;

    }

    public static int nextSmallerEleIndexOnLeft(int[] input, int index) {
        if (input.length == 0 || index <= 0) {
            return -1;
        }

        int data = input[index];

        index--;

        while (index >= 0 && input[index] >= data) {
            index--;
        }

        if (index < 0) {
            return -1;
        }

        return index;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        largestArea(a);
    }
}
