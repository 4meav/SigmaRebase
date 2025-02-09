package com.mentalfrostbyte.jello.module.impl.movement.fly;

import com.mentalfrostbyte.jello.event.impl.game.network.EventReceivePacket;
import com.mentalfrostbyte.jello.event.impl.game.network.EventSendPacket;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventMove;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventUpdateWalkingPlayer;
import team.sdhq.eventBus.annotations.EventTarget;
import team.sdhq.eventBus.annotations.priority.LowerPriority;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.util.game.player.MovementUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CPlayerPacket;
import net.minecraft.network.play.server.SPlayerPositionLookPacket;

public class OmegaCraftTestFly extends Module {
    private int field23854;
    private int field23855;
    private double posX;
    private double posY;
    private double posZ;
    private double field23859;
    private double posYClone;
    private double posZClone;

    public OmegaCraftTestFly() {
        super(ModuleCategory.MOVEMENT, "Test", "A fly for OmegaCraft");
    }

    @Override
    public void onEnable() {
        this.posX = mc.player.getPosX();
        this.posY = mc.player.getPosY();
        this.posZ = mc.player.getPosZ();
        this.field23859 = 0.0;
        this.field23854 = 2;
        this.field23855 = 0;
    }

    @Override
    public void onDisable() {
        MovementUtil.strafe(0.0);
        if (mc.player.getMotion().y > 0.0) {
            MovementUtil.setPlayerYMotion(-0.0789);
        }

//        mc.timer.timerSpeed = 1.0F;
    }

    @EventTarget
    @LowerPriority
    public void method16700(EventMove var1) {
        if (this.isEnabled()) {
            double var4 = Math.sqrt(var1.getX() * var1.getX() + var1.getZ() * var1.getZ());
            if (this.field23854 <= 1) {
                if (this.field23854 != -1) {
                    if (this.field23854 != 0) {
                        if (this.field23854 < 1) {
                        }
                    } else {
                        MovementUtil.setSpeed(var1, 0.1);
                    }
                } else {
                    this.field23855++;
                    if (this.field23855 != 1 && this.field23855 % 3 != 0 && this.field23855 % 3 != 1) {
                    }

                    MovementUtil.setPlayerYMotion(var1.getY());
                    MovementUtil.setSpeed(var1, 1.0);
                }
            } else {
                var1.setY(0.0);
                MovementUtil.setSpeed(var1, 0.0);
            }
        }
    }

    @EventTarget
    public void method16701(EventUpdateWalkingPlayer var1) {
        if (this.isEnabled() && var1.isPre()) {
            this.field23854++;
            if (this.field23854 != 3) {
                if (this.field23854 > 3) {
                    if (this.field23854 >= 20 && this.field23854 % 20 == 0) {
                        var1.setY(0.0);
                    } else {
                        var1.cancelled = true;
                    }
                }
            } else {
                var1.setY(1000.0);
            }

            var1.setMoving(true);
        }
    }

    @EventTarget
    public void method16702(EventReceivePacket event) {
        if (this.isEnabled()) {
            IPacket<?> packet = event.getPacket();
            if (packet instanceof SPlayerPositionLookPacket) {
                SPlayerPositionLookPacket var5 = (SPlayerPositionLookPacket) packet;
                if (this.field23854 >= 1) {
                    this.field23854 = -1;
                }

                this.posYClone = this.posY;
                this.posZClone = this.posZ;
                this.posX = var5.getX();
                this.posY = var5.getY();
                this.posZ = var5.getZ();
                var5.yaw = mc.player.rotationYaw;
                var5.pitch = mc.player.rotationPitch;
            }
        }
    }

    @EventTarget
    public void method16703(EventSendPacket event) {
        if (this.isEnabled()) {
            IPacket<?> packet = event.getPacket();
            if (packet instanceof CPlayerPacket) {
                CPlayerPacket playerPacket = (CPlayerPacket) packet;
                if (this.field23854 == -1) {
                    playerPacket.onGround = true;
                }
            }
        }
    }

//    empty
//    @EventTarget
//    public void onRender(Render2DEvent event) {
//        if (!this.isEnabled()) {
//        }
//    }
}
