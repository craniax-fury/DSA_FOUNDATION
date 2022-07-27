package com.insignia.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class Size {
    
    public static int size(TreeNode node){
        int sum=0;
        
        for(TreeNode child:node.children){
            sum+=size(child);
        }

        return sum+1;
    }
    public static void display(TreeNode node){
        System.out.print(node.data+" -> ");
        
        for(TreeNode child:node.children){
            System.out.print(child.data+", ");
        }
        
        System.out.println(".");
        
        for(TreeNode child:node.children){
            display(child);
        }
    }
    public static void main(String[] args) throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            // int input_length = Integer.parseInt(reader.readLine());
            // int[] input = new int[input_length];

            // for(int input_index=0;input_index<input_length;input_index++){
            //     input[input_index] = Integer.parseInt(reader.readLine());
           // }

            int[] input = new int[]{10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(); 

            for(int index=0;index<input.length;index++){
                if(input[index]==-1){
                    stack.pop();
                }else if(stack.size()==0){  
                    root.data=input[index];
                    stack.push(root);
                }else{
                    TreeNode node = new TreeNode();
                    node.data = input[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }

            display(root);
            System.out.println(size(root));
        }
         
    }
}
