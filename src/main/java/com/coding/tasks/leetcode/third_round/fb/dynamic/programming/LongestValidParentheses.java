package com.coding.tasks.leetcode.third_round.fb.dynamic.programming;

public class LongestValidParentheses {

  public static void main(String[] args) {
    System.out.println(longestValidParentheses(")("));
    System.out.println(longestValidParentheses("(()"));
    System.out.println(longestValidParentheses(")()())"));
    System.out.println(longestValidParentheses(""));
  }

  private static int longest = 0;
  private static int lastValidIndex = -1;

  public static int longestValidParentheses(String s) {
    longest = 0;
    int i = 0;
    while (i < s.length()) {
      int ret = isValid(0, 0, "", i, s);
      if (ret != -1) {
        i = ret;
      }
      i++;
      lastValidIndex = -1;
    }
    return longest;
  }

  private static int isValid(int open, int close, String current, int index, String s) {
    if (close <= open) {
      if (open == close) {
        longest = Math.max(longest, current.length());
        lastValidIndex = index;
      }
      if (index != s.length()) {
        char c = s.charAt(index);
        if (c == '(') {
          return isValid(open + 1, close, current + '(', index + 1, s);
        } else {
          return isValid(open, close + 1, current + ')', index + 1, s);
        }
      } else {
        return lastValidIndex;
      }
    } else {
      return lastValidIndex;
    }
  }
}
