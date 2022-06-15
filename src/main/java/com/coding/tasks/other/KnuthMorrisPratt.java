package com.coding.tasks.other;

public class KnuthMorrisPratt {

   public static void main(String[] args) {
      System.out.println("False = " + isMatching("abcd", "ef"));
      System.out.println("True = " + isMatching("abcbcglx", "bcgl"));
      System.out.println("True = " + isMatching("abcxabcdabxabcdabcdabcy", "abcdabcy"));
      System.out.println("True = " + isMatching("xccaabaaxccbaaaxccaabaabaaaxcc", "aabaabaaa"));
      System.out.println("True = " + isMatching("aaaaab", "aaab"));
      System.out.println("True = " + isMatching("adsgwadsxdsgwadsgz", "dsgwadsgz"));
   }

   private static boolean isMatching(String text, String pattern) {
      int[] array = getPatternPrefixPresence(pattern);

      int i = 0;
      int j = 0;
      while (i < text.length()) {
         char curr = text.charAt(i);

         if (curr == pattern.charAt(j)) {
            i++;
            j++;
         } else {
            if (j == 0) {
               i++;
            } else {
               j = array[j - 1];
            }
         }

         if (j == pattern.length()) {
            return true;
         }
      }

      return false;
   }

   private static int[] getPatternPrefixPresence(String pattern) {
      int[] arr = new int[pattern.length()];

      // length of the previous longest prefix suffix
      int len = 0;
      int j = 1;

      while (j < pattern.length()) {
         if (pattern.charAt(j) == pattern.charAt(len)) {
            len++;
            arr[j] = len;
            j++;
         } else {
            if (len != 0) {
               len = arr[len - 1];
            } else {
               arr[j] = len;
               j++;
            }
         }
      }

      return arr;
   }
}
