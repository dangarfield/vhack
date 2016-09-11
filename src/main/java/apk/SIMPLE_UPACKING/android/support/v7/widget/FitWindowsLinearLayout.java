package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements cm {
    private cn f1675a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(cn cnVar) {
        this.f1675a = cnVar;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1675a != null) {
            this.f1675a.m2861a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
