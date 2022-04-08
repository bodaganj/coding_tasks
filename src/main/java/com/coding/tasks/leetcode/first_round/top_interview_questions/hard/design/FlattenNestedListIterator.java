package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.design;

import java.util.ArrayList;
import java.util.Iterator;
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

   /**
    * Your NestedIterator object will be instantiated and called as such:
    * NestedIterator i = new NestedIterator(nestedList);
    * while (i.hasNext()) v[f()] = i.next();
    */
   static class NestedIterator implements Iterator<Integer> {

      private final List<Integer> list = new ArrayList<>();
      private int counter = 0;

      public NestedIterator(List<NestedInteger> nestedList) {
         fillInList(nestedList);
      }

      @Override
      public Integer next() {
         Integer integer = list.get(counter);
         counter++;
         return integer;
      }

      @Override
      public boolean hasNext() {
         return counter < list.size();
      }

      private void fillInList(List<NestedInteger> nestedList) {
         for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
               list.add(nestedInteger.getInteger());
            } else {
               fillInList(nestedInteger.getList());
            }
         }
      }
   }
}
