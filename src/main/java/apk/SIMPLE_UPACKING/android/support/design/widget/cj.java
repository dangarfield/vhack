package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ViewOffsetBehavior */
class cj extends CoordinatorLayout {
    private ck f169a;
    private int f170b;
    private int f171c;

    public cj() {
        this.f170b = 0;
        this.f171c = 0;
    }

    public cj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f170b = 0;
        this.f171c = 0;
    }

    public boolean m239a(CoordinatorLayout coordinatorLayout, View view, int i) {
        m241b(coordinatorLayout, view, i);
        if (this.f169a == null) {
            this.f169a = new ck(view);
        }
        this.f169a.m670a();
        if (this.f170b != 0) {
            this.f169a.m671a(this.f170b);
            this.f170b = 0;
        }
        if (this.f171c != 0) {
            this.f169a.m673b(this.f171c);
            this.f171c = 0;
        }
        return true;
    }

    protected void m241b(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.m377a(view, i);
    }

    public boolean m238a(int i) {
        if (this.f169a != null) {
            return this.f169a.m671a(i);
        }
        this.f170b = i;
        return false;
    }

    public int m240b() {
        return this.f169a != null ? this.f169a.m672b() : 0;
    }
}
