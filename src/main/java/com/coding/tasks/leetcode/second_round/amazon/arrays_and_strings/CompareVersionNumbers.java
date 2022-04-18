package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

public class CompareVersionNumbers {

   public static void main(String[] args) {
      System.out.println(compareVersion("1.0", "1.0.0"));
      System.out.println(compareVersion("1.01", "1.001"));
      System.out.println(compareVersion("0.1", "1.1"));
      System.out.println(compareVersion("1", "1.1"));
   }

   private static int compareVersion(String version1, String version2) {
      String[] version1Split = version1.split("\\.");
      String[] version2Split = version2.split("\\.");

      int counter1 = 0;
      int counter2 = 0;

      while (counter1 < version1Split.length && counter2 < version2Split.length) {
         int i1 = Integer.parseInt(version1Split[counter1]);
         int i2 = Integer.parseInt(version2Split[counter2]);
         if (i1 != i2) {
            return i1 < i2 ? -1 : 1;
         } else {
            counter1++;
            counter2++;
         }
      }

      while (counter1 < version1Split.length) {
         if (Integer.parseInt(version1Split[counter1]) > 0) {
            return 1;
         } else {
            counter1++;
         }
      }
      while (counter2 < version2Split.length) {
         if (Integer.parseInt(version2Split[counter2]) > 0) {
            return -1;
         } else {
            counter2++;
         }
      }

      return 0;
   }
}
