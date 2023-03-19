package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BuildFromLevelOrder {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node buildFromLevelOrder() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            Queue<Node> queue = new ArrayDeque<>();

            System.out.println("Enter data for root: ");

            Node root = new Node(Integer.parseInt(br.readLine()));

            queue.add(root);

            while(!queue.isEmpty()){
                Node temp = queue.poll();
                System.out.println("Enter data for left of "+temp.data+" :");
                int leftData = Integer.parseInt(br.readLine());

                if(leftData!=-1){
                    Node left = new Node(leftData);
                    temp.left=left;
                    queue.add(left);
                }
                

                System.out.println("Enter data for right of "+temp.data+" :");
                int rightData = Integer.parseInt(br.readLine());

                if(rightData!=-1){
                    Node right = new Node(rightData);
                    temp.right=right;
                    queue.add(right);
                }
            }

            return root;
        }
    }

    private static void displayLevelOrder(Node root) {

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        queue.add(new Node(-1));

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            
            if(temp.data==-1){
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.add(new Node(-1));
                }  
            }else{

                System.out.print(temp.data+" ");

                if(temp.left!=null){
                    queue.add(temp.left);    
                }
                
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Node root  = buildFromLevelOrder();
        displayLevelOrder(root);

    }
}