package android.support.v7.widget;

import android.view.View;

/* compiled from: ListPopupWindow */
class da implements Runnable {
    final /* synthetic */ cy f2104a;

    da(cy cyVar) {
        this.f2104a = cyVar;
    }

    public void run() {
        View e = this.f2104a.m4045e();
        if (e != null && e.getWindowToken() != null) {
            this.f2104a.m4041c();
        }
    }
}
