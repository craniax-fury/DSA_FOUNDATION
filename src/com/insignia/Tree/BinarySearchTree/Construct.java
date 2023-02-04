package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Construct {

    public static BSTNode constructor(Integer[] data,int start,int end) {
        
        if(start > end){
            return null;
        }

        int mid  = (start+end)/2;

        BSTNode lnode = constructor(data, start, mid-1);
        BSTNode rnode = constructor(data, mid+1, end);

        BSTNode newNode = new BSTNode(data[mid],lnode,rnode);

        return newNode; 
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                    arr[index] = Integer.parseInt(values[index]);
            }

            BSTNode node = Construct.constructor(arr,0,arr.length-1);
            Utility.display(node);
        }
    }
}
