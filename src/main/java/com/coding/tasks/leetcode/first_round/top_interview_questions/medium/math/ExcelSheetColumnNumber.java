package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.math;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {

   public static void main(String[] args) {
      System.out.println(titleToNumber("A"));
      System.out.println(titleToNumber("AB"));
      System.out.println(titleToNumber("ZY"));
      System.out.println(titleToNumber("FXSHRXW"));
   }

   private static int titleToNumber(String columnTitle) {
      Map<Character, Integer> mapping = new HashMap<>();
      mapping.put('A', 1);
      mapping.put('B', 2);
      mapping.put('C', 3);
      mapping.put('D', 4);
      mapping.put('E', 5);
      mapping.put('F', 6);
      mapping.put('G', 7);
      mapping.put('H', 8);
      mapping.put('I', 9);
      mapping.put('J', 10);
      mapping.put('K', 11);
      mapping.put('L', 12);
      mapping.put('M', 13);
      mapping.put('N', 14);
      mapping.put('O', 15);
      mapping.put('P', 16);
      mapping.put('Q', 17);
      mapping.put('R', 18);
      mapping.put('S', 19);
      mapping.put('T', 20);
      mapping.put('U', 21);
      mapping.put('V', 22);
      mapping.put('W', 23);
      mapping.put('X', 24);
      mapping.put('Y', 25);
      mapping.put('Z', 26);

      char[] chars = columnTitle.toCharArray();
      int ans = 0;
      for (int i = 0; i < chars.length; i++) {
         char currChar = chars[chars.length - 1 - i];
         ans += (mapping.get(currChar) * (Math.pow(26, i)));
      }

      return ans;
   }
}
