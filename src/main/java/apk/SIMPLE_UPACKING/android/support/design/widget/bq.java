package android.support.design.widget;

import android.support.v4.p002h.bu;
import android.view.View;

/* compiled from: SwipeDismissBehavior */
class bq implements Runnable {
    final /* synthetic */ SwipeDismissBehavior f378a;
    private final View f379b;
    private final boolean f380c;

    bq(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f378a = swipeDismissBehavior;
        this.f379b = view;
        this.f380c = z;
    }

    public void run() {
        if (this.f378a.f273a != null && this.f378a.f273a.m2638a(true)) {
            bu.m1931a(this.f379b, (Runnable) this);
        } else if (this.f380c && this.f378a.f274b != null) {
            this.f378a.f274b.m534a(this.f379b);
        }
    }
}
