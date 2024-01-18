package com.coding.tasks.leetcode.third_round.top_interview_questions.google.interview.process;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

   public static void main(String[] args) {
      System.out.println(totalFruit(new int[]{1, 2, 1}));
      System.out.println(totalFruit(new int[]{1, 2, 1, 4, 4, 4, 4}));
   }

   public static int totalFruit(int[] fruits) {
      int max = 0;
      Map<Integer, Integer> map = new HashMap<>();
      int left = 0;

      for (int fruit : fruits) {
         map.put(fruit, map.getOrDefault(fruit, 0) + 1);
         if (map.keySet().size() == 3) {
            max = Math.max(max, map.values().stream().mapToInt(o -> o).sum() - 1);
         }
         while (map.size() == 3) {
            int fruitLeft = fruits[left];
            if (map.get(fruitLeft) == 1) {
               map.remove(fruitLeft);
            } else {
               map.put(fruitLeft, map.get(fruitLeft) - 1);
            }
            left++;
         }
      }
      max = Math.max(max, map.values().stream().mapToInt(o -> o).sum());
      return max;
   }
}
