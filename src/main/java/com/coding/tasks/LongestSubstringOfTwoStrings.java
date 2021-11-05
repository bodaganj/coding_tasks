package com.coding.tasks;

public class LongestSubstringOfTwoStrings {

   public static void main(String[] args) {
      System.out.println(getLongestCommonString("afkbogdanafk", "ooobogdanee"));
   }

   static String getLongestCommonString(String str1, String str2) {
      int max = 0;

      int[][] dp = new int[str1.length()][str2.length()];
      int endIndex = -1;

      for (int i = 0; i < str1.length(); i++) {
         for (int j = 0; j < str2.length(); j++) {
            if (str1.charAt(i) == str2.charAt(j)) {
               // If first row or column
               if (i == 0 || j == 0) {
                  dp[i][j] = 1;
               } else {
                  // Add 1 to the diagonal value
                  dp[i][j] = dp[i - 1][j - 1] + 1;
               }

               if (max < dp[i][j]) {
                  max = dp[i][j];
                  endIndex = i;
               }
            }
         }
      }
      // We want String upto endIndex, we are using endIndex+1 in substring.
      return str1.substring(endIndex - max + 1, endIndex + 1);
   }
}
