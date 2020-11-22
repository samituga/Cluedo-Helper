package com.sam.cluedo.util;

import java.awt.*;


/**
 * Wrapper for the java.awt.Color class
 */
public enum Colour {
    AZURE(new Color(0x1520A6), ("Azure")),
    BLUE(new Color(0xFF0000FF), ("Blue")),
    BROWN(new Color(0x7C4700), "Brown"),
    EMERALD(new Color(0x50C878), ("Emerald")),
    GREEN(new Color(0xFF00FF00), ("Green")),
    GREY(new Color(0x808080), ("Grey")),
    ORCHID(new Color(0xB41EB4), ("Orchid")),
    PEACH(new Color(0xFF7F4F), ("Peach")),
    PURPLE(new Color(0x800080), ("Purple")),
    RED(new Color(0xFFFF0000), ("Red")),
    ROSE(new Color(0xFF007F), ("Rose")),
    RUST(new Color(0xB7410E), ("Rust")),
    SAPPHIRE(new Color(0x52B2BF), "Sapphire"),
    SHADOW(new Color(0x444444), ("Shadow")),
    SYRUP(new Color(0x492000), ("Syrup")),
    VENOM(new Color(0x728c00), ("Venom")),
    WHITE(new Color(0xFFFFFF), ("White")),
    YELLOW(new Color(0xFFFF00), ("Yellow"));

    private final Color colour;
    private final String label;

    Colour(Color colour, String label) {
        this.colour = colour;
        this.label = label;
    }

    /**
     * @return The name of the colour
     */
    public String label() {
        return label;
    }

    /**
     * @return The rgb of the colour
     */
    public int rgb() {
        return colour.getRGB();
    }
}
