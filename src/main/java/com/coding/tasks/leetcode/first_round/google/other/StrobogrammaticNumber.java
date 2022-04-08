package com.coding.tasks.leetcode.first_round.google.other;

import java.util.Set;

public class StrobogrammaticNumber {

   public static void main(String[] args) {
      System.out.println(isStrobogrammatic("69"));
      System.out.println(isStrobogrammatic("180"));
      System.out.println(isStrobogrammatic("88"));
      System.out.println(isStrobogrammatic("1196"));
   }

   private static boolean isStrobogrammatic(String num) {
      Set<Character> dontCare = Set.of('0', '1', '8');

      int i = 0;
      int length = num.length() - 1;
      while (i <= length / 2) {
         if (num.charAt(i) != num.charAt(length - i)) {
            if ((num.charAt(i) != '6' || num.charAt(length - i) != '9') && (num.charAt(i) != '9' || num.charAt(length - i) != '6')) {
               return false;
            }
         } else {
            if (!(dontCare.contains(num.charAt(i)))) {
               return false;
            }
         }

         i++;
      }

      return true;
   }
}
