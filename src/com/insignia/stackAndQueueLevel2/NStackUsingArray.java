package com.insignia.stackAndQueueLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NStackUsingArray {

    int[] top;
    int[] next;
    int[] arr;
    int freeSpot;

    NStackUsingArray(int stacks, int arrSize) {
        top = new int[stacks];
        next = new int[arrSize];
        arr = new int[arrSize];
        freeSpot = 0;

        for (int index = 0; index <= arrSize - 2; index++) {
            next[index] = index + 1;
        }

        Arrays.fill(top,-1);

        next[arrSize - 1] = -1;
    }

    public boolean push(int ele, int stack) {
        if (freeSpot == -1) {
            return false;
        }

        int index = freeSpot;

        freeSpot = next[index];

        arr[index] = ele;

        next[index] = top[stack-1];

        top[stack-1] = index;

        return true;

    }

    public int pop(int stack) {
        if (top[stack-1] == -1) {
            return -1;
        }

        int index = top[stack-1];

        top[stack-1] = next[index];

        int ele = arr[index];

        next[index] = freeSpot;

        freeSpot = index;

        return ele;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().split(" ");

            int stacks = Integer.parseInt(in[0]);
            int arrSize = Integer.parseInt(in[1]);
            int inLength = Integer.parseInt(in[2]);

            NStackUsingArray nstacks = new NStackUsingArray(stacks, arrSize);

            for (int index = 0; index < inLength; index++) {
                String[] inp = br.readLine().split(" ");

                int type = Integer.parseInt(inp[0]);

                if(type==1){
                    System.out.println(nstacks.push(Integer.parseInt(inp[1]),Integer.parseInt(inp[2])));
                }else{
                    System.out.println(nstacks.pop(Integer.parseInt(inp[1])));
                }
            }
        }
    }
}