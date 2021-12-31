package com.coding.tasks.leetcode.top.interview.questions.easy.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountAndSay {

   //   countAndSay(1) = "1"
//   countAndSay(2) = say "1" = one 1 = "11"
//   countAndSay(3) = say "11" = two 1's = "21"
//   countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

   public static void main(String[] args) {
      System.out.println(countAndSay(1));
      System.out.println(countAndSay(2));
      System.out.println(countAndSay(5));
   }

   // do while + counter
   private static String countAndSay(int n) {
      String result = "";
      for (int i = 1; i <= n; i++) {
         if (i == 1) {
            result = "1";
         } else {
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : result.toCharArray()) {
               if (map.size() == 1 && !map.containsKey(c)) {
                  sb.append(map.values().stream().findFirst().get());
                  sb.append(map.keySet().stream().findFirst().get());
                  map = new LinkedHashMap<>();
                  map.put(c, 1);
               } else {
                  map.put(c, map.getOrDefault(c, 0) + 1);
               }
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
               sb.append(entry.getValue()).append(entry.getKey());
            }

            result = sb.toString();
         }
      }
      return result;
   }

//   private static String countAndSay(int n) {
//      return countAndSay1(n, "");
//   }
//
//   private static String countAndSay1(int n, String result) {
//      if (n == 1) {
//         result = "1";
//         return result;
//      } else {
//         if (result.isBlank()) {
//            return countAndSay1(n - 1, result);
//         } else {
//            Map<Character, Integer> map = new LinkedHashMap<>();
//            for (char c : result.toCharArray()) {
//               map.put(c, map.getOrDefault(c, 0) + 1);
//            }
//            StringBuilder sb = new StringBuilder();
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//               sb.append(entry.getValue()).append(entry.getKey());
//            }
//
//            result = sb.toString();
//            return result;
//         }
//      }
//   }
}
