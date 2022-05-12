package com.coding.tasks.leetcode.second_round.google.other;

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
      return getBulls(secret, guess) + "A" + getCows(secret, guess) + "B";
   }

   private static int getBulls(String secret, String guess) {
      int counter = 0;
      for (int i = 0; i < secret.length(); i++) {
         if (secret.charAt(i) == guess.charAt(i)) {
            counter++;
         }
      }
      return counter;
   }

   private static int getCows(String secret, String guess) {
      int counter = 0;
      Map<Character, Integer> secretMapping = new HashMap<>();
      for (int i = 0; i < secret.length(); i++) {
         if (secret.charAt(i) != guess.charAt(i)) {
            secretMapping.put(secret.charAt(i), secretMapping.getOrDefault(secret.charAt(i), 0) + 1);
         }
      }

      for (int i = 0; i < guess.length(); i++) {
         if (secret.charAt(i) != guess.charAt(i)) {
            if (secretMapping.containsKey(guess.charAt(i))) {
               counter++;
               int newValue = secretMapping.get(guess.charAt(i)) - 1;
               if (newValue == 0) {
                  secretMapping.remove(guess.charAt(i));
               } else {
                  secretMapping.put(guess.charAt(i), newValue);
               }
            }
         }
      }

      return counter;
   }
}
