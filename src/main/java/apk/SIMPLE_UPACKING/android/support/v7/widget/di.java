package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: ListPopupWindow */
class di implements OnScrollListener {
    final /* synthetic */ cy f2124a;

    private di(cy cyVar) {
        this.f2124a = cyVar;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f2124a.m4056l() && this.f2124a.f1962e.getContentView() != null) {
            this.f2124a.f1956C.removeCallbacks(this.f2124a.f1981x);
            this.f2124a.f1981x.run();
        }
    }
}
