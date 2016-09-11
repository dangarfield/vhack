package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

final class al {
    private final String f4400a;
    private final ComponentName f4401b;

    public al(String str) {
        this.f4400a = bf.m7875a(str);
        this.f4401b = null;
    }

    public Intent m7747a() {
        return this.f4400a != null ? new Intent(this.f4400a).setPackage("com.google.android.gms") : new Intent().setComponent(this.f4401b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al)) {
            return false;
        }
        al alVar = (al) obj;
        return bc.m7871a(this.f4400a, alVar.f4400a) && bc.m7871a(this.f4401b, alVar.f4401b);
    }

    public int hashCode() {
        return bc.m7869a(this.f4400a, this.f4401b);
    }

    public String toString() {
        return this.f4400a == null ? this.f4401b.flattenToString() : this.f4400a;
    }
}
