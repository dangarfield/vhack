package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p017a.ActionBar;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: Toolbar */
public class gg extends ActionBar {
    int f2308b;

    public gg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2308b = 0;
    }

    public gg(int i, int i2) {
        super(i, i2);
        this.f2308b = 0;
        this.a = 8388627;
    }

    public gg(gg ggVar) {
        super((ActionBar) ggVar);
        this.f2308b = 0;
        this.f2308b = ggVar.f2308b;
    }

    public gg(ActionBar actionBar) {
        super(actionBar);
        this.f2308b = 0;
    }

    public gg(MarginLayoutParams marginLayoutParams) {
        super((LayoutParams) marginLayoutParams);
        this.f2308b = 0;
        m4672a(marginLayoutParams);
    }

    public gg(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2308b = 0;
    }

    void m4672a(MarginLayoutParams marginLayoutParams) {
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}
