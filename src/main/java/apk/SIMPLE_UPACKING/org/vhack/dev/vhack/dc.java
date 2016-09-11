package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dc implements OnClickListener {
    final /* synthetic */ MainActivity f5366a;

    dc(MainActivity mainActivity) {
        this.f5366a = mainActivity;
    }

    public void onClick(View view) {
        this.f5366a.f5115S = false;
        this.f5366a.f5124m.start();
        this.f5366a.startActivity(new Intent(this.f5366a.getApplicationContext(), SoftwareActivity.class));
    }
}
