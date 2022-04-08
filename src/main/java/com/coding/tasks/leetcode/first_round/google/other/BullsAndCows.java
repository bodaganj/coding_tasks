package com.coding.tasks.leetcode.first_round.google.other;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

   public static void main(String[] args) {
      System.out.println(getHint("1807", "7810"));
      System.out.println(getHint("1123", "0111"));
      System.out.println(getHint("1122", "2211"));
      System.out.println(getHint("1122", "1222"));
   }

   private static String getHint(String secret, String guess) {
      int bulls = 0;
      int cows = 0;
      boolean[] checked = new boolean[secret.length()];

      // check bulls first
      for (int i = 0; i < secret.length(); i++) {
         if (secret.charAt(i) == guess.charAt(i)) {
            checked[i] = true;
            bulls++;
         }
      }

      // check cows
      Map<Character, Integer> dict = new HashMap<>();
      for (int i = 0; i < secret.length(); i++) {
         if (!checked[i]) {
            dict.put(secret.charAt(i), dict.getOrDefault(secret.charAt(i), 0) + 1);
         }
      }

      for (int i = 0; i < guess.length(); i++) {
         if (!checked[i] && dict.containsKey(guess.charAt(i))) {
            cows++;
            dict.put(guess.charAt(i), dict.get(guess.charAt(i)) - 1);
            if (dict.get(guess.charAt(i)) == 0) {
               dict.remove(guess.charAt(i));
            }
         }
      }

      return bulls + "A" + cows + "B";
   }
}
