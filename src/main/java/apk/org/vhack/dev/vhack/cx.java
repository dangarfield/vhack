package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MainActivity */
class cx implements OnClickListener {
    final /* synthetic */ MainActivity a;

    cx(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
