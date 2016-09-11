package android.support.v7.widget;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.p017a.ActionBar;
import android.support.v7.p018b.R;
import android.support.v7.view.ActionBarPolicy;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

/* compiled from: ScrollingTabContainerView */
public class fd extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2223j;
    Runnable f2224a;
    int f2225b;
    int f2226c;
    private fg f2227d;
    private cs f2228e;
    private Spinner f2229f;
    private boolean f2230g;
    private int f2231h;
    private int f2232i;

    static {
        f2223j = new DecelerateInterpolator();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2228e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2225b = -1;
        } else {
            if (childCount > 2) {
                this.f2225b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2225b = MeasureSpec.getSize(i) / 2;
            }
            this.f2225b = Math.min(this.f2225b, this.f2226c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2231h, 1073741824);
        if (z || !this.f2230g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2228e.measure(0, mode);
            if (this.f2228e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4569b();
            } else {
                m4570c();
            }
        } else {
            m4570c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2232i);
        }
    }

    private boolean m4568a() {
        return this.f2229f != null && this.f2229f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2230g = z;
    }

    private void m4569b() {
        if (!m4568a()) {
            if (this.f2229f == null) {
                this.f2229f = m4571d();
            }
            removeView(this.f2228e);
            addView(this.f2229f, new LayoutParams(-2, -1));
            if (this.f2229f.getAdapter() == null) {
                this.f2229f.setAdapter(new ff());
            }
            if (this.f2224a != null) {
                removeCallbacks(this.f2224a);
                this.f2224a = null;
            }
            this.f2229f.setSelection(this.f2232i);
        }
    }

    private boolean m4570c() {
        if (m4568a()) {
            removeView(this.f2229f);
            addView(this.f2228e, new LayoutParams(-2, -1));
            setTabSelected(this.f2229f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f2232i = i;
        int childCount = this.f2228e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f2228e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m4572a(i);
            }
        }
        if (this.f2229f != null && i >= 0) {
            this.f2229f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2231h = i;
        requestLayout();
    }

    private Spinner m4571d() {
        Spinner bjVar = new bj(getContext(), null, R.actionDropDownStyle);
        bjVar.setLayoutParams(new ct(-2, -1));
        bjVar.setOnItemSelectedListener(this);
        return bjVar;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        ActionBarPolicy a = ActionBarPolicy.m3102a(getContext());
        setContentHeight(a.m3107e());
        this.f2226c = a.m3109g();
    }

    public void m4572a(int i) {
        View childAt = this.f2228e.getChildAt(i);
        if (this.f2224a != null) {
            removeCallbacks(this.f2224a);
        }
        this.f2224a = new fe(this, childAt);
        post(this.f2224a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2224a != null) {
            post(this.f2224a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2224a != null) {
            removeCallbacks(this.f2224a);
        }
    }

    private fh m4566a(ActionBar actionBar, boolean z) {
        fh fhVar = new fh(this, getContext(), actionBar, z);
        if (z) {
            fhVar.setBackgroundDrawable(null);
            fhVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2231h));
        } else {
            fhVar.setFocusable(true);
            if (this.f2227d == null) {
                this.f2227d = new fg();
            }
            fhVar.setOnClickListener(this.f2227d);
        }
        return fhVar;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        ((fh) view).m4575b().m3032d();
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
