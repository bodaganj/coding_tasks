package com.coding.tasks.leetcode.top.interview.questions.medium.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

   public static void main(String[] args) {
      System.out.println(isHappy(10));
      System.out.println(isHappy(19));
      System.out.println(isHappy(2));
   }

   private static boolean isHappy(int n) {
      Set<Integer> seen = new HashSet<>();
      while (!seen.contains(n)) {
         seen.add(n);

         if (n == 1) {
            return true;
         } else {
            String str = n + "";

            n = 0;
            for (char aChar : str.toCharArray()) {
               int i = Integer.parseInt(aChar + "");
               n += i * i;
            }
         }
      }

      return false;
   }
}
