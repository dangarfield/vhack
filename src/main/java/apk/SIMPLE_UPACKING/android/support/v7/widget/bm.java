package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: AppCompatSpinner */
class bm extends cy {
    final /* synthetic */ bj f1984a;
    private CharSequence f1985c;
    private ListAdapter f1986d;
    private final Rect f1987e;

    public bm(bj bjVar, Context context, AttributeSet attributeSet, int i) {
        this.f1984a = bjVar;
        super(context, attributeSet, i);
        this.f1987e = new Rect();
        m4035a((View) bjVar);
        m4039a(true);
        m4033a(0);
        m4036a(new bn(this, bjVar));
    }

    public void m4063a(ListAdapter listAdapter) {
        super.m4037a(listAdapter);
        this.f1986d = listAdapter;
    }

    public CharSequence m4062a() {
        return this.f1985c;
    }

    public void m4064a(CharSequence charSequence) {
        this.f1985c = charSequence;
    }

    void m4065b() {
        int i;
        int i2;
        Drawable d = m4043d();
        if (d != null) {
            d.getPadding(this.f1984a.f1947l);
            i = gq.m4750a(this.f1984a) ? this.f1984a.f1947l.right : -this.f1984a.f1947l.left;
        } else {
            Rect b = this.f1984a.f1947l;
            this.f1984a.f1947l.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.f1984a.getPaddingLeft();
        int paddingRight = this.f1984a.getPaddingRight();
        int width = this.f1984a.getWidth();
        if (this.f1984a.f1946k == -2) {
            int a = this.f1984a.m4018a((SpinnerAdapter) this.f1986d, m4043d());
            i2 = (this.f1984a.getContext().getResources().getDisplayMetrics().widthPixels - this.f1984a.f1947l.left) - this.f1984a.f1947l.right;
            if (a <= i2) {
                i2 = a;
            }
            m4048f(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.f1984a.f1946k == -1) {
            m4048f((width - paddingLeft) - paddingRight);
        } else {
            m4048f(this.f1984a.f1946k);
        }
        if (gq.m4750a(this.f1984a)) {
            i2 = ((width - paddingRight) - m4051h()) + i;
        } else {
            i2 = i + paddingLeft;
        }
        m4040b(i2);
    }

    public void m4066c() {
        boolean k = m4055k();
        m4065b();
        m4050g(2);
        super.m4041c();
        m4057m().setChoiceMode(1);
        m4052h(this.f1984a.getSelectedItemPosition());
        if (!k) {
            ViewTreeObserver viewTreeObserver = this.f1984a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                OnGlobalLayoutListener boVar = new bo(this);
                viewTreeObserver.addOnGlobalLayoutListener(boVar);
                m4038a(new bp(this, boVar));
            }
        }
    }

    private boolean m4061b(View view) {
        return bu.m1917C(view) && view.getGlobalVisibleRect(this.f1987e);
    }
}
