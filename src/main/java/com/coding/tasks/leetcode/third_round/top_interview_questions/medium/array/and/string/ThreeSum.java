package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

   public static void main(String[] args) {
//      System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//      System.out.println(threeSum(new int[]{0, -1, 1}));
      System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
   }

   public static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();

      Map<Integer, Integer> map = new HashMap<>();
      for (int curr : nums) {
         if (map.containsKey(curr)) {
            map.put(curr, map.get(curr) + 1);
         } else {
            map.put(curr, 1);
         }
      }

      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            int target = -1 * (nums[i] + nums[j]);
            if (target == nums[i] && map.get(target) <= 1) {
               continue;
            }
            if (target == nums[j] && map.get(target) <= 1) {
               continue;
            }
            if (target == nums[j] && target == nums[i] && map.get(target) <= 2) {
               continue;
            }
            if (map.containsKey(target)) {
               List<Integer> tmp = new ArrayList<>();
               tmp.add(nums[i]);
               tmp.add(nums[j]);
               tmp.add(target);
               Collections.sort(tmp);
               ans.add(tmp);
            }
         }
      }
      return ans.stream().toList();
   }
}
