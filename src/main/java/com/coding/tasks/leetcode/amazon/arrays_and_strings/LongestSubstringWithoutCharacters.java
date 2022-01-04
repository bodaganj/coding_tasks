package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(" "));
   }

   private static int lengthOfLongestSubstring(String s) {
      int ans = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0, j = 0; j < s.length(); j++) {
         char currentChar = s.charAt(j);

         if (map.containsKey(currentChar)) {
            i = Math.max(i, map.get(currentChar));
         }

         ans = Math.max(ans, j - i + 1);
         map.put(currentChar, j + 1);
      }
      return ans;
   }

   // this one is better!!!!!
//   public int lengthOfLongestSubstring1(String s) {
//      if (Objects.isNull(s) || s.isEmpty()) {
//         return 0;
//      }
//
//      int max = 0;
//      List<Character> input = s.chars().mapToObj(obj -> (char) obj).collect(Collectors.toList());
//      Queue<Character> queue = new LinkedList<>();
//
//      for (Character letter : input) {
//         if (queue.contains(letter)) {
//            max = Math.max(max, queue.size());
//            while (!queue.isEmpty()) {
//               Character poll = queue.poll();
//               if (poll == null || poll.equals(letter)) {
//                  break;
//               }
//            }
//            queue.add(letter);
//         } else {
//            queue.add(letter);
//            max = Math.max(max, queue.size());
//         }
//      }
//      return max;
//   }
}
