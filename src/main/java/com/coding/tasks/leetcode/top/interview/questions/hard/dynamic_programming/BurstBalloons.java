package com.coding.tasks.leetcode.top.interview.questions.hard.dynamic_programming;

import java.util.LinkedList;
import java.util.List;

public class BurstBalloons {

   private static int max;

   public static void main(String[] args) {
      System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
   }

   private static int maxCoins(int[] nums) {
      max = Integer.MIN_VALUE;
      LinkedList<Integer> list = new LinkedList<>();
      int i = 0;
      while (i < nums.length) {
         if (nums[i] != 0) {
            list.add(nums[i]);
         }
         i++;
      }

      if (list.size() > 0) {
         list.addFirst(1);
         list.addLast(1);
      }

      rec(list, 0);
      return max;
   }

   // TLE
   private static void rec(List<Integer> list, int currentSum) {
      if (list.size() == 2) {
         max = Math.max(max, currentSum);
         return;
      }

      for (int i = 1; i < list.size() - 1; i++) {
         int boost = list.get(i - 1) * list.get(i) * list.get(i + 1);

         LinkedList<Integer> tmp = new LinkedList<>(list);
         tmp.remove(i);

         rec(tmp, currentSum + boost);
      }
   }
}
