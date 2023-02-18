package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularTour {

    public static int circularTour(int[] petrol,int[] distance) {

        int start = 0;
        int index = 0;
        int balance = 0;
        int deficit = 0; 

        while(index!=petrol.length){
            balance += petrol[index] - distance[index];

            if(balance<0){
                start=index+1;
                deficit+=balance;
                balance=0;
            }

            index+=1;
        }

        if(balance+deficit<0){
            return -1;
        }

        return start;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] petrol = new int[n];
            int[] distance = new int[n];

            for(int index=0;index<petrol.length;index++){
                petrol[index] = Integer.parseInt(br.readLine());
            }

            for(int index=0;index<petrol.length;index++){
                distance[index] = Integer.parseInt(br.readLine());
            }
            
            System.out.println(circularTour(petrol,distance));
        }
    }
}