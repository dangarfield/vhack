package org.vhack.dev.vhack;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/* compiled from: LogActivity */
class cd implements OnItemClickListener {
    final /* synthetic */ cc f5326a;

    cd(cc ccVar) {
        this.f5326a = ccVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = "";
        if (this.f5326a.f5325a.f5083x[i].equals(this.f5326a.f5325a.f5081v)) {
            Object obj = this.f5326a.f5325a.f5082w[i];
        } else {
            String str2 = this.f5326a.f5325a.f5083x[i];
        }
        if (obj.equals("Anonymous")) {
            Toast.makeText(this.f5326a.f5325a.getApplicationContext(), "Unable to copy IP.", 0).show();
            return;
        }
        ((ClipboardManager) this.f5326a.f5325a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IP", obj));
        Toast.makeText(this.f5326a.f5325a.getApplicationContext(), obj + " copied to clipboard.", 0).show();
    }
}
