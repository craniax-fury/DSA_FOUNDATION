package com.insignia.trees.genericTree;

public class Pair {
    TreeNode node;
    int level;

    public Pair() {
    
    }

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }

    

}
