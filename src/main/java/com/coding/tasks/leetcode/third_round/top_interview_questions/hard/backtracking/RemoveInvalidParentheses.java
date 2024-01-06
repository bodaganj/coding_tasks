package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {

   public static void main(String[] args) {
      System.out.println(removeInvalidParentheses("()())()"));
      System.out.println(removeInvalidParentheses("(a)())()"));
      System.out.println(removeInvalidParentheses("(a"));
      System.out.println(removeInvalidParentheses("(a("));
      System.out.println(removeInvalidParentheses("a("));
      System.out.println(removeInvalidParentheses(")(a"));
   }

   public static List<String> removeInvalidParentheses(String s) {
      int openAmount = getAmountOfParentheses(true, s);
      int closeAmount = getAmountOfParentheses(false, s);
      int dif = Math.abs(openAmount - closeAmount);
      boolean isOpenMore = openAmount - closeAmount > 0;
      Set<String> ans = new HashSet<>();
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         backtrack(isOpenMore, dif, i, s, ans);
      }
      return ans.size() == 0 ? List.of("") : new ArrayList<>(ans);
   }

   private static int getAmountOfParentheses(boolean isOpen, String s) {
      int count = 0;
      char expected = isOpen ? '(' : ')';
      for (char c : s.toCharArray()) {
         if (c == expected) {
            count++;
         }
      }
      return count;
   }

   private static void backtrack(boolean isOpen, int leftCount, int index, String s, Set<String> ans) {
      if (leftCount == 0 && isValid(s)) {
         ans.add(s);
      } else {
         char expected = isOpen ? '(' : ')';
         if (index < s.length() && s.charAt(index) == expected) {
            String newString = s.substring(0, index) + s.substring(index + 1);
            for (int i = index + 1; i <= s.length(); i++) {
               backtrack(isOpen, leftCount - 1, i, newString, ans);
            }
         }
      }
   }

   private static boolean isValid(String s) {
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
         if (Character.isLetter(s.charAt(i))) {
            continue;
         }
         if (s.charAt(i) == '(') {
            stack.add(i);
         }
         if (s.charAt(i) == ')' && stack.isEmpty()) {
            return false;
         }
         if (s.charAt(i) == ')') {
            stack.pop();
         }
      }
      return stack.isEmpty();
   }
}
