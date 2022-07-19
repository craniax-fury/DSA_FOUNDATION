package com.insignia.stacksAndQueues;

import java.io.*;

public class DynamicStack {

    int[] data;
    int tos;

    public DynamicStack(int cap) {
        data = new int[cap];
        tos = -1;
    }

    int size() {
        return tos + 1;
    }

    void display() {
        for (int index = tos; index >= 0; index--) {
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    void push(int val) {
        if (tos >= data.length - 1) {
            int[] ns = new int[2 * data.length];
            for (int index = 0; index < data.length; index++) {
                ns[index] = data[index];
            }
            data = ns;
            tos++;
            data[tos] = val;

        } else {
            tos++;
            data[tos] = val;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return tos;
        } else {
            int val = data[tos];
            tos--;
            return val;
        }
    }

    int top() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return tos;
        } else {
            return data[tos];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DynamicStack st = new DynamicStack(n);

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
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}