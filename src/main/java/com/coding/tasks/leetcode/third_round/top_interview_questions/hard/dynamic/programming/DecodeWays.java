package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

   private static Map<String, String> mapping;
   private static int count = 0;

   static {
      mapping = new HashMap<>();
      mapping.put("1", "A");
      mapping.put("2", "B");
      mapping.put("3", "C");
      mapping.put("4", "D");
      mapping.put("5", "E");
      mapping.put("6", "F");
      mapping.put("7", "G");
      mapping.put("8", "H");
      mapping.put("9", "I");
      mapping.put("10", "J");
      mapping.put("11", "K");
      mapping.put("12", "L");
      mapping.put("13", "M");
      mapping.put("14", "N");
      mapping.put("15", "O");
      mapping.put("16", "P");
      mapping.put("17", "Q");
      mapping.put("18", "R");
      mapping.put("19", "S");
      mapping.put("20", "T");
      mapping.put("21", "U");
      mapping.put("22", "V");
      mapping.put("23", "W");
      mapping.put("24", "X");
      mapping.put("25", "Y");
      mapping.put("26", "Z");
   }

   public static void main(String[] args) {
      System.out.println(numDecodings("12"));
      System.out.println(numDecodings("226"));
      System.out.println(numDecodings("06"));
   }

   public static int numDecodings(String s) {
      count = 0;
      rec(0, s);
      return count;
   }

   private static void rec(int index, String s) {
      if (index == s.length()) {
         count++;
      } else {
         if (mapping.containsKey("" + s.charAt(index))) {
            rec(index + 1, s);
         }
         if (index < s.length() - 1 && mapping.containsKey("" + s.charAt(index) + s.charAt(index + 1))) {
            rec(index + 2, s);
         }
      }
   }
}
