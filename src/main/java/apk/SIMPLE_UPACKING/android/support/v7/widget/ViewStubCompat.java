package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f1837a;
    private int f1838b;
    private WeakReference f1839c;
    private LayoutInflater f1840d;
    private gp f1841e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1837a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.ViewStubCompat, i, 0);
        this.f1838b = obtainStyledAttributes.getResourceId(R.ViewStubCompat_android_inflatedId, -1);
        this.f1837a = obtainStyledAttributes.getResourceId(R.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1838b;
    }

    public void setInflatedId(int i) {
        this.f1838b = i;
    }

    public int getLayoutResource() {
        return this.f1837a;
    }

    public void setLayoutResource(int i) {
        this.f1837a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1840d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1840d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f1839c != null) {
            View view = (View) this.f1839c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m3900a();
        }
    }

    public View m3900a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1837a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f1840d != null) {
                layoutInflater = this.f1840d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1837a, viewGroup, false);
            if (this.f1838b != -1) {
                inflate.setId(this.f1838b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1839c = new WeakReference(inflate);
            if (this.f1841e != null) {
                this.f1841e.m4747a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(gp gpVar) {
        this.f1841e = gpVar;
    }
}
