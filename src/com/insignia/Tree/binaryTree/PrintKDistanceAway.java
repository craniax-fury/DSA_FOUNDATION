package com.insignia.Tree.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintKDistanceAway {

    public static void printKDistanceAway(BinaryTreeNode node,int data,int k){
        
        if(node==null || k<0){
            return;
        }

        if(k==0){
            System.out.println(node.data);
            return;
        }

        ArrayList<BinaryTreeNode> path = nodeToRootPath(node, data);

        if(path.size()==1){
            return;
        }

        printKLevelDown(path.get(0), k, null);

        int index=1;

        for(int level=k-1;level>=0 && index<path.size();level--){
            printKLevelDown(path.get(index), level, path.get(index-1));
            index+=1;
        }
    }
    
    public static void printKLevelDown(BinaryTreeNode node, int level, BinaryTreeNode blocker) {

        if(node==null || level<0 || node==blocker){
            return;
        }

        if(level==0){
            System.out.println(node.data);
            return;
        }

        printKLevelDown(node.left, level-1,blocker);
        printKLevelDown(node.right, level-1,blocker);

    }


    public static ArrayList<BinaryTreeNode> nodeToRootPath(BinaryTreeNode node,int data){

        ArrayList<BinaryTreeNode> path = new ArrayList<>(); 
        
        if(node==null){
            return path;
        }

        if(node.data==data){
            path.add(node);
            return path;
        }

        ArrayList<BinaryTreeNode> leftPath = nodeToRootPath(node.left, data);
        
        if(!leftPath.isEmpty()){
            path.addAll(leftPath);
            path.add(node);

            return path;
        }

        ArrayList<BinaryTreeNode> rightPath = nodeToRootPath(node.right, data);
        if(!rightPath.isEmpty()){
            path.addAll(rightPath);
            path.add(node);

            return path;    
        }


        return path;
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
            
            int level = Integer.parseInt(reader.readLine());

            BinaryTreeNode root = Constructor.constructor(arr);
            PrintKDistanceAway.printKDistanceAway(root,data, level);
        }
    }
}
