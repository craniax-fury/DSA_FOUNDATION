package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/

public class MedianInAStream {

    static PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void add(int num) {
        if (left.isEmpty()) {
            left.add(num);

        }else if(right.isEmpty()){
            right.add(num);

        }else if (num > right.peek()) {
            left.add(right.poll());
            right.add(num);

        } else {
            left.add(num);
        }

        balance(left, right);
    }

    private static void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (Math.abs(left.size() - right.size()) > 1) {

            if (left.size() > right.size()) {
                right.add(left.poll());
            } else {
                left.add(right.poll());
            }

        }

        if(!left.isEmpty() && !right.isEmpty() && right.peek() < left.peek()){
            right.add(left.poll());
            left.add(right.poll());
        }
    }

    public static double median() {
        if (left.size() == right.size()) {
            return (left.peek() + (double) right.peek()) / 2;
        } else {
            double ans = left.peek();

            if (Math.abs(left.size() - right.size()) > 1) {
                left.add(right.poll());
            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            for (int subIndex = 0; subIndex < n; subIndex++) {
                String input = br.readLine();

                if (input.startsWith("add")) {
                    add(Integer.parseInt(input.split(" ")[1]));

                } else if (input.startsWith("median")) {
                    System.out.println(median());

                }
            }
        }
    }
}
