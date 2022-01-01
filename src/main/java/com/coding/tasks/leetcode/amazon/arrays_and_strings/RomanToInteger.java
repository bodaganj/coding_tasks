package com.coding.tasks.leetcode.amazon.arrays_and_strings;

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
      int length = s.length();

      while (i < length) {
         char c = s.charAt(i);

         if (c == 'C') {
            if (s.indexOf("CM") == i || s.indexOf("CD") == i) {
               answer += integers.get(roman.indexOf("" + c + s.charAt(i + 1)));
               i++;
            } else {
               answer += integers.get(roman.indexOf(c + ""));
            }
         } else if (c == 'X') {
            if (s.indexOf("XC") == i || s.indexOf("XL") == i) {
               answer += integers.get(roman.indexOf("" + c + s.charAt(i + 1)));
               i++;
            } else {
               answer += integers.get(roman.indexOf(c + ""));
            }
         } else if (c == 'I') {
            if (s.indexOf("IX") == i || s.indexOf("IV") == i) {
               answer += integers.get(roman.indexOf("" + c + s.charAt(i + 1)));
               i++;
            } else {
               answer += integers.get(roman.indexOf(c + ""));
            }
         } else {
            answer += integers.get(roman.indexOf(c + ""));
         }

         i++;
      }
      return answer;
   }
}
