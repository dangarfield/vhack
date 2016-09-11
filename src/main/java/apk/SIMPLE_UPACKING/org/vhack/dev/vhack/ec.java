package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NetworkActivity */
class ec implements OnClickListener {
    final /* synthetic */ NetworkActivity f5402a;

    ec(NetworkActivity networkActivity) {
        this.f5402a = networkActivity;
    }

    public void onClick(View view) {
        String obj = this.f5402a.f5149t.getText().toString();
        if (obj.length() > 5 && obj.contains(".")) {
            this.f5402a.f5146q = obj;
            this.f5402a.f5148s.setText("vHack XT [Version 1.15]\n\n");
            new er(this.f5402a).execute(new String[]{obj});
            obj = "";
        }
    }
}
