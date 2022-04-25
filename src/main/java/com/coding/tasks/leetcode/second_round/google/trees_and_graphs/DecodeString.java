package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

import java.util.Stack;

public class DecodeString {

   public static void main(String[] args) {
//      System.out.println(decodeString("3[a]2[bc]"));
      System.out.println(decodeString("100[leetcode]"));
//      System.out.println(decodeString("3[a2[c]]"));
//      System.out.println(decodeString("2[abc]3[cd]ef"));
   }

   private static String decodeString(String s) {
      StringBuilder sb = new StringBuilder();

      Stack<Character> stack = new Stack<>();
      for (char aChar : s.toCharArray()) {
         if (aChar == ']') {
            StringBuilder currentString = new StringBuilder();
            while (stack.peek() != '[') {
               currentString.append(stack.pop());
            }
            stack.pop();

            StringBuilder multiplier = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
               multiplier.append(stack.pop());
            }

            String stringToBeAdded = currentString.toString().repeat(Integer.parseInt(multiplier.reverse().toString()));
            for (int i = stringToBeAdded.length() - 1; i >= 0; i--) {
               stack.add(stringToBeAdded.charAt(i));
            }
         } else {
            stack.add(aChar);
         }
      }

      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }
      return sb.reverse().toString();
   }
}
