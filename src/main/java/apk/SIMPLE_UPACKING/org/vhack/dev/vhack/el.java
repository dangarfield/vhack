package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class el implements OnClickListener {
    final /* synthetic */ NetworkActivity f5411a;

    el(NetworkActivity networkActivity) {
        this.f5411a = networkActivity;
    }

    public void onClick(View view) {
        this.f5411a.f5138A[4].setBackgroundResource(0);
        this.f5411a.f5138A[4].setBackground(ContextCompat.m741a(this.f5411a.getApplicationContext(), 2130837737));
        this.f5411a.f5147r = this.f5411a.f5141l[4];
        this.f5411a.f5146q = this.f5411a.f5147r;
        this.f5411a.f5149t.setText(this.f5411a.f5146q);
        this.f5411a.f5148s.setText("vHack XT [Version 1.15]\n\n");
        this.f5411a.findViewById(2131558866).setEnabled(false);
        this.f5411a.findViewById(2131558870).setEnabled(false);
        this.f5411a.findViewById(2131558874).setEnabled(false);
        this.f5411a.findViewById(2131558878).setEnabled(false);
        this.f5411a.findViewById(2131558882).setEnabled(false);
        this.f5411a.findViewById(2131558886).setEnabled(false);
        this.f5411a.findViewById(2131558890).setEnabled(false);
        this.f5411a.findViewById(2131558894).setEnabled(false);
        this.f5411a.findViewById(2131558898).setEnabled(false);
        new er(this.f5411a).execute(new String[]{this.f5411a.f5146q});
    }
}
