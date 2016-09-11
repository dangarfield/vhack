package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class ct implements OnClickListener {
    final /* synthetic */ MainActivity f5356a;

    ct(MainActivity mainActivity) {
        this.f5356a = mainActivity;
    }

    public void onClick(View view) {
        this.f5356a.f5115S = false;
        this.f5356a.f5124m.start();
        this.f5356a.startActivity(new Intent(this.f5356a.getApplicationContext(), DailysActivity.class));
    }
}
