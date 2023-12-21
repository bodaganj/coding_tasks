package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

public class CountAndSay {

   public String countAndSay(int n) {
      String ans = "1";
      for (int i = 1; i < n; i++) {
         int index = 1;
         StringBuilder sb = new StringBuilder();
         int curCount = 1;
         char currChar = ans.charAt(0);
         while (index < ans.length()) {
            if (ans.charAt(index) == currChar) {
               curCount++;
            } else {
               sb.append(curCount).append(currChar);
               curCount = 1;
               currChar = ans.charAt(index);
            }
            index++;
         }
         sb.append(curCount).append(currChar);
         ans = sb.toString();
      }
      return ans;
   }
}
