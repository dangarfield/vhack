package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class de implements OnClickListener {
    final /* synthetic */ MainActivity f5368a;

    de(MainActivity mainActivity) {
        this.f5368a = mainActivity;
    }

    public void onClick(View view) {
        this.f5368a.f5115S = false;
        this.f5368a.f5124m.start();
        this.f5368a.startActivity(new Intent(this.f5368a.getApplicationContext(), RankingActivity.class));
    }
}
