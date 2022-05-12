package com.coding.tasks.leetcode.second_round.google.other;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

   public static void main(String[] args) {

   }

   private static int numJewelsInStones(String jewels, String stones) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < jewels.length(); i++) {
         set.add(jewels.charAt(i));
      }

      int counter = 0;
      for (int i = 0; i < stones.length(); i++) {
         if (set.contains(stones.charAt(i))) {
            counter++;
         }
      }

      return counter;
   }
}
