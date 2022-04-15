package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

   public static void main(String[] args) {
//      System.out.println(multiply("12", "12"));
//      System.out.println(multiply("123", "456"));
//      System.out.println(multiply("9", "9"));
      System.out.println(multiply("123456789", "987654321"));
   }

   private static String multiply(String num1, String num2) {
      char[] chars1 = num1.toCharArray();
      char[] chars2 = num2.toCharArray();
      List<Integer> toSum = new ArrayList<>();

      int counter = 0;
      for (int i = chars1.length - 1; i >= 0; i--) {
         int carry = 0;
         StringBuilder sb = new StringBuilder();
         for (int j = chars2.length - 1; j >= 0; j--) {
            int product = Integer.parseInt(chars1[i] + "") * Integer.parseInt(chars2[j] + "") + carry;
            carry = product / 10;
            sb.append(product % 10);
         }
         if (carry != 0) {
            sb.append(carry);
         }
         sb.reverse().append("0".repeat(Math.max(0, counter)));
         counter++;
         toSum.add(Integer.parseInt(sb.toString()));
      }
      return toSum.stream().mapToInt(Integer::intValue).sum() + "";
   }
}
