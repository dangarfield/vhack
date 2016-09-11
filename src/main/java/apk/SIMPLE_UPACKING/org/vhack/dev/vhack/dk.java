package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class dk implements OnClickListener {
    final /* synthetic */ MainActivity f5374a;

    dk(MainActivity mainActivity) {
        this.f5374a = mainActivity;
    }

    public void onClick(View view) {
        this.f5374a.f5124m.start();
        this.f5374a.f5115S = false;
        this.f5374a.startActivity(new Intent(this.f5374a.getApplicationContext(), TutActivity.class));
    }
}
