package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsSymmetric {

    public static boolean isSymmetric(GenericTreeNode node) {
        
        if(node==null){
            return false;
        }

        if(node.children.size()==0){
            return true;
        }

        if(!(node.children.get(0).children.size()==node.children.get(node.children.size()-1).children.size())){
            return false;
        }

        for(GenericTreeNode child:node.children){
            if(!isSymmetric(child)){
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

            GenericTreeNode root1 = Constructor.constructGenericTree(arr);
            System.out.println(isSymmetric(root1));
        }

    }
}
