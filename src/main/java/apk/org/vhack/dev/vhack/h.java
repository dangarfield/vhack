package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AdWareActivity */
class h implements OnClickListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new f(this.a.a.a).execute(new String[]{this.a.a.a.s});
    }
}
