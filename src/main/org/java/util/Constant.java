package org.java.util;

public interface Constant {
    static final int MINIMAL_WEIGHT = 1;
    static final int PRODUCT_MAXIMAL_WEIGHT = 9;
    static final int BOX_MAXIMAL_WEIGHT = 10;
    static final String EXCEPTION_MESSAGE_BASE = "Weight is too ";
    static final String EXCEPTION_MESSAGE_UNIT = " unit).";
    static final String EXCEPTION_MESSAGE_HEAVY = EXCEPTION_MESSAGE_BASE + "heavy (";
    static final String EXCEPTION_MESSAGE_LIGHT = EXCEPTION_MESSAGE_BASE + "light (";
}
