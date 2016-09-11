package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ClusterActivity */
class au implements OnClickListener {
    final /* synthetic */ at a;

    au(at atVar) {
        this.a = atVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new be(this.a.a).execute(new String[0]);
    }
}
