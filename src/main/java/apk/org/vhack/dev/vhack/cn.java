package org.vhack.dev.vhack;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainActivity */
class cn implements OnClickListener {
    final /* synthetic */ MainActivity a;

    cn(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(View view) {
        this.a.S = false;
        this.a.m.start();
        this.a.findViewById(2131558842).setVisibility(8);
        this.a.startActivity(new Intent(this.a.getApplicationContext(), ClusterActivity.class));
    }
}
