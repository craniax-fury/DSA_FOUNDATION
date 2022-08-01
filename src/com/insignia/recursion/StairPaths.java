package com.insignia.recursion;

import java.io.*;
import java.util.ArrayList;


public class StairPaths {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int input = Integer.parseInt(br.readLine());

            ArrayList<String> output = getStairPaths(input);

            System.out.print(output);
        }
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n<0){
            return new ArrayList<String>();
        }
        if(n==0){
            ArrayList<String> path =  new ArrayList<>();
            path.add("");
            return path;
        }

        ArrayList<String> paths = new ArrayList<>();

        ArrayList<String> paths1 = getStairPaths(n - 1);
        ArrayList<String> paths2 = getStairPaths(n - 2);
        ArrayList<String> paths3 = getStairPaths(n - 3);

        for(String path: paths1){
            paths.add(path+1);
        }

        for(String path: paths2){
            paths.add(path+2);
        }

        for(String path: paths3){
            paths.add(path+3);
        }
        
        return paths;
    }
}