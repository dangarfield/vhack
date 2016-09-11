package com.google.android.gms.p051b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C0284f;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.b.md */
public class md {
    private static String f4020a;
    private static String f4021b;
    private static boolean f4022c;
    private final WakeLock f4023d;
    private WorkSource f4024e;
    private final int f4025f;
    private final String f4026g;
    private final String f4027h;
    private final Context f4028i;
    private boolean f4029j;
    private int f4030k;
    private int f4031l;

    static {
        f4020a = "WakeLock";
        f4021b = "*gcore*:";
        f4022c = false;
    }

    public md(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public md(Context context, int i, String str, String str2, String str3) {
        this.f4029j = true;
        bf.m7876a(str, (Object) "Wake lock name can NOT be empty");
        this.f4025f = i;
        this.f4027h = str2;
        this.f4028i = context.getApplicationContext();
        if (kp.m6946a(str3) || "com.google.android.gms" == str3) {
            this.f4026g = str;
        } else {
            this.f4026g = f4021b + str;
        }
        this.f4023d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (kq.m6953a(this.f4028i)) {
            if (kp.m6946a(str3)) {
                if (C0284f.f4420a && je.m6867b()) {
                    Log.e(f4020a, "callingPackage is not supposed to be empty for wakelock " + this.f4026g + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                } else {
                    str3 = context.getPackageName();
                }
            }
            this.f4024e = kq.m6949a(context, str3);
            m7093a(this.f4024e);
        }
    }

    private String m7087a(String str, boolean z) {
        return this.f4029j ? z ? str : this.f4027h : this.f4027h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7088a(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.m7090b(r9);
        r5 = r8.m7087a(r9, r0);
        r1 = f4022c;
        if (r1 == 0) goto L_0x0068;
    L_0x000c:
        r1 = f4020a;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Release:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r8.f4026g;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r8.f4027h;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r8.f4029j;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r3 = "\n mOpenEventCount";
        r2 = r2.append(r3);
        r3 = r8.f4031l;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0068:
        monitor-enter(r8);
        r1 = r8.f4029j;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0077;
    L_0x006d:
        r1 = r8.f4030k;	 Catch:{ all -> 0x00a3 }
        r1 = r1 + -1;
        r8.f4030k = r1;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0080;
    L_0x0075:
        if (r0 != 0) goto L_0x0080;
    L_0x0077:
        r0 = r8.f4029j;	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x00a1;
    L_0x007b:
        r0 = r8.f4031l;	 Catch:{ all -> 0x00a3 }
        r1 = 1;
        if (r0 != r1) goto L_0x00a1;
    L_0x0080:
        r0 = com.google.android.gms.common.stats.C0324k.m8053a();	 Catch:{ all -> 0x00a3 }
        r1 = r8.f4028i;	 Catch:{ all -> 0x00a3 }
        r2 = r8.f4023d;	 Catch:{ all -> 0x00a3 }
        r2 = com.google.android.gms.common.stats.C0322i.m8049a(r2, r5);	 Catch:{ all -> 0x00a3 }
        r3 = 8;
        r4 = r8.f4026g;	 Catch:{ all -> 0x00a3 }
        r6 = r8.f4025f;	 Catch:{ all -> 0x00a3 }
        r7 = r8.f4024e;	 Catch:{ all -> 0x00a3 }
        r7 = com.google.android.gms.p051b.kq.m6955b(r7);	 Catch:{ all -> 0x00a3 }
        r0.m8056a(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00a3 }
        r0 = r8.f4031l;	 Catch:{ all -> 0x00a3 }
        r0 = r0 + -1;
        r8.f4031l = r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a1:
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        return;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.md.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7089a(java.lang.String r11, long r12) {
        /*
        r10 = this;
        r0 = r10.m7090b(r11);
        r5 = r10.m7087a(r11, r0);
        r1 = f4022c;
        if (r1 == 0) goto L_0x0072;
    L_0x000c:
        r1 = f4020a;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Acquire:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r10.f4026g;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r10.f4027h;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r10.f4029j;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r3 = "\nmOpenEventCount";
        r2 = r2.append(r3);
        r3 = r10.f4031l;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r3 = "\ntimeout: ";
        r2 = r2.append(r3);
        r2 = r2.append(r12);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0072:
        monitor-enter(r10);
        r1 = r10.f4029j;	 Catch:{ all -> 0x00ac }
        if (r1 == 0) goto L_0x0081;
    L_0x0077:
        r1 = r10.f4030k;	 Catch:{ all -> 0x00ac }
        r2 = r1 + 1;
        r10.f4030k = r2;	 Catch:{ all -> 0x00ac }
        if (r1 == 0) goto L_0x0089;
    L_0x007f:
        if (r0 != 0) goto L_0x0089;
    L_0x0081:
        r0 = r10.f4029j;	 Catch:{ all -> 0x00ac }
        if (r0 != 0) goto L_0x00aa;
    L_0x0085:
        r0 = r10.f4031l;	 Catch:{ all -> 0x00ac }
        if (r0 != 0) goto L_0x00aa;
    L_0x0089:
        r0 = com.google.android.gms.common.stats.C0324k.m8053a();	 Catch:{ all -> 0x00ac }
        r1 = r10.f4028i;	 Catch:{ all -> 0x00ac }
        r2 = r10.f4023d;	 Catch:{ all -> 0x00ac }
        r2 = com.google.android.gms.common.stats.C0322i.m8049a(r2, r5);	 Catch:{ all -> 0x00ac }
        r3 = 7;
        r4 = r10.f4026g;	 Catch:{ all -> 0x00ac }
        r6 = r10.f4025f;	 Catch:{ all -> 0x00ac }
        r7 = r10.f4024e;	 Catch:{ all -> 0x00ac }
        r7 = com.google.android.gms.p051b.kq.m6955b(r7);	 Catch:{ all -> 0x00ac }
        r8 = r12;
        r0.m8057a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x00ac }
        r0 = r10.f4031l;	 Catch:{ all -> 0x00ac }
        r0 = r0 + 1;
        r10.f4031l = r0;	 Catch:{ all -> 0x00ac }
    L_0x00aa:
        monitor-exit(r10);	 Catch:{ all -> 0x00ac }
        return;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00ac }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.md.a(java.lang.String, long):void");
    }

    private boolean m7090b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.f4027h)) ? false : true;
    }

    public void m7091a() {
        m7088a(null);
        this.f4023d.release();
    }

    public void m7092a(long j) {
        if (!kn.m6935c() && this.f4029j) {
            Log.wtf(f4020a, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.f4026g);
        }
        m7089a(null, j);
        this.f4023d.acquire(j);
    }

    public void m7093a(WorkSource workSource) {
        if (kq.m6953a(this.f4028i) && workSource != null) {
            if (this.f4024e != null) {
                this.f4024e.add(workSource);
            } else {
                this.f4024e = workSource;
            }
            this.f4023d.setWorkSource(this.f4024e);
        }
    }

    public void m7094a(boolean z) {
        this.f4023d.setReferenceCounted(z);
        this.f4029j = z;
    }

    public boolean m7095b() {
        return this.f4023d.isHeld();
    }
}
