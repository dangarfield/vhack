package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cw implements OnClickListener {
    final /* synthetic */ MainActivity a;

    cw(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.S = false;
        this.a.m.start();
        this.a.startActivity(new Intent(this.a.getApplicationContext(), TasksActivity.class));
    }
}
