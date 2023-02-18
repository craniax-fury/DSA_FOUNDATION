package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MiddleOfStack {

    public static void popMiddle(Stack<Integer> stack,int size, int count) {

        if(count==size/2){
            stack.pop();
            return;
        }

        int temp = stack.pop();

        popMiddle(stack, size, count+1);

        stack.push(temp);

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            for(int index=0;index<n;index++){
                stack.push(Integer.parseInt(br.readLine()));
            }

            System.out.print("Before: ");

            Arrays.stream(stack.toArray()).forEach(ele-> System.out.print(ele+" "));

            System.out.println();

            popMiddle(stack, stack.size(), 0);
            
            System.out.print("After: ");
            
            Arrays.stream(stack.toArray()).forEach(ele-> System.out.print(ele+" "));

        }
    }
}