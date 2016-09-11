package org.vhack.dev.vhack.p053a;

/* renamed from: org.vhack.dev.vhack.a.n */
public class IabResult {
    int f5242a;
    String f5243b;

    public IabResult(int i, String str) {
        this.f5242a = i;
        if (str == null || str.trim().length() == 0) {
            this.f5243b = IabHelper.m9038a(i);
        } else {
            this.f5243b = str + " (response: " + IabHelper.m9038a(i) + ")";
        }
    }

    public String m9060a() {
        return this.f5243b;
    }

    public boolean m9061b() {
        return this.f5242a == 0;
    }

    public boolean m9062c() {
        return !m9061b();
    }

    public String toString() {
        return "IabResult: " + m9060a();
    }
}
