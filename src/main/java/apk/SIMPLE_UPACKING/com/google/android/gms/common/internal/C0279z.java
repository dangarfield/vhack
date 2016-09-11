package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.z */
abstract class C0279z extends ab {
    public final int f4378a;
    public final Bundle f4379b;
    final /* synthetic */ C0122y f4380c;

    protected C0279z(C0122y c0122y, int i, Bundle bundle) {
        this.f4380c = c0122y;
        super(c0122y, Boolean.valueOf(true));
        this.f4378a = i;
        this.f4379b = bundle;
    }

    protected abstract void m7720a(ConnectionResult connectionResult);

    protected void m7721a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f4380c.m5734b(1, null);
            return;
        }
        switch (this.f4378a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (!m7723a()) {
                    this.f4380c.m5734b(1, null);
                    m7720a(new ConnectionResult(8, null));
                }
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                this.f4380c.m5734b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f4380c.m5734b(1, null);
                if (this.f4379b != null) {
                    pendingIntent = (PendingIntent) this.f4379b.getParcelable("pendingIntent");
                }
                m7720a(new ConnectionResult(this.f4378a, pendingIntent));
        }
    }

    protected /* synthetic */ void m7722a(Object obj) {
        m7721a((Boolean) obj);
    }

    protected abstract boolean m7723a();

    protected void m7724b() {
    }
}
