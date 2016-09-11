package android.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.ActionProvider;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    ActionProvider f1656a;
    private final ag f1657b;
    private final ah f1658c;
    private final cs f1659d;
    private final FrameLayout f1660e;
    private final ImageView f1661f;
    private final FrameLayout f1662g;
    private final int f1663h;
    private final DataSetObserver f1664i;
    private final OnGlobalLayoutListener f1665j;
    private cy f1666k;
    private OnDismissListener f1667l;
    private boolean f1668m;
    private int f1669n;
    private boolean f1670o;
    private int f1671p;

    public class InnerLayout extends cs {
        private static final int[] f1655a;

        static {
            f1655a = new int[]{16842964};
        }

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            gb a = gb.m4645a(context, attributeSet, f1655a);
            setBackgroundDrawable(a.m4649a(0));
            a.m4650a();
        }
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f1657b.m3907a(activityChooserModel);
        if (m3477c()) {
            m3476b();
            m3475a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1661f.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1661f.setContentDescription(getContext().getString(i));
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1656a = actionProvider;
    }

    public boolean m3475a() {
        if (m3477c() || !this.f1670o) {
            return false;
        }
        this.f1668m = false;
        m3466a(this.f1669n);
        return true;
    }

    private void m3466a(int i) {
        if (this.f1657b.m3912d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1665j);
        boolean z = this.f1662g.getVisibility() == 0;
        int c = this.f1657b.m3911c();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || c <= r3 + i) {
            this.f1657b.m3908a(false);
            this.f1657b.m3906a(i);
        } else {
            this.f1657b.m3908a(true);
            this.f1657b.m3906a(i - 1);
        }
        cy listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m4055k()) {
            if (this.f1668m || !z) {
                this.f1657b.m3909a(true, z);
            } else {
                this.f1657b.m3909a(false, false);
            }
            listPopupWindow.m4048f(Math.min(this.f1657b.m3905a(), this.f1663h));
            listPopupWindow.m4041c();
            if (this.f1656a != null) {
                this.f1656a.m2399a(true);
            }
            listPopupWindow.m4057m().setContentDescription(getContext().getString(R.abc_activitychooserview_choose_application));
        }
    }

    public boolean m3476b() {
        if (m3477c()) {
            getListPopupWindow().m4053i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1665j);
            }
        }
        return true;
    }

    public boolean m3477c() {
        return getListPopupWindow().m4055k();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel d = this.f1657b.m3912d();
        if (d != null) {
            d.registerObserver(this.f1664i);
        }
        this.f1670o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel d = this.f1657b.m3912d();
        if (d != null) {
            d.unregisterObserver(this.f1664i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1665j);
        }
        if (m3477c()) {
            m3476b();
        }
        this.f1670o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1659d;
        if (this.f1662g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1659d.layout(0, 0, i3 - i, i4 - i2);
        if (!m3477c()) {
            m3476b();
        }
    }

    public ActivityChooserModel getDataModel() {
        return this.f1657b.m3912d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1667l = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1669n = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1671p = i;
    }

    private cy getListPopupWindow() {
        if (this.f1666k == null) {
            this.f1666k = new cy(getContext());
            this.f1666k.m4037a(this.f1657b);
            this.f1666k.m4035a((View) this);
            this.f1666k.m4039a(true);
            this.f1666k.m4036a(this.f1658c);
            this.f1666k.m4038a(this.f1658c);
        }
        return this.f1666k;
    }
}
