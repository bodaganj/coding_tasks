package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.List;

public class RomanToInteger {

   public static void main(String[] args) {
      System.out.println(romanToInt("III"));
      System.out.println(romanToInt("LVIII"));
      System.out.println(romanToInt("MCMXCIV"));
   }

   private static int romanToInt(String s) {
      List<Integer> integers = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
      List<String> roman = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

      int answer = 0;
      int i = 0;
      while (i < s.length()) {
         if (i < s.length() - 1) {
            String twoStrings = s.substring(i, i + 2);
            if (roman.contains(twoStrings)) {
               answer += integers.get(roman.indexOf(twoStrings));
               i = i + 2;
               continue;
            }
         }
         answer += integers.get(roman.indexOf(s.charAt(i) + ""));
         i++;
      }
      return answer;
   }
}
