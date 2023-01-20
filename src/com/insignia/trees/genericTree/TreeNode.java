package com.insignia.trees.genericTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int data;
    List<TreeNode> children;

    TreeNode() {
        this.children = new ArrayList<>();
    }
}
