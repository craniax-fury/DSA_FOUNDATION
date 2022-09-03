package com.insignia.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSorted {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] input = new int[n];

            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(reader.readLine());
            }

            int k = Integer.parseInt(reader.readLine());

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            PriorityQueue<Integer> result = new PriorityQueue<>();

            for (int i = 0; i <= k; i++) {
                queue.add(input[i]);
            }

            for (int i = k + 1; i < n; i++) {
                int inp = input[i];
                result.add(queue.remove());
                queue.add(inp);

            }

            while (!queue.isEmpty()) {
                result.add(queue.remove());
            }

            while(!result.isEmpty()){
                System.out.println(result.remove());
            }
        }
    }
}
