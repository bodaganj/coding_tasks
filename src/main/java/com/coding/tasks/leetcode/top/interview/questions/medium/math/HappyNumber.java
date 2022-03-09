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
            int tmp = 0;
            while (n != 0) {
               int i = n % 10;
               tmp += i * i;
               n /= 10;
            }
            n = tmp;
         }
      }

      return false;
   }
}
