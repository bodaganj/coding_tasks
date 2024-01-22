package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

import java.util.Stack;

public class DecodeString {

   public static void main(String[] args) {
//      System.out.println(decodeString("3[a]2[c]"));
//      System.out.println(decodeString("3[a2[c]]"));
//      System.out.println(decodeString("abc3[cd]xyz"));
      System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
//      System.out.println(decodeString("sd2[f2[e]g]i")); // "sdfeegfeegi"
//      System.out.println(decodeString("1[a1[b1[c]d]s]")); // "abcds"     "bcdas"
   }

   public static String decodeString(String s) {
      StringBuilder sb = new StringBuilder();
      int i = 0;
      int digit = 0;
      while (i < s.length()) {
         char currChar = s.charAt(i);

         if (Character.isLetter(currChar)) {
            sb.append(currChar);
         } else if (Character.isDigit(currChar)) {
            digit = digit * 10 + Integer.parseInt(currChar + "");
         } else if (currChar == '[') {
            Pair rec = rec(i + 1, s, digit);
            digit = 0;
            i = rec.index;
            sb.append(rec.str);
         }
         i++;
      }
      return sb.toString();
   }

   public static String decodeString1(String s) {
      StringBuilder ans = new StringBuilder();
      StringBuilder currentString = new StringBuilder();
      int digit = 0;
      Stack<Integer> intStack = new Stack<>();
      Stack<String> strStack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
         char currChar = s.charAt(i);

         if (Character.isDigit(currChar)) {
            if (!currentString.isEmpty()) {
               strStack.add(strStack.pop() + currentString);
               currentString = new StringBuilder();
            }
            digit = digit * 10 + Integer.parseInt(currChar + "");
         } else if (currChar == '[') {
            strStack.add("");
            intStack.add(digit);
            digit = 0;
         } else if (Character.isLetter(currChar)) {
            if (intStack.isEmpty()) {
               ans.append(currChar);
            } else {
               currentString.append(currChar);
            }
         } else { // ']'
            if (currentString.isEmpty()) {
               String repeat = strStack.pop().repeat(intStack.pop());
               if (intStack.isEmpty()) {
                  ans.append(repeat);
               } else {
                  strStack.add(strStack.pop() + repeat);
               }
            } else {
               if (strStack.peek().equals("")) {
                  String repeat = currentString.toString().repeat(intStack.pop());
                  String fullStr = strStack.pop() + repeat;
                  if (intStack.isEmpty()) {
                     ans.append(repeat);
                  } else {
                     strStack.add(strStack.pop() + fullStr);
                  }
               } else {
                  strStack.add(strStack.pop() + currentString);
                  String repeat = strStack.pop().repeat(intStack.pop());
                  if (intStack.isEmpty()) {
                     ans.append(repeat);
                  } else {
                     strStack.add(strStack.pop() + repeat);
                  }
               }

               currentString = new StringBuilder();
            }
         }
      }

      return ans.toString();
   }

   private static Pair rec(int index, String s, int repeat) {
      StringBuilder sb = new StringBuilder();
      int digit = 0;
      while (index < s.length()) {
         char currChar = s.charAt(index);

         if (Character.isLetter(currChar)) {
            sb.append(currChar);
         } else if (Character.isDigit(currChar)) {
            digit = digit * 10 + Integer.parseInt(currChar + "");
         } else if (currChar == '[') {
            Pair rec = rec(index + 1, s, digit);
            index = rec.index;
            sb.append(rec.str);
            digit = 0;
         } else { // ']'
            return new Pair(index, sb.toString().repeat(repeat));
         }
         index++;
      }
      throw new RuntimeException("");
   }

   private record Pair(int index, String str) {

   }
}
