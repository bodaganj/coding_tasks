package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
      System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
   }

   public static int[] intersect(int[] nums1, int[] nums2) {
      List<Integer> intersections = new ArrayList<>();
      if (nums1.length < nums2.length) {
         calc(nums1, nums2, intersections);
      } else {
         calc(nums2, nums1, intersections);
      }
      return intersections.stream().mapToInt(i -> i).toArray();
   }

   private static Map<Integer, Integer> getSmallestMapping(int[] smallestArray) {
      Map<Integer, Integer> smallMap = new HashMap<>();
      for (int i : smallestArray) {
         if (smallMap.containsKey(i)) {
            smallMap.put(i, smallMap.get(i) + 1);
         } else {
            smallMap.put(i, 1);
         }
      }
      return smallMap;
   }

   private static void calc(int[] smaller, int[] bigger, List<Integer> intersections) {
      Map<Integer, Integer> smallMap = getSmallestMapping(smaller);
      for (int i : bigger) {
         if (smallMap.containsKey(i)) {
            intersections.add(i);
            if (smallMap.get(i) == 1) {
               smallMap.remove(i);
            } else {
               smallMap.put(i, smallMap.get(i) - 1);
            }
         }
      }
   }
}
