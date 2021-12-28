package com.coding.tasks.cracking.the.code.arrays.and.strings;

public class SimilarString {

   public static void main(String[] args) {
      System.out.println(areStringsSimilar("pale", "ple"));
      System.out.println(areStringsSimilar("pales", "pale"));
      System.out.println(areStringsSimilar("pale", "bale"));
      System.out.println(areStringsSimilar("pales", "bake"));
   }

   /**
    * One step to have similar strings
    */
   private static boolean areStringsSimilar(String first, String second) {
      int firstLength = first.length();
      int secondLength = second.length();

      if (firstLength == secondLength) {
         int counter = 0;
         for (int i = 0; i < firstLength; i++) {
            if (first.charAt(i) != second.charAt(i)) {
               counter++;
            }
            if (counter > 1) {
               return false;
            }
         }
      } else if (Math.abs(firstLength - secondLength) == 1) {
         int i = 0;
         int j = 0;
         int counter = 0;

         while (i < firstLength && j < secondLength) {
            if (first.charAt(i) == second.charAt(j)) {
               i++;
               j++;
            } else if (firstLength > secondLength) {
               counter++;
               i++;
            } else {
               counter++;
               j++;
            }
            if (counter > 1) {
               return false;
            }
         }
      } else {
         return false;
      }
      return true;
   }
}
