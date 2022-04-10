package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(intersect(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})));
      System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
   }

   private static int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> mapping = new HashMap<>();
      for (int i : nums1) {
         mapping.put(i, mapping.getOrDefault(i, 0) + 1);
      }

      List<Integer> ans = new ArrayList<>();
      for (int i : nums2) {
         if (mapping.containsKey(i)) {
            ans.add(i);
            int value = mapping.get(i) - 1;
            if (value == 0) {
               mapping.remove(i);
            } else {
               mapping.put(i, value);
            }
         }
      }

      int[] res = new int[ans.size()];
      int i = 0;
      for (Integer an : ans) {
         res[i] = an;
         i++;
      }

      return res;
   }
}
