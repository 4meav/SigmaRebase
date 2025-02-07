package com.mentalfrostbyte.jello.gui.base.elements;

import com.mentalfrostbyte.jello.gui.base.CustomGuiScreen;
import com.mentalfrostbyte.jello.gui.base.interfaces.IHandler;
import com.mentalfrostbyte.jello.gui.impl.others.panels.AnimatedIconPanelWrap;
import com.mentalfrostbyte.jello.util.client.render.theme.ColorHelper;
import org.newdawn.slick.TrueTypeFont;

import java.util.ArrayList;
import java.util.List;

// NOTE: thought of this being PanelBase because AlertPanel uses it,
//       but then I checked the usages and I saw UIButton & etc.
public class Element extends AnimatedIconPanelWrap {
    private final List<IHandler> iHandlers = new ArrayList<IHandler>();

   public Element(CustomGuiScreen screen, String typeThingIdk, int x, int y, int width, int height, boolean var7) {
      super(screen, typeThingIdk, x, y, width, height, var7);
   }

   public Element(CustomGuiScreen screen, String typeThingIdk, int x, int y, int width, int height, ColorHelper var7, boolean var8) {
      super(screen, typeThingIdk, x, y, width, height, var7, var8);
   }

   public Element(CustomGuiScreen screen, String typeThingIdk, int x, int y, int width, int height, ColorHelper var7, String var8, boolean var9) {
      super(screen, typeThingIdk, x, y, width, height, var7, var8, var9);
   }

   public Element(CustomGuiScreen screen, String typeThingIdk, int x, int y, int width, int height, ColorHelper var7, String var8, TrueTypeFont font, boolean var10) {
      super(screen, typeThingIdk, x, y, width, height, var7, var8, font, var10);
   }

   public final void onPress(IHandler iHandler) {
      this.iHandlers.add(iHandler);
   }

   public final void callUIHandlers() {
      for (IHandler handler : this.iHandlers) {
         handler.handle(this);
      }
   }
}
