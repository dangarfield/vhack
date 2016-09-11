package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@fi
/* renamed from: com.google.android.gms.b.v */
public class C0218v {
    private final int f4114a;
    private final int f4115b;
    private final int f4116c;
    private final C0195u f4117d;

    public C0218v(int i) {
        this.f4117d = new aa();
        this.f4115b = i;
        this.f4114a = 6;
        this.f4116c = 0;
    }

    private String m7265b(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C0221y a = m7266a();
        Arrays.sort(split, new C0219w(this));
        int i = 0;
        while (i < split.length && i < this.f4115b) {
            if (split[i].trim().length() != 0) {
                try {
                    a.m7271a(this.f4117d.m6067a(split[i]));
                } catch (Throwable e) {
                    C0099b.m5640b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return a.toString();
    }

    C0221y m7266a() {
        return new C0221y();
    }

    String m7267a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C0221y a = m7266a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f4115b, new C0220x(this));
        for (String b : split) {
            String[] b2 = C0222z.m7276b(b);
            if (b2.length != 0) {
                ab.m6075a(b2, this.f4115b, this.f4114a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.m7271a(this.f4117d.m6067a(((ac) it.next()).f3385b));
            } catch (Throwable e) {
                C0099b.m5640b("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String m7268a(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.f4116c) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                return m7267a(stringBuffer.toString());
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return m7265b(stringBuffer.toString());
            default:
                return "";
        }
    }
}
