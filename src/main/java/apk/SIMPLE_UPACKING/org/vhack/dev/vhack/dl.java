package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dl implements OnClickListener {
    final /* synthetic */ MainActivity f5375a;

    dl(MainActivity mainActivity) {
        this.f5375a = mainActivity;
    }

    public void onClick(View view) {
        this.f5375a.f5124m.start();
        if (this.f5375a.f5119W) {
            this.f5375a.startActivityForResult(this.f5375a.f5120X, 17);
        }
    }
}
