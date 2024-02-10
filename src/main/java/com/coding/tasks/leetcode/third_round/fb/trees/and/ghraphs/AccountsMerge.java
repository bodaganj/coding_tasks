package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.*;

public class AccountsMerge {

  public static void main(String[] args) {
//    System.out.println(accountsMerge(List.of(
//        List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
//        List.of("John", "johnsmith@mail.com", "john00@mail.com"),
//        List.of("Mary", "mary@mail.com"),
//        List.of("John", "johnnybravo@mail.com")
//    )));

    System.out.println(accountsMerge(List.of(
        List.of("David", "David0@m.co", "David1@m.co"), //a
        List.of("David", "David3@m.co", "David4@m.co"), //a
        List.of("David", "David4@m.co", "David5@m.co"), //a
        List.of("David", "David2@m.co", "David3@m.co"), //a
        List.of("David", "David1@m.co", "David2@m.co") //a
    )));
  }

  public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> ans = new ArrayList<>();

    Map<String, List<Integer>> mapping = getMailToIndexMapping(accounts);

    Set<Integer> seenIndex = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    for (List<String> account : accounts) {
      for (int j = 1; j < account.size(); j++) {
        List<Integer> indexs = mapping.get(account.get(j));
        for (Integer index : indexs) {
          if (!seenIndex.contains(index)) {
            seenIndex.add(index);
            queue.add(index);
          }
        }
      }

      List<String> tmp = new ArrayList<>();
      tmp.add(account.get(0));
      Set<String> set = new TreeSet<>();
      while (!queue.isEmpty()) {
        Integer poll = queue.poll();

        List<String> strings = accounts.get(poll);
        for (int k = 1; k < strings.size(); k++) {
          List<Integer> integers = mapping.get(strings.get(k));
          for (Integer integer : integers) {
            if (!seenIndex.contains(integer)) {
              seenIndex.add(integer);
              queue.add(integer);
            }
          }
          set.add(strings.get(k));
        }
      }
      if (!set.isEmpty()) {
        tmp.addAll(set);
        ans.add(tmp);
      }
    }

    return ans;
  }

  private static Map<String, List<Integer>> getMailToIndexMapping(List<List<String>> accounts) {
    Map<String, List<Integer>> mapping = new HashMap<>();
    for (int x = 0; x < accounts.size(); x++) {
      List<String> account = accounts.get(x);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        if (!mapping.containsKey(email)) {
          mapping.put(email, new ArrayList<>());
        }
        mapping.get(email).add(x);
      }
    }

    return mapping;
  }
}

