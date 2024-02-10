package com.coding.tasks.leetcode.third_round.google.others;

public class StrobogrammaticNumber {

   public static void main(String[] args) {

   }

   public static boolean isStrobogrammatic(String num) {
      if (num == null || num.length() == 0) {
         return true;
      }

      int left = 0;
      int right = num.length() - 1;

      while (left <= right) {
         char leftChar = num.charAt(left);
         char rightChar = num.charAt(right);

         if ((leftChar != '6' || rightChar != '9') && (leftChar != '9' || rightChar != '6') && (leftChar != '8' || rightChar != '8') && (leftChar != '0' || rightChar != '0') && (leftChar != '1' || rightChar != '1')) {
            return false;
         }

         left++;
         right--;
      }

      return true;
   }
}
