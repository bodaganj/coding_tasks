package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

   public static void main(String[] args) {
      System.out.println(isHappy(10));
      System.out.println(isHappy(19));
      System.out.println(isHappy(2));
   }

   private static boolean isHappy(int n) {
      return rec(n, new HashSet<>());
   }

   private static boolean rec(int n, Set<Integer> visited) {
      if (visited.contains(n)) {
         return false;
      } else if (n == 1) {
         return true;
      } else {
         visited.add(n);

         int newN = 0;
         while (n / 10 > 0) {
            int tmp = n % 10;
            newN += tmp * tmp;
            n /= 10;
         }
         newN += n * n;
         return rec(newN, visited);
      }
   }
}
