package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

public class ReverseString {

   public static void main(String[] args) {

   }

   public void reverseString(char[] s) {
      int left = 0;
      int right = s.length - 1;
      while (left < right) {
         char tmp = s[left];
         s[left] = s[right];
         s[right] = tmp;
         left++;
         right--;
      }
   }
}
