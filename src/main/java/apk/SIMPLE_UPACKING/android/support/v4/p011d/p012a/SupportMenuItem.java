package android.support.v4.p011d.p012a;

import android.support.v4.p002h.ActionProvider;
import android.support.v4.p002h.aw;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.d.a.b */
public interface SupportMenuItem extends MenuItem {
    SupportMenuItem m1427a(aw awVar);

    SupportMenuItem m1428a(ActionProvider actionProvider);

    ActionProvider m1429a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
