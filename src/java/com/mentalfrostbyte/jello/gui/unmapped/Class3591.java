package com.mentalfrostbyte.jello.gui.unmapped;

import com.mentalfrostbyte.jello.managers.impl.account.microsoft.Account;

import java.util.Comparator;

public final class Class3591 implements Comparator<Account> {
   private static String[] field19536;

   public int compare(Account var1, Account var2) {
      return var1.getName().toLowerCase().compareTo(var2.getName().toLowerCase());
   }
}
