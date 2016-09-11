package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.auth.api.credentials.d */
public class C0114d {
    private final TreeSet f3172a;
    private final List f3173b;
    private final List f3174c;
    private int f3175d;
    private int f3176e;

    public C0114d() {
        this.f3172a = new TreeSet();
        this.f3173b = new ArrayList();
        this.f3174c = new ArrayList();
        this.f3175d = 12;
        this.f3176e = 16;
    }

    private TreeSet m5695a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new C0115e(str2 + " cannot be null or empty");
        }
        TreeSet treeSet = new TreeSet();
        for (char c : str.toCharArray()) {
            if (PasswordSpecification.m5690b(c, 32, 126)) {
                throw new C0115e(str2 + " must only contain ASCII printable characters");
            }
            treeSet.add(Character.valueOf(c));
        }
        return treeSet;
    }

    private void m5696b() {
        int i = 0;
        for (Integer intValue : this.f3174c) {
            i = intValue.intValue() + i;
        }
        if (i > this.f3176e) {
            throw new C0115e("required character count cannot be greater than the max password size");
        }
    }

    private void m5697c() {
        boolean[] zArr = new boolean[95];
        for (String toCharArray : this.f3173b) {
            for (char c : toCharArray.toCharArray()) {
                if (zArr[c - 32]) {
                    throw new C0115e("character " + c + " occurs in more than one required character set");
                }
                zArr[c - 32] = true;
            }
        }
    }

    public PasswordSpecification m5698a() {
        if (this.f3172a.isEmpty()) {
            throw new C0115e("no allowed characters specified");
        }
        m5696b();
        m5697c();
        return new PasswordSpecification(1, PasswordSpecification.m5689b(this.f3172a), this.f3173b, this.f3174c, this.f3175d, this.f3176e);
    }

    public C0114d m5699a(int i, int i2) {
        if (i < 1) {
            throw new C0115e("minimumSize must be at least 1");
        } else if (i > i2) {
            throw new C0115e("maximumSize must be greater than or equal to minimumSize");
        } else {
            this.f3175d = i;
            this.f3176e = i2;
            return this;
        }
    }

    public C0114d m5700a(String str) {
        this.f3172a.addAll(m5695a(str, "allowedChars"));
        return this;
    }

    public C0114d m5701a(String str, int i) {
        if (i < 1) {
            throw new C0115e("count must be at least 1");
        }
        this.f3173b.add(PasswordSpecification.m5689b(m5695a(str, "requiredChars")));
        this.f3174c.add(Integer.valueOf(i));
        return this;
    }
}
