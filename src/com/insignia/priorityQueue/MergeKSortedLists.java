package com.insignia.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

   public static class Pair implements Comparable<Pair> {
      int listIndex;
      int dataIndex;
      int val;

      public Pair(int listIndex, int dataIndex, int val) {
         this.listIndex = listIndex;
         this.dataIndex = dataIndex;
         this.val = val;
      }

      @Override
      public int compareTo(Pair pair) {
         return this.val - pair.val;
      }
   }

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<Pair> queue = new PriorityQueue<>();

      for (int i = 0; i < lists.size(); i++) {
         queue.add(new Pair(i, 0, lists.get(i).get(0)));
      }

      while (!queue.isEmpty()) {
         Pair pair = queue.remove();
         rv.add(pair.val);

         if (lists.get(pair.listIndex).size() - 1 != pair.dataIndex) {
            queue.add(new Pair(pair.listIndex, pair.dataIndex + 1, lists.get(pair.listIndex).get(pair.dataIndex + 1)));
         }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for (int i = 0; i < k; i++) {
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for (int j = 0; j < n; j++) {
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for (int val : mlist) {
         System.out.print(val + " ");
      }
      System.out.println();
   }
}
