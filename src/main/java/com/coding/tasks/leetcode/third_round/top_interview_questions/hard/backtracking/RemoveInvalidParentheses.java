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
      System.out.println(removeInvalidParentheses(")()))())))"));
   }

   public static List<String> removeInvalidParentheses(String s) {
      if (isValid(s)) {
         return List.of(s);
      }
      int count = getParenthesesCount(s);
      Set<String> ans = new HashSet<>();
      char[] chars = s.toCharArray();
      for (int removes = 1; removes <= count; removes++) {
         for (int i = 0; i < chars.length; i++) {
            backtrack(removes, i, s, ans);
         }
         if (ans.size() > 0) {
            return new ArrayList<>(ans);
         }
      }
      return List.of("");
   }

   private static void backtrack(int amountOfRemoves, int index, String s, Set<String> ans) {
      if (amountOfRemoves == 0 && isValid(s)) {
         ans.add(s);
      } else {
         if (index < s.length() && (s.charAt(index) == ')' || s.charAt(index) == '(')) {
            String newString = s.substring(0, index) + s.substring(index + 1);
            for (int i = 0; i < s.length(); i++) {
               backtrack(amountOfRemoves - 1, i, newString, ans);
            }
         }
      }
   }

   private static int getParenthesesCount(String s) {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            count++;
         }
      }
      return count;
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
