package com.insignia.trees.genericTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Constructor {

    public static void main(String[] args) throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int[] input = new int[]{22,10,20,50,-1, 60,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,40,100,-1,-1,-1};

            Stack<TreeNode> stack = new Stack<>();

            for(int index=0;index<input.length;index++){
                if(input[index]==-1){
                    stack.pop();
                }else if(stack.size()==0){
                    TreeNode root = new TreeNode(); 
                    root.data=input[index];
                    stack.push(root);
                }else{
                    TreeNode node = new TreeNode();
                    node.data = input[index];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }
        }
    } 
    
}
