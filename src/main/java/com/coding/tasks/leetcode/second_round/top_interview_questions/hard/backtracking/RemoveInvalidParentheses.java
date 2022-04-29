package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {

   public static void main(String[] args) {
      System.out.println(removeInvalidParentheses("(a)())()"));
   }

   private static List<String> removeInvalidParentheses(String s) {
      Set<String> ans = new HashSet<>();
      rec(s, ans);
      int max = 0;
      for (String an : ans) {
         max = Math.max(max, an.length());
      }

      int finalMax = max;
      return ans.stream().filter(an -> an.length() == finalMax).collect(Collectors.toList());
   }

   private static void rec(String s, Set<String> ans) {
      if (isValid(s)) {
         ans.add(s);
      } else {
         List<Integer> amountOfParentheses = getAmountOfParentheses(s);
         Integer openCount = amountOfParentheses.get(0);
         Integer closeCount = amountOfParentheses.get(1);

         if (openCount > closeCount) {
            for (int i = 0; i < s.length(); i++) {
               if (s.charAt(i) == '(') {
                  rec(s.substring(0, i) + s.substring(i + 1), ans);
               }
            }
         } else if (openCount < closeCount) {
            for (int i = 0; i < s.length(); i++) {
               if (s.charAt(i) == ')') {
                  rec(s.substring(0, i) + s.substring(i + 1), ans);
               }
            }
         } else {
            for (int i = 0; i < s.length(); i++) {
               String s1 = s.substring(0, i) + s.substring(i + 1);
               if (s.charAt(i) == ')') {
                  rec(s1, ans);
               }
               if (s.charAt(i) == '(') {
                  rec(s1, ans);
               }
            }
         }
      }
   }

   private static List<Integer> getAmountOfParentheses(String s) {
      int i = 0;
      int counterOpen = 0;
      int counterClose = 0;
      while (i < s.length()) {
         if (s.charAt(i) == '(') {
            counterOpen++;
         } else if (s.charAt(i) == ')') {
            counterClose++;
         }
         i++;
      }
      return List.of(counterOpen, counterClose);
   }

   private static boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      int i = 0;
      while (i < s.length()) {
         if (Character.isLetter(s.charAt(i))) {
            i++;
            continue;
         } else if (stack.isEmpty() && s.charAt(i) == ')') {
            return false;
         } else if (s.charAt(i) == '(') {
            stack.add('(');
         } else {
            stack.pop();
         }
         i++;
      }

      return stack.isEmpty();
   }
}
