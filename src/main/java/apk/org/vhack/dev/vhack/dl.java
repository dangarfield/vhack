package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dl implements OnClickListener {
    final /* synthetic */ MainActivity a;

    dl(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.m.start();
        if (this.a.W) {
            this.a.startActivityForResult(this.a.X, 17);
        }
    }
}
