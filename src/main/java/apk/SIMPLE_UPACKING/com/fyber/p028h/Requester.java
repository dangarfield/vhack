package com.fyber.p028h;

import com.fyber.utils.Dispatchable;

/* renamed from: com.fyber.h.i */
final class Requester extends Dispatchable {
    final /* synthetic */ RequestError f2764a;
    final /* synthetic */ Requester f2765b;

    Requester(Requester requester, RequestError requestError) {
        this.f2765b = requester;
        this.f2764a = requestError;
    }

    public final void m5215a() {
        this.f2765b.f2748a.m4876a(this.f2764a);
    }
}
