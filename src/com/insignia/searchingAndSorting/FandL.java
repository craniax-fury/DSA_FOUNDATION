package com.insignia.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FNLPair {

    int firstIndex;
    int lastIndex;

    FNLPair(int firstIndex,int lastIndex){
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public String toString(){
        return ("firstIndex: "+firstIndex+" lastIndex "+lastIndex);
    }
}

public class FandL {

    public static FNLPair fAndl(int[] input, int ele) {

        int firstIndex = firstIndex(input, 0, input.length - 1, ele,-1);
        int lastIndex = lastIndex(input, 0, input.length - 1, ele,-1);

        FNLPair pair = new FNLPair(firstIndex,lastIndex);
        
        return pair;
    }

    private static int lastIndex(int[] input, int start, int end, int ele,int index) {
        if(start>end){
            return index;
        }
        
        int mid = start + (end-start)/2;

        if(input[mid]==ele){
            index=mid;
            start = mid+1;
        
        }else if(ele > input[mid]){
            start = mid+1;
        
        }else{
            end = mid-1;
        }

        return lastIndex(input, start, end, ele, index);
    }

    private static int firstIndex(int[] input, int start, int end, int ele,int index) {
        if(start>end){
            return index;
        }
        
        int mid = start + (end-start)/2;

        if(input[mid]==ele){
            index=mid;
            end=mid-1;
        
        }else if(ele > input[mid]){
            start = mid+1;
        
        }else{
            end = mid-1;
        }

        return firstIndex(input, start, end, ele, index);
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] input = new int[n];

            int index = 0;
            while (index < n) {
                input[index] = Integer.parseInt(br.readLine());

                index += 1;
            }

            int ele1 = Integer.parseInt(br.readLine());
            int ele2 = Integer.parseInt(br.readLine());

            System.out.println(fAndl(input, ele1));
            System.out.println(fAndl(input, ele2));
        }
    }
}