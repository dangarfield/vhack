package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class dz implements OnClickListener {
    final /* synthetic */ NetworkActivity f5398a;

    dz(NetworkActivity networkActivity) {
        this.f5398a = networkActivity;
    }

    public void onClick(View view) {
        this.f5398a.f5138A[6].setBackgroundResource(0);
        this.f5398a.f5138A[6].setBackground(ContextCompat.m741a(this.f5398a.getApplicationContext(), 2130837737));
        this.f5398a.f5147r = this.f5398a.f5141l[6];
        this.f5398a.f5146q = this.f5398a.f5147r;
        this.f5398a.f5149t.setText(this.f5398a.f5146q);
        this.f5398a.f5148s.setText("vHack XT [Version 1.15]\n\n");
        this.f5398a.findViewById(2131558866).setEnabled(false);
        this.f5398a.findViewById(2131558870).setEnabled(false);
        this.f5398a.findViewById(2131558874).setEnabled(false);
        this.f5398a.findViewById(2131558878).setEnabled(false);
        this.f5398a.findViewById(2131558882).setEnabled(false);
        this.f5398a.findViewById(2131558886).setEnabled(false);
        this.f5398a.findViewById(2131558890).setEnabled(false);
        this.f5398a.findViewById(2131558894).setEnabled(false);
        this.f5398a.findViewById(2131558898).setEnabled(false);
        new er(this.f5398a).execute(new String[]{this.f5398a.f5146q});
    }
}
