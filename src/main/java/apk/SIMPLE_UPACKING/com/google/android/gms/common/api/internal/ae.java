package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.common.api.C0224w;
import com.google.android.gms.common.api.C0231x;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.api.Status;

class ae implements C0231x {
    final /* synthetic */ aw f4164a;
    final /* synthetic */ boolean f4165b;
    final /* synthetic */ C0257n f4166c;
    final /* synthetic */ C0258z f4167d;

    ae(C0258z c0258z, aw awVar, boolean z, C0257n c0257n) {
        this.f4167d = c0258z;
        this.f4164a = awVar;
        this.f4165b = z;
        this.f4166c = c0257n;
    }

    public void m7349a(Status status) {
        ac.m5929a(this.f4167d.f4288n).m5943d();
        if (status.m7292e() && this.f4167d.m7602k()) {
            this.f4167d.m7601j();
        }
        this.f4164a.m5976a((C0224w) status);
        if (this.f4165b) {
            this.f4166c.m7565g();
        }
    }

    public /* synthetic */ void m7350a(C0224w c0224w) {
        m7349a((Status) c0224w);
    }
}
