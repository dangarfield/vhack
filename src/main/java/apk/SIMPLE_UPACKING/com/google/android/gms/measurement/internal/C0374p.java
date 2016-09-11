package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0229q;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.internal.C0301t;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.C0316b;

/* renamed from: com.google.android.gms.measurement.internal.p */
public class C0374p implements ServiceConnection, C0229q, C0230r {
    final /* synthetic */ C0367i f4936a;
    private volatile boolean f4937b;
    private volatile bb f4938c;

    protected C0374p(C0367i c0367i) {
        this.f4936a = c0367i;
    }

    public void m8905a() {
        this.f4936a.m8884f();
        Context m = this.f4936a.m8891m();
        synchronized (this) {
            if (this.f4937b) {
                this.f4936a.m8897s().m8606z().m8607a("Connection attempt already in progress");
            } else if (this.f4938c != null) {
                this.f4936a.m8897s().m8606z().m8607a("Already awaiting connection attempt");
            } else {
                this.f4938c = new bb(m, Looper.getMainLooper(), C0301t.m7969a(m), this, this);
                this.f4936a.m8897s().m8606z().m8607a("Connecting to remote service");
                this.f4937b = true;
                this.f4938c.m5762l();
            }
        }
    }

    public void m8906a(int i) {
        bf.m7880b("MeasurementServiceConnection.onConnectionSuspended");
        this.f4936a.m8897s().m8605y().m8607a("Service connection suspended");
        this.f4936a.m8896r().m8709a(new C0378t(this));
    }

    public void m8907a(Intent intent) {
        this.f4936a.m8884f();
        Context m = this.f4936a.m8891m();
        C0316b a = C0316b.m8032a();
        synchronized (this) {
            if (this.f4937b) {
                this.f4936a.m8897s().m8606z().m8607a("Connection attempt already in progress");
                return;
            }
            this.f4937b = true;
            a.m8043a(m, intent, this.f4936a.f4920a, 129);
        }
    }

    public void m8908a(Bundle bundle) {
        bf.m7880b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                ax axVar = (ax) this.f4938c.m5768r();
                this.f4938c = null;
                this.f4936a.m8896r().m8709a(new C0377s(this, axVar));
            } catch (DeadObjectException e) {
                this.f4938c = null;
                this.f4937b = false;
            } catch (IllegalStateException e2) {
                this.f4938c = null;
                this.f4937b = false;
            }
        }
    }

    public void m8909a(ConnectionResult connectionResult) {
        bf.m7880b("MeasurementServiceConnection.onConnectionFailed");
        bc g = this.f4936a.n.m8768g();
        if (g != null) {
            g.m8583c().m8608a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f4937b = false;
            this.f4938c = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        bf.m7880b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f4937b = false;
                this.f4936a.m8897s().m8582b().m8607a("Service connected with null binder");
                return;
            }
            ax axVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    axVar = ay.m8497a(iBinder);
                    this.f4936a.m8897s().m8606z().m8607a("Bound to IMeasurementService interface");
                } else {
                    this.f4936a.m8897s().m8582b().m8608a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException e) {
                this.f4936a.m8897s().m8582b().m8607a("Service connect failed to get IMeasurementService");
            }
            if (axVar == null) {
                this.f4937b = false;
                try {
                    C0316b.m8032a().m8041a(this.f4936a.m8891m(), this.f4936a.f4920a);
                } catch (IllegalArgumentException e2) {
                }
            } else {
                this.f4936a.m8896r().m8709a(new C0375q(this, axVar));
            }
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        bf.m7880b("MeasurementServiceConnection.onServiceDisconnected");
        this.f4936a.m8897s().m8605y().m8607a("Service disconnected");
        this.f4936a.m8896r().m8709a(new C0376r(this, componentName));
    }
}
