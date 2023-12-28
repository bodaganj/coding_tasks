package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

   public static void main(String[] args) {
      System.out.println(isHappy(2));
      System.out.println(isHappy(19));
   }

   public static boolean isHappy(int n) {
      Set<Integer> seen = new HashSet<>();
      while (n != 1 && !seen.contains(n)) {
         seen.add(n);
         String s = String.valueOf(n);
         n = 0;
         for (char c : s.toCharArray()) {
            int i = Integer.parseInt("" + c);
            n += i * i;
         }
      }
      return n == 1;
   }
}
