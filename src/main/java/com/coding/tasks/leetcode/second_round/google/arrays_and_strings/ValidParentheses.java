package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

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
      Map<Character, Character> mapping = Map.of('(', ')', '[', ']', '{', '}');

      Stack<Character> stack = new Stack<>();
      for (char aChar : s.toCharArray()) {
         if (mapping.containsKey(aChar)) {
            stack.add(aChar);
         } else {
            if (stack.isEmpty() || mapping.get(stack.pop()) != aChar) {
               return false;
            }
         }
      }
      return stack.isEmpty();
   }
}
