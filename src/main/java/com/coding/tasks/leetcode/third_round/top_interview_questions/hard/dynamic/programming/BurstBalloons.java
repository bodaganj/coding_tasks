package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {

   private static int max = Integer.MIN_VALUE;

   public static void main(String[] args) {
      System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
      System.out.println(maxCoins(new int[]{1, 5}));
   }

   public static int maxCoins(int[] nums) {
      max = 0;
      List<Integer> list = new ArrayList<>();
      list.add(1);
      for (int num : nums) {
         list.add(num);
      }
      list.add(1);
      rec(list, 0);
      return max;
   }

   private static void rec(List<Integer> list, int currentProfit) {
      if (list.size() == 2) {
         max = Math.max(max, currentProfit);
      } else {
         for (int i = 1; i < list.size() - 1; i++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.remove(i);
            int profit = list.get(i - 1) * list.get(i) * list.get(i + 1);
            rec(tmp, currentProfit + profit);
         }
      }
   }
}
