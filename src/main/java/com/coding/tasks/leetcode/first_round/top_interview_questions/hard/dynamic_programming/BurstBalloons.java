package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {

   private static int max = 0;

   public static void main(String[] args) {
      System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
      System.out.println(maxCoins(new int[]{1, 5}));
   }

   private static int maxCoins(int[] nums) {
      max = 0;
      List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
      rec(list, 0);
      return max;
   }

   private static int rec(List<Integer> currentList, int currentProduct) {
      if (currentList.size() == 1) {
         int product = currentProduct + currentList.get(0);
         max = Math.max(max, product);
         return product;
      }

      int currentMax = 0;
      for (int i = 0; i < currentList.size(); i++) {
         List<Integer> tmpList = new ArrayList<>(currentList);
         tmpList.remove(i);
         int product = currentProduct + getProduct(currentList, i);
         int tmp = rec(tmpList, product);
         currentMax = Math.max(currentMax, tmp);
      }
      return currentMax;
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
