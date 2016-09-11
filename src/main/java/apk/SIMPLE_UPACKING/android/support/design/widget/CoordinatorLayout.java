package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

/* renamed from: android.support.design.widget.q */
class CoordinatorLayout implements OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout f434a;

    private CoordinatorLayout(CoordinatorLayout coordinatorLayout) {
        this.f434a = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.f434a.f245y != null) {
            this.f434a.f245y.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        this.f434a.m386b(view2);
        if (this.f434a.f245y != null) {
            this.f434a.f245y.onChildViewRemoved(view, view2);
        }
    }
}
