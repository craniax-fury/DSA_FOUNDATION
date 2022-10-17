package com.insignia.linkedListLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MergeKSortedLLPriorityQueue {

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

    public void unfold() {
      if (head == null || head.next == null || head.next.next == null) {
        return;
      }

      Node h2 = head.next;

      Node c1 = head;
      Node c2 = head.next;
      Node fwd = c2.next;

      while (c2 != null && c2.next != null) {
        c1.next = fwd;
        c2.next = fwd.next;

        c1 = c1.next;
        c2 = c2.next;

        if (c2 != null) {
          fwd = c2.next;
        }

      }

      Node reversedC2Head = reverse(h2);
      c1.next = reversedC2Head;

    }

    public void fold() { // O(n) space O(1)
      Node mid = mid(); // O(n)
      Node temp = mid.next;
      mid.next = null;

      Node reversedHead = reverse(temp); // O(n/2)

      Node startHead = head;
      Node endHead = reversedHead;
      Node next1 = null;
      Node next2 = null;

      while (endHead != null) { // O(n/2)
        // taking extra nodes to avoid null pointed exceptions
        next1 = startHead.next;
        next2 = endHead.next;

        startHead.next = endHead;
        endHead.next = next1;

        startHead = next1;
        endHead = next2;
      }
    }

    public void printList(Node node) {
      while (node != null) {
        System.out.print(node.data + "-> ");
        node = node.next;
      }
      System.out.println("null");
    }

    public Node mid() {

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

    public Node reverse(Node head) {
      if (head == null || head.next == null) {
        return head;
      }

      Node prev = null;
      Node curr = head;

      while (curr != null) {
        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }

      return prev;
    }

    public void revertOrgReverse(Node head, Node mid) {
      head = reverse(head);
      mid.next = head;
    }

    public Node mergeSortedLinkedLists(Node ListHead1, Node ListHead2) {
      Node head1 = ListHead1;
      Node head2 = ListHead2;

      if (head1 == null) {
        return head2;
      }

      if (head2 == null) {
        return head1;
      }

      Node c1 = head1;
      Node c2 = head2;
      Node dummy = new Node(-1);
      Node prev = dummy;

      while (c1 != null && c2 != null) { // O(n+m)
        if (c2.data < c1.data) {
          prev.next = c2;
          prev = c2;
          c2 = c2.next;

        } else {
          prev.next = c1;
          prev = c1;
          c1 = c1.next;
        }
      }

      if (c1 == null) {
        prev.next = c2;
      } else {
        prev.next = c1;
      }

      return dummy.next;
    }

    public Node mergeListPQ(Node[] nodes) { //O(KN logk)
      PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

      for (Node node : nodes) {
        if (node != null) {
          pq.add(node);
        }
      }

      Node dummy = new Node(-1);
      Node prev = dummy;

      while (pq.size() != 0) {
        Node minAvail = pq.remove();
        prev.next = minAvail;
        prev = minAvail;
        if (minAvail.next!=null) {
          pq.add(minAvail.next);
        }
      }

      return dummy.next;
    }

    public Node merge2List(Node head1, Node head2) { // O(n+m)
      if (head1 == null) {
        return head2;
      }

      if (head2 == null) {
        return head1;
      }

      Node lhead1 = head1;
      Node lhead2 = head2;

      Node dummy = new Node(-1);
      Node prev = dummy;
      Node c1 = head1;
      Node c2 = head2;

      while (c1 != null && c2 != null) {
        if (c1.data < c2.data) {
          prev.next = c1;
          prev = c1;
          c1 = c1.next;

        } else {
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

    public Node mergeList(Node[] nodes, int si, int ei) {
      if (si > ei) {
        return null;
      }

      if (si == ei) {
        return nodes[si];
      }

      int mid = (si + ei) / 2;

      Node head1 = mergeList(nodes, si, mid);
      Node head2 = mergeList(nodes, mid + 1, ei);

      return merge2List(head1, head2);

    }

    public Node mergeKLists(Node[] nodes) { // O(nk log(k))
      if (nodes == null || nodes.length == 0) {
        return null;
      }

      return mergeList(nodes, 0, nodes.length - 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();
    LinkedList list3 = new LinkedList();

    list1.addLast(0);
    list1.addLast(0);
    list1.addLast(0);

    list2.addLast(0);
    list2.addLast(0);
    list2.addLast(1);
    list2.addLast(1);
    list2.addLast(1);
    list2.addLast(2);
    list2.addLast(2);
    list2.addLast(4);

    list3.addLast(0);
    list3.addLast(0);
    list3.addLast(0);
    list3.addLast(0);
    list3.addLast(5);
    list3.addLast(5);
    list3.addLast(6);

    Node[] nodes = { list1.head, list2.head, list3.head };

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if (str.startsWith("fold")) {
        list.fold();
        list.printList(list.head);
      } else if (str.startsWith("unfold")) {
        list.unfold();
        list.printList(list.head);
      } else if (str.startsWith("merge")) {
        Node head = list.mergeSortedLinkedLists(list.head, list2.head);
        list.printList(head);
      } else if (str.startsWith("Kmerge")) {
        Node head = list.mergeKLists(nodes);
        list.printList(head);
      }else if (str.startsWith("PKmerge")) {
        Node head = list.mergeListPQ(nodes);
        list.printList(head);
      }
      
      str = br.readLine();

    }

  }
}