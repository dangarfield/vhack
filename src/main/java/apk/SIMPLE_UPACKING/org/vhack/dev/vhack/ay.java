package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: ClusterActivity */
class ay implements OnItemClickListener {
    final /* synthetic */ ax f5284a;

    ay(ax axVar) {
        this.f5284a = axVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f5284a.f5283a.f5032o = this.f5284a.f5283a.f5035r[i];
        Builder builder = new Builder(this.f5284a.f5283a);
        builder.setCancelable(false);
        builder.setMessage(this.f5284a.f5283a.getString(2131165394) + this.f5284a.f5283a.f5032o + "?");
        builder.setPositiveButton(2131165262, new az(this));
        builder.setNegativeButton(2131165261, new ba(this));
        builder.create().show();
    }
}
