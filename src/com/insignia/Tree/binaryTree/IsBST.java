package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BSTPair {
    boolean isBST;
    int min;
    int max;

    BSTPair(boolean isBST, int min, int max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}

public class IsBST {

    private static BSTPair checkBST(BinaryTreeNode node) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if (node == null) {
            return new BSTPair(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTPair lpair = checkBST(node.left);
        
        if (!lpair.isBST || lpair.max > node.data){
            return new BSTPair(false, 0, 0);
        }

        BSTPair rpair = checkBST(node.right);

        if(!rpair.isBST  || rpair.min < node.data) {
            return new BSTPair(false, 0, 0);
        }

        min = Math.min(Math.min(lpair.min, rpair.min),node.data);
        max = Math.max(Math.max(lpair.max, rpair.max),node.data);

        return new BSTPair(true, min, max);
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

            BinaryTreeNode root = Constructor.constructor(arr);
            System.out.println(IsBST.checkBST(root).isBST);
        }
    }

}
