package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
      Map<List<Integer>, Integer> memo = new HashMap<>();
      rec(list, memo);
      return max;
   }

   private static int rec(List<Integer> list, Map<List<Integer>, Integer> memo) {
      if (list.size() == 2) {
         return 0;
      } else {
         List<Integer> memoKey = list.subList(1, list.size() - 1);
         if (!memo.containsKey(memoKey)) {
            int currentMax = Integer.MIN_VALUE;
            for (int i = 1; i < list.size() - 1; i++) {
               List<Integer> tmp = new ArrayList<>(list);
               tmp.remove(i);
               int profit = list.get(i - 1) * list.get(i) * list.get(i + 1);
               int nextProfit = rec(tmp, memo);
               currentMax = Math.max(currentMax, nextProfit + profit);
            }
            memo.put(memoKey, currentMax);
            max = Math.max(max, currentMax);
         }
         return memo.get(memoKey);
      }
   }
}
