package android.support.v7.p017a;

import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.ar */
final class ar implements MenuPresenter {
    final /* synthetic */ ae f1164a;

    private ar(ae aeVar) {
        this.f1164a = aeVar;
    }

    public void m2891a(MenuBuilder menuBuilder, boolean z) {
        Menu menu;
        Menu p = menuBuilder.m3254p();
        boolean z2 = p != menuBuilder;
        ae aeVar = this.f1164a;
        if (z2) {
            menu = p;
        }
        aq a = aeVar.m2782a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.f1164a.m2783a(a.f1145a, a, p);
            this.f1164a.m2789a(a, true);
            return;
        }
        this.f1164a.m2789a(a, z);
    }

    public boolean m2892a(MenuBuilder menuBuilder) {
        if (menuBuilder == null && this.f1164a.h) {
            Callback o = this.f1164a.m2775o();
            if (!(o == null || this.f1164a.m2774n())) {
                o.onMenuOpened(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
            }
        }
        return true;
    }
}
