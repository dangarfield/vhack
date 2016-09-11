package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cs implements OnClickListener {
    final /* synthetic */ MainActivity f5355a;

    cs(MainActivity mainActivity) {
        this.f5355a = mainActivity;
    }

    public void onClick(View view) {
        this.f5355a.f5115S = false;
        this.f5355a.f5124m.start();
        this.f5355a.startActivity(new Intent(this.f5355a.getApplicationContext(), BonusBoxActivity.class));
    }
}
