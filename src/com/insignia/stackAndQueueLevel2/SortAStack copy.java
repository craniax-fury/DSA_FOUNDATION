package com.insignia.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class SortAStack {

    public static void approach1(Stack<Integer> stack, PriorityQueue<Integer> queue) {

        // O(n) time
        // O(n) space
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }

    public static void approach2(Stack<Integer> stack) {
        
        // time O(n^2)
        // space O(n)
        if(stack.isEmpty()){
            return;    
        }

        int temp = stack.pop();

        approach2(stack);

        placeTemp(stack,temp);
    }

    public static void placeTemp(Stack<Integer> stack,int temp){
        if(stack.isEmpty()){
            stack.push(temp);
            return;    
        }
        
        if(stack.peek()<temp){
            stack.push(temp);
        }else{
           int num = stack.pop();

           placeTemp(stack, temp);

           stack.push(num);
        }
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            for (int index = 0; index < n; index++) {
                stack.push(Integer.parseInt(br.readLine()));
            }

            System.out.print("Before: ");

            Arrays.stream(stack.toArray()).forEach(ele -> System.out.print(ele + " "));

            System.out.println();

            //approach1(stack, new PriorityQueue<>());

            approach2(stack);

            System.out.print("After: ");

            Arrays.stream(stack.toArray()).forEach(ele -> System.out.print(ele + " "));

        }
    }
}