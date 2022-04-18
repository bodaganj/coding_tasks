package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFiles {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(reorderLogFiles(new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"})));
   }

   private static String[] reorderLogFiles(String[] logs) {
      List<LetterLog> letterLogList = new ArrayList<>();
      List<DigitLog> digitLogList = new ArrayList<>();

      for (String log : logs) {
         String updatedLog = log.replaceFirst(" ", "#");
         String[] split = updatedLog.split("#");
         if (Character.isDigit(split[1].charAt(0))) {
            digitLogList.add(new DigitLog(split[0], split[1]));
         } else {
            letterLogList.add(new LetterLog(split[0], split[1]));
         }
      }

      String[] ans = new String[logs.length];
      letterLogList.sort((o1, o2) -> {
         if (o1.log.compareTo(o2.log) == 0) {
            return o1.identifier.compareTo(o2.identifier);
         } else {
            return o1.log.compareTo(o2.log);
         }
      });

      int i = 0;
      int j = 0;
      while (i < letterLogList.size()) {
         ans[i] = letterLogList.get(i).identifier + " " + letterLogList.get(i).log;
         i++;
      }
      while (j < digitLogList.size()) {
         ans[i] = digitLogList.get(j).identifier + " " + digitLogList.get(j).log;
         i++;
         j++;
      }
      return ans;
   }

   static class LetterLog {

      public String identifier;
      public String log;

      public LetterLog(String i, String l) {
         identifier = i;
         log = l;
      }
   }

   static class DigitLog {

      public String identifier;
      public String log;

      public DigitLog(String i, String l) {
         identifier = i;
         log = l;
      }
   }
}