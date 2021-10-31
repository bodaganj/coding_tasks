package com.coding.tasks.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

   /**
    * Find common digits between two arrays (not intersections exactly)
    * @param args
    */
   public static void main(String[] args) {
      for (int i : intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
         System.out.print(i + " ");
      }
      System.out.println();
      for (int i : intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) {
         System.out.print(i + " ");
      }
   }

   private static int[] intersect(int[] nums1, int[] nums2) {
      if (nums1.length <= nums2.length) {
         return getIntersection(nums1, nums2);
      } else {
         return getIntersection(nums2, nums1);
      }
   }

   private static int[] getIntersection(int[] smaller, int[] bigger) {
      List<Integer> result = new ArrayList<>();
      Map<Integer, Integer> smallerDigitsAmount = new HashMap<>();
      for (int currentValue : smaller) {
         if (smallerDigitsAmount.containsKey(currentValue)) {
            smallerDigitsAmount.put(currentValue, smallerDigitsAmount.get(currentValue) + 1);
         } else {
            smallerDigitsAmount.put(currentValue, 1);
         }
      }

      for (int digit : bigger) {
         if (smallerDigitsAmount.containsKey(digit) && smallerDigitsAmount.get(digit) > 0) {
            result.add(digit);
            smallerDigitsAmount.put(digit, smallerDigitsAmount.get(digit) - 1);
         }
      }
      return result.stream().mapToInt(i -> i).toArray();
   }
}
