package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dm implements OnClickListener {
    final /* synthetic */ MainActivity f5376a;

    dm(MainActivity mainActivity) {
        this.f5376a = mainActivity;
    }

    public void onClick(View view) {
        this.f5376a.f5115S = false;
        this.f5376a.f5124m.start();
        this.f5376a.startActivity(new Intent(this.f5376a.getApplicationContext(), LogActivity.class));
    }
}
