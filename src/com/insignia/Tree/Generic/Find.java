package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find {

    public static boolean find(GenericTreeNode node,int data) {

        boolean found = false;

        if (node == null) {
            return found;
        }

        if(node.data==data){
            found=true;
            return found;
        }

        for(GenericTreeNode child:node.children){
            if(child.data==data){
                found=true;
                return found;    
            }else{
                found = find(child, data);
                if(found==true){
                    return found;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            int data = Integer.parseInt(reader.readLine());

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            System.out.println(find(root,data));
        }

    }
}
