package com.coding.tasks.leetcode.third_round.google.others;

import java.util.Arrays;

public class GuesstheWord {

   public void findSecretWord(String[] words, Master master) {
      Arrays.sort(words);

      int left = 0;
      int right = words.length - 1;

      while (left <= right) {
         int mid = left + (right - left) / 2;
         int guess = master.guess(words[mid]);

         if (guess == words[mid].length()) {
            return;
         } else {
            if (master.guess(words[mid + 1]) > guess) {
               left = mid + 1;
            } else {
               right = mid - 1;
            }
         }
      }
   }

   interface Master {

      public int guess(String word);
   }
}
