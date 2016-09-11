package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ConsoleActivity */
class bh implements OnClickListener {
    final /* synthetic */ ConsoleActivity f5297a;

    bh(ConsoleActivity consoleActivity) {
        this.f5297a = consoleActivity;
    }

    public void onClick(View view) {
        this.f5297a.f5046s.setText(this.f5297a.f5045r.toUpperCase());
    }
}
