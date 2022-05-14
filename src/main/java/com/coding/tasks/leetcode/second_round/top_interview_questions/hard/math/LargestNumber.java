package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

   public static void main(String[] args) {
      System.out.println(largestNumber(new int[]{10, 2}));
      System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
      System.out.println(largestNumber(new int[]{3, 30, 34}));
      System.out.println(largestNumber(new int[]{111311, 1113}));
      System.out.println(largestNumber(new int[]{8308, 8308, 830}));
   }

   private static String largestNumber(int[] nums) {
      List<String> list = new ArrayList<>();
      for (int num : nums) {
         list.add(num + "");
      }

      Comparator<String> custom = (o1, o2) -> {
         int i = 0;
         while (i < o1.length() && i < o2.length()) {
            if (o1.charAt(i) == o2.charAt(i)) {
               i++;
            } else {
               return Integer.parseInt(o2.charAt(i) + "") - Integer.parseInt(o1.charAt(i) + "");
            }
         }

         if (o1.length() == o2.length()) {
            return 0;
         }

         if (i >= o1.length()) { // 113 : 11311
            if (o2.charAt(i) < o1.charAt(0)) {
               return -1;
            } else {
               return 1;
            }
         } // 111311, 1113

         // 34 : 3 and 30 : 3
         if (o1.charAt(i) <= o2.charAt(0)) {
            return 1;
         } else {
            return -1;
         } // 34,3,30
      };

      list.sort(custom);
      return String.join("", list);
   }
}
