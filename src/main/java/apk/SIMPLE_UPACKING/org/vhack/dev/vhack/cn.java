package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cn implements OnClickListener {
    final /* synthetic */ MainActivity f5350a;

    cn(MainActivity mainActivity) {
        this.f5350a = mainActivity;
    }

    public void onClick(View view) {
        this.f5350a.f5115S = false;
        this.f5350a.f5124m.start();
        this.f5350a.findViewById(2131558842).setVisibility(8);
        this.f5350a.startActivity(new Intent(this.f5350a.getApplicationContext(), ClusterActivity.class));
    }
}
