package com.coding.tasks.leetcode.third_round.google.others;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

   public static void main(String[] args) {
      System.out.println(getHint("1807", "7810"));
      System.out.println(getHint("1123", "0111"));
   }

   public static String getHint(String secret, String guess) {
      int bulls = getBulls(secret, guess);
      int cows = getCows(secret, guess);
      return bulls + "A" + cows + "B";
   }

   private static int getBulls(String secret, String guess) {
      int bulls = 0;
      for (int i = 0; i < secret.length(); i++) {
         if (secret.charAt(i) == guess.charAt(i)) {
            bulls++;
         }
      }
      return bulls;
   }

   private static int getCows(String secret, String guess) {
      int cows = 0;
      Map<Character, Integer> secretCowsMapping = new HashMap<>();
      for (int i = 0; i < secret.length(); i++) {
         if (secret.charAt(i) != guess.charAt(i)) {
            secretCowsMapping.put(secret.charAt(i), secretCowsMapping.getOrDefault(secret.charAt(i), 0) + 1);
         }
      }

      for (int i = 0; i < secret.length() && secretCowsMapping.size() > 0; i++) {
         if (secret.charAt(i) != guess.charAt(i)) {
            if (secretCowsMapping.containsKey(guess.charAt(i))) {
               cows++;
               if (secretCowsMapping.get(guess.charAt(i)) == 1) {
                  secretCowsMapping.remove(guess.charAt(i));
               } else {
                  secretCowsMapping.put(guess.charAt(i), secretCowsMapping.get(guess.charAt(i)) - 1);
               }
            }
         }
      }

      return cows;
   }
}
