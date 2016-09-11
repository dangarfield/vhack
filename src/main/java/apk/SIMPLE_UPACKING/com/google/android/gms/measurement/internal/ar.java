package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import java.util.Iterator;

public class ar {
    final String f4680a;
    final String f4681b;
    final String f4682c;
    final long f4683d;
    final long f4684e;
    final EventParams f4685f;

    ar(bx bxVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        bf.m7875a(str2);
        bf.m7875a(str3);
        this.f4680a = str2;
        this.f4681b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f4682c = str;
        this.f4683d = j;
        this.f4684e = j2;
        if (this.f4684e != 0 && this.f4684e > this.f4683d) {
            bxVar.m8767f().m8583c().m8607a("Event created with reverse previous/current timestamps");
        }
        this.f4685f = m8470a(bxVar, bundle);
    }

    private ar(bx bxVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        bf.m7875a(str2);
        bf.m7875a(str3);
        bf.m7873a((Object) eventParams);
        this.f4680a = str2;
        this.f4681b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f4682c = str;
        this.f4683d = j;
        this.f4684e = j2;
        if (this.f4684e != 0 && this.f4684e > this.f4683d) {
            bxVar.m8767f().m8583c().m8607a("Event created with reverse previous/current timestamps");
        }
        this.f4685f = eventParams;
    }

    private EventParams m8470a(bx bxVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                it.remove();
            } else {
                Object a = bxVar.m8775n().m8275a(str, bundle2.get(str));
                if (a == null) {
                    it.remove();
                } else {
                    bxVar.m8775n().m8276a(bundle2, str, a);
                }
            }
        }
        return new EventParams(bundle2);
    }

    ar m8471a(bx bxVar, long j) {
        return new ar(bxVar, this.f4682c, this.f4680a, this.f4681b, this.f4683d, j, this.f4685f);
    }

    public String toString() {
        return "Event{appId='" + this.f4680a + '\'' + ", name='" + this.f4681b + '\'' + ", params=" + this.f4685f + '}';
    }
}
