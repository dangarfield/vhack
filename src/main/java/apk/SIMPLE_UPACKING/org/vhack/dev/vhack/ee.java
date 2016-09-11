package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ee implements OnClickListener {
    final /* synthetic */ NetworkActivity f5404a;

    ee(NetworkActivity networkActivity) {
        this.f5404a = networkActivity;
    }

    public void onClick(View view) {
        String obj = this.f5404a.f5149t.getText().toString();
        if (obj.length() > 5 && obj.contains(".")) {
            this.f5404a.f5147r = obj;
            this.f5404a.f5148s.setText("vHack XT [Version 1.15]\n\n");
            new eo(this.f5404a).execute(new String[]{obj});
        }
    }
}
