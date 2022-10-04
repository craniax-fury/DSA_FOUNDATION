package com.insignia.recursionPractise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Stairs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> ss = stairs(n, 0);
        System.out.print(ss);
    }

    private static ArrayList<String> stairs(int n, int step) {
        
        if(step>n){
            ArrayList<String> output = new ArrayList<>();
            return output;
        }
        
        if (step == n) {
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            return output;
        }

        ArrayList<String> outpu1 = stairs(n, step + 1);
        ArrayList<String> outpu2 = stairs(n, step + 2);
        ArrayList<String> outpu3 = stairs(n, step + 3);

        ArrayList<String> output = new ArrayList<>();

        for (String path : outpu1) {
            output.add(path + "1");
        }

        for (String path : outpu2) {
            output.add(path + "2");
        }

        for (String path : outpu3) {
            output.add(path + "3");
        }

        return output;
    }
}