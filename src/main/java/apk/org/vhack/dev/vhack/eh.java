package org.vhack.dev.vhack;

import android.support.v4.b.c;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class eh implements OnClickListener {
    final /* synthetic */ NetworkActivity a;

    eh(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    public void onClick(View view) {
        this.a.A[0].setBackgroundResource(0);
        this.a.A[0].setBackground(c.a(this.a.getApplicationContext(), 2130837737));
        this.a.r = this.a.l[0];
        this.a.q = this.a.r;
        this.a.t.setText(this.a.q);
        this.a.s.setText("vHack XT [Version 1.15]\n\n");
        this.a.findViewById(2131558866).setEnabled(false);
        this.a.findViewById(2131558870).setEnabled(false);
        this.a.findViewById(2131558874).setEnabled(false);
        this.a.findViewById(2131558878).setEnabled(false);
        this.a.findViewById(2131558882).setEnabled(false);
        this.a.findViewById(2131558886).setEnabled(false);
        this.a.findViewById(2131558890).setEnabled(false);
        this.a.findViewById(2131558894).setEnabled(false);
        this.a.findViewById(2131558898).setEnabled(false);
        new er(this.a).execute(new String[]{this.a.q});
    }
}
