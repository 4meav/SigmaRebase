package com.mentalfrostbyte.jello.module.impl.movement.step;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventUpdateWalkingPlayer;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventSafeWalk;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventStep;
import com.mentalfrostbyte.jello.event.impl.player.movement.EventMove;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.module.impl.combat.Criticals;
import com.mentalfrostbyte.jello.module.impl.movement.Step;
import com.mentalfrostbyte.jello.module.settings.impl.ModeSetting;
import com.mentalfrostbyte.jello.util.game.player.MovementUtil2;
import net.minecraft.util.math.MathHelper;
import team.sdhq.eventBus.annotations.EventTarget;
import team.sdhq.eventBus.annotations.priority.LowerPriority;

public class SpiderStep extends Module {
    private int field23758;
    private double field23759;
    private double field23760;
    private float field23761;

    public SpiderStep() {
        super(ModuleCategory.MOVEMENT, "Spider", "Step for Spider");
        this.registerSetting(new ModeSetting("Mode", "Mode", 0, "NCP", "AAC", "Gomme"));
    }

    @Override
    public void onEnable() {
        this.field23758 = 0;
    }

    @EventTarget
    @LowerPriority
    public void onStep(EventStep event) {
        if (this.isEnabled() && !event.isCancelled()) {
            double var4 = event.getHeight();
            Step.StepEnum var6 = ((Step) this.access()).method16748(event);
            if (var6 == Step.StepEnum.NORMAL_BLOCK) {
                event.setCancelled(true);
            } else if (var6 != Step.StepEnum.STAIRS) {
                if (!com.mentalfrostbyte.jello.util.game.player.MovementUtil.isInWater() && var4 >= 0.625) {
                    this.field23760 = var4;
                    double var7 = com.mentalfrostbyte.jello.util.game.player.MovementUtil.getJumpValue();
                    if (var4 < 1.1) {
                        var7 *= var4;
                    }

                    var7 = !(var7 > 0.42) ? var7 : 0.4199998;
                    event.setY(var7);
                    this.field23761 = com.mentalfrostbyte.jello.util.game.player.MovementUtil.otherStrafe()[0] - 90.0F;
                    this.field23758 = 1;
                    this.field23759 = mc.player.getPosY();
                    var4 = event.getHeight();
                }
            }
        }
    }

    @EventTarget
    public void onUpdate(EventUpdateWalkingPlayer var1) {
        if (this.isEnabled() && mc.player != null && var1.isPre()) {
            if (this.field23758 != 1) {
                if (this.field23758 == 3) {
                    Module var4 = Client.getInstance().moduleManager.getModuleByClass(Criticals.class);
                    if (var4.isEnabled() && var4.getStringSettingValueByName("Type").equals("NoGround")) {
                        var1.setY(var1.getY() + 1.0E-14);
                    } else {
                        var1.setGround(true);
                    }
                }
            } else {
                var1.setGround(false);
            }
        }
    }

    @EventTarget
    public void onMove(EventMove var1) {
        if (this.isEnabled() && mc.player != null) {
            if (this.field23758 == 1) {
                double var4 = com.mentalfrostbyte.jello.util.game.player.MovementUtil.getJumpValue();
                if (this.field23760 < 1.1) {
                    var4 *= this.field23760;
                }

                var4 = var4 > 0.42 ? 0.4199998 : var4;
                var1.setY(var4 * 0.797);
                com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, 0.0);
                this.field23758++;
            } else if (this.field23758 == 2) {
                var1.setY(this.field23759 + this.field23760 - mc.player.getPosY());
                double var10 = this.getStringSettingValueByName("Mode").equals("AAC") ? 0.301 : com.mentalfrostbyte.jello.util.game.player.MovementUtil.getSpeed();
                float var6 = this.field23761 * (float) (Math.PI / 180.0);
                var1.setX((double) (-MathHelper.sin(var6)) * var10);
                var1.setZ((double) MathHelper.cos(var6) * var10);
                this.field23758++;
            } else if (this.field23758 == 3) {
                if (MovementUtil2.isAboveBounds(mc.player, 0.001F)) {
                    var1.setY(-0.078);
                    String var7 = this.getStringSettingValueByName("Mode");
                    switch (var7) {
                        case "NCP":
                            com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, com.mentalfrostbyte.jello.util.game.player.MovementUtil.getSpeed());
                            break;
                        case "AAC":
                            com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, 0.301);
                            break;
                        case "Gomme":
                            com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, 0.175);
                    }
                } else {
                    com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, 0.25);
                }

                if (!MovementUtil2.isMoving()) {
                    com.mentalfrostbyte.jello.util.game.player.MovementUtil.setSpeed(var1, 0.0);
                }

                this.field23758 = 0;
            }
        }
    }

    @EventTarget
    public void onSafeWalk(EventSafeWalk var1) {
        if (this.isEnabled() && mc.player != null) {
            if (!var1.isOnEdge()) {
                mc.player.stepHeight = 1.07F;
            } else {
                mc.player.stepHeight = 0.5F;
            }
        }
    }
}