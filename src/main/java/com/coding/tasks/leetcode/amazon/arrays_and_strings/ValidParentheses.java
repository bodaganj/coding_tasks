package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

   public static void main(String[] args) {
      System.out.println(isValid("()"));
      System.out.println(isValid("()[]{}"));
      System.out.println(isValid("(]"));
      System.out.println(isValid("){"));
   }

   private static boolean isValid(String s) {
      if (s.length() == 1) {
         return false;
      }

      Map<Character, Character> closeMapping = Map.of('}', '{', ']', '[', ')', '(');

      Stack<Character> stack = new Stack<>();
      for (char aChar : s.toCharArray()) {
         if (closeMapping.containsKey(aChar)) {
            if (!stack.isEmpty() && stack.peek().equals(closeMapping.get(aChar))) {
               stack.pop();
            } else {
               return false;
            }
         } else {
            stack.add(aChar);
         }
      }

      return stack.isEmpty();
   }
}
