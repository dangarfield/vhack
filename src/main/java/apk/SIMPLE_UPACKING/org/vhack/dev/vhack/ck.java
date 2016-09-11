package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MailsActivity */
class ck implements OnClickListener {
    final /* synthetic */ String f5346a;
    final /* synthetic */ ci f5347b;

    ck(ci ciVar, String str) {
        this.f5347b = ciVar;
        this.f5346a = str;
    }

    public void onClick(View view) {
        new cl(this.f5347b.f5343a).execute(new String[]{this.f5346a, "0"});
    }
}
