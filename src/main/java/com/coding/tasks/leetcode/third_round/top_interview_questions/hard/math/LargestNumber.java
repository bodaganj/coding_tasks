package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

   public static void main(String[] args) {
      System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
   }

   public static String largestNumber(int[] nums) {
      List<String> list = new ArrayList<>();
      for (int num : nums) {
         list.add(Integer.toString(num));
      }

      Collections.sort(list, (o1, o2) -> {
         String order1 = o1 + o2;
         String order2 = o2 + o1;
         return order2.compareTo(order1);
      });
      if (list.get(0).equals("0")) {
         return "0";
      }
      return String.join("", list);
   }
}
