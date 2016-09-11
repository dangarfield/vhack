package android.support.v7.p017a;

import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

/* compiled from: ToolbarActionBar */
/* renamed from: android.support.v7.a.ax */
final class ax implements MenuPresenter {
    final /* synthetic */ av f1182a;
    private boolean f1183b;

    private ax(av avVar) {
        this.f1182a = avVar;
    }

    public boolean m2928a(MenuBuilder menuBuilder) {
        if (this.f1182a.f1176b == null) {
            return false;
        }
        this.f1182a.f1176b.onMenuOpened(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
        return true;
    }

    public void m2927a(MenuBuilder menuBuilder, boolean z) {
        if (!this.f1183b) {
            this.f1183b = true;
            this.f1182a.f1175a.m4140n();
            if (this.f1182a.f1176b != null) {
                this.f1182a.f1176b.onPanelClosed(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
            }
            this.f1183b = false;
        }
    }
}
