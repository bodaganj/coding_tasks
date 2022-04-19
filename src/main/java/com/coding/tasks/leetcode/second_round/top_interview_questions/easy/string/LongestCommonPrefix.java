package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.string;

public class LongestCommonPrefix {

   public static void main(String[] args) {
      String[] array1 = new String[]{"ab", "a"};
      System.out.println(longestCommonPrefix(array1));

      String[] array2 = new String[]{"dog", "racecar", "car"};
      System.out.println(longestCommonPrefix(array2));
   }

   private static String longestCommonPrefix(String[] strs) {
      int length = Integer.MAX_VALUE;
      for (String str : strs) {
         length = Math.min(length, str.length());
      }

      StringBuilder longest = new StringBuilder();
      int counter = 0;
      while (counter < length) {
         char expected = strs[0].charAt(counter);
         for (String str : strs) {
            if (str.charAt(counter) != expected) {
               return longest.toString();
            }
         }
         longest.append(expected);
         counter++;
      }

      return longest.toString();
   }
}
