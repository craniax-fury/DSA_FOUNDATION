package com.insignia.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class kLargest {
    public static void main(String[] args) throws IOException{
        
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
           int n = Integer.parseInt(reader.readLine());
           int[] input = new int[n];
           
           for(int i=0;i<n;i++){
            input[i]= Integer.parseInt(reader.readLine());
        }

           int k = Integer.parseInt(reader.readLine());

           PriorityQueue<Integer> queue = new PriorityQueue<>();

           for(int i=0;i<k;i++){
                queue.add(input[i]);
            }

            for(int i=k;i<n;i++){
                int inp = input[i];
                if(queue.peek()<inp){
                    queue.remove();
                    queue.add(inp);
                }
            }

            while(!queue.isEmpty()){
                System.out.println(queue.remove());
            }
        }
    }
}
