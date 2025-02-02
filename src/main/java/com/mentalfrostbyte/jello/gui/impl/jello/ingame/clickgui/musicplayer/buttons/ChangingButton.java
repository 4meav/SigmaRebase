package com.mentalfrostbyte.jello.gui.impl.jello.ingame.clickgui.musicplayer.buttons;

import com.mentalfrostbyte.jello.gui.base.CustomGuiScreen;
import com.mentalfrostbyte.jello.gui.unmapped.UIBase;
import com.mentalfrostbyte.jello.managers.util.music.AudioRepeatMode;
import com.mentalfrostbyte.jello.util.client.ClientColors;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil2;
import com.mentalfrostbyte.jello.util.game.render.RenderUtil;
import com.mentalfrostbyte.jello.util.client.render.Resources;

public class ChangingButton extends UIBase {
   public AudioRepeatMode repeatMode;

   public ChangingButton(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6, AudioRepeatMode var7) {
      super(var1, var2, var3, var4, var5, var6, false);
      this.repeatMode = var7;
      this.doThis((var1x, var2x) -> {
         this.repeatMode = this.repeatMode.getNext();
         this.callUIHandlers();
      });
   }

   public AudioRepeatMode getRepeatMode() {
      return this.repeatMode;
   }

   @Override
   public void draw(float partialTicks) {
      RenderUtil.startScissor((float)this.xA, (float)this.yA, (float)this.widthA, (float)this.heightA);
      RenderUtil.drawImage(
         (float)(this.xA - this.repeatMode.type * this.widthA),
         (float)this.yA,
         (float)(this.widthA * 3),
         (float)this.heightA,
         Resources.repeatPNG,
         RenderUtil2.applyAlpha(  ClientColors.LIGHT_GREYISH_BLUE.getColor(), 0.35F)
      );
      RenderUtil.endScissor();
      super.draw(partialTicks);
   }
}
