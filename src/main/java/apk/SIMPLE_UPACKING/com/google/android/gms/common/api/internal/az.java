package com.google.android.gms.common.api.internal;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;

class az implements Runnable {
    final /* synthetic */ ax f4198a;
    private final int f4199b;
    private final ConnectionResult f4200c;

    public az(ax axVar, int i, ConnectionResult connectionResult) {
        this.f4198a = axVar;
        this.f4199b = i;
        this.f4200c = connectionResult;
    }

    public void run() {
        if (this.f4198a.f4148b && !this.f4198a.f4149c) {
            this.f4198a.f4149c = true;
            this.f4198a.f4150d = this.f4199b;
            this.f4198a.f4151e = this.f4200c;
            if (this.f4200c.m7279a()) {
                try {
                    this.f4200c.m7278a(this.f4198a.m1173g(), ((this.f4198a.m1173g().m1226f().m816d().indexOf(this.f4198a) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    this.f4198a.m7319L();
                }
            } else if (this.f4198a.m7318K().m7640a(this.f4200c.m7281c())) {
                this.f4198a.m7322a(this.f4199b, this.f4200c);
            } else if (this.f4200c.m7281c() == 18) {
                this.f4198a.m7326b(this.f4199b, this.f4200c);
            } else {
                this.f4198a.m7317c(this.f4199b, this.f4200c);
            }
        }
    }
}
