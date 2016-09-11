package org.vhack.dev.vhack;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: BotnetActivity */
class s implements OnClickListener {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new ah(this.a.a.a).execute(new String[]{this.a.a.a.t});
    }
}
