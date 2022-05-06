package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

   private static final Map<String, String> mapping;

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
      System.out.println(numDecodings("27"));
      System.out.println(numDecodings("10011"));
   }

   private static int numDecodings(String s) {
      if (s.charAt(0) == '0') {
         return 0;
      }
      return rec(s);
   }

   private static int rec(String str) {
      if (str.isEmpty()) {
         return 1;
      } else if (str.length() > 1 && str.substring(str.length() - 2).equals("00")) {
         return 0;
      } else {
         int counter = 0;
         char lastChar = str.charAt(str.length() - 1);

         if (lastChar == '0') {
            counter += rec(str.substring(0, str.length() - 2));
         } else {
            counter += rec(str.substring(0, str.length() - 1));

            if (str.length() > 1) {
               String substring = str.substring(0, str.length() - 2);
               char beforeLastChar = str.charAt(str.length() - 2);

               if (beforeLastChar == '1') {
                  counter += rec(substring);
               } else if (beforeLastChar == '2' && lastChar < '7') {
                  counter += rec(substring);
               }
            }
         }

         return counter;
      }
   }
}
