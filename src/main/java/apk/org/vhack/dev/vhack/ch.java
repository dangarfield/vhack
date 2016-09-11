package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: MailsActivity */
class ch implements OnItemClickListener {
    final /* synthetic */ cg a;

    ch(cg cgVar) {
        this.a = cgVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.a.a.s[i];
        this.a.a.w = i;
        Editor edit = this.a.a.m.edit();
        edit.putString("urmail", "0");
        edit.commit();
        new ci(this.a.a).execute(new String[]{this.a.a.u[i]});
    }
}
