package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

   public List<List<String>> groupAnagrams(String[] strs) {
      Map<Map<Character, Integer>, List<String>> ans = new HashMap<>();
      for (String str : strs) {
         Map<Character, Integer> tmp = new HashMap<>();
         for (char c : str.toCharArray()) {
            tmp.put(c, tmp.getOrDefault(c, 0) + 1);
         }

         if (!ans.containsKey(tmp)) {
            ans.put(tmp, new ArrayList<>());
         }
         ans.get(tmp).add(str);
      }

      return ans.values().stream().toList();
   }
}
