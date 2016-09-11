package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

/* compiled from: TasksActivity */
class fr implements OnItemClickListener {
    final /* synthetic */ fq a;

    fr(fq fqVar) {
        this.a = fqVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a.A = this.a.a.v[i];
        this.a.a.r = this.a.a.A;
        this.a.a.B = Math.round((float) ((Integer.parseInt(this.a.a.u[i]) / 60) + 1)) + "";
        ((TextView) this.a.a.findViewById(2131558956)).setText(this.a.a.B);
        this.a.a.findViewById(2131558950).setVisibility(0);
    }
}
