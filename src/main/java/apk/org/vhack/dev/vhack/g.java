package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: AdWareActivity */
class g implements OnItemClickListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a.s = this.a.a.p[i];
        Builder builder = new Builder(this.a.a);
        builder.setCancelable(false);
        builder.setMessage("Do you really want to remove AdWare on " + this.a.a.s + "?");
        builder.setPositiveButton(2131165262, new h(this));
        builder.setNegativeButton(2131165261, new i(this));
        builder.create().show();
    }
}
