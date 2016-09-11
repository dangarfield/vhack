package android.support.v7.p017a;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.ea;
import android.view.View;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.al */
class al extends ea {
    final /* synthetic */ ae f1131a;

    al(ae aeVar) {
        this.f1131a = aeVar;
    }

    public void m2870b(View view) {
        bu.m1939c(this.f1131a.f1104n, 1.0f);
        this.f1131a.f1107q.m2286a(null);
        this.f1131a.f1107q = null;
    }

    public void m2869a(View view) {
        this.f1131a.f1104n.setVisibility(0);
        this.f1131a.f1104n.sendAccessibilityEvent(32);
        if (this.f1131a.f1104n.getParent() != null) {
            bu.m1962s((View) this.f1131a.f1104n.getParent());
        }
    }
}
