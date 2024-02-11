package com.coding.tasks.leetcode.third_round.fb.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {

  public static void main(String[] args) {
//    System.out.println(removeInvalidParentheses("()())()"));
//    System.out.println(removeInvalidParentheses("(a)())()"));
    System.out.println(removeInvalidParentheses(")("));
    System.out.println(removeInvalidParentheses("n"));
  }

  private static int maxLength = 0;

  public static List<String> removeInvalidParentheses(String s) {
    maxLength = 0;
    int maxAmount = getMaxAmountOfParenteses(s);

    Set<String> ans = new HashSet<>();
    rec(0, 0, maxAmount, "", s, ans);

    return ans.stream().filter(str -> str.length() == maxLength).collect(Collectors.toList());
  }

  private static void rec(int alreadyOpened, int alreadyClosed, int maxAmount, String current, String s, Set<String> ans) {
    if (alreadyOpened == alreadyClosed && current.length() >= maxLength) {
      maxLength = current.length();
      ans.add(current);
    }
    if (alreadyClosed == maxAmount || s.isEmpty()) {
      return;
    }
    char c = s.charAt(0);
    if (Character.isLetter(c)) {
      rec(alreadyOpened, alreadyClosed, maxAmount, current + c, s.substring(1), ans);
    } else if (c == '(') {
      if (alreadyOpened != maxAmount) {
        rec(alreadyOpened + 1, alreadyClosed, maxAmount, current + c, s.substring(1), ans);
      }
      rec(alreadyOpened, alreadyClosed, maxAmount, current, s.substring(1), ans);
    } else {
      rec(alreadyOpened, alreadyClosed, maxAmount, current, s.substring(1), ans);
      if (alreadyOpened > alreadyClosed) {
        rec(alreadyOpened, alreadyClosed + 1, maxAmount, current + c, s.substring(1), ans);
      }
    }
  }

  private static int getMaxAmountOfParenteses(String s) {
    int open = 0;
    int close = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        open++;
      } else if (c == ')') {
        close++;
      }
    }

    return Math.min(open, close);
  }
}
