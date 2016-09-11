package android.support.v7.p017a;

import android.support.v4.p002h.bu;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.an */
class an implements ActionMode {
    final /* synthetic */ ae f1133a;
    private ActionMode f1134b;

    public an(ae aeVar, ActionMode actionMode) {
        this.f1133a = aeVar;
        this.f1134b = actionMode;
    }

    public boolean m2880a(ActionMode actionMode, Menu menu) {
        return this.f1134b.m2876a(actionMode, menu);
    }

    public boolean m2882b(ActionMode actionMode, Menu menu) {
        return this.f1134b.m2878b(actionMode, menu);
    }

    public boolean m2881a(ActionMode actionMode, MenuItem menuItem) {
        return this.f1134b.m2877a(actionMode, menuItem);
    }

    public void m2879a(ActionMode actionMode) {
        this.f1134b.m2875a(actionMode);
        if (this.f1133a.f1105o != null) {
            this.f1133a.b.getDecorView().removeCallbacks(this.f1133a.f1106p);
        }
        if (this.f1133a.f1104n != null) {
            this.f1133a.m2814u();
            this.f1133a.f1107q = bu.m1960q(this.f1133a.f1104n).m2284a(0.0f);
            this.f1133a.f1107q.m2286a(new ao(this));
        }
        if (this.f1133a.e != null) {
            this.f1133a.e.m2895b(this.f1133a.f1103m);
        }
        this.f1133a.f1103m = null;
    }
}
