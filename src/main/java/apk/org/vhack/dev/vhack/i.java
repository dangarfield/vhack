package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AdWareActivity */
class i implements OnClickListener {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
