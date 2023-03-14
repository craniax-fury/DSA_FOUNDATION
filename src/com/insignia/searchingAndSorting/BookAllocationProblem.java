package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookAllocationProblem {

    public static int allocate(int[] pages, int people) {

        if (people > pages.length) {
            return -1;
        }

        int start = 0;
        int end = Arrays.stream(pages).reduce(0, Integer::sum);

        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(mid, pages, people)) {
                min = mid;
                end = mid;

            } else {
                start = mid + 1;
            }

        }

        if (min == Integer.MAX_VALUE){
            return -1;
        }

        return min;
    }

    private static boolean isPossible(int mid, int[] pages, int people) {

        int index = 0;

        int partition = 0;

        int ans = 0;
        while (index < pages.length && partition < people) {

            if (ans + pages[index] <= mid) {
                ans += pages[index];
                index += 1;

            } else {
                partition += 1;
                ans = 0;
            }

        }

        if (index != pages.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int books = Integer.parseInt(br.readLine());

            int[] pages = new int[books];

            for (int index = 0; index < books; index++) {
                pages[index] = Integer.parseInt(br.readLine());
            }

            int people = Integer.parseInt(br.readLine());

            System.out.println(allocate(pages, people));
        }
    }
}