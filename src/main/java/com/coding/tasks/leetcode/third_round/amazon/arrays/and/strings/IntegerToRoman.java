package com.coding.tasks.leetcode.third_round.amazon.arrays.and.strings;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

   private static List<Pair> list = new ArrayList<>();

   static {
      list.add(new Pair(1000, "M"));
      list.add(new Pair(900, "CM"));
      list.add(new Pair(500, "D"));
      list.add(new Pair(400, "CD"));
      list.add(new Pair(100, "C"));
      list.add(new Pair(90, "XC"));
      list.add(new Pair(50, "L"));
      list.add(new Pair(40, "XL"));
      list.add(new Pair(10, "X"));
      list.add(new Pair(9, "IX"));
      list.add(new Pair(5, "V"));
      list.add(new Pair(4, "IV"));
      list.add(new Pair(1, "I"));
   }

   public static void main(String[] args) {

   }

   public static String intToRoman(int num) {
      StringBuilder sb = new StringBuilder();
      while (num != 0) {
         for (Pair pair : list) {
            if (num >= pair.digit) {
               sb.append(pair.str);
               num -= pair.digit;
               break;
            }
         }
      }
      return sb.toString();
   }

   private record Pair(int digit, String str) {

   }
}
