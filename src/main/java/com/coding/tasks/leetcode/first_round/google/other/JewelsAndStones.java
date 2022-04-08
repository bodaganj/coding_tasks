package com.coding.tasks.leetcode.first_round.google.other;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

   public static void main(String[] args) {

   }

   private static int numJewelsInStones(String jewels, String stones) {
      Set<Character> jSet = new HashSet<>();
      for (char aChar : jewels.toCharArray()) {
         jSet.add(aChar);
      }

      int count = 0;
      for (char aChar : stones.toCharArray()) {
         if (jSet.contains(aChar)) {
            count++;
         }
      }

      return count;
   }
}
