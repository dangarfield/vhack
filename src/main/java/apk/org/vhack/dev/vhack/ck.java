package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MailsActivity */
class ck implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ci b;

    ck(ci ciVar, String str) {
        this.b = ciVar;
        this.a = str;
    }

    public void onClick(View view) {
        new cl(this.b.a).execute(new String[]{this.a, "0"});
    }
}
