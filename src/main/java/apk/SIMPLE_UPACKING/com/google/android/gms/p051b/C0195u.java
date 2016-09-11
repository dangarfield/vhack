package com.google.android.gms.p051b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.b.u */
public abstract class C0195u {
    private static MessageDigest f3381b;
    protected Object f3382a;

    static {
        f3381b = null;
    }

    public C0195u() {
        this.f3382a = new Object();
    }

    protected MessageDigest m6066a() {
        MessageDigest messageDigest;
        synchronized (this.f3382a) {
            if (f3381b != null) {
                messageDigest = f3381b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f3381b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f3381b;
            }
        }
        return messageDigest;
    }

    abstract byte[] m6067a(String str);
}
