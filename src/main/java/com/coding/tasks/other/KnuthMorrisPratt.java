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
      int i = 0;
      int j = 1;
      int length = pattern.length();
      int[] array = new int[length];

      while (j < length) {
         if (pattern.charAt(i) == pattern.charAt(j)) {
            array[j] = array[j - 1] + 1;
            i++;
            j++;
         } else {
            boolean isJSet = false;
            while (!isJSet) {
               if (i == 0) {
                  if (pattern.charAt(i) == pattern.charAt(j)) {
                     array[j] = array[i] + 1;
                     i++;
                  } else {
                     array[j] = 0;
                  }
                  j++;
                  isJSet = true;
               } else {
                  i = array[i - 1];
                  if (pattern.charAt(i) == pattern.charAt(j)) {
                     array[j] = array[i] + 1;
                     isJSet = true;
                     i++;
                     j++;
                  }
               }
            }
         }
      }

      return array;
   }
}
