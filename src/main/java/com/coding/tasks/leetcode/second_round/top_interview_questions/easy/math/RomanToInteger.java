package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.math;

import java.util.Map;

public class RomanToInteger {

   private static Map<String, Integer> doubleStr = Map.of("IV", 4,
                                                          "IX", 9,
                                                          "XL", 40,
                                                          "XC", 90,
                                                          "CD", 400,
                                                          "CM", 900);
   private static Map<String, Integer> singleStr = Map.of("I", 1,
                                                          "V", 5,
                                                          "X", 10,
                                                          "L", 50,
                                                          "C", 100,
                                                          "D", 500,
                                                          "M", 1000);

   public static void main(String[] args) {
      System.out.println(romanToInt("III"));
      System.out.println(romanToInt("MCMXCIV"));
   }

   private static int romanToInt(String s) {
      return rec(s, 0);
   }

   private static int rec(String s, int current) {
      if (s.isEmpty()) {
         return current;
      } else {
         for (Map.Entry<String, Integer> entry : doubleStr.entrySet()) {
            if (s.startsWith(entry.getKey())) {
               return rec(s.substring(2), current + entry.getValue());
            }
         }
         for (Map.Entry<String, Integer> entry : singleStr.entrySet()) {
            if (s.startsWith(entry.getKey())) {
               return rec(s.substring(1), current + entry.getValue());
            }
         }
         return 0;
      }
   }
}
