package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.C0257n;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ay implements C0230r {
    public final int f4194a;
    public final C0257n f4195b;
    public final C0230r f4196c;
    final /* synthetic */ ax f4197d;

    public ay(ax axVar, int i, C0257n c0257n, C0230r c0230r) {
        this.f4197d = axVar;
        this.f4194a = i;
        this.f4195b = c0257n;
        this.f4196c = c0230r;
        c0257n.m7555a((C0230r) this);
    }

    public void m7404a() {
        this.f4195b.m7560b((C0230r) this);
        this.f4195b.m7565g();
    }

    public void m7405a(ConnectionResult connectionResult) {
        this.f4197d.f4152f.post(new az(this.f4197d, this.f4194a, connectionResult));
    }

    public void m7406a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("GoogleApiClient #").print(this.f4194a);
        printWriter.println(":");
        this.f4195b.m7556a(str + "  ", fileDescriptor, printWriter, strArr);
    }
}
