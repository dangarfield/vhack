package com.fyber.p028h;

import android.content.Intent;
import com.fyber.utils.Dispatchable;

/* renamed from: com.fyber.h.h */
final class OfferWallRequester extends Dispatchable {
    final /* synthetic */ Intent f2762a;
    final /* synthetic */ OfferWallRequester f2763b;

    OfferWallRequester(OfferWallRequester offerWallRequester, Intent intent) {
        this.f2763b = offerWallRequester;
        this.f2762a = intent;
    }

    public final void m5214a() {
        ((RequestCallback) this.f2763b.a).m4877a(this.f2762a);
    }
}
