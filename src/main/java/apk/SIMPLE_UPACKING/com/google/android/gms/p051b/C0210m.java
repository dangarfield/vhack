package com.google.android.gms.p051b;

import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.ArrayList;
import java.util.Iterator;

@fi
/* renamed from: com.google.android.gms.b.m */
public class C0210m {
    private final int f3994a;
    private final int f3995b;
    private final int f3996c;
    private final C0218v f3997d;
    private final Object f3998e;
    private ArrayList f3999f;
    private ArrayList f4000g;
    private int f4001h;
    private int f4002i;
    private int f4003j;
    private int f4004k;
    private String f4005l;
    private String f4006m;

    public C0210m(int i, int i2, int i3, int i4) {
        this.f3998e = new Object();
        this.f3999f = new ArrayList();
        this.f4000g = new ArrayList();
        this.f4001h = 0;
        this.f4002i = 0;
        this.f4003j = 0;
        this.f4005l = "";
        this.f4006m = "";
        this.f3994a = i;
        this.f3995b = i2;
        this.f3996c = i3;
        this.f3997d = new C0218v(i4);
    }

    private String m7068a(ArrayList arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m7069c(String str, boolean z) {
        if (str != null && str.length() >= this.f3996c) {
            synchronized (this.f3998e) {
                this.f3999f.add(str);
                this.f4001h += str.length();
                if (z) {
                    this.f4000g.add(str);
                }
            }
        }
    }

    int m7070a(int i, int i2) {
        return (this.f3994a * i) + (this.f3995b * i2);
    }

    public void m7071a(int i) {
        this.f4002i = i;
    }

    public void m7072a(String str, boolean z) {
        m7069c(str, z);
        synchronized (this.f3998e) {
            if (this.f4003j < 0) {
                C0099b.m5636a("ActivityContent: negative number of WebViews.");
            }
            m7078e();
        }
    }

    public boolean m7073a() {
        boolean z;
        synchronized (this.f3998e) {
            z = this.f4003j == 0;
        }
        return z;
    }

    public String m7074b() {
        return this.f4005l;
    }

    public void m7075b(String str, boolean z) {
        m7069c(str, z);
    }

    public void m7076c() {
        synchronized (this.f3998e) {
            this.f4003j--;
        }
    }

    public void m7077d() {
        synchronized (this.f3998e) {
            this.f4003j++;
        }
    }

    public void m7078e() {
        synchronized (this.f3998e) {
            int a = m7070a(this.f4001h, this.f4002i);
            if (a > this.f4004k) {
                this.f4004k = a;
                this.f4005l = this.f3997d.m7268a(this.f3999f);
                this.f4006m = this.f3997d.m7268a(this.f4000g);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0210m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0210m c0210m = (C0210m) obj;
        return c0210m.m7074b() != null && c0210m.m7074b().equals(m7074b());
    }

    int m7079f() {
        return this.f4001h;
    }

    public int hashCode() {
        return m7074b().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.f4002i + " score:" + this.f4004k + " total_length:" + this.f4001h + "\n text: " + m7068a(this.f3999f, 100) + "\n viewableText" + m7068a(this.f4000g, 100) + "\n signture: " + this.f4005l + "\n viewableSignture: " + this.f4006m;
    }
}
