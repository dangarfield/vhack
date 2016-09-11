package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: ClusterActivity */
class ay implements OnItemClickListener {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a.o = this.a.a.r[i];
        Builder builder = new Builder(this.a.a);
        builder.setCancelable(false);
        builder.setMessage(this.a.a.getString(2131165394) + this.a.a.o + "?");
        builder.setPositiveButton(2131165262, new az(this));
        builder.setNegativeButton(2131165261, new ba(this));
        builder.create().show();
    }
}
