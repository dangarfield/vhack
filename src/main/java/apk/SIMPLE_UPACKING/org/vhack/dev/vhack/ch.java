package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: MailsActivity */
class ch implements OnItemClickListener {
    final /* synthetic */ cg f5342a;

    ch(cg cgVar) {
        this.f5342a = cgVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.f5342a.f5341a.f5091s[i];
        this.f5342a.f5341a.f5095w = i;
        Editor edit = this.f5342a.f5341a.f5085m.edit();
        edit.putString("urmail", "0");
        edit.commit();
        new ci(this.f5342a.f5341a).execute(new String[]{this.f5342a.f5341a.f5093u[i]});
    }
}
