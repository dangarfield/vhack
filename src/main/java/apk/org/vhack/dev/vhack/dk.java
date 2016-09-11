package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dk implements OnClickListener {
    final /* synthetic */ MainActivity a;

    dk(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.m.start();
        this.a.S = false;
        this.a.startActivity(new Intent(this.a.getApplicationContext(), TutActivity.class));
    }
}
