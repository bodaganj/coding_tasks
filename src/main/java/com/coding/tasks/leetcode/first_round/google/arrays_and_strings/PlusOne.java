package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.math.BigInteger;

public class PlusOne {

   public static void main(String[] args) {
//      int[] plusOne = plusOne(new int[]{1, 2, 3});
      int[] plusOne = plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
      for (int i : plusOne) {
         System.out.println(i);
      }
   }

   private static int[] plusOne(int[] digits) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int digit : digits) {
         stringBuilder.append(digit);
      }

      BigInteger finalInteger = new BigInteger(stringBuilder.toString()).add(new BigInteger("1"));
      String finalString = String.valueOf(finalInteger);

      String[] strings = finalString.split("");
      int[] finalArray = new int[strings.length];

      for (int i = 0; i < finalArray.length; i++) {
         finalArray[i] = Integer.parseInt(strings[i]);
      }
      return finalArray;
   }

   // brute force int calculation
//   private static int[] plusOne(int[] digits) {
//      int length = digits.length;
//
//      for (int i = length - 1; i >= 0; --i) {
//         if (digits[i] == 9) {
//            digits[i] = 0;
//         } else {
//            digits[i]++;
//            return digits;
//         }
//      }
//
//      digits = new int[length + 1];
//      digits[0] = 1;
//      return digits;
//   }
}
