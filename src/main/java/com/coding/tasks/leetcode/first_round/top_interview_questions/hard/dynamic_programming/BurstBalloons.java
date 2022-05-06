package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BurstBalloons {

   private static int max = 0;

   public static void main(String[] args) {
      System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
//      System.out.println(maxCoins(new int[]{1, 5}));
   }

   private static int maxCoins(int[] nums) {
      max = 0;
      List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
      rec(list, 0, new HashMap<>());
      return max;
   }

   private static int rec(List<Integer> currentList, int currentProduct, Map<List<Integer>, Integer> memo) {
      if (currentList.isEmpty()) {
         max = Math.max(max, currentProduct);
         return currentProduct;
      }

      if (memo.containsKey(currentList)) {
         return memo.get(currentList);
      }

      int currentMax = 0;
      for (int i = 0; i < currentList.size(); i++) {
         List<Integer> tmpList = new ArrayList<>(currentList);
         tmpList.remove(i);
         int product = currentProduct + getProduct(currentList, i);
         int tmp = rec(tmpList, product, memo);
         currentMax = Math.max(currentMax, tmp);
      }
      memo.put(currentList, currentMax);
      return memo.get(currentList);
   }

   private static int getProduct(List<Integer> currentList, int i) {
      if (currentList.size() == 1) {
         return currentList.get(0);
      } else if (i == 0) {
         return currentList.get(i) * currentList.get(i + 1);
      } else if (i == currentList.size() - 1) {
         return currentList.get(i) * currentList.get(i - 1);
      } else {
         return currentList.get(i) * currentList.get(i - 1) * currentList.get(i + 1);
      }
   }
}
