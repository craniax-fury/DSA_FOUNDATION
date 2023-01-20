package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PredecessorAndSuccessor {

    private static GenericTreeNode predecessor;
    private static GenericTreeNode successor;
    private static int state = 0;

    public static void predecessorAndSuccessor(GenericTreeNode node, int data) {
        if (node == null || state==2) {
            return;
        }

        if(state==1){
            state=2;
            successor=node;
            return;
        }

        if(state==0){
            if(node.data==data){
                state=1;
            }else{
                predecessor=node;
            }
        }

        for(GenericTreeNode child:node.children){
            predecessorAndSuccessor(child, data);
        }
        
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
            predecessorAndSuccessor(root, data);
            
            if(predecessor!=null && successor!=null){
                System.out.println("Predecessor = " + predecessor.data);
                System.out.println("Successor = " + successor.data);
            }
            
        }

    }
}
