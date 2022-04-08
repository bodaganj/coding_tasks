package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.design;

import java.util.List;

public class FlattenNestedListIterator {

   // This is the interface that allows for creating nested lists.
   // You should not implement it, or speculate about its implementation
   interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      List<NestedInteger> getList();
   }
}
