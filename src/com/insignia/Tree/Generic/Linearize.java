package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Linearize {

    public static void linearize(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        for (GenericTreeNode child : node.children) {
            linearize(child);
        }

        for(int index=node.children.size()-2;index>=0;index--){
           GenericTreeNode tail1 = getTail(node.children.get(index));
           tail1.children.add(node.children.get(index+1));
        }

        if(node.children.size()==0){
            return;
        }
        
        GenericTreeNode firstChild = node.children.get(0);
        node.children=new ArrayList<>();

        node.children.add(firstChild);

    }

    private static GenericTreeNode getTail(GenericTreeNode node) {
        if(node.children.size()==0){
            return node;
        }

        GenericTreeNode tail = getTail(node.children.get(node.children.size()-1));
        return tail;
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
            linearize(root);
            Display.display(root);

        }

    }
}
