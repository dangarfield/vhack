package org.vhack.dev.vhack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

/* compiled from: TasksActivity */
class fr implements OnItemClickListener {
    final /* synthetic */ fq f5468a;

    fr(fq fqVar) {
        this.f5468a = fqVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f5468a.f5467a.f5189A = this.f5468a.f5467a.f5206v[i];
        this.f5468a.f5467a.f5202r = this.f5468a.f5467a.f5189A;
        this.f5468a.f5467a.f5190B = Math.round((float) ((Integer.parseInt(this.f5468a.f5467a.f5205u[i]) / 60) + 1)) + "";
        ((TextView) this.f5468a.f5467a.findViewById(2131558956)).setText(this.f5468a.f5467a.f5190B);
        this.f5468a.f5467a.findViewById(2131558950).setVisibility(0);
    }
}
