package com.fyber.utils;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: SignatureTools */
public final class ac {
    public static String m5233a(Map map, String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(map.keySet());
        Iterator it = treeSet.iterator();
        String str2 = "";
        while (it.hasNext()) {
            String str3 = (String) map.get((String) it.next());
            str2 = str2 + String.format("%s=%s&", new Object[]{r0, str3});
        }
        return m5232a(str2, str);
    }

    public static String m5232a(String str, String str2) {
        return m5231a(str + str2);
    }

    public static String m5231a(String str) {
        String str2 = "nosha1";
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(str.getBytes());
            Formatter formatter = new Formatter();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                formatter.format("%02x", new Object[]{Byte.valueOf(digest[i])});
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Exception e) {
            FyberLogger.m5221a("UrlBuilder", "SHA1 algorithm not available.", e);
            return str2;
        }
    }
}
