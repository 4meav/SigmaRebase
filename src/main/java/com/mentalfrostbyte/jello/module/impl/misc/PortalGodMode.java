package com.mentalfrostbyte.jello.module.impl.misc;

import com.mentalfrostbyte.jello.event.impl.game.network.EventReceivePacket;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import net.minecraft.network.play.client.CConfirmTeleportPacket;
import team.sdhq.eventBus.annotations.EventTarget;

public class PortalGodMode extends Module {
    public PortalGodMode() {
        super(ModuleCategory.MISC, "PortalGodMode", "Makes you invulnerable when you go through a portal and stay in it");
    }

    @EventTarget
    private void onReceivePacket(EventReceivePacket var1) {
        if (this.isEnabled()) {
            if (var1.getPacket() instanceof CConfirmTeleportPacket) {
                var1.setCancelled(true);
            }
        }
    }
}