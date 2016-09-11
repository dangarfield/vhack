package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class co implements OnClickListener {
    final /* synthetic */ MainActivity f5351a;

    co(MainActivity mainActivity) {
        this.f5351a = mainActivity;
    }

    public void onClick(View view) {
        this.f5351a.f5115S = false;
        this.f5351a.f5124m.start();
        this.f5351a.startActivity(new Intent(this.f5351a.getApplicationContext(), EventsActivity.class));
    }
}
