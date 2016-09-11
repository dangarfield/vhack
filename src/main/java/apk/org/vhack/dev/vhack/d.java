package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AdWareActivity */
class d implements OnClickListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new f(this.a.a.a).execute(new String[]{this.a.a.a.s});
    }
}
