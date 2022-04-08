package com.coding.tasks.leetcode.first_round.google.interview_process;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

   public static void main(String[] args) {
      System.out.println(totalFruit(new int[]{0, 1, 1, 4, 3}));
      System.out.println(totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
      System.out.println(totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
      System.out.println(totalFruit(new int[]{1, 2, 1}));
      System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
      System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
      System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
   }

   // kinda two pointer algorithm
   private static int totalFruit(int[] fruits) {
      Map<Integer, Integer> count = new HashMap<>();
      int firstIdx = 0;
      int totalMax = 0;

      for (int i = 0; i < fruits.length; i++) {
         count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);
         while (count.size() > 2) {
            count.put(fruits[firstIdx], count.get(fruits[firstIdx]) - 1);
            if (count.get(fruits[firstIdx]) == 0) {
               count.remove(fruits[firstIdx]);
            }
            firstIdx++;
         }
         totalMax = Math.max(totalMax, i - firstIdx + 1);
      }
      return totalMax;
   }
}
