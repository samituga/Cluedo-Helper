package com.sam.cluedo.logger;

import com.sam.cluedo.base.NotEmpty;
import com.sam.cluedo.base.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Util class to help construct the message to be used in the logs
 */
public class LoggerMessageFormatter {

    /**
     * Formats a message with the given params
     *
     * @param reasonsOfFailure The reasons of failures
     * @param caller           The caller
     * @param where            The method where this is being called
     * @return the message
     */
    public static String message(final HashMap<String, String> reasonsOfFailure, final Object caller, final String where) {
        return message(reasonsOfFailure, caller.getClass(), where);
    }

    /**
     * Formats a message with the given params
     *
     * @param reasonsOfFailure The reasons of failures
     * @param caller           The caller
     * @param where            The method where this is being called
     * @return the message
     */
    public static <T> String message(final HashMap<String, String> reasonsOfFailure, final Class<T> caller, final String where) {
        NotNull.required(reasonsOfFailure, caller, "ctor");
        NotEmpty.required(reasonsOfFailure, caller, "ctor");

        StringBuilder message = new StringBuilder();
        message.append(message(caller, where)).append(" ->\n");
        for (Map.Entry<String, String> entry : reasonsOfFailure.entrySet()) {
            message.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }

        return message.toString();
    }

    /**
     * Formats a message with the given params
     *
     * @param caller The caller
     * @param where  The method where this is being called
     * @return the message
     */
    public static String message(final Object caller, final String where) {
        return message(caller.getClass(), where);
    }

    /**
     * Formats a message with the given params
     *
     * @param caller The caller
     * @param where  The method where this is being called
     * @return the message
     */
    public static <T> String message(final Class<T> caller, final String where) {
        return message(caller, where, null);
    }

    /**
     * Formats a message with the given params
     *
     * @param caller The caller
     * @param where  The method where this is being called
     * @return the message
     */
    public static <T> String message(final Object caller, final String where, final String message) {
        return message(caller.getClass(), where, message);
    }

    /**
     * Formats a message with the given params
     *
     * @param caller The caller
     * @param where  The method where this is being called
     * @return the message
     */
    public static <T> String message(final Class<T> caller, final String where, final String message) {
        return caller.getCanonicalName() + "::" + where + (message != null ? " - " + message : "");
    }
}
