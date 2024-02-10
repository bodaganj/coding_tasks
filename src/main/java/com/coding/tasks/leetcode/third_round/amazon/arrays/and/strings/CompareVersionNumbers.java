package com.coding.tasks.leetcode.third_round.amazon.arrays.and.strings;

public class CompareVersionNumbers {

   public static void main(String[] args) {
      System.out.println(compareVersion("1.0.0", "1.0")); //
      System.out.println(compareVersion("1", "1.1")); //
   }

   public static int compareVersion(String version1, String version2) {
      String[] split1 = version1.split("\\.");
      String[] split2 = version2.split("\\.");

      int i1 = 0;
      int i2 = 0;
      while (i1 < split1.length || i2 < split2.length) {
         int ver1 = i1 < split1.length ? Integer.parseInt(split1[i1]) : 0;
         int ver2 = i2 < split2.length ? Integer.parseInt(split2[i2]) : 0;

         if (ver1 != ver2) {
            return ver1 > ver2 ? 1 : -1;
         }
         i1++;
         i2++;
      }

      return 0;
   }
}
