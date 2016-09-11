package org.vhack.dev.vhack;

import android.content.Intent;
import com.fyber.p028h.RequestCallback;
import com.fyber.p028h.RequestError;

/* compiled from: MainActivity */
class di implements RequestCallback {
    final /* synthetic */ MainActivity f5372a;

    di(MainActivity mainActivity) {
        this.f5372a = mainActivity;
    }

    public void m9139a(Intent intent) {
        this.f5372a.f5120X = intent;
        this.f5372a.f5119W = true;
    }

    public void m9140a(RequestError requestError) {
        this.f5372a.f5119W = false;
    }
}
