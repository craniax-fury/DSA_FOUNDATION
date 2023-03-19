package com.insignia.Tree.BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PredecessorAndSuccessorInBST {

    public static Pair pAnds(BSTNode root,int key) {

        if(root==null){
            return new Pair(-1,-1);
        }
        /**
         * find key
         */

        BSTNode temp = root;

        while(temp!=null && temp.data!=key){
            if(temp.data==key){
                break;
            
            } else if(temp.data>key){
                temp=temp.left;
            } else {
                temp=temp.right;
            }
        }

        if(temp==null) {
            return new Pair(-1, -1);
        }

        int pre = -1;
        int succ = -1;

        pre = findMax(temp.left);
        succ = findMin(temp.right);

        return new Pair(pre, succ);

    }

    private static int findMax(BSTNode node) {

        if(node==null){
            return -1;
        }

        int temp = node.data;

        if(findMax(node.left)==-1){
            return temp;
        }

        return node.data;
    }

    private static int findMin(BSTNode node) {

        if(node==null){
            return -1;
        }

        int temp = node.data;

        if(findMax(node.right)==-1){ 
            return temp;
        }

        return node.data;
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

            int data = Integer.parseInt(reader.readLine());
            BSTNode root = Constructor.constructor(arr);
            delete(root, data);

        }
    }
}
