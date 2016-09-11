package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItem;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ToolbarWidgetWrapper */
class gk implements OnClickListener {
    final ActionMenuItem f2327a;
    final /* synthetic */ gj f2328b;

    gk(gj gjVar) {
        this.f2328b = gjVar;
        this.f2327a = new ActionMenuItem(this.f2328b.f2309a.getContext(), 0, 16908332, 0, 0, this.f2328b.f2317i);
    }

    public void onClick(View view) {
        if (this.f2328b.f2320l != null && this.f2328b.f2321m) {
            this.f2328b.f2320l.onMenuItemSelected(0, this.f2327a);
        }
    }
}
