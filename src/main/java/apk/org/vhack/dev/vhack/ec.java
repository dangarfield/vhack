package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ec implements OnClickListener {
    final /* synthetic */ NetworkActivity a;

    ec(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    public void onClick(View view) {
        String obj = this.a.t.getText().toString();
        if (obj.length() > 5 && obj.contains(".")) {
            this.a.q = obj;
            this.a.s.setText("vHack XT [Version 1.15]\n\n");
            new er(this.a).execute(new String[]{obj});
            obj = "";
        }
    }
}
