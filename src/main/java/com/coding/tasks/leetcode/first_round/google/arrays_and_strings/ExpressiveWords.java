package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExpressiveWords {

   public static void main(String[] args) {
      System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
      System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
      System.out.println(expressiveWords("abcd", new String[]{"abc"}));
      System.out.println(expressiveWords("heeellooo", new String[]{"heeelloooworld"}));
   }

   private static int expressiveWords(String s, String[] words) {
      if (Objects.isNull(words) || words.length == 0) {
         return 0;
      }

      int counter = 0;
      for (String word : words) {

         int i = 0;
         int j = 0;

         boolean flag = false;

         while (i < s.length()) {
            Map<Character, Integer> firstGroup = new HashMap<>();
            while (i < s.length()) {
               char charAt = s.charAt(i);

               if (firstGroup.isEmpty()) {
                  firstGroup.put(charAt, 1);
                  i++;
               } else if (firstGroup.containsKey(charAt)) {
                  firstGroup.put(charAt, firstGroup.get(charAt) + 1);
                  i++;
               } else {
                  break;
               }
            }

            Map<Character, Integer> secondGroup = new HashMap<>();
            while (j < word.length()) {
               char charAt = word.charAt(j);

               if (secondGroup.isEmpty()) {
                  secondGroup.put(charAt, 1);
                  j++;
               } else if (secondGroup.containsKey(charAt)) {
                  secondGroup.put(charAt, secondGroup.get(charAt) + 1);
                  j++;
               } else {
                  break;
               }
            }

            if (i == s.length() && j < word.length() - 1) {
               flag = false;
               break;
            }

            Integer firstValue;
            if (firstGroup.values().stream().findFirst().isPresent()) {
               firstValue = firstGroup.values().stream().findFirst().get();
            } else {
               flag = false;
               break;
            }

            Integer secondValue;
            if (secondGroup.values().stream().findFirst().isPresent()) {
               secondValue = secondGroup.values().stream().findFirst().get();
            } else {
               flag = false;
               break;
            }

            Character firstKey = firstGroup.keySet().stream().findFirst().get();
            Character secondKey = secondGroup.keySet().stream().findFirst().get();

            if (firstKey != secondKey || firstValue < secondValue || !firstValue.equals(secondValue) && firstValue < 3) {
               flag = false;
               break;
            } else {
               flag = true;
            }
         }
         if (flag) {
            counter++;
         }
      }
      return counter;
   }

//   private static int expressiveWords(String S, String[] words) {
//      if (S == null || words == null) {
//         return 0;
//      }
//      int count = 0;
//      for (String word : words) {
//         if (stretchy(S, word)) {
//            count++;
//         }
//      }
//      return count;
//   }
//
//   private static boolean stretchy(String S, String word) {
//      if (word == null) {
//         return false;
//      }
//      int i = 0;
//      int j = 0;
//      while (i < S.length() && j < word.length()) {
//         if (S.charAt(i) == word.charAt(j)) {
//            int len1 = getRepeatedLength(S, i);
//            int len2 = getRepeatedLength(word, j);
//            if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
//               return false;
//            }
//            i += len1;
//            j += len2;
//         } else {
//            return false;
//         }
//      }
//      return i == S.length() && j == word.length();
//   }
//
//   private static int getRepeatedLength(String str, int i) {
//      int j = i;
//      while (j < str.length() && str.charAt(j) == str.charAt(i)) {
//         j++;
//      }
//      return j - i;
//   }
}
