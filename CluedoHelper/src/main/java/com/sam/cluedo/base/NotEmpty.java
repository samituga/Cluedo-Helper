package com.sam.cluedo.base;

import com.sam.cluedo.exception.EmptyException;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;


/**
 * Util class to check if a given object is empty or not
 * Use the given method if it is needed to throw an {@link EmptyException}
 */
public class NotEmpty {

    /**
     * Util method to verify if the given string is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final String toCheck, final Object caller, final String where) {
        required(toCheck, caller.getClass(), where);
    }

    /**
     * Util method to verify if the given string is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final String toCheck, final Class caller, final String where) {
        if (isEmpty(toCheck)) {
            throw new EmptyException(caller.getCanonicalName() + "::" + where + " string is empty");
        }
    }


    /**
     * Util method to verify if the given collection is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final Collection toCheck, final Object caller, final String where) {
        required(toCheck, caller.getClass(), where);
    }

    /**
     * Util method to verify if the given collection is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final Collection toCheck, final Class caller, final String where) {
        if (isEmpty(toCheck)) {
            throw new EmptyException(caller.getCanonicalName() + "::" + where + " string is empty");
        }
    }

    /**
     * Util method to verify if the given map is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final Map toCheck, final Object caller, final String where) {
        required(toCheck, caller.getClass(), where);
    }

    /**
     * Util method to verify if the given map is empty or not
     *
     * @param toCheck the map to check
     * @param caller  the caller
     * @param where   the method where this was called
     */
    public static void required(final Map toCheck, final Class caller, final String where) {
        if (isEmpty(toCheck)) {
            throw new EmptyException(caller.getCanonicalName() + "::" + where + " string is empty");
        }
    }


    /**
     * Checks if the given string is empty or not
     *
     * @param toCheck To check string
     * @return true if the string is empty, false if not
     */
    private static boolean isEmpty(final String toCheck) {
        return StringUtils.isEmpty(toCheck);
    }

    /**
     * Checks if the given collection is empty or not
     *
     * @param toCheck To check collection
     * @return true if the collection is empty, false if not
     */
    private static boolean isEmpty(final Collection toCheck) {
        return toCheck.isEmpty();
    }

    /**
     * Checks if the given object is empty or not
     *
     * @param toCheck To check object
     * @return true if the object is empty, false if not
     */
    private static boolean isEmpty(final Map toCheck) {
        return toCheck.isEmpty();
    }

}
