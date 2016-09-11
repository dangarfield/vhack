package org.vhack.dev.vhack;

import android.support.v4.p007b.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ed implements OnClickListener {
    final /* synthetic */ NetworkActivity f5403a;

    ed(NetworkActivity networkActivity) {
        this.f5403a = networkActivity;
    }

    public void onClick(View view) {
        String obj = this.f5403a.f5149t.getText().toString();
        if (obj.length() > 5 && obj.contains(".")) {
            this.f5403a.f5147r = obj;
            for (int i = 0; i < this.f5403a.f5141l.length; i++) {
                if (this.f5403a.f5141l[i].equals(this.f5403a.f5147r)) {
                    this.f5403a.f5138A[i].setBackground(ContextCompat.m741a(this.f5403a.getApplicationContext(), 2130837736));
                }
            }
            this.f5403a.f5148s.setText("vHack XT [Version 1.15]\n\n");
            new eu(this.f5403a).execute(new String[]{obj});
        }
    }
}
