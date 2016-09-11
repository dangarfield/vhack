package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p002h.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.menu.u */
class MenuItemWrapperJB extends MenuItemWrapperICS implements VisibilityListener {
    ActionProvider f1563c;
    final /* synthetic */ MenuItemWrapperJB f1564d;

    public MenuItemWrapperJB(MenuItemWrapperJB menuItemWrapperJB, Context context, android.view.ActionProvider actionProvider) {
        this.f1564d = menuItemWrapperJB;
        super(menuItemWrapperJB, context, actionProvider);
    }

    public View m3364a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public boolean m3366b() {
        return this.a.overridesItemVisibility();
    }

    public boolean m3367c() {
        return this.a.isVisible();
    }

    public void m3365a(ActionProvider actionProvider) {
        VisibilityListener visibilityListener;
        this.f1563c = actionProvider;
        android.view.ActionProvider actionProvider2 = this.a;
        if (actionProvider == null) {
            visibilityListener = null;
        }
        actionProvider2.setVisibilityListener(visibilityListener);
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.f1563c != null) {
            this.f1563c.m2406a(z);
        }
    }
}
