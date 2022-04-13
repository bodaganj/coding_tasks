package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Stack;

public class BasicCalculator {

   public static void main(String[] args) {
      System.out.println(calculate("3+2*2")); // 7
      System.out.println(calculate(" 3/2 ")); // 1
      System.out.println(calculate("3+5 / 2")); // 5
      System.out.println(calculate("42")); // 42
      System.out.println(calculate("1-1+1")); // 1
      System.out.println(calculate("0-2147483647")); // -2147483647
      System.out.println(calculate("1*2-3/4+5*6-7*8+9/10")); // -24
   }

   // O(n) and S(n)
   private static int calculate(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }
      int length = s.length();
      Stack<Integer> stack = new Stack<>();
      int currentNumber = 0;
      char operation = '+';
      for (int i = 0; i < length; i++) {
         char currentChar = s.charAt(i);
         if (Character.isDigit(currentChar)) {
            currentNumber = (currentNumber * 10) + (currentChar - '0');
         }
         if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
            if (operation == '-') {
               stack.push(-currentNumber);
            } else if (operation == '+') {
               stack.push(currentNumber);
            } else if (operation == '*') {
               stack.push(stack.pop() * currentNumber);
            } else if (operation == '/') {
               stack.push(stack.pop() / currentNumber);
            }
            operation = currentChar;
            currentNumber = 0;
         }
      }

      int result = 0;
      while (!stack.isEmpty()) {
         result += stack.pop();
      }
      return result;
   }

   // O(n) and S(1)
   public int calculate1(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }
      int length = s.length();
      int currentNumber = 0, lastNumber = 0, result = 0;
      char operation = '+';
      for (int i = 0; i < length; i++) {
         char currentChar = s.charAt(i);
         if (Character.isDigit(currentChar)) {
            currentNumber = (currentNumber * 10) + (currentChar - '0');
         }
         if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
            if (operation == '+' || operation == '-') {
               result += lastNumber;
               lastNumber = (operation == '+') ? currentNumber : -currentNumber;
            } else if (operation == '*') {
               lastNumber = lastNumber * currentNumber;
            } else if (operation == '/') {
               lastNumber = lastNumber / currentNumber;
            }
            operation = currentChar;
            currentNumber = 0;
         }
      }
      result += lastNumber;
      return result;
   }
}
