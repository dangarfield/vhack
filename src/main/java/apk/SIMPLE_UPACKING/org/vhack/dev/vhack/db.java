package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class db implements OnClickListener {
    final /* synthetic */ MainActivity f5365a;

    db(MainActivity mainActivity) {
        this.f5365a = mainActivity;
    }

    public void onClick(View view) {
        this.f5365a.f5115S = false;
        this.f5365a.f5124m.start();
        this.f5365a.startActivity(new Intent(this.f5365a.getApplicationContext(), BotnetActivity.class));
    }
}
