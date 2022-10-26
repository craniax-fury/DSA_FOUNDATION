package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CopyRandomList {

  public static class Node {
    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public Node() {
    }

    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public void printList(Node node) {
      while (node != null) {
        System.out.print(node.data + "-> ");
        node = node.next;
      }
      System.out.println("null");
    }

    private void printList(RandomNode th) {
      while (th != null) {
        System.out.print(th.data + "-> ");
        th = th.next;
      }
      System.out.println("null");
    }

    class RandomNode {
      private int data;
      private RandomNode next;
      private RandomNode random;

      RandomNode(int data) {
        this.data = data;
      }

      RandomNode() {
      }
    }

    private static Map<RandomNode, RandomNode> map = new HashMap<>();
    private static RandomNode th = null;
    private static RandomNode rHead = null;

    private void createDummyList() {
      RandomNode dummy = new RandomNode(-1);
      RandomNode prev = dummy;
  
      for(int i=0;i<10;i++){
        RandomNode node = new RandomNode(i);
        prev.next=node;
        prev=node;
        if(rHead==null){
          rHead=node;
        }
      }

      rHead.random = rHead;
      rHead.next.random=rHead.next.next.next;
      rHead.next.next.random =  rHead;
      rHead.next.next.next.next.random = rHead.next.next.next;
      rHead.next.next.next.next.next.random =  rHead.next.next.next.next.next;
    }

    private RandomNode copyRandom(RandomNode head) {
      if (head == null) {
        return head;
      }

      RandomNode curr = head;
      RandomNode curr_ = null;
      RandomNode dummy = new RandomNode(-1);
      RandomNode prev = dummy;

      while (curr != null) {
        curr_ = new RandomNode();
        curr_.data = curr.data;

        if (th == null) {
          th = curr_;
        } 
          
        prev.next = curr_;
        prev = curr_;

        map.put(curr, curr_);
        curr = curr.next;
      }

      for (Entry<RandomNode, RandomNode> entry : map.entrySet()) {
        entry.getValue().random = entry.getKey().random;
      }

      return th;
    }

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      LinkedList list = new LinkedList();
      LinkedList list2 = new LinkedList();

      String str = br.readLine();
      while (str.equals("quit") == false) {
        if (str.startsWith("addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list.addLast(val);
        }else if (str.startsWith("2addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list2.addLast(val);
        }else if (str.startsWith("dummyList")) {
          list.createDummyList();
        }else if (str.startsWith("print")) {
          list.printList(rHead);
        }else if (str.startsWith("copyRandom")) {
          RandomNode th = list.copyRandom(rHead);
          list.printList(th);
        } 
        str = br.readLine();

      }

    }

   

  }
}