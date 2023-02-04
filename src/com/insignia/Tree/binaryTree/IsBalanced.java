package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BPair {
    boolean isBalanced;
    int height;

    BPair(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

public class IsBalanced {

    private static BPair isBalanced(BinaryTreeNode node) {
        
        int height=-1;

        if (node == null) {
            return new BPair(true, height);
        }

        BPair lpair = isBalanced(node.left);
        
        if (!lpair.isBalanced){
            return new BPair(false,height);
        }

        BPair rpair = isBalanced(node.right);

        if(!rpair.isBalanced) {
            return new BPair(false,height);
        }

        

        return new BPair(Math.abs(lpair.height-rpair.height)<=1,Math.max(lpair.height,rpair.height)+1);
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
            System.out.println(IsBalanced.isBalanced(root).isBalanced);
        }
    }

}
