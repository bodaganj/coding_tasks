package com.coding.tasks.leetcode.google.interview_process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitsIntoBaskets {

   public static void main(String[] args) {
      System.out.println(totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
      System.out.println(totalFruit(new int[]{1, 2, 1}));
      System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
      System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
      System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
   }

   private static int totalFruit(int[] fruits) {
      List<Integer> allCombinations = new ArrayList<>();
      List<Integer> currentFruits = new ArrayList<>();
      int currentCombinationSize = 0;

      for (int index = 0; index < fruits.length; index++) {
         int currentFruit = fruits[index];
         if (currentFruits.contains(currentFruit)) {
            currentFruits.add(currentFruit);
            currentCombinationSize++;
            if (index == fruits.length - 1) {
               allCombinations.add(currentCombinationSize);
            }
         } else if (currentFruits.stream().distinct().count() < 2) {
            currentFruits.add(currentFruit);
            currentCombinationSize++;
            if (index == fruits.length - 1) {
               allCombinations.add(currentCombinationSize);
            }
         } else {
            int prevFruit = fruits[index - 1];
            int amount = 0;
            for (int j = currentFruits.size() - 1; j >= 0; j--) {
               if (currentFruits.get(j) == prevFruit) {
                  amount++;
               } else {
                  break;
               }
            }
            currentFruits = new ArrayList<>();
            currentFruits.add(prevFruit);
            currentFruits.add(currentFruit);
            allCombinations.add(currentCombinationSize);
            currentCombinationSize = amount + 1;
         }
      }

      return Collections.max(allCombinations);

      // shorter way to solve:

//      Map<Integer, Integer> count = new HashMap<>();
//      int firstIdx = 0;
//      int totalMax = 0;
//
//      for (int i = 0; i < fruits.length; i++) {
//         count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);
//         while (count.size() > 2) {
//            count.put(fruits[firstIdx], count.get(fruits[firstIdx]) - 1);
//            if (count.get(fruits[firstIdx]) == 0) {
//               count.remove(fruits[firstIdx]);
//            }
//            firstIdx++;
//         }
//         totalMax = Math.max(totalMax, i - firstIdx + 1);
//      }
//      return totalMax;
   }
}
