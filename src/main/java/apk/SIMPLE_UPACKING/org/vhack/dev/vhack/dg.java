package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dg implements OnClickListener {
    final /* synthetic */ MainActivity f5370a;

    dg(MainActivity mainActivity) {
        this.f5370a = mainActivity;
    }

    public void onClick(View view) {
        this.f5370a.f5115S = false;
        this.f5370a.f5124m.start();
        this.f5370a.startActivity(new Intent(this.f5370a.getApplicationContext(), MailsActivity.class));
    }
}
