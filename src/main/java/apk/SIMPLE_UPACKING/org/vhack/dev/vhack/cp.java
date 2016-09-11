package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cp implements OnClickListener {
    final /* synthetic */ MainActivity f5352a;

    cp(MainActivity mainActivity) {
        this.f5352a = mainActivity;
    }

    public void onClick(View view) {
        this.f5352a.f5115S = false;
        this.f5352a.f5124m.start();
        this.f5352a.startActivity(new Intent(this.f5352a.getApplicationContext(), EventsActivity.class));
    }
}
