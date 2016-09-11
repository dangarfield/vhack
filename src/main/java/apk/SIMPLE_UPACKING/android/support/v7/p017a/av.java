package android.support.v7.p017a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.p002h.bu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.by;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
/* renamed from: android.support.v7.a.av */
class av extends ActionBar {
    private by f1175a;
    private Callback f1176b;
    private boolean f1177c;
    private boolean f1178d;
    private ArrayList f1179e;
    private final Runnable f1180f;

    public void m2915a(boolean z) {
    }

    public void m2912a(float f) {
        bu.m1944d(this.f1175a.m4116a(), f);
    }

    public Context m2918c() {
        return this.f1175a.m4125b();
    }

    public void m2919c(boolean z) {
    }

    public void m2920d(boolean z) {
    }

    public void m2913a(Configuration configuration) {
        super.m2719a(configuration);
    }

    public void m2914a(CharSequence charSequence) {
        this.f1175a.m4123a(charSequence);
    }

    public boolean m2924g() {
        ViewGroup a = this.f1175a.m4116a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public int m2911a() {
        return this.f1175a.m4141o();
    }

    public boolean m2917b() {
        return this.f1175a.m4143q() == 0;
    }

    public boolean m2922e() {
        this.f1175a.m4116a().removeCallbacks(this.f1180f);
        bu.m1931a(this.f1175a.m4116a(), this.f1180f);
        return true;
    }

    public boolean m2923f() {
        if (!this.f1175a.m4129c()) {
            return false;
        }
        this.f1175a.m4130d();
        return true;
    }

    void m2926i() {
        Menu j = m2910j();
        MenuBuilder menuBuilder = j instanceof MenuBuilder ? (MenuBuilder) j : null;
        if (menuBuilder != null) {
            menuBuilder.m3245g();
        }
        try {
            j.clear();
            if (!(this.f1176b.onCreatePanelMenu(0, j) && this.f1176b.onPreparePanel(0, null, j))) {
                j.clear();
            }
            if (menuBuilder != null) {
                menuBuilder.m3246h();
            }
        } catch (Throwable th) {
            if (menuBuilder != null) {
                menuBuilder.m3246h();
            }
        }
    }

    public boolean m2916a(int i, KeyEvent keyEvent) {
        Menu j = m2910j();
        if (j != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            j.setQwertyMode(z);
            j.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    void m2925h() {
        this.f1175a.m4116a().removeCallbacks(this.f1180f);
    }

    public void m2921e(boolean z) {
        if (z != this.f1178d) {
            this.f1178d = z;
            int size = this.f1179e.size();
            for (int i = 0; i < size; i++) {
                ((ActionBar) this.f1179e.get(i)).m3028a(z);
            }
        }
    }

    private Menu m2910j() {
        if (!this.f1177c) {
            this.f1175a.m4119a(new ax(), new ay());
            this.f1177c = true;
        }
        return this.f1175a.m4144r();
    }
}
