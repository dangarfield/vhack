package android.support.v7.p017a;

import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.am */
final class am implements MenuPresenter {
    final /* synthetic */ ae f1132a;

    private am(ae aeVar) {
        this.f1132a = aeVar;
    }

    public boolean m2874a(MenuBuilder menuBuilder) {
        Callback o = this.f1132a.m2775o();
        if (o != null) {
            o.onMenuOpened(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
        }
        return true;
    }

    public void m2873a(MenuBuilder menuBuilder, boolean z) {
        this.f1132a.m2797b(menuBuilder);
    }
}
