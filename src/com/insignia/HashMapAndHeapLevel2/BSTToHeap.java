package com.insignia.HashMapAndHeapLevel2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
* is implemented using heap , heap is a binary tree here with below mentioned properties
* HeapOrderProperty, completeBinaryTree
* HeapOrderProperty : parent has high property than child, allows peek to work in O(1)
* completeBinaryTree : h-1 level is complete and at h level, elements are filled from left to right
* , helps to achieve remove and add in O(log n) as with arraylist we can then apply formulae to determine
* the position of children and parent   
*/

class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data,BinaryTreeNode left,BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static BinaryTreeNode constructor(Integer[] data,int start,int end) {
        
        if(start > end){
            return null;
        }

        int mid  = (start+end)/2;

        BinaryTreeNode lnode = constructor(data, start, mid-1);
        BinaryTreeNode rnode = constructor(data, mid+1, end);

        BinaryTreeNode newNode = new BinaryTreeNode(data[mid],lnode,rnode);

        return newNode; 
    }
    
}



public class BSTToHeap {

    public static void getInOrderList(BinaryTreeNode root, List<Integer> inOrderList) {

        if (root == null) {
            return;
        }

        getInOrderList(root.left, inOrderList);
        inOrderList.add(root.data);
        getInOrderList(root.right, inOrderList);
    }

    public static void convert(BinaryTreeNode root, List<Integer> inOrderList) {

        if (root == null) {
            return;
        }

        root.data = inOrderList.remove(0);
        convert(root.left,inOrderList);
        convert(root.right, inOrderList);

    }

    public static BinaryTreeNode convertBST(BinaryTreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();

        getInOrderList(root, inOrderList);

        convert(root, inOrderList);

        return root;

    }

    public static void display(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.print(node.left.data + " <- ");
        } else {
            System.out.print("." + " <- ");
        }

        System.out.print(node.data + " -> ");

        if (node.right != null) {
            System.out.print(node.right.data);
        } else {
            System.out.print(".");
        }

        System.out.println();

        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] data = new Integer[]{1,2,3,4,5,6,7};

            BinaryTreeNode root = BinaryTreeNode.constructor(data,0,data.length-1);
            display(convertBST(root));
        }
    }
}
