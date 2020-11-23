package com.sam.cluedo.base;

/**
 * Util class to provide the name of a class
 */
public class Typename {


    /**
     * Simple method to return the name of a class
     *
     * @param fromClazz The class
     * @param <T> The type of the class
     * @return The name of the class
     */
    public static <T> String get(final Class<T> fromClazz) {
        NotNull.required(fromClazz, Typename.class, "get()");
        return fromClazz.getSimpleName();
    }
}
