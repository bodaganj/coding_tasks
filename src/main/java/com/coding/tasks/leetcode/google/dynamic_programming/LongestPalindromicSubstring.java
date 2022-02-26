package com.coding.tasks.leetcode.google.dynamic_programming;

public class LongestPalindromicSubstring {

   public static void main(String[] args) {
      System.out.println(longestPalindrome("ababad"));
   }

   // O(n^2)
   private static String longestPalindrome(String s) {
      if (s == null || s.length() < 1) {
         return "";
      }
      int start = 0;
      int end = 0;
      for (int i = 0; i < s.length(); i++) {
         int len1 = expandAroundCenter(s, i, i);
         int len2 = expandAroundCenter(s, i, i + 1);
         int len = Math.max(len1, len2);
         if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
         }
      }
      return s.substring(start, end + 1);
   }

   private static int expandAroundCenter(String s, int left, int right) {
      int L = left;
      int R = right;
      while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
         L--;
         R++;
      }
      return R - L - 1;
   }

   // TLE even with memo
//   private static String longestPalindrome(String str) {
//      char[] chars = str.toCharArray();
//      String longest = chars[0] + "";
//      int[][] memo = new int[str.length() + 1][str.length() + 1];
//
//      for (int i = 0; i < str.length(); i++) {
//         for (int j = 0; j < i; j++) {
//            String potentialPalindrome = str.substring(j, i + 1);
//            if (isPalindrome(chars, j, i, memo) && potentialPalindrome.length() > longest.length()) {
//               longest = potentialPalindrome;
//            }
//         }
//      }
//
//      return longest;
//   }
//
//   private static boolean isPalindrome(char[] str, int i, int j, int[][] memo) {
//      int x = i;
//      int y = j;
//
//      while (x < y) {
//         if (memo[x][y] == 1) {
//            return true;
//         }
//         if (memo[x][y] == -1) {
//            return false;
//         }
//
//         if (str[x] != str[y]) {
//            memo[x][y] = -1;
//            return false;
//         }
//         x++;
//         y--;
//      }
//      memo[i][j] = 1;
//      return true;
//   }
}
