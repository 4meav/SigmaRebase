package com.mentalfrostbyte.jello.gui.unmapped;

import com.mentalfrostbyte.jello.managers.impl.account.microsoft.Account;

import java.util.Comparator;

public final class Class3578 implements Comparator<Account> {
   private static String[] field19518;

   public int compare(Account var1, Account var2) {
      return var1.getLastUsed() >= var2.getLastUsed() ? (var1.getLastUsed() <= var2.getLastUsed() ? 0 : -1) : 1;
   }
}
