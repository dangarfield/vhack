package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dp implements OnClickListener {
    final /* synthetic */ MainActivity f5379a;

    dp(MainActivity mainActivity) {
        this.f5379a = mainActivity;
    }

    public void onClick(View view) {
        this.f5379a.f5115S = false;
        this.f5379a.f5124m.start();
        this.f5379a.startActivity(new Intent(this.f5379a.getApplicationContext(), AdWareActivity.class));
    }
}
