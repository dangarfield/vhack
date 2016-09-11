package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ConsoleActivity */
class bh implements OnClickListener {
    final /* synthetic */ ConsoleActivity a;

    bh(ConsoleActivity consoleActivity) {
        this.a = consoleActivity;
    }

    public void onClick(View view) {
        this.a.s.setText(this.a.r.toUpperCase());
    }
}
