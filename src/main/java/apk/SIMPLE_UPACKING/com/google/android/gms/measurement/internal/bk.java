package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.bf;

class bk extends BroadcastReceiver {
    static final String f4779a;
    private final bx f4780b;
    private boolean f4781c;
    private boolean f4782d;

    static {
        f4779a = bk.class.getName();
    }

    bk(bx bxVar) {
        bf.m7873a((Object) bxVar);
        this.f4780b = bxVar;
    }

    private Context m8638d() {
        return this.f4780b.m8778q();
    }

    private bc m8639e() {
        return this.f4780b.m8767f();
    }

    public void m8640a() {
        this.f4780b.m8751a();
        this.f4780b.m8786y();
        if (!this.f4781c) {
            m8638d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4782d = this.f4780b.m8777p().m8617b();
            m8639e().m8606z().m8608a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4782d));
            this.f4781c = true;
        }
    }

    public void m8641b() {
        this.f4780b.m8751a();
        this.f4780b.m8786y();
        if (m8642c()) {
            m8639e().m8606z().m8607a("Unregistering connectivity change receiver");
            this.f4781c = false;
            this.f4782d = false;
            try {
                m8638d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m8639e().m8582b().m8608a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean m8642c() {
        this.f4780b.m8786y();
        return this.f4781c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f4780b.m8751a();
        String action = intent.getAction();
        m8639e().m8606z().m8608a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean b = this.f4780b.m8777p().m8617b();
            if (this.f4782d != b) {
                this.f4782d = b;
                this.f4780b.m8769h().m8709a(new bl(this, b));
                return;
            }
            return;
        }
        m8639e().m8583c().m8608a("NetworkBroadcastReceiver received unknown action", action);
    }
}
