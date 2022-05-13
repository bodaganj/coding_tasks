package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.math;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountPrimes {

   public static void main(String[] args) {
      System.out.println(countPrimes(20));
   }

   private static int countPrimes(int n) {
      Map<Integer, Boolean> map = new HashMap<>();
      for (int i = 2; i < n; i++) {
         map.put(i, true);
      }

      for (int i = 2; i < n; i++) {
         for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getKey() != i && entry.getKey() % i == 0) {
               entry.setValue(false);
            }
         }

         map = map.entrySet().stream().filter(Map.Entry::getValue).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      }

      return map.size();
   }
}
