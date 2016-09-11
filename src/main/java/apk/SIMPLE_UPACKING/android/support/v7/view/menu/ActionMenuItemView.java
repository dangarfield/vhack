package android.support.v7.view.menu;

import android.support.v7.widget.cy;
import android.support.v7.widget.dd;

/* renamed from: android.support.v7.view.menu.b */
class ActionMenuItemView extends dd {
    final /* synthetic */ ActionMenuItemView f1504a;

    public ActionMenuItemView(ActionMenuItemView actionMenuItemView) {
        this.f1504a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public cy m3279a() {
        if (this.f1504a.f1426f != null) {
            return this.f1504a.f1426f.m3281a();
        }
        return null;
    }

    protected boolean m3280b() {
        if (this.f1504a.f1424d == null || !this.f1504a.f1424d.m3181a(this.f1504a.f1421a)) {
            return false;
        }
        cy a = m3279a();
        if (a == null || !a.m4055k()) {
            return false;
        }
        return true;
    }
}
