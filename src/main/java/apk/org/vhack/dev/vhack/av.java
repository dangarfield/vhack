package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ClusterActivity */
class av implements OnClickListener {
    final /* synthetic */ at a;

    av(at atVar) {
        this.a = atVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
