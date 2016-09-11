package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ClusterActivity */
class au implements OnClickListener {
    final /* synthetic */ at f5280a;

    au(at atVar) {
        this.f5280a = atVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new be(this.f5280a.f5279a).execute(new String[0]);
    }
}
