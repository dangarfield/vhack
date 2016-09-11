package android.support.v7.p017a;

import android.support.v7.p018b.R;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.af */
class af implements Runnable {
    final /* synthetic */ ae f1125a;

    af(ae aeVar) {
        this.f1125a = aeVar;
    }

    public void run() {
        if ((this.f1125a.f1097F & 1) != 0) {
            this.f1125a.m2808f(0);
        }
        if ((this.f1125a.f1097F & 4096) != 0) {
            this.f1125a.m2808f(R.AppCompatTheme_ratingBarStyleSmall);
        }
        this.f1125a.f1096E = false;
        this.f1125a.f1097F = 0;
    }
}
