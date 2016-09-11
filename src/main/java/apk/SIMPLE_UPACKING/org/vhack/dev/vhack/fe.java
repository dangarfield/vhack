package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SoftwareActivity */
class fe implements OnClickListener {
    final /* synthetic */ SoftwareActivity f5447a;

    fe(SoftwareActivity softwareActivity) {
        this.f5447a = softwareActivity;
    }

    public void onClick(View view) {
        this.f5447a.f5179v.setClickable(false);
        this.f5447a.f5170m.start();
        new fg(this.f5447a).execute(new String[]{this.f5447a.f5177t});
    }
}
