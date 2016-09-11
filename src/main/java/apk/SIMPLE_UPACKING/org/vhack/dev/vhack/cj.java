package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MailsActivity */
class cj implements OnClickListener {
    final /* synthetic */ String f5344a;
    final /* synthetic */ ci f5345b;

    cj(ci ciVar, String str) {
        this.f5345b = ciVar;
        this.f5344a = str;
    }

    public void onClick(View view) {
        new cl(this.f5345b.f5343a).execute(new String[]{this.f5344a, "1"});
    }
}
