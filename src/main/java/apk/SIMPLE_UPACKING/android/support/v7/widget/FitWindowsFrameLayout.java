package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements cm {
    private cn f1674a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(cn cnVar) {
        this.f1674a = cnVar;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1674a != null) {
            this.f1674a.m2861a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
