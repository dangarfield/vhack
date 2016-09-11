package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SoftwareActivity */
class fe implements OnClickListener {
    final /* synthetic */ SoftwareActivity a;

    fe(SoftwareActivity softwareActivity) {
        this.a = softwareActivity;
    }

    public void onClick(View view) {
        this.a.v.setClickable(false);
        this.a.m.start();
        new fg(this.a).execute(new String[]{this.a.t});
    }
}
