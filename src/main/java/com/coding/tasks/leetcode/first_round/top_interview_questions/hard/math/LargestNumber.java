package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.math;

import java.util.ArrayList;
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
         list.add(String.valueOf(num));
      }
      list.sort((o1, o2) -> {
         if (o1.equals(o2)) {
            return 0;
         } else {
            int fL = o1.length();
            int sL = o2.length();

            int i = 0;
            while (i < fL && i < sL) {
               int i1 = Integer.parseInt(o1.charAt(i) + "");
               int i2 = Integer.parseInt(o2.charAt(i) + "");

               if (i1 < i2) {
                  return 1;
               }
               if (i1 > i2) {
                  return -1;
               }
               i++;
            }

            if (i == sL) {
               if (Integer.parseInt(o1.charAt(i) + "") == 0) {
                  return 1;
               } else {
                  return -1;
               }
            } else {
               if (Integer.parseInt(o2.charAt(i) + "") == 0) {
                  return 1;
               } else {
                  return -1;
               }
            }
         }
      });

      StringBuilder sb = new StringBuilder();
      for (String s : list) {
         sb.append(s);
      }

      return sb.toString();
   }
}
