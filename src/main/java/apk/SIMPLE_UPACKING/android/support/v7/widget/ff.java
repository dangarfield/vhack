package android.support.v7.widget;

import android.support.v7.p017a.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: ScrollingTabContainerView */
class ff extends BaseAdapter {
    final /* synthetic */ fd f2235a;

    private ff(fd fdVar) {
        this.f2235a = fdVar;
    }

    public int getCount() {
        return this.f2235a.f2228e.getChildCount();
    }

    public Object getItem(int i) {
        return ((fh) this.f2235a.f2228e.getChildAt(i)).m4575b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f2235a.m4566a((ActionBar) getItem(i), true);
        }
        ((fh) view).m4574a((ActionBar) getItem(i));
        return view;
    }
}
