package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cv implements OnClickListener {
    final /* synthetic */ MainActivity f5358a;

    cv(MainActivity mainActivity) {
        this.f5358a = mainActivity;
    }

    public void onClick(View view) {
        this.f5358a.f5115S = false;
        this.f5358a.f5124m.start();
        this.f5358a.startActivity(new Intent(this.f5358a.getApplicationContext(), LogActivity.class));
    }
}
