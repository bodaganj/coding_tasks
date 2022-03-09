package com.coding.tasks.leetcode.top.interview.questions.easy.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

   public static void main(String[] args) {
      System.out.println(romanToInt("III"));
      System.out.println(romanToInt("MCMXCIV"));
   }

   private static int romanToInt(String s) {
      Map<String, Integer> mapping = new HashMap<>();
      mapping.put("M", 1000);
      mapping.put("CM", 900);
      mapping.put("D", 500);
      mapping.put("CD", 400);
      mapping.put("C", 100);
      mapping.put("XC", 90);
      mapping.put("L", 50);
      mapping.put("XL", 40);
      mapping.put("X", 10);
      mapping.put("IX", 9);
      mapping.put("V", 5);
      mapping.put("IV", 4);
      mapping.put("I", 1);

      int ans = 0;
      char[] chars = s.toCharArray();

      int i = 0;
      while (i < chars.length) {
         StringBuilder sb = new StringBuilder();
         sb.append(chars[i]);

         if (i < chars.length - 1) {
            if (mapping.containsKey(sb.toString() + chars[i + 1])) {
               sb.append(chars[i + 1]);
               i++;
            }
         }

         ans += mapping.get(sb.toString());
         i++;
      }
      return ans;
   }
}
