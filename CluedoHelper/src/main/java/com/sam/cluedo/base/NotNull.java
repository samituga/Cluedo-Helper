package com.sam.cluedo.base;

import java.util.Objects;

/**
 * Util class to check if a given object is null or not
 */
public class NotNull {

    /**
     * Requires the toCheck object to be not null
     *
     * @param toCheck The object to check
     * @param caller  The caller
     * @param where   The method where this is being called from
     */
    public static void required(final Object toCheck, final Object caller, final String where) {
        required(toCheck, caller.getClass(), where);
    }

    /**
     * Requires the toCheck object to be not null
     *
     * @param toCheck The object to check
     * @param caller  The caller
     * @param where   The method where this is being called from
     */
    public static <T> void required(final Object toCheck, final Class<T> caller, final String where) {
        Objects.requireNonNull(toCheck, caller.getCanonicalName() + "::" + where + " object/value is null");
    }

}
