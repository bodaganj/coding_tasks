package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

public class ImplementStrStr {

   public static void main(String[] args) {
      System.out.println(strStr("hello", "ll"));
      System.out.println(strStr("hello", ""));
      System.out.println(strStr("", ""));
      System.out.println(strStr("aaaaa", "bba"));
      System.out.println(strStr("mississippi", "issip"));
      System.out.println(strStr("mississippi", "issipi"));
   }

   private static int strStr(String haystack, String needle) {
      if (needle.isEmpty()) {
         return 0;
      }
      if (needle.length() > haystack.length()) {
         return -1;
      }

      for (int i = 0; i < haystack.length(); i++) {
         if (haystack.charAt(i) == needle.charAt(0)) {
            int counter = 1;
            while (counter < needle.length() && i + counter < haystack.length() && haystack.charAt(i + counter) == needle.charAt(counter)) {
               counter++;
            }
            if (counter == needle.length()) {
               return i;
            }
         }
      }
      return -1;
   }
}
