package android.support.design.widget;

import android.support.v4.p002h.bu;
import android.view.View;

/* compiled from: HeaderBehavior */
class ap implements Runnable {
    final /* synthetic */ ao f327a;
    private final CoordinatorLayout f328b;
    private final View f329c;

    ap(ao aoVar, CoordinatorLayout coordinatorLayout, View view) {
        this.f327a = aoVar;
        this.f328b = coordinatorLayout;
        this.f329c = view;
    }

    public void run() {
        if (this.f329c != null && this.f327a.f173b != null) {
            if (this.f327a.f173b.m2545g()) {
                this.f327a.a_(this.f328b, this.f329c, this.f327a.f173b.m2541c());
                bu.m1931a(this.f329c, (Runnable) this);
                return;
            }
            this.f327a.m247a(this.f328b, this.f329c);
        }
    }
}
