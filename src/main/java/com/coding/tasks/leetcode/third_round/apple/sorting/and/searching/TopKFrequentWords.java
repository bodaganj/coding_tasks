package com.coding.tasks.leetcode.third_round.apple.sorting.and.searching;

import java.util.*;

public class TopKFrequentWords {

  public static void main(String[] args) {
    System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
  }

  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
      if (Objects.equals(map.get(o1), map.get(o2))) {
        return o2.compareTo(o1);
      } else {
        return map.get(o1) - map.get(o2);
      }
    });
    for (String word : map.keySet()) {
      queue.add(word);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    List<String> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      ans.add(queue.poll());
    }
    Collections.reverse(ans);
    return ans;
  }
}
