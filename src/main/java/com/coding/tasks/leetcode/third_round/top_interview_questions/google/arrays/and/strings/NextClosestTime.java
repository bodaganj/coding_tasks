package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {

   public static void main(String[] args) {
      System.out.println(nextClosestTime("19:39"));
      System.out.println(nextClosestTime("19:34"));
      System.out.println(nextClosestTime("23:59"));
   }

   public static String nextClosestTime(String time) {
      Set<Integer> set = new HashSet<>();
      for (char c : time.toCharArray()) {
         if (Character.isDigit(c)) {
            set.add(Integer.parseInt(c + ""));
         }
      }
      List<Integer> list = new ArrayList<>(set);
      Collections.sort(list);

      int currentSecondMinute = Integer.parseInt(time.charAt(4) + "");
      int nextSecondMinute = getNext(9, list, currentSecondMinute);
      if (nextSecondMinute > currentSecondMinute) {
         return time.substring(0, 4) + nextSecondMinute;
      }

      int currentFirstMinute = Integer.parseInt(time.charAt(3) + "");
      int nextFirstMinute = getNext(5, list, currentFirstMinute);
      if (nextFirstMinute > currentFirstMinute) {
         return time.substring(0, 3) + nextFirstMinute + nextSecondMinute;
      }

      int currentSecondHour = Integer.parseInt(time.charAt(1) + "");
      int nextSecondHour;
      if (time.charAt(0) == '2') {
         nextSecondHour = getNext(3, list, currentSecondHour);
      } else {
         nextSecondHour = getNext(9, list, currentSecondHour);
      }
      if (nextSecondHour > currentSecondHour) {
         return time.substring(0, 1) + nextSecondHour + ":" + nextFirstMinute + nextSecondMinute;
      }

      int currentFirstHour = Integer.parseInt(time.charAt(0) + "");
      int nextFirstHour = getNext(2, list, currentFirstHour);
      return "" + nextFirstHour + nextSecondHour + ":" + nextFirstMinute + nextSecondMinute;
   }

   private static int getNext(int limit, List<Integer> list, int current) {
      int i = 0;
      while (i < list.size() && list.get(i) <= limit) {
         if (list.get(i) > current) {
            return list.get(i);
         }
         i++;
      }
      return list.get(0);
   }
}
