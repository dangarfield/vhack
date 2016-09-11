package com.fyber.utils;

/* renamed from: com.fyber.utils.d */
public class StringUtils {
    public static final boolean m5259a(String str) {
        return str == null || str.trim().equals("");
    }

    public static final boolean m5260b(String str) {
        return !StringUtils.m5259a(str);
    }

    public static String m5261c(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }
}
