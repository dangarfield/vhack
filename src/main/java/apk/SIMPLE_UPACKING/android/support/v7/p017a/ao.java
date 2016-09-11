package android.support.v7.p017a;

import android.support.v4.p002h.bu;
import android.support.v4.p002h.ea;
import android.view.View;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.ao */
class ao extends ea {
    final /* synthetic */ an f1135a;

    ao(an anVar) {
        this.f1135a = anVar;
    }

    public void m2883b(View view) {
        this.f1135a.f1133a.f1104n.setVisibility(8);
        if (this.f1135a.f1133a.f1105o != null) {
            this.f1135a.f1133a.f1105o.dismiss();
        } else if (this.f1135a.f1133a.f1104n.getParent() instanceof View) {
            bu.m1962s((View) this.f1135a.f1133a.f1104n.getParent());
        }
        this.f1135a.f1133a.f1104n.removeAllViews();
        this.f1135a.f1133a.f1107q.m2286a(null);
        this.f1135a.f1133a.f1107q = null;
    }
}
