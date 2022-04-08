package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.List;

public class IntegerToRoman {

   public static void main(String[] args) {
      System.out.println(intToRoman(3));
      System.out.println(intToRoman(4));
      System.out.println(intToRoman(12));
      System.out.println(intToRoman(113));
      System.out.println(intToRoman(114));
      System.out.println(intToRoman(1994));
   }

   private static String intToRoman(int num) {
      List<Integer> integers = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
      List<String> roman = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

      StringBuilder sb = new StringBuilder();

      int i = 0;
      while (num != 0 && i < integers.size()) {
         if (num >= integers.get(i)) {
            num -= integers.get(i);
            sb.append(roman.get(i));
         } else {
            i++;
         }
      }
      return sb.toString();
   }
}
