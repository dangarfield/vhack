package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ListPopupWindow */
class db implements OnItemSelectedListener {
    final /* synthetic */ cy f2105a;

    db(cy cyVar) {
        this.f2105a = cyVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            dc a = this.f2105a.f1964g;
            if (a != null) {
                a.f2115g = false;
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
