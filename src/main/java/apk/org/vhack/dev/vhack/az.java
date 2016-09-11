package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ClusterActivity */
class az implements OnClickListener {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new bb(this.a.a.a).execute(new String[]{this.a.a.a.o});
    }
}
