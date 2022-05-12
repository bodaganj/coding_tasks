package com.coding.tasks.leetcode.second_round.google.other;

import java.util.Map;

public class StrobogrammaticNumber {

   public static void main(String[] args) {
      System.out.println(isStrobogrammatic("69"));
      System.out.println(isStrobogrammatic("180"));
      System.out.println(isStrobogrammatic("88"));
      System.out.println(isStrobogrammatic("1196"));
   }

   private static boolean isStrobogrammatic(String num) {
      Map<Character, Character> map = Map.of('0', '0', '8', '8', '1', '1', '6', '9', '9', '6');
      int left = 0;
      int right = num.length() - 1;
      while (left <= right) {
         if (!map.containsKey(num.charAt(left)) || !map.containsKey(num.charAt(right))) {
            return false;
         } else {
            if (map.get(num.charAt(left)) != num.charAt(right)) {
               return false;
            }
         }
         left++;
         right--;
      }
      return true;
   }
}
