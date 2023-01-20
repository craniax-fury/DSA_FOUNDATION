package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Mirror {

    public static void mirror(GenericTreeNode node) {

        if (node == null) {
            return;
        }

        for(GenericTreeNode child:node.children){
            mirror(child);
        }

        Stack<GenericTreeNode> mirrorStack = new Stack<>();
        
        for(GenericTreeNode child: node.children){
            mirrorStack.push(child);
        }

        node.children=new ArrayList<>();

        while(!mirrorStack.isEmpty()){
            node.children.add(mirrorStack.pop());
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

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            mirror(root);
            Display.display(root);

        }

    }
}
