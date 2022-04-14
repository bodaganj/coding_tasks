package com.coding.tasks.leetcode.second_round.google.interview_process;

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

   private static int totalFruit(int[] fruits) {
      int max = 1;
      Map<Integer, Integer> map = new HashMap<>();
      int left = 0;
      int right = 0;
      while (right < fruits.length) {
         int fruit = fruits[right];
         if (map.keySet().size() < 2 || map.containsKey(fruit)) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            right++;
         } else {
            while (map.keySet().size() == 2) {
               map.put(fruits[left], map.get(fruits[left]) - 1);
               if (map.get(fruits[left]) == 0) {
                  map.remove(fruits[left]);
               }
               left++;
            }
         }
         max = Math.max(max, map.values().stream().mapToInt(Integer::intValue).sum());
      }

      return max;
   }
}
