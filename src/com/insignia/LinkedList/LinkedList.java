package com.insignia.linkedList;

public class LinkedList{
    Node head;
    Node tail;
    int size;
        
        public LinkedList() {
        }

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
      
    }