package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: BotnetActivity */
class t implements OnClickListener {
    final /* synthetic */ r a;

    t(r rVar) {
        this.a = rVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
