package com.insignia.recursionPractise2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TargetSumSubset {

    // asf -> answer so far
    public static void targetSumsubset(int[] input, int index, String asf, int ssf, int tar) {

        // base case
        if (index == input.length && ssf == tar) {
            System.out.println(asf+".");
            return;
        }else if(index==input.length){
            return;
        }

        // recursive calls
        if (input[index] + ssf <= tar) {
            targetSumsubset(input, index + 1, asf + input[index]+",", ssf + input[index], tar);
        }

        targetSumsubset(input, index + 1, asf, ssf, tar);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputSize = Integer.parseInt(br.readLine());

        int[] input = new int[inputSize];

        for (int index = 0; index < inputSize; index++) {
            input[index] = Integer.parseInt(br.readLine());
        }

        int target = Integer.parseInt(br.readLine());

        targetSumsubset(input,0,"",0,target);
    }

}