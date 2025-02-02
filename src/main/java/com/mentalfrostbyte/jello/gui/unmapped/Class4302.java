package com.mentalfrostbyte.jello.gui.unmapped;


import com.mentalfrostbyte.jello.gui.base.CustomGuiScreen;
import com.mentalfrostbyte.jello.util.client.ClientColors;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil2;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil;
import com.mentalfrostbyte.jello.util.client.render.Resources;

public class Class4302 extends AnimatedIconPanelWrap {
   private static String[] field20844;

   public Class4302(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6, false);
   }

   @Override
   public void draw(float partialTicks) {
      if (this.isVisible()) {
         RenderUtil.drawImage(
            (float)(this.xA + 30),
            (float)(this.yA + 30),
            187.0F,
            36.0F,
            Resources.gemPNG,
            RenderUtil2.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor(), partialTicks)
         );
      }
   }
}
