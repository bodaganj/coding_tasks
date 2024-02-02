package com.coding.tasks.leetcode.third_round.google.others;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

   public static void main(String[] args) {

   }

   public static int numJewelsInStones(String jewels, String stones) {
      Set<Character> jewelsSet = new HashSet<>();
      for (char c : jewels.toCharArray()) {
         jewelsSet.add(c);
      }

      int count = 0;
      for (char c : stones.toCharArray()) {
         if (jewelsSet.contains(c)) {
            count++;
         }
      }

      return count;
   }
}
