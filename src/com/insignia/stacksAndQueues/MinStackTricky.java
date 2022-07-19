package com.insignia.stacksAndQueues;

import java.io.*;
import java.util.*;

public class MinStackTricky {

    Stack<Integer> data;
    int min;

    public MinStackTricky() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      if (data.size() == 0) {
        data.push(val);
        min = val;
      } else if (val >= min) {
        data.push(val);
      } else {
        data.push(val - min);
        min = val;
      }
    }

    int pop() {

      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }

      int val = data.pop();
      if (val < min) {
        int result = min;
        min = min-val;
        return result;
      } else {
        return val;
      }
    }

    int top() {

      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }

      if (data.peek() < min) {
        return min;
      } else {
        return data.peek();
      }
    }

    int min() {
      if (data.size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      }

      return min;
    }



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStackTricky st = new MinStackTricky();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}