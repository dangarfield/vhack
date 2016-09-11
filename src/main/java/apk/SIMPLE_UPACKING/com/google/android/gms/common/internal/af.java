package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class af extends C0279z {
    public final IBinder f4381e;
    final /* synthetic */ C0122y f4382f;

    public af(C0122y c0122y, int i, IBinder iBinder, Bundle bundle) {
        this.f4382f = c0122y;
        super(c0122y, i, bundle);
        this.f4381e = iBinder;
    }

    protected void m7725a(ConnectionResult connectionResult) {
        if (this.f4382f.f3207y != null) {
            this.f4382f.f3207y.m7346a(connectionResult);
        }
        this.f4382f.m5748a(connectionResult);
    }

    protected boolean m7726a() {
        try {
            String interfaceDescriptor = this.f4381e.getInterfaceDescriptor();
            if (this.f4382f.m5753b().equals(interfaceDescriptor)) {
                IInterface b = this.f4382f.m5752b(this.f4381e);
                if (b == null || !this.f4382f.m5730a(2, 3, b)) {
                    return false;
                }
                Bundle b_ = this.f4382f.b_();
                if (this.f4382f.f3206x != null) {
                    this.f4382f.f3206x.m7343a(b_);
                }
                return true;
            }
            Log.e("GmsClient", "service descriptor mismatch: " + this.f4382f.m5753b() + " vs. " + interfaceDescriptor);
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
