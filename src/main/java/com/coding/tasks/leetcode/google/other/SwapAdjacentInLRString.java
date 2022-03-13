package com.coding.tasks.leetcode.google.other;

public class SwapAdjacentInLRString {

   public static void main(String[] args) {
//      System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
      System.out.println(canTransform("X", "L"));
   }

   private static boolean canTransform(String start, String end) {
      int startCounter = 0;
      int endCounter = 0;
      char[] sChars = start.toCharArray();
      char[] eChars = end.toCharArray();

      while (startCounter < start.length() && endCounter < end.length()) {
         char s = sChars[startCounter];
         char e = eChars[endCounter];

         if (startCounter == endCounter && s == e) {
            startCounter++;
            endCounter++;
         } else {
            if (startCounter == start.length() - 1) {
               return false;
            }
            if (e == 'R') {
               return false;
            } else if (e == 'L') {
               if (s == 'X') {
                  for (int j = startCounter + 1; j < start.length(); j++) {
                     if (sChars[j] == 'R') {
                        return false;
                     } else if (sChars[j] == 'L') {
                        sChars[j] = 'X';
                        sChars[startCounter] = 'L';
                        startCounter++;
                        endCounter++;
                        break;
                     }
                  }
               } else {
                  return false;
               }
            } else {
               if (s == 'R') {
                  for (int j = startCounter + 1; j < start.length(); j++) {
                     if (sChars[j] == 'L') {
                        return false;
                     } else if (sChars[j] == 'X') {
                        sChars[j] = 'R';
                        sChars[startCounter] = 'X';
                        startCounter++;
                        endCounter++;
                        break;
                     }
                  }
               } else {
                  return false;
               }
            }
         }
      }

      for (int i = 0; i < sChars.length; i++) {
         if (sChars[i] != eChars[i]) {
            return false;
         }
      }
      return true;
   }
}
