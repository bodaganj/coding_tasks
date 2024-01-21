package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

import java.util.Stack;

public class DecodeString {

   public static void main(String[] args) {
//      System.out.println(decodeString("3[a]2[c]"));
      System.out.println(decodeString("3[a2[c]]"));
   }

   public static String decodeString(String s) {
      StringBuilder ans = new StringBuilder();
      StringBuilder current = new StringBuilder();
      int digit = 0;
      Stack<Integer> intStack = new Stack<>();
      Stack<String> strStack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
         char currChar = s.charAt(i);
         if (Character.isDigit(currChar)) {
            if (!current.isEmpty()) {
               strStack.add(current.toString());
               current = new StringBuilder();
            }
            digit = digit * 10 + Integer.parseInt(currChar + "");
         } else if (currChar == '[') {
            intStack.add(digit);
            digit = 0;
         } else if (Character.isLetter(currChar)) {
            current.append(currChar);
         } else { // ']'
            // TODO: fix that or recursion which returns string
            if (strStack.isEmpty()) {
               ans.append(current.toString().repeat(intStack.pop()));
            } else {
               strStack.add(strStack.pop() + current.toString().repeat(intStack.pop()));
            }
            current = new StringBuilder();
         }
      }

      return ans.toString();
   }
}
