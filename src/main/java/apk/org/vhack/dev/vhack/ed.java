package org.vhack.dev.vhack;

import android.support.v4.b.c;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ed implements OnClickListener {
    final /* synthetic */ NetworkActivity a;

    ed(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    public void onClick(View view) {
        String obj = this.a.t.getText().toString();
        if (obj.length() > 5 && obj.contains(".")) {
            this.a.r = obj;
            for (int i = 0; i < this.a.l.length; i++) {
                if (this.a.l[i].equals(this.a.r)) {
                    this.a.A[i].setBackground(c.a(this.a.getApplicationContext(), 2130837736));
                }
            }
            this.a.s.setText("vHack XT [Version 1.15]\n\n");
            new eu(this.a).execute(new String[]{obj});
        }
    }
}
