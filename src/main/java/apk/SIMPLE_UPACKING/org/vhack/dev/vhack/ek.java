package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ek implements OnClickListener {
    final /* synthetic */ NetworkActivity f5410a;

    ek(NetworkActivity networkActivity) {
        this.f5410a = networkActivity;
    }

    public void onClick(View view) {
        this.f5410a.f5138A[3].setBackgroundResource(0);
        this.f5410a.f5138A[3].setBackground(ContextCompat.m741a(this.f5410a.getApplicationContext(), 2130837737));
        this.f5410a.f5147r = this.f5410a.f5141l[3];
        this.f5410a.f5146q = this.f5410a.f5147r;
        this.f5410a.f5149t.setText(this.f5410a.f5146q);
        this.f5410a.f5148s.setText("vHack XT [Version 1.15]\n\n");
        this.f5410a.findViewById(2131558866).setEnabled(false);
        this.f5410a.findViewById(2131558870).setEnabled(false);
        this.f5410a.findViewById(2131558874).setEnabled(false);
        this.f5410a.findViewById(2131558878).setEnabled(false);
        this.f5410a.findViewById(2131558882).setEnabled(false);
        this.f5410a.findViewById(2131558886).setEnabled(false);
        this.f5410a.findViewById(2131558890).setEnabled(false);
        this.f5410a.findViewById(2131558894).setEnabled(false);
        this.f5410a.findViewById(2131558898).setEnabled(false);
        new er(this.f5410a).execute(new String[]{this.f5410a.f5146q});
    }
}
