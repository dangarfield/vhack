package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AdWareActivity */
class a implements OnClickListener {
    final /* synthetic */ AdWareActivity a;

    a(AdWareActivity adWareActivity) {
        this.a = adWareActivity;
    }

    public void onClick(View view) {
        new j(this.a).execute(new String[0]);
    }
}
