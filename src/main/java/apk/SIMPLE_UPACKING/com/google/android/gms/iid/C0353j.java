package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.p007b.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.google.android.gms.iid.j */
public class C0353j {
    SharedPreferences f4599a;
    Context f4600b;

    public C0353j(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C0353j(Context context, String str) {
        this.f4600b = context;
        this.f4599a = context.getSharedPreferences(str, 4);
        m8164g(str + "-no-backup");
    }

    private String m8163b(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    private void m8164g(String str) {
        File file = new File(new ContextCompat().m744a(this.f4600b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m8171a()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    C0345b.m8134a(this.f4600b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }

    synchronized String m8165a(String str) {
        return this.f4599a.getString(str, null);
    }

    synchronized String m8166a(String str, String str2) {
        return this.f4599a.getString(str + "|S|" + str2, null);
    }

    public synchronized String m8167a(String str, String str2, String str3) {
        return this.f4599a.getString(m8163b(str, str2, str3), null);
    }

    synchronized KeyPair m8168a(String str, long j) {
        KeyPair a;
        a = C0347d.m8142a();
        Editor edit = this.f4599a.edit();
        m8169a(edit, str, "|P|", C0344a.m8124a(a.getPublic().getEncoded()));
        m8169a(edit, str, "|K|", C0344a.m8124a(a.getPrivate().getEncoded()));
        m8169a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    synchronized void m8169a(Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void m8170a(String str, String str2, String str3, String str4, String str5) {
        String b = m8163b(str, str2, str3);
        Editor edit = this.f4599a.edit();
        edit.putString(b, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    boolean m8171a() {
        return this.f4599a.getAll().isEmpty();
    }

    public synchronized void m8172b() {
        this.f4599a.edit().clear().commit();
    }

    public synchronized void m8173b(String str) {
        Editor edit = this.f4599a.edit();
        for (String str2 : this.f4599a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair m8174c(String str) {
        return m8177f(str);
    }

    void m8175d(String str) {
        m8173b(str + "|");
    }

    public void m8176e(String str) {
        m8173b(str + "|T|");
    }

    KeyPair m8177f(String str) {
        Object e;
        String a = m8166a(str, "|P|");
        String a2 = m8166a(str, "|K|");
        if (a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            C0345b.m8134a(this.f4600b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            C0345b.m8134a(this.f4600b, this);
            return null;
        }
    }
}
