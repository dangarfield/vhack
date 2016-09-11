package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.C0273r;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class cc extends ay {
    private final bx f4881a;
    private final boolean f4882b;

    public cc(bx bxVar) {
        bf.m7873a((Object) bxVar);
        this.f4881a = bxVar;
        this.f4882b = false;
    }

    public cc(bx bxVar, boolean z) {
        bf.m7873a((Object) bxVar);
        this.f4881a = bxVar;
        this.f4882b = z;
    }

    private void m8814b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4881a.m8767f().m8582b().m8607a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m8815c(str);
        } catch (SecurityException e) {
            this.f4881a.m8767f().m8582b().m8608a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void m8815c(String str) {
        int myUid = this.f4882b ? Process.myUid() : Binder.getCallingUid();
        if (!C0273r.m7654a(this.f4881a.m8778q(), myUid, str)) {
            if (!C0273r.m7660b(this.f4881a.m8778q(), myUid) || this.f4881a.m8787z()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public List m8816a(AppMetadata appMetadata, boolean z) {
        Object e;
        bf.m7873a((Object) appMetadata);
        m8814b(appMetadata.f4618b);
        try {
            List<af> list = (List) this.f4881a.m8769h().m8707a(new ci(this, appMetadata)).get();
            List arrayList = new ArrayList(list.size());
            for (af afVar : list) {
                if (z || !ag.m8273g(afVar.f4660b)) {
                    arrayList.add(new UserAttributeParcel(afVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f4881a.m8767f().m8582b().m8608a("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f4881a.m8767f().m8582b().m8608a("Failed to get user attributes", e);
            return null;
        }
    }

    public void m8817a(AppMetadata appMetadata) {
        bf.m7873a((Object) appMetadata);
        m8814b(appMetadata.f4618b);
        this.f4881a.m8769h().m8709a(new cj(this, appMetadata));
    }

    public void m8818a(EventParcel eventParcel, AppMetadata appMetadata) {
        bf.m7873a((Object) eventParcel);
        bf.m7873a((Object) appMetadata);
        m8814b(appMetadata.f4618b);
        this.f4881a.m8769h().m8709a(new ce(this, appMetadata, eventParcel));
    }

    public void m8819a(EventParcel eventParcel, String str, String str2) {
        bf.m7873a((Object) eventParcel);
        bf.m7875a(str);
        m8814b(str);
        this.f4881a.m8769h().m8709a(new cf(this, str2, eventParcel, str));
    }

    public void m8820a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        bf.m7873a((Object) userAttributeParcel);
        bf.m7873a((Object) appMetadata);
        m8814b(appMetadata.f4618b);
        if (userAttributeParcel.m8198a() == null) {
            this.f4881a.m8769h().m8709a(new cg(this, appMetadata, userAttributeParcel));
        } else {
            this.f4881a.m8769h().m8709a(new ch(this, appMetadata, userAttributeParcel));
        }
    }

    void m8821a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f4881a.m8766e().f4795b.m8670a(split[1], longValue);
                    } else {
                        this.f4881a.m8767f().m8583c().m8608a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f4881a.m8767f().m8583c().m8608a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public void m8822b(AppMetadata appMetadata) {
        bf.m7873a((Object) appMetadata);
        m8814b(appMetadata.f4618b);
        this.f4881a.m8769h().m8709a(new cd(this, appMetadata));
    }
}
