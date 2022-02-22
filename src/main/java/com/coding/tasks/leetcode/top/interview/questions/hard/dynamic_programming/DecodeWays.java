package com.coding.tasks.leetcode.top.interview.questions.hard.dynamic_programming;

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
   }

   private static int numDecodings(String s) {
      if (s.startsWith("0")) {
         return 0;
      }
      return rec(s, new HashMap<>());
   }

   private static int rec(String s, Map<String, Integer> memo) {
      if (memo.containsKey(s)) {
         return memo.get(s);
      }

      if (s.isBlank()) {
         return 1;
      }

      int shortAns = 0;
      int longAns = 0;
      char c0 = s.charAt(0);

      long count = mapping.keySet().stream().filter(key -> key.startsWith(Character.toString(c0))).count();
      if (count > 1 && s.length() > 1) {
         char c1 = s.charAt(1);
         StringBuilder sb = new StringBuilder();
         sb.append(c0);
         sb.append(c1);
         if (mapping.keySet().stream().filter(key -> key.startsWith(sb.toString())).count() == 1) {
            longAns = rec(s.substring(2), memo);
         }
      }

      if (count >= 1) {
         shortAns = rec(s.substring(1), memo);
      }

      memo.put(s, longAns + shortAns);
      return memo.get(s);
   }
}
