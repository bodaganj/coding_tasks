package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

   public static void main(String[] args) {
      System.out.println(numDecodings("12"));
      System.out.println(numDecodings("226"));
      System.out.println(numDecodings("06"));
      System.out.println(numDecodings("27"));
      System.out.println(numDecodings("10011"));
   }

   private static int numDecodings(String s) {
      if (s.charAt(0) == '0') {
         return 0;
      }
      return rec(s, 0, new HashMap<>());
   }

   private static int rec(String str, int index, Map<Integer, Integer> memo) {
      int length = str.length();

      if (index == length) {
         return 1;
      } else if (memo.containsKey(index)) {
         return memo.get(index);
      }

      if (str.charAt(index) == '0') {
         memo.put(index, 0);
      } else {
         int counter = 0;
         char curr = str.charAt(index);

         counter += rec(str, index + 1, memo);

         if (index + 1 < length) {
            if (curr == '1') {
               counter += rec(str, index + 2, memo);
            } else if (curr == '2' && str.charAt(index + 1) < '7') {
               counter += rec(str, index + 2, memo);
            }
         }
         memo.put(index, counter);
      }
      return memo.get(index);
   }
}
