package org.vhack.dev.vhack.a;

/* compiled from: IabResult */
public class n {
    int a;
    String b;

    public n(int i, String str) {
        this.a = i;
        if (str == null || str.trim().length() == 0) {
            this.b = d.a(i);
        } else {
            this.b = str + " (response: " + d.a(i) + ")";
        }
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return this.a == 0;
    }

    public boolean c() {
        return !b();
    }

    public String toString() {
        return "IabResult: " + a();
    }
}
