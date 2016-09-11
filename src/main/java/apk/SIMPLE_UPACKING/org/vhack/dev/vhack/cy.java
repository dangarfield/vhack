package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cy implements OnClickListener {
    final /* synthetic */ MainActivity f5361a;

    cy(MainActivity mainActivity) {
        this.f5361a = mainActivity;
    }

    public void onClick(View view) {
        this.f5361a.f5115S = false;
        this.f5361a.f5124m.start();
        this.f5361a.startActivity(new Intent(this.f5361a.getApplicationContext(), NetworkActivity.class));
    }
}
