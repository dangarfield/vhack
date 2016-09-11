package android.support.v7.p017a;

import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuBuilder;
import android.view.MenuItem;

/* compiled from: ToolbarActionBar */
/* renamed from: android.support.v7.a.ay */
final class ay implements MenuBuilder {
    final /* synthetic */ av f1184a;

    private ay(av avVar) {
        this.f1184a = avVar;
    }

    public boolean m2930a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return false;
    }

    public void m2929a(MenuBuilder menuBuilder) {
        if (this.f1184a.f1176b == null) {
            return;
        }
        if (this.f1184a.f1175a.m4135i()) {
            this.f1184a.f1176b.onPanelClosed(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
        } else if (this.f1184a.f1176b.onPreparePanel(0, null, menuBuilder)) {
            this.f1184a.f1176b.onMenuOpened(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
        }
    }
}
