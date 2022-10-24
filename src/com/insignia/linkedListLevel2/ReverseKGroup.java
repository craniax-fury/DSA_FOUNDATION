package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseKGroup {

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

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return tail.data;
      }
    }

    public int getAt(int idx) {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
        return -1;
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp.data;
      }
    }

    public void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = head;
      head = temp;

      if (size == 0) {
        tail = temp;
      }

      size++;
    }

    

    public void addAt(int idx, int val) {
      if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else {
        Node node = new Node();
        node.data = val;

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        node.next = temp.next;

        temp.next = node;
        size++;
      }
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }

    public void removeAt(int idx) {
      if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        removeFirst();
      } else if (idx == size - 1) {
        removeLast();
      } else {
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
      }
    }

    private Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }

    public void reverseDI() {
      int li = 0;
      int ri = size - 1;
      while (li < ri) {
        Node left = getNodeAt(li);
        Node right = getNodeAt(ri);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        li++;
        ri--;
      }
    }

    public void reversePI() {
      if (head == null || head.next == null) {
        return;
      } // handle for 0 and 1 length cases
      Node prev = null;
      Node curr = head;

      while (curr != null) {
        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
    }

    public void printList(Node node) {
      while (node != null) {
        System.out.print(node.data + "-> ");
        node = node.next;
      }
      System.out.println("null");
    }

    public Node mergeSortLL(Node start) { // O(nlog(n))
      if (start == null || start.next == null) {
        return start;
      }

      Node mid = mid(start);
      Node nHead = mid.next;
      mid.next = null;

      Node l1head = mergeSortLL(start);
      Node l2head = mergeSortLL(nHead);

      return mergeSortedLL(l1head, l2head);
    }

    private Node mergeSortedLL(Node l1head, Node l2head) {
      if (l1head == null) {
        return l2head;
      }

      if (l2head == null) {
        return l1head;
      }

      Node dummy = new Node(-1);
      Node prev = dummy;

      Node c1 = l1head;
      Node c2 = l2head;

      while (c1 != null && c2 != null) {
        if (c1.data < c2.data) {
          prev.next = c1;
          prev = c1;
          c1 = c1.next;
        } else if (c2.data < c1.data) {
          prev.next = c2;
          prev = c2;
          c2 = c2.next;
        }
      }

      if (c1 == null) {
        prev.next = c2;
      } else {
        prev.next = c1;
      }

      return dummy.next;
    }

    private Node mid(Node head) {
      if (head == null || head.next == null) {
        return head;
      }

      Node slow = head;
      Node fast = head;

      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow;
    }

    private static Node th = null;
    private static Node tt = null;

    public void addFirst(Node node){
      if(node==null){
        return;
      }

      if(th==null){
        th=node;
        tt=node;
        node.next=head;

      }else{
        node.next=th;
        th=node;
      } 
    }
    private static Node oh = null;
    private static Node ot = null;
    
    private Node reverseKGroups(Node head,int k){ // O(n) , space O(1)
      int length = length(head); 
      
      if(length<k || k==0 || head==null || head.next==null){
        return head;
      }
      
      Node curr = head;
      Node fwd = curr.next;

      while(length>=k){
        int tk = k;
        while(tk-->0){
          curr.next=null;
          addFirst(curr);
          curr=fwd;
          
          if(fwd!=null){
            fwd=fwd.next;
          }
        }

        if(oh==null){
          oh=th;
          ot=tt;
        }else{
          ot.next=th;
          ot=tt;
        }
       
        th=null;
        tt=null;

        length-=k;
      }
      
      ot.next=curr;
      return oh;
    }

    private int length(Node head) {
      Node curr = head;
      int l=0;
      while(curr!=null){
        curr=curr.next;
        l++;
      }
      return l;
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
        }
        if (str.startsWith("2addLast")) {
          int val = Integer.parseInt(str.split(" ")[1]);
          list2.addLast(val);
        } else if (str.startsWith("mergeSort")) {
          Node head = list.mergeSortLL(list.head);
          list.printList(head);
        }else if(str.startsWith("reverseK")){
          int k=Integer.parseInt(br.readLine());
          list.printList(list.reverseKGroups(list.head, k));
          
        }
        str = br.readLine();

      }

    }
  }
}