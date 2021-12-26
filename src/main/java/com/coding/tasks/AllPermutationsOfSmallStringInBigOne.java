package com.coding.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutationsOfSmallStringInBigOne {

   public static void main(String[] args) {
      System.out.println(getIndexesOfAllPermutations("BACDGABCDA", "ABCD"));
      System.out.println(getIndexesOfAllPermutations("AAAABABAA", "AABA"));
   }

   private static List<Integer> getIndexesOfAllPermutations(String big, String small) {
      List<Integer> result = new ArrayList<>();

      int smallLength = small.length();
      int bigLength = big.length();

      char[] smallChars = new char[256];
      char[] bigChars = new char[256];

      for (int i = 0; i < smallLength; i++) {
         smallChars[small.charAt(i)]++;
         bigChars[big.charAt(i)]++;
      }

      if (Arrays.equals(smallChars, bigChars)) {
         result.add(0);
      }

      for (int i = smallLength; i < bigLength; i++) {
         bigChars[big.charAt(i)]++;
         bigChars[big.charAt(i - smallLength)]--;

         if (Arrays.equals(smallChars, bigChars)) {
            result.add(i - smallLength + 1);
         }
      }

      return result;
   }
}
