package com.coding.tasks.leetcode.third_round.google.arrays.and.strings;

import java.util.Objects;

public class MultiplyStrings {

   public static void main(String[] args) {
      System.out.println(multiply("123", "456"));
      System.out.println(multiply("9", "9"));
      System.out.println(multiply("123456789", "987654321"));
      System.out.println(multiply("498828660196", "840477629533"));
      System.out.println(multiply("9133", "0"));
   }

   // length num1 - M
   // length num2 - N
   public static String multiply(String num1, String num2) {
      if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
         return "0";
      }
      String product = "0";
      int counter = 0;
      for (int i = num1.length() - 1; i >= 0; i--) {
         String curr = mult(num1.charAt(i) + "", num2) + "0".repeat(counter);
         product = sum(product, curr);
         counter++;
      }

      return product;
   }

   private static String mult(String small, String big) { // O(N)
      int carry = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = big.length() - 1; i >= 0; i--) {
         int curr = Integer.parseInt(small) * Integer.parseInt(big.charAt(i) + "") + carry;
         sb.append(curr % 10);
         carry = curr / 10;
      }
      return carry != 0 ? "" + carry + sb.reverse() : sb.reverse().toString();
   }

   private static String sum(String first, String second) {
      int carry = 0;
      StringBuilder sb = new StringBuilder();
      int length = Math.max(first.length(), second.length());
      int i = 0;
      while (i < length) {
         int currFirst = i < first.length() ? Integer.parseInt(first.charAt(first.length() - 1 - i) + "") : 0;
         int currSecond = i < second.length() ? Integer.parseInt(second.charAt(second.length() - 1 - i) + "") : 0;
         int curr = currFirst + currSecond + carry;
         sb.append(curr % 10);
         carry = curr / 10;
         i++;
      }
      return carry != 0 ? "" + carry + sb.reverse() : sb.reverse().toString();
   }
}
