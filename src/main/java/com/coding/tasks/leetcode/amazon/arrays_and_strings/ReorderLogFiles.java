package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(reorderLogFiles(new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"})));
   }

   private static String[] reorderLogFiles(String[] logs) {
      List<String> letterLogs = new ArrayList<>();
      List<String> digitLogs = new ArrayList<>();

      for (String log : logs) {
         String[] words = log.split(" ");

         if (Character.isDigit(words[1].toCharArray()[0])) {
            digitLogs.add(log);
         } else {
            letterLogs.add(log);
         }
      }

      letterLogs.sort(new MyComparator());

      letterLogs.addAll(digitLogs);
      String[] finalArray = new String[letterLogs.size()];

      for (int i = 0; i < letterLogs.size(); i++) {
         finalArray[i] = letterLogs.get(i);
      }

      return finalArray;
   }

   static class MyComparator implements Comparator<String> {

      @Override
      public int compare(String o1, String o2) {
         String[] first = o1.split(" ");
         StringBuilder sb1 = new StringBuilder();

         for (int i = 1; i < first.length; i++) {
            sb1.append(first[i]).append(" ");
         }
         String s1 = sb1.toString();

         String[] second = o2.split(" ");
         StringBuilder sb2 = new StringBuilder();

         for (int i = 1; i < second.length; i++) {
            sb2.append(second[i]).append(" ");
         }
         String s2 = sb2.toString();

         int result = s1.compareTo(s2);

         return result == 0 ? first[0].compareTo(second[0]) : result;
      }
   }
}