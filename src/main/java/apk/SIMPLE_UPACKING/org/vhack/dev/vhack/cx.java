package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MainActivity */
class cx implements OnClickListener {
    final /* synthetic */ MainActivity f5360a;

    cx(MainActivity mainActivity) {
        this.f5360a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
