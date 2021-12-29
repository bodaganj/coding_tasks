package com.coding.tasks.leetcode.top.interview.questions.easy.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

   public static void main(String[] args) {
      System.out.println(singleNumber(new int[]{2, 2, 1}));
      System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
      System.out.println(singleNumber(new int[]{1}));
   }

   private static int singleNumber(int[] nums) {
      Map<Integer, Integer> hashMap = new HashMap<>(nums.length / 2 + 1);
      for (int num : nums) {
         hashMap.put(num, (hashMap.getOrDefault(num, 0) + 1));
      }

      return hashMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
   }
}
