package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

import java.util.Arrays;

public class ImplementStrStr {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(prefixSufix("issip")));

      System.out.println(strStr("mississippi", "issip"));
   }

   public static int strStr(String haystack, String needle) {
      if (needle.length() > haystack.length()) {
         return -1;
      }

      int[] prefixSufix = prefixSufix(needle);

      int big = 0;
      int small = 0;
      while (big < haystack.length()) {
         if (haystack.charAt(big) == needle.charAt(small)) {
            big++;
            small++;
         } else {
            if (small > 0) {
               small = prefixSufix[small - 1];
            } else {
               big++;
            }
         }
         if (small == needle.length()) {
            return big - small;
         }
      }

      return -1;
   }

   public static int[] prefixSufix(String s) {
      int[] ans = new int[s.length()];
      int length = 0;
      int right = 1;
      while (right < s.length()) {
         if (s.charAt(length) == s.charAt(right)) {
            length++;
            ans[right] = length;
            right++;
         } else {
            if (length != 0) {
               length = ans[length - 1];
            } else {
               ans[right] = length;
               right++;
            }
         }
      }
      return ans;
   }
}
