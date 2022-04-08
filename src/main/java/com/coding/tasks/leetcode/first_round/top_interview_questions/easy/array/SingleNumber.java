package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

   public static void main(String[] args) {
      System.out.println(singleNumber(new int[]{2, 2, 1, 2}));
      System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2, 2, 1}));
      System.out.println(singleNumber(new int[]{1}));
      System.out.println("-----");
      System.out.println(singleNumberWithConstantSpace(new int[]{2, 2, 1, 2}));
      System.out.println(singleNumberWithConstantSpace(new int[]{4, 1, 2, 1, 2, 2, 1}));
      System.out.println(singleNumberWithConstantSpace(new int[]{1}));
   }

   private static int singleNumber(int[] nums) {
      Map<Integer, Integer> hashMap = new HashMap<>(nums.length / 2 + 1);
      for (int num : nums) {
         hashMap.put(num, (hashMap.getOrDefault(num, 0) + 1));
      }

      return hashMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
   }

   /**
    * MUST have to be written on the A4!!! REMEMBER!!!!
    */
   private static int singleNumberWithConstantSpace(int[] nums) {
      int seenOnce = 0, seenTwice = 0;

      for (int num : nums) {
         // first appearence:
         // add num to seen_once
         // don't add to seen_twice because of presence in seen_once

         // second appearance:
         // remove num from seen_once
         // add num to seen_twice

         // third appearance:
         // don't add to seen_once because of presence in seen_twice
         // remove num from seen_twice
         seenOnce = ~seenTwice & (seenOnce ^ num);
         seenTwice = ~seenOnce & (seenTwice ^ num);
      }

      return seenOnce;
   }
}
