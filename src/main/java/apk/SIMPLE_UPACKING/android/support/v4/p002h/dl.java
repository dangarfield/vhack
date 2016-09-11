package android.support.v4.p002h;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
/* renamed from: android.support.v4.h.dl */
class dl implements Runnable {
    WeakReference f945a;
    di f946b;
    final /* synthetic */ dk f947c;

    private dl(dk dkVar, di diVar, View view) {
        this.f947c = dkVar;
        this.f945a = new WeakReference(view);
        this.f946b = diVar;
    }

    public void run() {
        View view = (View) this.f945a.get();
        if (view != null) {
            this.f947c.m2307d(this.f946b, view);
        }
    }
}
