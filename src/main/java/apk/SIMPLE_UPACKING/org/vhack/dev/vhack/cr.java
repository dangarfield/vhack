package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cr implements OnClickListener {
    final /* synthetic */ MainActivity f5354a;

    cr(MainActivity mainActivity) {
        this.f5354a = mainActivity;
    }

    public void onClick(View view) {
        this.f5354a.f5115S = false;
        this.f5354a.f5124m.start();
        this.f5354a.startActivity(new Intent(this.f5354a.getApplicationContext(), BonusBoxActivity.class));
    }
}
