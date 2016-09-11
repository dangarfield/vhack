package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: AppCompatSpinner */
class bn implements OnItemClickListener {
    final /* synthetic */ bj f1988a;
    final /* synthetic */ bm f1989b;

    bn(bm bmVar, bj bjVar) {
        this.f1989b = bmVar;
        this.f1988a = bjVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1989b.f1984a.setSelection(i);
        if (this.f1989b.f1984a.getOnItemClickListener() != null) {
            this.f1989b.f1984a.performItemClick(view, i, this.f1989b.f1986d.getItemId(i));
        }
        this.f1989b.m4053i();
    }
}
