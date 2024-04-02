package com.coding.tasks.leetcode.third_round.fb.recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {

  private static int maxLength = 0;

  public static void main(String[] args) {
//    System.out.println(removeInvalidParentheses("()())()"));
//    System.out.println(removeInvalidParentheses("(a)())()"));
    System.out.println(removeInvalidParentheses(")("));
    System.out.println(removeInvalidParentheses("n"));
  }

  public static List<String> removeInvalidParentheses(String s) {
    maxLength = 0;
    Set<String> ans = new HashSet<>();
    rec(0, 0, "", s, ans);
    return ans.stream().filter(str -> str.length() == maxLength).collect(Collectors.toList());
  }

  private static void rec(int alreadyOpened, int alreadyClosed, String current, String s, Set<String> ans) {
    if (alreadyOpened == alreadyClosed && current.length() >= maxLength) {
      maxLength = current.length();
      ans.add(current);
    }
    if (s.isEmpty()) {
      return;
    }
    char c = s.charAt(0);
    if (Character.isLetter(c)) {
      rec(alreadyOpened, alreadyClosed, current + c, s.substring(1), ans);
    } else if (c == '(') {
      rec(alreadyOpened + 1, alreadyClosed, current + c, s.substring(1), ans);
      rec(alreadyOpened, alreadyClosed, current, s.substring(1), ans);
    } else {
      rec(alreadyOpened, alreadyClosed, current, s.substring(1), ans);
      if (alreadyOpened > alreadyClosed) {
        rec(alreadyOpened, alreadyClosed + 1, current + c, s.substring(1), ans);
      }
    }
  }
}
