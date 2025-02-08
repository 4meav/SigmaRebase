package com.mentalfrostbyte.jello.gui.base;

public enum WaypointColors {
    GRAY("Gray", -2565928),
    RED("Red", -35477),
    ORANGE("Orange", -17579),
    YELLOW("Yellow", -6310),
    GREEN("Green", -9240708),
    BLUE("Blue", -11491585),
    MAGENTA("Magenta", -2652417);

    public final String name;
    public final int color;

    WaypointColors(String name, int color) {
        this.name = name;
        this.color = color;
    }
}
