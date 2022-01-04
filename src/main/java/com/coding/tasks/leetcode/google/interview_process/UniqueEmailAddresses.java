package com.coding.tasks.leetcode.google.interview_process;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

   /**
    * Every valid email consists of a local name and a domain name, separated by the '@' sign.
    * Besides lowercase letters, the email may contain one or more '.' or '+'.
    * <p>
    * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
    * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.
    * Note that this rule does not apply to domain names.
    * <p>
    * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
    * This allows certain emails to be filtered. Note that this rule does not apply to domain names.
    * <p>
    * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    * It is possible to use both of these rules at the same time.
    * <p>
    * Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.
    */
   public static void main(String[] args) {
      String[] first = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
      String[] second = new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};

      System.out.println(numUniqueEmails(first));
      System.out.println(numUniqueEmails(second));
   }

   private static int numUniqueEmails(String[] emails) {
      Set<String> set = new HashSet<>();

      for (String email : emails) {
         String[] split = email.split("@");
         String localName = split[0];
         String domain = split[1];

         localName = localName.replaceAll("\\.", "").split("\\+", 2)[0];

         set.add(localName + "@" + domain);
      }

      return set.size();
   }
}
