package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AreSimilar {

    public static boolean areSimilar(GenericTreeNode n1, GenericTreeNode n2) {
        
        if(n1==null || n2==null){
            return false;
        }

        if(n1.children.size()!=n2.children.size()){
            return false;
        }

        for(int index=0;index<n1.children.size();index++){
            if(!areSimilar(n1.children.get(index),n2.children.get(index))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            int n1 = Integer.parseInt(reader.readLine());
            int[] arr1 = new int[n1];
            String[] values1 = reader.readLine().split(" ");
            for (int index = 0; index < n1; index++) {
                arr1[index] = Integer.parseInt(values1[index]);
            }

            GenericTreeNode root1 = Constructor.constructGenericTree(arr);
            GenericTreeNode root2 = Constructor.constructGenericTree(arr1);
            System.out.println(areSimilar(root1, root2));
        }

    }
}
