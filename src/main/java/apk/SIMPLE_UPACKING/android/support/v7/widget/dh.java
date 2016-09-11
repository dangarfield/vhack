package android.support.v7.widget;

import android.database.DataSetObserver;

/* compiled from: ListPopupWindow */
class dh extends DataSetObserver {
    final /* synthetic */ cy f2123a;

    private dh(cy cyVar) {
        this.f2123a = cyVar;
    }

    public void onChanged() {
        if (this.f2123a.m4055k()) {
            this.f2123a.m4041c();
        }
    }

    public void onInvalidated() {
        this.f2123a.m4053i();
    }
}
