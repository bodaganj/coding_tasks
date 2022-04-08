package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

import java.math.BigInteger;

public class PlusOne {

   public int[] plusOne(int[] digits) {
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
}
