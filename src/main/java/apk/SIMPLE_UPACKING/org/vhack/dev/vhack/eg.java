package org.vhack.dev.vhack;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: NetworkActivity */
class eg implements OnClickListener {
    final /* synthetic */ NetworkActivity f5406a;

    eg(NetworkActivity networkActivity) {
        this.f5406a = networkActivity;
    }

    public void onClick(View view) {
        if (!this.f5406a.f5146q.equals("")) {
            ((ClipboardManager) this.f5406a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IP", this.f5406a.f5146q));
            Toast.makeText(this.f5406a.getApplicationContext(), this.f5406a.f5146q + " copied to clipboard.", 0).show();
        }
    }
}
