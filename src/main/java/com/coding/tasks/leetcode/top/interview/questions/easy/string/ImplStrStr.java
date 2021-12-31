package com.coding.tasks.leetcode.top.interview.questions.easy.string;

public class ImplStrStr {

   public static void main(String[] args) {
      System.out.println(strStr("hello", "ll"));
      System.out.println(strStr("aaaaa", "bba"));
      System.out.println(strStr("mississippi", "issip"));
   }

   // best case!!!!
//   private static int strStr(String haystack, String needle) {
//      for (int i = 0; ; i++) {
//         for (int j = 0; ; j++) {
//            if (j == needle.length()) {
//               return i;
//            }
//            if (i + j == haystack.length()) {
//               return -1;
//            }
//            if (needle.charAt(j) != haystack.charAt(i + j)) {
//               break;
//            }
//         }
//      }
//   }

   private static int strStr(String haystack, String needle) {
      if (needle.isBlank()) {
         return 0;
      }

      char[] charsOfHaystack = haystack.toCharArray();
      char[] charsOfNeedle = needle.toCharArray();
      int needleLength = charsOfNeedle.length;

      int i = 0;
      int j = 0;

      while (i < charsOfHaystack.length && j < needleLength) {
         if (charsOfHaystack[i] == charsOfNeedle[j]) {
            if (j == needleLength - 1) {
               return i - needleLength + 1;
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
