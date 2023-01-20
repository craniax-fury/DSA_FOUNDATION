package com.insignia.Tree.Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTreeNode {
    GenericTreeNode(int data){
        this.data=data;
        this.children = new ArrayList<>();
    }

    int data;
    List<GenericTreeNode> children;
}
