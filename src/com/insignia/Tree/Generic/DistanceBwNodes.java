package com.insignia.Tree.Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistanceBwNodes {

    public static int distanceBwNodes(GenericTreeNode node, int data1,int data2) {
        if(node==null){
            return -1;
        }

        ArrayList<Integer> path1 = nodeToRootPath(node,data1);
        ArrayList<Integer> path2 = nodeToRootPath(node,data2);

        if(path1.isEmpty() || path2.isEmpty()){
            return -1;
        }

        int path2_index = path2.size()-1;
        int path1_index = path1.size()-1;

        while(path1_index>=0 && path2_index>=0 && path1.get(path1_index)==path2.get(path2_index)){
                path1_index--;
                path2_index--;
        }

        int commonEle1Pos = path1_index+1;
        int commonEle2Pos = path2_index+1;


        int edges1 = commonEle1Pos;
        int edges2 = commonEle2Pos;
        return edges1+edges2;

    }

    private static ArrayList<Integer> nodeToRootPath(GenericTreeNode node, int data) {
        
        ArrayList<Integer> path = new ArrayList<>();

        if(node==null){
            return null;
        }

        if(node.data==data){
            path.add(node.data);
            return path;
        }

        for(GenericTreeNode child:node.children){
            ArrayList<Integer> childPaths = nodeToRootPath(child, data);
            if(!childPaths.isEmpty()){
                childPaths.add(node.data);
                path.addAll(childPaths);
                return path;
            }
        }

        return path;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] values = reader.readLine().split(" ");
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(values[index]);
            }

            int data1 = Integer.parseInt(reader.readLine());
            int data2 = Integer.parseInt(reader.readLine());

            GenericTreeNode root = Constructor.constructGenericTree(arr);
            System.out.println(distanceBwNodes(root, data1,data2));
        }

    }
}
