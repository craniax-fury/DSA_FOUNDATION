package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Diameter {

    public static int diameter(GenericTreeNode node) {

        if(node==null){
            return 0;
        }

        if(node.children.size()==0){
            return 1;
        }

        int max = 0;
        int secondMax = 0;
        
        int diameter = 0;

        for (GenericTreeNode child : node.children) {
            diameter = diameter(child);
            if(diameter>max){
                secondMax=max;
                max=diameter;
            }else if(diameter>secondMax){
                secondMax=diameter;
            }
        }

        return max+secondMax;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            GenericTreeNode root = Constructor.constructGenericTree(arr);

           System.out.println(diameter(root));

        }

    }
}
