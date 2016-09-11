package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ea implements OnClickListener {
    final /* synthetic */ NetworkActivity f5400a;

    ea(NetworkActivity networkActivity) {
        this.f5400a = networkActivity;
    }

    public void onClick(View view) {
        this.f5400a.f5138A[7].setBackgroundResource(0);
        this.f5400a.f5138A[7].setBackground(ContextCompat.m741a(this.f5400a.getApplicationContext(), 2130837737));
        this.f5400a.f5147r = this.f5400a.f5141l[7];
        this.f5400a.f5146q = this.f5400a.f5147r;
        this.f5400a.f5149t.setText(this.f5400a.f5146q);
        this.f5400a.f5148s.setText("vHack XT [Version 1.15]\n\n");
        this.f5400a.findViewById(2131558866).setEnabled(false);
        this.f5400a.findViewById(2131558870).setEnabled(false);
        this.f5400a.findViewById(2131558874).setEnabled(false);
        this.f5400a.findViewById(2131558878).setEnabled(false);
        this.f5400a.findViewById(2131558882).setEnabled(false);
        this.f5400a.findViewById(2131558886).setEnabled(false);
        this.f5400a.findViewById(2131558890).setEnabled(false);
        this.f5400a.findViewById(2131558894).setEnabled(false);
        this.f5400a.findViewById(2131558898).setEnabled(false);
        new er(this.f5400a).execute(new String[]{this.f5400a.f5146q});
    }
}
