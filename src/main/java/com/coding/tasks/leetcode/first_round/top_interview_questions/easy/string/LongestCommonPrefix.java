package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

public class LongestCommonPrefix {

   public static void main(String[] args) {
      String[] array1 = new String[]{"ab", "a"};
      System.out.println(longestCommonPrefix(array1));

      String[] array2 = new String[]{"dog", "racecar", "car"};
      System.out.println(longestCommonPrefix(array2));
   }

   // string.indexOf("prefix") should be used!!!!
   private static String longestCommonPrefix(String[] strs) {
      String result = strs[0];

      for (int i = 1; i < strs.length; i++) {
         int j = 0;
         String current = strs[i];

         if (result.length() > current.length()) {
            result = result.substring(0, current.length());
         }

         while (j < result.length()) {
            if (result.charAt(j) == current.charAt(j)) {
               j++;
            } else {
               result = result.substring(0, j);
            }
            if (result.isBlank()) {
               return result;
            }
         }
      }

      return result;
   }
}
