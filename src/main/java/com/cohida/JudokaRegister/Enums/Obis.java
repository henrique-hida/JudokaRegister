package com.cohida.JudokaRegister.Enums;

import java.util.Arrays;

public enum Obis {
    WHITE(1, "White"),
    GRAY(2, "Gray"),
    BLUE(3, "Blue"),
    YELLOW(4, "Yellow"),
    ORANGE(5, "Orange"),
    GREEN(6, "Green"),
    PURPLE(7, "Purple"),
    BROWN(8, "Brown"),
    BLACK(9, "Black"),
    CORAL(10, "Coral"),
    RED(11, "Red");

    private final int id;
    private final String displayName;

    Obis(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Obis fromId(Integer id) {
        if (id == null) return null;
        return Arrays.stream(values())
                .filter(e -> e.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid belt ID: " + id));
    }

    public static Countries fromName(String name) {
        try {
            return Countries.valueOf(name.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
