package com.coding.tasks.leetcode.second_round.google.interview_process;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

   public static void main(String[] args) {
      String[] first = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
      String[] second = new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};

      System.out.println(numUniqueEmails(first));
      System.out.println(numUniqueEmails(second));
   }

   private static int numUniqueEmails(String[] emails) {
      Set<String> uniqueEmails = new HashSet<>();

      for (String email : emails) {
         String[] splitEmail = email.split("@");
         String localName = getLocalName(splitEmail[0]);
         uniqueEmails.add(localName + "@" + splitEmail[1]);
      }

      return uniqueEmails.size();
   }

   private static String getLocalName(String str) {
      StringBuilder sb = new StringBuilder();
      for (char aChar : str.toCharArray()) {
         if (Character.isLetter(aChar)) {
            sb.append(aChar);
         } else if (aChar == '+') {
            return sb.toString();
         }
      }
      return sb.toString();
   }
}
