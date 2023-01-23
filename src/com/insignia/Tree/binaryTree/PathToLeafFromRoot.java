package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathToLeafFromRoot {

    public static void pathToLeafFromRoot(BinaryTreeNode node, String path, int sum, int lo, int hi) {
        
        if(node==null){
            return;
        }

        if(node.left==null && node.right==null && sum+node.data>=lo && sum+node.data<=hi){
            path=path+" "+node.data;
            System.out.println(path);
            return;
        }

        pathToLeafFromRoot(node.left, path.equals("")?node.data+"": path+" "+node.data, sum+node.data, lo, hi);
        pathToLeafFromRoot(node.right, path.equals("")?node.data+"": path+" "+node.data, sum+node.data, lo, hi);

    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            Integer[] arr = new Integer[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                if (!(values[index].equals("n"))) {
                    arr[index] = Integer.parseInt(values[index]);
                } else {
                    arr[index] = null;
                }
            }

            int lo = Integer.parseInt(reader.readLine());
            int hi = Integer.parseInt(reader.readLine());

            BinaryTreeNode root = Constructor.constructor(arr);
            PathToLeafFromRoot.pathToLeafFromRoot(root, "", 0, lo, hi);
        }
    }
}
