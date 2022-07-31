package com.insignia.recursion;

import java.io.*;

public class FirstIndex {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            
            int number = Integer.parseInt(reader.readLine());
            
            
            int[] input = new int[number];
           
            for (int index = 0; index < number; index++) {
                input[index] = Integer.parseInt(reader.readLine());
            }
            int x = Integer.parseInt(reader.readLine());
            System.out.println(firstIndex(input, 0, x));
        }

    }

    public static int firstIndex(int[] arr, int idx, int x) {

        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        }

        return firstIndex(arr, idx + 1, x);

    }

}