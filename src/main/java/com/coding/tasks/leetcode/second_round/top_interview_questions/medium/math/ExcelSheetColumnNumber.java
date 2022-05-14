package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.math;

public class ExcelSheetColumnNumber {

   public static void main(String[] args) {
      System.out.println(titleToNumber("A"));
      System.out.println(titleToNumber("AB"));
      System.out.println(titleToNumber("ZY"));
      System.out.println(titleToNumber("FXSHRXW"));
   }

   private static int titleToNumber(String columnTitle) {
      int result = 0;
      int n = columnTitle.length();
      for (int i = 0; i < n; i++) {
         result *= 26;
         // In Java, subtracting characters is subtracting ASCII values of characters
         result += columnTitle.charAt(i) - 'A' + 1;
      }
      return result;
   }
}
