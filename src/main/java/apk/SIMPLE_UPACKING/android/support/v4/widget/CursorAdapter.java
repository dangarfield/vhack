package android.support.v4.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.widget.p */
class CursorAdapter extends DataSetObserver {
    final /* synthetic */ CursorAdapter f1072a;

    private CursorAdapter(CursorAdapter cursorAdapter) {
        this.f1072a = cursorAdapter;
    }

    public void onChanged() {
        this.f1072a.f1017a = true;
        this.f1072a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f1072a.f1017a = false;
        this.f1072a.notifyDataSetInvalidated();
    }
}
