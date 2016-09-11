package org.vhack.dev.vhack;

import android.content.Intent;
import com.fyber.h.c;
import com.fyber.h.d;

/* compiled from: MainActivity */
class di implements c {
    final /* synthetic */ MainActivity a;

    di(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void a(Intent intent) {
        this.a.X = intent;
        this.a.W = true;
    }

    public void a(d dVar) {
        this.a.W = false;
    }
}
