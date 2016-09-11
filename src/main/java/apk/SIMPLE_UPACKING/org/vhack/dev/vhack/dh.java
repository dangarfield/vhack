package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dh implements OnClickListener {
    final /* synthetic */ MainActivity f5371a;

    dh(MainActivity mainActivity) {
        this.f5371a = mainActivity;
    }

    public void onClick(View view) {
        this.f5371a.f5115S = false;
        this.f5371a.f5124m.start();
        this.f5371a.startActivity(new Intent(this.f5371a.getApplicationContext(), BuyActivity.class));
    }
}
