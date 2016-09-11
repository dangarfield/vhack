package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cw implements OnClickListener {
    final /* synthetic */ MainActivity f5359a;

    cw(MainActivity mainActivity) {
        this.f5359a = mainActivity;
    }

    public void onClick(View view) {
        this.f5359a.f5115S = false;
        this.f5359a.f5124m.start();
        this.f5359a.startActivity(new Intent(this.f5359a.getApplicationContext(), TasksActivity.class));
    }
}
