package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

   public static void main(String[] args) {
//      [4,7,9,7,6,7]
//[5,0,0,6,1,6,2,2,4]
      System.out.println(Arrays.toString(intersect(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})));
//      System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
   }

   private static int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1); // O(n * log n)
      Arrays.sort(nums2); // O(m * log m)

      if (nums1.length < nums2.length) {
         return getIntersection(nums1, nums2);
      } else {
         return getIntersection(nums2, nums1);
      }
   }

   private static int[] getIntersection(int[] smaller, int[] bigger) {
      int i = 0;
      int j = 0;
      List<Integer> result = new ArrayList<>();
      while (i < smaller.length && j < bigger.length) { // O (N + M)
         int currentSmall = smaller[i];
         int currentBig = bigger[j];

         if (currentSmall == currentBig) {
            result.add(currentSmall);
            j++;
            i++;
         } else if (currentSmall < currentBig) {
            i++;
         } else {
            j++;
         }
      }
      return result.stream().mapToInt(in -> in).toArray();
   }
}
