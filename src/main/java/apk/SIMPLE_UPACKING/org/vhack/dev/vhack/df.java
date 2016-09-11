package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class df implements OnClickListener {
    final /* synthetic */ MainActivity f5369a;

    df(MainActivity mainActivity) {
        this.f5369a = mainActivity;
    }

    public void onClick(View view) {
        this.f5369a.f5115S = false;
        this.f5369a.f5124m.start();
        this.f5369a.startActivity(new Intent(this.f5369a.getApplicationContext(), ClusterActivity.class));
    }
}
