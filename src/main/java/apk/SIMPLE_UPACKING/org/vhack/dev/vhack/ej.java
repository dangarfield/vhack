package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ej implements OnClickListener {
    final /* synthetic */ NetworkActivity f5409a;

    ej(NetworkActivity networkActivity) {
        this.f5409a = networkActivity;
    }

    public void onClick(View view) {
        this.f5409a.f5138A[2].setBackgroundResource(0);
        this.f5409a.f5138A[2].setBackground(ContextCompat.m741a(this.f5409a.getApplicationContext(), 2130837737));
        this.f5409a.f5147r = this.f5409a.f5141l[2];
        this.f5409a.f5146q = this.f5409a.f5147r;
        this.f5409a.f5149t.setText(this.f5409a.f5146q);
        this.f5409a.f5148s.setText("vHack XT [Version 1.15]\n\n");
        this.f5409a.findViewById(2131558866).setEnabled(false);
        this.f5409a.findViewById(2131558870).setEnabled(false);
        this.f5409a.findViewById(2131558874).setEnabled(false);
        this.f5409a.findViewById(2131558878).setEnabled(false);
        this.f5409a.findViewById(2131558882).setEnabled(false);
        this.f5409a.findViewById(2131558886).setEnabled(false);
        this.f5409a.findViewById(2131558890).setEnabled(false);
        this.f5409a.findViewById(2131558894).setEnabled(false);
        this.f5409a.findViewById(2131558898).setEnabled(false);
        new er(this.f5409a).execute(new String[]{this.f5409a.f5146q});
    }
}
