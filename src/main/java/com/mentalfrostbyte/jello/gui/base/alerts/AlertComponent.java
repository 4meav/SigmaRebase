package com.mentalfrostbyte.jello.gui.base.alerts;

public class AlertComponent {
    public ComponentType componentType;
    public String text;
    public int field44773;

    public AlertComponent(ComponentType componentType, String title, int var3) {
        this.componentType = componentType;
        this.text = title;
        this.field44773 = var3;
    }
}
