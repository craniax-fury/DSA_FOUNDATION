package com.insignia.Tree.binaryTree.viewsAndTraversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.insignia.Tree.binaryTree.BinaryTreeNode;
import com.insignia.Tree.binaryTree.Constructor;

public class TopView {

    private static void topView(BinaryTreeNode node) {
        if(node==null){
            return;
        }

        Stack<Integer> leftStack = new Stack<>();
        Queue<Integer> rightQueue = new ArrayDeque<>();


        leftFill(leftStack,node.getLeft());

        while(!leftStack.isEmpty()){
            System.out.print(leftStack.pop()+" ");
        }
        
        System.out.print(node.getData() + " ");

        rightFill(rightQueue,node.getRight());

        for(Integer point: rightQueue){
            System.out.print(point + " ");
        }
    }

    private static void rightFill(Queue<Integer> rightQueue, BinaryTreeNode node) {
        if(node==null){
            return ;
        }
        
        rightQueue.add(node.getData());

        rightFill(rightQueue, node.getRight());
    }

    private static void leftFill(Stack<Integer> leftStack, BinaryTreeNode node) {

        if(node==null){
            return ; 
        }

        leftStack.push(node.getData());

        leftFill(leftStack, node.getLeft());
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
            TopView.topView(root);
        }
    }
}
