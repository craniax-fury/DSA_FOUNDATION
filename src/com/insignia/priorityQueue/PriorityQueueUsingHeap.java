package com.insignia.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PriorityQueueUsingHeap {

    ArrayList<Integer> data;

    public PriorityQueueUsingHeap() {
        data = new ArrayList<>();
    }

    public void add(int val) {
        if (data.isEmpty()) {
            data.add(val);
        } else if (data.size() % 2 != 0) {
            int vp = (data.size() - 1) / 2;
            /** virtual parent */

            if (vp >= 0 && data.get(vp) > val) {
                while (vp >= 0 && data.get(vp) > val) {
                    int temp = data.get(vp);
                    data.set(vp, val);

                    if(2*vp+1>data.size()-1){
                        data.add(2*vp+1, temp);
                    }else{
                        data.set(2*vp+1, temp);
                    }
                    

                    if (vp % 2 != 0) {
                        vp = (vp - 1) / 2;
                    } else {
                        vp = (vp - 2) / 2;
                    }

                }
            } else {
                data.add(val);
            }
        } else if (data.size() % 2 == 0) {
            int vp = (data.size() - 2) / 2;
            /** virtual parent */

            if (vp >= 0 && data.get(vp) > val) {
                while (vp >= 0 && data.get(vp) > val) {
                    int temp = data.get(vp);
                    data.set(vp, val);
                    if(2*vp+2>data.size()-1){
                        data.add(2*vp+2, temp);
                    }else{
                        data.set(2*vp+2, temp);
                    }

                    if (vp % 2 != 0) {
                        vp = (vp - 1) / 2;
                    } else {
                        vp = (vp - 2) / 2;
                    }
                }
            } else {
                data.add(val);
            }
        }
    }

    public int remove() {

        if (data.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        /** set answer at last of list so that it can be removed in O(1) */
        int temp = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.set(data.size() - 1, temp);

        int ans = data.remove(data.size() - 1);

        int parent = 0;

        /**
         * adjust the position of last element as we have swapped it with 0 index , it
         * takes O(log n)
         */
        while ((2 * parent + 1 < data.size() && data.get(parent) > data.get(2 * parent + 1))
                || (2 * parent + 2 < data.size() && data.get(parent) > data.get(2 * parent + 2))) {

            int child = 0;

            if (2 * parent + 1 < data.size() && 2 * parent + 2 < data.size()) {
                if (data.get(2 * parent + 1) < data.get(2 * parent + 2)) {
                    child = 2 * parent + 1;
                } else {
                    child = 2 * parent + 2;
                }
            } else if (2 * parent + 1 < data.size()) {
                child = 2 * parent + 1;

            } else if (2 * parent + 2 < data.size()) {
                child = 2 * parent + 2;
            } else {
                break;
            }

            if (child < data.size() && data.get(parent) > child) {
                int tmp = data.get(parent);
                data.set(parent, data.get(child));
                data.set(child, tmp);

                parent = child;

            }
        }

        return ans;

    }

    public int peek() {
        if (data.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        return data.get(0);
    }

    public int size() {
        return data.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueueUsingHeap qu = new PriorityQueueUsingHeap();

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
            }
            str = br.readLine();
        }
    }
}
