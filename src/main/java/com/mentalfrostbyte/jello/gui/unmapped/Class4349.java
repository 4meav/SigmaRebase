package com.mentalfrostbyte.jello.gui.unmapped;

import com.mentalfrostbyte.jello.gui.base.CustomGuiScreen;
import com.mentalfrostbyte.jello.gui.impl.jello.buttons.LoadingIndicator;
import com.mentalfrostbyte.jello.managers.util.account.microsoft.Account;
import com.mentalfrostbyte.jello.util.client.ClientColors;
import com.mentalfrostbyte.jello.util.client.render.ResourceRegistry;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil2;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil;
import com.mentalfrostbyte.jello.util.client.render.Resources;
import org.newdawn.slick.opengl.Texture;
import com.mentalfrostbyte.jello.util.client.render.Class2218;

import java.awt.image.BufferedImage;

public class Class4349 extends AnimatedIconPanelWrap {
   public Account field21249 = null;
   private BufferedImage field21250;
   private Texture field21251;
   private float field21252 = 0.0F;
   private LoadingIndicator field21253;
   private boolean field21254 = false;
   private float field21255 = 0.0F;
   private int field21256 = 0;
   private int field21257 = 0;
   private int field21258 = RenderUtil2.shiftTowardsOther(ClientColors.LIGHT_GREYISH_BLUE.getColor(), ClientColors.DEEP_TEAL.getColor(), 20.0F);

   public Class4349(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6, Account var7) {
      super(var1, var2, var3, var4, var5, var6, false);
      this.field21249 = var7;
      this.addToList(this.field21253 = new LoadingIndicator(this, "loading", var5 - 50, 35, 30, 30));
      this.field21253.method13296(false);
   }

   public void method13580(boolean var1) {
      this.method13581(var1, false);
   }

   public void method13581(boolean var1, boolean var2) {
      this.field21254 = var1;
      if (var2) {
         this.field21252 = 1.0F;
      }
   }

   public boolean method13582() {
      return this.field21254;
   }

   @Override
   public void draw(float partialTicks) {
      this.method13225();
      this.field21252 = (float)((double)this.field21252 + (this.field21254 ? 0.2 : -0.2));
      this.field21252 = Math.min(1.0F, Math.max(0.0F, this.field21252));
      this.field21258 = RenderUtil2.shiftTowardsOther(ClientColors.LIGHT_GREYISH_BLUE.getColor(), ClientColors.DEEP_TEAL.getColor(), 2.0F);
      if (this.field21254 || this.method13212() || this.method13298()) {
         RenderUtil.drawRoundedRect(
            (float)this.xA,
            (float)this.yA,
            (float)(this.xA + this.widthA),
            (float)(this.yA + this.heightA),
            RenderUtil2.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor(), 0.05F)
         );
      }

      if (!this.method13212()) {
         if (this.method13298() && this.field21254) {
            RenderUtil.method11429(
               (float)this.xA,
               (float)this.yA,
               (float)(this.xA + this.widthA),
               (float)(this.yA + this.heightA),
               2,
                    RenderUtil2.applyAlpha(ClientColors.MID_GREY.getColor(), 0.5F)
            );
         } else if (!this.method13298()) {
            if (this.field21254) {
               RenderUtil.method11429(
                  (float)this.xA,
                  (float)this.yA,
                  (float)(this.xA + this.widthA),
                  (float)(this.yA + this.heightA),
                  2,
                       RenderUtil2.applyAlpha(ClientColors.MID_GREY.getColor(), 0.3F)
               );
            }
         } else {
            RenderUtil.method11429(
               (float)this.xA,
               (float)this.yA,
               (float)(this.xA + this.widthA),
               (float)(this.yA + this.heightA),
               2,
                    RenderUtil2.applyAlpha(ClientColors.DEEP_TEAL.getColor(), 0.3F)
            );
         }
      } else {
         RenderUtil.method11429(
            (float)this.xA,
            (float)this.yA,
            (float)(this.xA + this.widthA),
            (float)(this.yA + this.heightA),
            2,
                 RenderUtil2.applyAlpha(ClientColors.MID_GREY.getColor(), 0.65F)
         );
      }

      RenderUtil.drawPortalBackground(this.xA, this.yA, this.xA + this.widthA, this.yA + this.heightA, true);
      if (this.field21249 != null) {
         this.method13584();
         RenderUtil.endScissor();
         if (this.field21252 > 0.0F && this.heightA > 55) {
            RenderUtil.drawImage(
               (float)(this.xA + this.getWidthA()),
               (float)this.yA + (float)(26 * this.heightA) / 100.0F,
               18.0F * this.field21252 * (float)this.heightA / 100.0F,
               (float)(47 * this.heightA) / 100.0F,
               Resources.selectPNG,
               !this.method13212() ? ClientColors.LIGHT_GREYISH_BLUE.getColor() : this.field21258
            );
         }

         super.draw(partialTicks);
      }
   }

   public void method13583() {
      RenderUtil.drawImage(
         (float)(this.xA + 13), (float)(this.yA + 13), 75.0F, 75.0F, this.field21249.setSkinTexture(), ClientColors.LIGHT_GREYISH_BLUE.getColor(), true
      );
      RenderUtil.method11464((float)(this.xA + 13), (float)(this.yA + 13), 75.0F, 75.0F, 20.0F, 1.0F);
      RenderUtil.drawImage(
         (float)(this.xA + 1),
         (float)this.yA,
         100.0F,
         100.0F,
         Resources.cerclePNG,
         !this.method13212() ? ClientColors.LIGHT_GREYISH_BLUE.getColor() : this.field21258
      );
   }

   public void method13584() {
      String var3 = this.field21249.getKnownName();
      if (var3.equals("Unknown name")) {
         var3 = this.field21249.getEmail();
      }

      RenderUtil.drawString(
         ResourceRegistry.DefaultClientFont,
         (float)(this.xA + this.widthA / 2),
         (float)(this.yA + 20),
         var3,
         RenderUtil2.applyAlpha(ClientColors.DEEP_TEAL.getColor(), 0.4F),
         Class2218.field14492,
         Class2218.field14492
      );
      RenderUtil.drawString(
         ResourceRegistry.DefaultClientFont,
         (float)(this.xA + this.widthA / 2),
         (float)(this.yA + 18),
         var3,
         ClientColors.LIGHT_GREYISH_BLUE.getColor(),
         Class2218.field14492,
         Class2218.field14492
      );
      if (!this.field21249.isEmailAValidEmailFormat()) {
         RenderUtil.drawString(
            ResourceRegistry.DefaultClientFont,
            (float)(this.xA + this.widthA / 2),
            (float)(this.yA + 32),
            this.field21249.getPassword().replaceAll(".", "*"),
            -8355712,
            Class2218.field14492,
            Class2218.field14489,
            true
         );
      } else {
         RenderUtil.drawString(
            ResourceRegistry.DefaultClientFont,
            (float)(this.xA + this.widthA / 2),
            (float)(this.yA + 29),
            "Cracked",
            ClientColors.PALE_YELLOW.getColor(),
            Class2218.field14492,
            Class2218.field14489,
            true
         );
      }
   }

   public void method13585(int var1) {
      this.field21256 = var1;
      this.field21257 = var1;
   }

   public void method13586(boolean var1) {
      this.field21253.method13296(var1);
   }
}
