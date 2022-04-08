package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.math;

import java.util.LinkedList;

public class CountPrimes {

   public static void main(String[] args) {
      System.out.println(countPrimes(20));
   }

   private static int countPrimes(int n) {
      if (n <= 2) {
         return 0;
      }

      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 2; i < n; i++) {
         list.add(i);
      }

      for (int i = 0; i < list.size(); i++) {
         for (int j = i + 1; j < list.size(); j++) {
            if (list.get(j) % list.get(i) == 0) {
               list.remove(j);
            }
         }
      }
      System.out.println(list);
      return list.size();
   }
}
