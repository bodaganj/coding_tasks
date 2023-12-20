package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.others;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

   public boolean isValid(String s) {
      if (s.length() % 2 != 0) {
         return false;
      }

      Map<Character, Character> mapping = Map.of('(', ')', '{', '}', '[', ']');
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
         char currChar = s.charAt(i);

         if (stack.isEmpty() && !mapping.containsKey(currChar)) {
            return false;
         } else if (stack.isEmpty() || mapping.containsKey(currChar)) {
            stack.add(currChar);
         } else {
            if (mapping.get(stack.peek()).equals(currChar)) {
               stack.pop();
            } else {
               return false;
            }
         }
      }

      return stack.isEmpty();
   }
}
