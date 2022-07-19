package com.insignia.stacksAndQueues;

import java.io.*;

public class DynamicQueue {

  int[] data;
  int front;
  int size;

  public DynamicQueue(int cap) {
    data = new int[cap];
    front = 0;
    size = 0;
  }

  int remove() {
    if (size == 0) {
      System.out.println("Queue underflow");
      return -1;
    }
    int val = data[front];
    front = (front+1)%data.length;
    size--;

    return val;
  }

  void display() {
    for (int i = 0; i < size; i++) {
      int index = (front + i) % data.length;
      System.out.print(data[index] + " ");
    }

    System.out.println();
  }

  void add(int val) {
    if (size == data.length) {
      int[] temp = new int[2 * data.length];

      for (int i = 0; i < size; i++) {
        int index = (front + i) % data.length;

        temp[i] = data[index];
      }
      front = 0;
      temp[size] = val;
      size++;
      data = temp;
    } else {

      int rear = (front + size) % data.length;
      data[rear] = val;
      size++;
    }
  }

  int peek() {
    if (size == 0) {
      System.out.println("Queue underflow");
      return -1;
    }

    return data[front];
  }

  int size() {
    return size;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    DynamicQueue qu = new DynamicQueue(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if (str.startsWith("display")) {
        qu.display();
      }
      str = br.readLine();
    }
  }
}