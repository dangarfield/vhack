package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cq implements OnClickListener {
    final /* synthetic */ MainActivity f5353a;

    cq(MainActivity mainActivity) {
        this.f5353a = mainActivity;
    }

    public void onClick(View view) {
        this.f5353a.f5115S = false;
        this.f5353a.f5124m.start();
        this.f5353a.startActivity(new Intent(this.f5353a.getApplicationContext(), DailysActivity.class));
    }
}
