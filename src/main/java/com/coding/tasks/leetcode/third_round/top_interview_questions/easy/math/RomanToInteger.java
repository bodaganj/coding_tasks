package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

   static Map<String, Integer> map;

   static {
      map = new HashMap<>();
      map.put("I", 1);
      map.put("IV", 4);
      map.put("V", 5);
      map.put("IX", 9);
      map.put("X", 10);
      map.put("XL", 40);
      map.put("L", 50);
      map.put("XC", 90);
      map.put("C", 100);
      map.put("CD", 400);
      map.put("D", 500);
      map.put("CM", 900);
      map.put("M", 1000);
   }

   public static void main(String[] args) {
      System.out.println(romanToInt("MCMXCIV"));
   }

   public static int romanToInt(String s) {
      int ans = 0;
      int i = 0;
      while (i < s.length()) {
         if (i < s.length() - 1 && map.containsKey("" + s.charAt(i) + s.charAt(i + 1))) {
            ans += map.get("" + s.charAt(i) + s.charAt(i + 1));
            i++;
         } else {
            ans += map.get("" + s.charAt(i));
         }
         i++;
      }
      return ans;
   }
}
