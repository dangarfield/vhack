package org.vhack.dev.vhack;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/* compiled from: LogActivity */
class cd implements OnItemClickListener {
    final /* synthetic */ cc a;

    cd(cc ccVar) {
        this.a = ccVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = "";
        if (this.a.a.x[i].equals(this.a.a.v)) {
            Object obj = this.a.a.w[i];
        } else {
            String str2 = this.a.a.x[i];
        }
        if (obj.equals("Anonymous")) {
            Toast.makeText(this.a.a.getApplicationContext(), "Unable to copy IP.", 0).show();
            return;
        }
        ((ClipboardManager) this.a.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IP", obj));
        Toast.makeText(this.a.a.getApplicationContext(), obj + " copied to clipboard.", 0).show();
    }
}
