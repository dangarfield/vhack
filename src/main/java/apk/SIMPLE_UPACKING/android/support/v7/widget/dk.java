package android.support.v7.widget;

import android.support.v4.p002h.bu;

/* compiled from: ListPopupWindow */
class dk implements Runnable {
    final /* synthetic */ cy f2126a;

    private dk(cy cyVar) {
        this.f2126a = cyVar;
    }

    public void run() {
        if (this.f2126a.f1964g != null && bu.m1917C(this.f2126a.f1964g) && this.f2126a.f1964g.getCount() > this.f2126a.f1964g.getChildCount() && this.f2126a.f1964g.getChildCount() <= this.f2126a.f1960b) {
            this.f2126a.f1962e.setInputMethodMode(2);
            this.f2126a.m4041c();
        }
    }
}
