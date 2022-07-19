package com.insignia.arrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BarChart barChart = new BarChart();

            int length = sc.nextInt();
            int[] arr = new int[length]; 
            
            for(int input=0;input<length;input++){
                arr[input] = sc.nextInt();
            }

            int max =  barChart.findMaxInArray(arr);

            for(int row=0;row<max;row++){
                for(int column=0;column<length;column++){
                    if((max-row)<=arr[column]){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public int findMaxInArray(int[] arr){
        int max=0;
        for(int num:arr){
            if(num>max){
                max=num;
            }
        }

        return max;
    }
}
