package com.insignia.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendsPairing  {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int fr = Integer.parseInt(reader.readLine());

            int[] ways = new int[fr+1]; 
           
            ways[1] = 1;
            ways[2] = 2;
            ways[3] = 4;

            for(int i=4;i<fr+1;i++){
                ways[i] = (i-1) * ways[i-2] + ways[i-1]; 
            }

            System.out.println(ways[fr]);
        }
    }
}
