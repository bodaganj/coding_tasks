package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.Set;
import java.util.Stack;

public class BasicCalculatorII {

   public static void main(String[] args) {
      System.out.println(calculate("3+2*2")); // 7
      System.out.println(calculate(" 3+5 / 2 ")); // 5
      System.out.println(calculate("1-1+1")); // 1
      System.out.println(calculate("0-2147483647")); // -2147483647
      System.out.println(calculate("3/2")); // 1
      System.out.println(calculate("1+1+1")); // 3
   }

   public static int calculate(String s) {
      Set<Character> operators = Set.of('*', '/', '+', '-');
      Stack<Integer> intStack = new Stack<>();
      Stack<Character> operStack = new Stack<>();

      char[] chars = s.trim().toCharArray();
      int i = 0;
      while (i < chars.length) {
         char c = chars[i];
         if (Character.isSpaceChar(c)) {
            i++;
            continue;
         }
         if (operators.contains(c)) {
            if (operStack.isEmpty()) {
               operStack.add(c);
            } else {
               if (c == '+' || c == '-') {
                  Character curOper = operStack.pop();
                  int secondVal = intStack.pop();
                  int firstVal = intStack.pop();
                  if (curOper == '+') {
                     intStack.add(firstVal + secondVal);
                  } else {
                     intStack.add(firstVal - secondVal);
                  }
               }
               operStack.add(c);
            }
            i++;
         } else {
            StringBuilder sb = new StringBuilder();
            while (i < chars.length && Character.isDigit(chars[i])) {
               sb.append(chars[i]);
               i++;
            }
            Integer cur = Integer.parseInt(sb.toString());
            if (operStack.isEmpty() || operStack.peek().equals('+') || operStack.peek().equals('-')) {
               intStack.add(cur);
            } else {
               Character pop = operStack.pop();
               if (pop.equals('*')) {
                  intStack.add(intStack.pop() * cur);
               } else {
                  intStack.add(intStack.pop() / cur);
               }
            }
         }
      }

      if (operStack.isEmpty()) {
         return intStack.pop();
      } else {
         int second = intStack.pop();
         int first = intStack.pop();
         char cur = operStack.pop();
         if (cur == '+') {
            return first + second;
         } else {
            return first - second;
         }
      }
   }
}
