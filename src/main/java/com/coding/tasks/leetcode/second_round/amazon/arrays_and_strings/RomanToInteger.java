package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

   public static void main(String[] args) {
//      System.out.println(romanToInt("III"));
//      System.out.println(romanToInt("LVIII"));
      System.out.println(romanToInt("MCMXCIV")); // 1994
   }

   private static int romanToInt(String s) {
      Map<String, Integer> mapping = new HashMap<>();
      mapping.put("I", 1);
      mapping.put("V", 5);
      mapping.put("X", 10);
      mapping.put("L", 50);
      mapping.put("C", 100);
      mapping.put("D", 500);
      mapping.put("M", 1000);
      mapping.put("IV", 4);
      mapping.put("IX", 9);
      mapping.put("XL", 40);
      mapping.put("XC", 90);
      mapping.put("CD", 400);
      mapping.put("CM", 900);

      int result = 0;
      char[] chars = s.toCharArray();
      int i = 0;
      while (i < chars.length) {
         char curr = chars[i];
         if (i + 1 < chars.length && mapping.containsKey(curr + "" + chars[i + 1])) {
            result += mapping.get(curr + "" + chars[i + 1]);
            i++;
         } else {
            result += mapping.get(curr + "");
         }
         i++;
      }

      return result;
   }
}
