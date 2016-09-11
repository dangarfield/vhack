package android.support.v7.p017a;

import android.support.v4.p002h.bm;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.ec;
import android.view.View;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.ag */
class ag implements bm {
    final /* synthetic */ ae f1126a;

    ag(ae aeVar) {
        this.f1126a = aeVar;
    }

    public ec m2860a(View view, ec ecVar) {
        int b = ecVar.m2353b();
        int c = this.f1126a.m2809g(b);
        if (b != c) {
            ecVar = ecVar.m2352a(ecVar.m2351a(), c, ecVar.m2354c(), ecVar.m2355d());
        }
        return bu.m1922a(view, ecVar);
    }
}
