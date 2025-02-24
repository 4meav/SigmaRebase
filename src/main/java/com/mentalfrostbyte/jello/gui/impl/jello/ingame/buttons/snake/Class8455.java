package com.mentalfrostbyte.jello.gui.impl.jello.ingame.buttons.snake;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.util.system.render.ScreenDimension;

public class Class8455 {
   public final int field36259;
   public final int field36260;
   private Class8438 field36261;
   private ScreenDimension field36262;

   public Class8455(int var1, int var2) {
      this.field36259 = var1;
      this.field36260 = var2;
      this.field36261 = new Class8438(new ScreenDimension(this.field36259 / 2, this.field36260 / 2));
      this.method29735();
   }

   public void method29728() {
      this.field36261.method29651();
      if (this.field36261.method29656(this.field36262)) {
         this.method29735();
         this.field36261.method29652();
         Client.getInstance().soundManager.play("pop");
      }

      if (this.field36261.method29654() || this.method29729()) {
         this.method29731();
      }
   }

   public boolean method29729() {
      for (ScreenDimension var4 : this.field36261.method29655()) {
         if (var4.width < 0 || var4.height < 0 || var4.width >= this.field36259 || var4.height >= this.field36260) {
            return true;
         }
      }

      return false;
   }

   public boolean method29730(ScreenDimension var1) {
      return var1.width < 0 || var1.height < 0 || var1.width >= this.field36259 || var1.height >= this.field36260;
   }

   public void method29731() {
      this.field36261 = new Class8438(new ScreenDimension(this.field36259 / 2, this.field36260 / 2));
      this.method29735();
   }

   public ScreenDimension method29732() {
      return new ScreenDimension(this.field36259, this.field36260);
   }

   public int method29733() {
      return this.field36259 * this.field36260;
   }

   public ScreenDimension method29734() {
      ScreenDimension var3 = null;

      while (this.field36261.method29656(var3) || this.method29730(var3)) {
         var3 = new ScreenDimension((int)Math.round(Math.random() * (double)this.field36259), (int)Math.round(Math.random() * (double)this.field36260));
      }

      return var3;
   }

   public void method29735() {
      this.field36262 = this.method29734();
   }

   public ScreenDimension method29736() {
      return this.field36262;
   }

   public Class8438 method29737() {
      return this.field36261;
   }
}
