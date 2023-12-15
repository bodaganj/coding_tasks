package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

public class LongestCommonPrefix {

   public static void main(String[] args) {
      System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
   }

   public static String longestCommonPrefix(String[] strs) {
      String common = strs[0];
      for (int i = 1; i < strs.length; i++) {
         if (common.equals("")) {
            return common;
         }

         StringBuilder sb = new StringBuilder();
         int j = 0;
         while (j < common.length() && j < strs[i].length()) {
            if (common.charAt(j) == strs[i].charAt(j)) {
               sb.append(common.charAt(j));
               j++;
            } else {
               break;
            }
         }
         common = sb.toString();
      }
      return common;
   }
}
