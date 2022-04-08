package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

public class CompareVersionNumbers {

   public static void main(String[] args) {
      System.out.println(compareVersion("1.0", "1.0.0"));
      System.out.println(compareVersion("1.01", "1.001"));
      System.out.println(compareVersion("0.1", "1.1"));
      System.out.println(compareVersion("1", "1.1"));
   }

   // shorter implementation!!!!!
//   public int compareVersion(String version1, String version2) {
//      String[] nums1 = version1.split("\\.");
//      String[] nums2 = version2.split("\\.");
//      int n1 = nums1.length, n2 = nums2.length;
//
//      // compare versions
//      int i1, i2;
//      for (int i = 0; i < Math.max(n1, n2); ++i) {
//         i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
//         i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
//         if (i1 != i2) {
//            return i1 > i2 ? 1 : -1;
//         }
//      }
//      // the versions are equal
//      return 0;
//   }

   private static int compareVersion(String version1, String version2) {
      String[] digits1 = version1.split("\\.");
      String[] digits2 = version2.split("\\.");

      int[] dig1 = convertToIntArray(digits1);
      int[] dig2 = convertToIntArray(digits2);

      int[] newArray;
      if (dig1.length > dig2.length) {
         newArray = new int[dig1.length];
         System.arraycopy(dig2, 0, newArray, 0, dig2.length);
         return compareArrays(dig1, newArray);
      } else if (dig1.length < dig2.length) {
         newArray = new int[dig2.length];
         System.arraycopy(dig1, 0, newArray, 0, dig1.length);
         return compareArrays(newArray, dig2);
      } else {
         return compareArrays(dig1, dig2);
      }
   }

   private static int[] convertToIntArray(String[] array) {
      int[] integers = new int[array.length];
      for (int i = 0; i < array.length; i++) {
         integers[i] = Integer.parseInt(array[i]);
      }
      return integers;
   }

   private static int compareArrays(int[] first, int[] second) {
      for (int i = 0; i < first.length; i++) {
         if (first[i] > second[i]) {
            return 1;
         } else if (first[i] < second[i]) {
            return -1;
         }
      }
      return 0;
   }
}
