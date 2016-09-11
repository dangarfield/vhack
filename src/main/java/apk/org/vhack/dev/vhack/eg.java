package org.vhack.dev.vhack;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: NetworkActivity */
class eg implements OnClickListener {
    final /* synthetic */ NetworkActivity a;

    eg(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    public void onClick(View view) {
        if (!this.a.q.equals("")) {
            ((ClipboardManager) this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IP", this.a.q));
            Toast.makeText(this.a.getApplicationContext(), this.a.q + " copied to clipboard.", 0).show();
        }
    }
}
