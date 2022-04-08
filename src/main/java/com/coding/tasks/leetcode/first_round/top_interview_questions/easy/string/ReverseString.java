package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

public class ReverseString {

   public static void main(String[] args) {
      char[] array = new char[]{'h', 'e', 'l', 'l', 'o'};
      System.out.println(array);
      reverseString(array);
      System.out.println(array);
   }

   private static void reverseString(char[] s) {
      int start = 0;
      int end = s.length - 1;
      while (start < end) {
         char tmp = s[start];
         s[start] = s[end];
         s[end] = tmp;
         start++;
         end--;
      }
   }
}
