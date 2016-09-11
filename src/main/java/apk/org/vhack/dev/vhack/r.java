package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: BotnetActivity */
class r implements OnItemClickListener {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a.t = this.a.a.n[i];
        Builder builder = new Builder(this.a.a);
        builder.setCancelable(false);
        builder.setMessage("Do you really want to upgrade PC #" + this.a.a.n[i] + " to level " + (Integer.parseInt(this.a.a.o[i]) + 1) + " for $" + this.a.a.a(this.a.a.q[i]) + "?");
        builder.setPositiveButton(2131165262, new s(this));
        builder.setNegativeButton(2131165261, new t(this));
        builder.create().show();
    }
}
