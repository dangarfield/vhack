package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dd implements OnClickListener {
    final /* synthetic */ MainActivity f5367a;

    dd(MainActivity mainActivity) {
        this.f5367a = mainActivity;
    }

    public void onClick(View view) {
        this.f5367a.f5115S = false;
        this.f5367a.f5124m.start();
        this.f5367a.startActivity(new Intent(this.f5367a.getApplicationContext(), NetworkActivity.class));
    }
}
