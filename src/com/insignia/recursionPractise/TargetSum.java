package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TargetSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int in = Integer.parseInt(br.readLine());

        int[] input = new int[in];

        for (int i = 0; i < in; i++) {

            input[i] = Integer.parseInt(br.readLine());

        }

        int target = Integer.parseInt(br.readLine());

        targetSumSubs(input, 0, target,0,"");
    }

    public static void targetSumSubs(int[] input,int idx,int target,int ssf,String out) {

        if (idx==input.length) {
        if (ssf==target) {
            System.out.println(out+".");
        }
        return;
        }

        // if (ssf>target || idx>input.length-1) {
        //     return;
        // }

        

        targetSumSubs(input, idx+1, target,ssf+input[idx],out+input[idx]+", ");
        targetSumSubs(input, idx+1, target,ssf,out);
        
    }
}