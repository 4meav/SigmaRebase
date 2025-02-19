package com.mentalfrostbyte.jello.gui.impl.jello.ingame.buttons.snake;

import com.mentalfrostbyte.jello.gui.combined.CustomGuiScreen;
import com.mentalfrostbyte.jello.gui.combined.AnimatedIconPanel;
import com.mentalfrostbyte.jello.util.system.render.ScreenDimension;
import com.mentalfrostbyte.jello.util.client.render.theme.ClientColors;
import com.mentalfrostbyte.jello.util.system.math.counter.TimerUtil;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class Class4297 extends AnimatedIconPanel {
   private static String[] field20816;
   public Minecraft field20817 = Minecraft.getInstance();
   public Class8455 field20818;
   public TimerUtil field20819 = new TimerUtil();
   public int field20820;

   public Class4297(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      super(var1, var2, var3, var4, 100, 100, false);
      this.field20818 = new Class8455(var5, var6);
      this.widthA = var5 * var7;
      this.heightA = var6 * var7;
      this.field20820 = var7;
      this.field20819.start();
   }

   @Override
   public void draw(float partialTicks) {
      if (this.field20819.getElapsedTime() > 70L) {
         this.field20819.reset();
         this.field20818.method29728();
      }

      GL11.glPushMatrix();
      GL11.glTranslatef((float)this.xA, (float)this.yA, 0.0F);
      RenderUtil.drawRoundedRect2(0.0F, 0.0F, (float)this.getWidthA(), (float)this.getHeightA(), ClientColors.DEEP_TEAL.getColor());
      RenderUtil.drawRoundedButton(
         (float)(this.field20818.method29736().width * this.field20820),
         (float)(this.field20818.method29736().height * this.field20820),
         (float)this.field20820,
         (float)this.field20820,
         5.0F,
         ClientColors.PALE_ORANGE.getColor()
      );

      for (ScreenDimension var5 : this.field20818.method29737().method29655()) {
         RenderUtil.drawRoundedRect2(
            (float)(var5.width * this.field20820),
            (float)(var5.height * this.field20820),
            (float)this.field20820,
            (float)this.field20820,
            ClientColors.LIGHT_GREYISH_BLUE.getColor()
         );
      }

      GL11.glPopMatrix();
      super.draw(partialTicks);
   }

   public int method13179() {
      return this.field20818.method29737().method29655().size();
   }

   @Override
   public void keyPressed(int keyCode) {
      super.keyPressed(keyCode);
      if (keyCode != this.field20817.gameSettings.keyBindForward.keyCode.getKeyCode()) {
         if (keyCode != this.field20817.gameSettings.keyBindBack.keyCode.getKeyCode()) {
            if (keyCode != this.field20817.gameSettings.keyBindLeft.keyCode.getKeyCode()) {
               if (keyCode == this.field20817.gameSettings.keyBindRight.keyCode.getKeyCode()) {
                  this.field20818.method29737().method29653(Class2097.field13664);
               }
            } else {
               this.field20818.method29737().method29653(Class2097.field13663);
            }
         } else {
            this.field20818.method29737().method29653(Class2097.field13662);
         }
      } else {
         this.field20818.method29737().method29653(Class2097.field13661);
      }
   }
}
