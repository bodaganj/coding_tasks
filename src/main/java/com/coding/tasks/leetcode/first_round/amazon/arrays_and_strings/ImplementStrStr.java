package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

public class ImplementStrStr {

   public static void main(String[] args) {
      System.out.println(strStr("hello", "ll"));
      System.out.println(strStr("hello", ""));
      System.out.println(strStr("", ""));
      System.out.println(strStr("aaaaa", "bba"));
      System.out.println(strStr("mississippi", "issip"));
   }

   private static int strStr(String haystack, String needle) {
      if (needle.equals("")) {
         return 0;
      }
      int i = 0, j = 0;
      while (i < haystack.length() && j < needle.length()) {
         if (haystack.charAt(i) == needle.charAt(j)) {
            if (j == needle.length() - 1) {
               return i - needle.length() + 1;
            }
            i++;
            j++;
         } else {
            i = i - j + 1;
            j = 0;
         }
      }
      return -1;
   }
}
