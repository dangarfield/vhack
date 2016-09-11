package android.support.v7.widget;

import android.view.View;

/* compiled from: ScrollingTabContainerView */
class fe implements Runnable {
    final /* synthetic */ View f2233a;
    final /* synthetic */ fd f2234b;

    fe(fd fdVar, View view) {
        this.f2234b = fdVar;
        this.f2233a = view;
    }

    public void run() {
        this.f2234b.smoothScrollTo(this.f2233a.getLeft() - ((this.f2234b.getWidth() - this.f2233a.getWidth()) / 2), 0);
        this.f2234b.f2224a = null;
    }
}
