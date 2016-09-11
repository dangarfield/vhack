package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002h.GravityCompat;
import android.support.v4.p002h.am;
import android.support.v4.p002h.ar;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bu;
import android.support.v7.p017a.ActionBar;
import android.support.v7.p018b.R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f1797A;
    private final ArrayList f1798B;
    private final ArrayList f1799C;
    private final int[] f1800D;
    private gh f1801E;
    private final ActionMenuView f1802F;
    private gj f1803G;
    private ActionMenuPresenter f1804H;
    private gf f1805I;
    private MenuPresenter f1806J;
    private MenuBuilder f1807K;
    private boolean f1808L;
    private final Runnable f1809M;
    private final ar f1810N;
    View f1811a;
    private ActionMenuView f1812b;
    private TextView f1813c;
    private TextView f1814d;
    private ImageButton f1815e;
    private ImageView f1816f;
    private Drawable f1817g;
    private CharSequence f1818h;
    private ImageButton f1819i;
    private Context f1820j;
    private int f1821k;
    private int f1822l;
    private int f1823m;
    private int f1824n;
    private int f1825o;
    private int f1826p;
    private int f1827q;
    private int f1828r;
    private int f1829s;
    private final fb f1830t;
    private int f1831u;
    private CharSequence f1832v;
    private CharSequence f1833w;
    private int f1834x;
    private int f1835y;
    private boolean f1836z;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f1795a;
        boolean f1796b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1795a = parcel.readInt();
            this.f1796b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1795a);
            parcel.writeInt(this.f1796b ? 1 : 0);
        }

        static {
            CREATOR = new gi();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3897i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3882a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3883a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1830t = new fb();
        this.f1831u = 8388627;
        this.f1798B = new ArrayList();
        this.f1799C = new ArrayList();
        this.f1800D = new int[2];
        this.f1802F = new gc(this);
        this.f1809M = new gd(this);
        gb a = gb.m4646a(getContext(), attributeSet, R.Toolbar, i, 0);
        this.f1822l = a.m4662g(R.Toolbar_titleTextAppearance, 0);
        this.f1823m = a.m4662g(R.Toolbar_subtitleTextAppearance, 0);
        this.f1831u = a.m4654c(R.Toolbar_android_gravity, this.f1831u);
        this.f1824n = 48;
        int d = a.m4656d(R.Toolbar_titleMargins, 0);
        this.f1829s = d;
        this.f1828r = d;
        this.f1827q = d;
        this.f1826p = d;
        d = a.m4656d(R.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f1826p = d;
        }
        d = a.m4656d(R.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f1827q = d;
        }
        d = a.m4656d(R.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f1828r = d;
        }
        d = a.m4656d(R.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f1829s = d;
        }
        this.f1825o = a.m4658e(R.Toolbar_maxButtonHeight, -1);
        d = a.m4656d(R.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m4656d(R.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f1830t.m4559b(a.m4658e(R.Toolbar_contentInsetLeft, 0), a.m4658e(R.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f1830t.m4556a(d, d2);
        }
        this.f1817g = a.m4649a(R.Toolbar_collapseIcon);
        this.f1818h = a.m4655c(R.Toolbar_collapseContentDescription);
        CharSequence c = a.m4655c(R.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m4655c(R.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f1820j = getContext();
        setPopupTheme(a.m4662g(R.Toolbar_popupTheme, 0));
        Drawable a2 = a.m4649a(R.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m4655c(R.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m4649a(R.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m4655c(R.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m4661f(R.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m4652b(R.Toolbar_titleTextColor, -1));
        }
        if (a.m4661f(R.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m4652b(R.Toolbar_subtitleTextColor, -1));
        }
        a.m4650a();
        this.f1810N = ar.m3972a();
    }

    public void setPopupTheme(int i) {
        if (this.f1821k != i) {
            this.f1821k = i;
            if (i == 0) {
                this.f1820j = getContext();
            } else {
                this.f1820j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1821k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        fb fbVar = this.f1830t;
        if (i != 1) {
            z = false;
        }
        fbVar.m4557a(z);
    }

    public void setLogo(int i) {
        setLogo(this.f1810N.m3993a(getContext(), i));
    }

    public boolean m3888a() {
        return getVisibility() == 0 && this.f1812b != null && this.f1812b.m3451a();
    }

    public boolean m3890b() {
        return this.f1812b != null && this.f1812b.m3461g();
    }

    public boolean m3891c() {
        return this.f1812b != null && this.f1812b.m3462h();
    }

    public boolean m3892d() {
        return this.f1812b != null && this.f1812b.m3459e();
    }

    public boolean m3893e() {
        return this.f1812b != null && this.f1812b.m3460f();
    }

    public void m3886a(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f1812b != null) {
            m3877n();
            MenuBuilder d = this.f1812b.m3458d();
            if (d != menuBuilder) {
                if (d != null) {
                    d.m3234b(this.f1804H);
                    d.m3234b(this.f1805I);
                }
                if (this.f1805I == null) {
                    this.f1805I = new gf();
                }
                actionMenuPresenter.m4781d(true);
                if (menuBuilder != null) {
                    menuBuilder.m3224a((MenuPresenter) actionMenuPresenter, this.f1820j);
                    menuBuilder.m3224a(this.f1805I, this.f1820j);
                } else {
                    actionMenuPresenter.m4767a(this.f1820j, null);
                    this.f1805I.m4665a(this.f1820j, null);
                    actionMenuPresenter.m4777b(true);
                    this.f1805I.m4669b(true);
                }
                this.f1812b.setPopupTheme(this.f1821k);
                this.f1812b.setPresenter(actionMenuPresenter);
                this.f1804H = actionMenuPresenter;
            }
        }
    }

    public void m3894f() {
        if (this.f1812b != null) {
            this.f1812b.m3463i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m3875l();
            if (!m3874d(this.f1816f)) {
                m3864a(this.f1816f, true);
            }
        } else if (this.f1816f != null && m3874d(this.f1816f)) {
            removeView(this.f1816f);
            this.f1799C.remove(this.f1816f);
        }
        if (this.f1816f != null) {
            this.f1816f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f1816f != null ? this.f1816f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3875l();
        }
        if (this.f1816f != null) {
            this.f1816f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f1816f != null ? this.f1816f.getContentDescription() : null;
    }

    private void m3875l() {
        if (this.f1816f == null) {
            this.f1816f = new ImageView(getContext());
        }
    }

    public boolean m3895g() {
        return (this.f1805I == null || this.f1805I.f2306b == null) ? false : true;
    }

    public void m3896h() {
        MenuItemImpl menuItemImpl = this.f1805I == null ? null : this.f1805I.f2306b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f1832v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1813c == null) {
                Context context = getContext();
                this.f1813c = new TextView(context);
                this.f1813c.setSingleLine();
                this.f1813c.setEllipsize(TruncateAt.END);
                if (this.f1822l != 0) {
                    this.f1813c.setTextAppearance(context, this.f1822l);
                }
                if (this.f1834x != 0) {
                    this.f1813c.setTextColor(this.f1834x);
                }
            }
            if (!m3874d(this.f1813c)) {
                m3864a(this.f1813c, true);
            }
        } else if (this.f1813c != null && m3874d(this.f1813c)) {
            removeView(this.f1813c);
            this.f1799C.remove(this.f1813c);
        }
        if (this.f1813c != null) {
            this.f1813c.setText(charSequence);
        }
        this.f1832v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f1833w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1814d == null) {
                Context context = getContext();
                this.f1814d = new TextView(context);
                this.f1814d.setSingleLine();
                this.f1814d.setEllipsize(TruncateAt.END);
                if (this.f1823m != 0) {
                    this.f1814d.setTextAppearance(context, this.f1823m);
                }
                if (this.f1835y != 0) {
                    this.f1814d.setTextColor(this.f1835y);
                }
            }
            if (!m3874d(this.f1814d)) {
                m3864a(this.f1814d, true);
            }
        } else if (this.f1814d != null && m3874d(this.f1814d)) {
            removeView(this.f1814d);
            this.f1799C.remove(this.f1814d);
        }
        if (this.f1814d != null) {
            this.f1814d.setText(charSequence);
        }
        this.f1833w = charSequence;
    }

    public void m3885a(Context context, int i) {
        this.f1822l = i;
        if (this.f1813c != null) {
            this.f1813c.setTextAppearance(context, i);
        }
    }

    public void m3889b(Context context, int i) {
        this.f1823m = i;
        if (this.f1814d != null) {
            this.f1814d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f1834x = i;
        if (this.f1813c != null) {
            this.f1813c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f1835y = i;
        if (this.f1814d != null) {
            this.f1814d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1815e != null ? this.f1815e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m3878o();
        }
        if (this.f1815e != null) {
            this.f1815e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1810N.m3993a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m3878o();
            if (!m3874d(this.f1815e)) {
                m3864a(this.f1815e, true);
            }
        } else if (this.f1815e != null && m3874d(this.f1815e)) {
            removeView(this.f1815e);
            this.f1799C.remove(this.f1815e);
        }
        if (this.f1815e != null) {
            this.f1815e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f1815e != null ? this.f1815e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m3878o();
        this.f1815e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m3876m();
        return this.f1812b.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m3876m();
        this.f1812b.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m3876m();
        return this.f1812b.getOverflowIcon();
    }

    private void m3876m() {
        m3877n();
        if (this.f1812b.m3458d() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f1812b.getMenu();
            if (this.f1805I == null) {
                this.f1805I = new gf();
            }
            this.f1812b.setExpandedActionViewsExclusive(true);
            menuBuilder.m3224a(this.f1805I, this.f1820j);
        }
    }

    private void m3877n() {
        if (this.f1812b == null) {
            this.f1812b = new ActionMenuView(getContext());
            this.f1812b.setPopupTheme(this.f1821k);
            this.f1812b.setOnMenuItemClickListener(this.f1802F);
            this.f1812b.m3450a(this.f1806J, this.f1807K);
            LayoutParams i = m3897i();
            i.a = 8388613 | (this.f1824n & 112);
            this.f1812b.setLayoutParams(i);
            m3864a(this.f1812b, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void setOnMenuItemClickListener(gh ghVar) {
        this.f1801E = ghVar;
    }

    public void m3884a(int i, int i2) {
        this.f1830t.m4556a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f1830t.m4560c();
    }

    public int getContentInsetEnd() {
        return this.f1830t.m4561d();
    }

    public int getContentInsetLeft() {
        return this.f1830t.m4555a();
    }

    public int getContentInsetRight() {
        return this.f1830t.m4558b();
    }

    private void m3878o() {
        if (this.f1815e == null) {
            this.f1815e = new ImageButton(getContext(), null, R.toolbarNavigationButtonStyle);
            LayoutParams i = m3897i();
            i.a = 8388611 | (this.f1824n & 112);
            this.f1815e.setLayoutParams(i);
        }
    }

    private void m3879p() {
        if (this.f1819i == null) {
            this.f1819i = new ImageButton(getContext(), null, R.toolbarNavigationButtonStyle);
            this.f1819i.setImageDrawable(this.f1817g);
            this.f1819i.setContentDescription(this.f1818h);
            LayoutParams i = m3897i();
            i.a = 8388611 | (this.f1824n & 112);
            i.f2308b = 2;
            this.f1819i.setLayoutParams(i);
            this.f1819i.setOnClickListener(new ge(this));
        }
    }

    private void m3864a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m3897i();
        } else if (checkLayoutParams(layoutParams)) {
            gg ggVar = (gg) layoutParams;
        } else {
            layoutParams = m3883a(layoutParams);
        }
        layoutParams.f2308b = 1;
        if (!z || this.f1811a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1799C.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1805I == null || this.f1805I.f2306b == null)) {
            savedState.f1795a = this.f1805I.f2306b.getItemId();
        }
        savedState.f1796b = m3890b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Menu d = this.f1812b != null ? this.f1812b.m3458d() : null;
        if (!(savedState.f1795a == 0 || this.f1805I == null || d == null)) {
            MenuItem findItem = d.findItem(savedState.f1795a);
            if (findItem != null) {
                ar.m1795b(findItem);
            }
        }
        if (savedState.f1796b) {
            m3880q();
        }
    }

    private void m3880q() {
        removeCallbacks(this.f1809M);
        post(this.f1809M);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1809M);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = az.m1825a(motionEvent);
        if (a == 0) {
            this.f1836z = false;
        }
        if (!this.f1836z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1836z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1836z = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = az.m1825a(motionEvent);
        if (a == 9) {
            this.f1797A = false;
        }
        if (!this.f1797A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1797A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1797A = false;
        }
        return true;
    }

    private void m3863a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m3859a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m3881r() {
        if (!this.f1808L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3866a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1800D;
        if (gq.m4750a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m3866a(this.f1815e)) {
            m3863a(this.f1815e, i, 0, i2, 0, this.f1825o);
            i7 = this.f1815e.getMeasuredWidth() + m3868b(this.f1815e);
            max = Math.max(0, this.f1815e.getMeasuredHeight() + m3871c(this.f1815e));
            i6 = gq.m4748a(0, bu.m1953j(this.f1815e));
            i5 = max;
        }
        if (m3866a(this.f1819i)) {
            m3863a(this.f1819i, i, 0, i2, 0, this.f1825o);
            i7 = this.f1819i.getMeasuredWidth() + m3868b(this.f1819i);
            i5 = Math.max(i5, this.f1819i.getMeasuredHeight() + m3871c(this.f1819i));
            i6 = gq.m4748a(i6, bu.m1953j(this.f1819i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m3866a(this.f1812b)) {
            m3863a(this.f1812b, i, max2, i2, 0, this.f1825o);
            i7 = this.f1812b.getMeasuredWidth() + m3868b(this.f1812b);
            i5 = Math.max(i5, this.f1812b.getMeasuredHeight() + m3871c(this.f1812b));
            i6 = gq.m4748a(i6, bu.m1953j(this.f1812b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m3866a(this.f1811a)) {
            max2 += m3859a(this.f1811a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1811a.getMeasuredHeight() + m3871c(this.f1811a));
            i6 = gq.m4748a(i6, bu.m1953j(this.f1811a));
        }
        if (m3866a(this.f1816f)) {
            max2 += m3859a(this.f1816f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1816f.getMeasuredHeight() + m3871c(this.f1816f));
            i6 = gq.m4748a(i6, bu.m1953j(this.f1816f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((gg) childAt.getLayoutParams()).f2308b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m3866a(childAt)) {
                max2 += m3859a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m3871c(childAt));
                i7 = gq.m4748a(i5, bu.m1953j(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f1828r + this.f1829s;
        max = this.f1826p + this.f1827q;
        if (m3866a(this.f1813c)) {
            m3859a(this.f1813c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m3868b(this.f1813c) + this.f1813c.getMeasuredWidth();
            i7 = this.f1813c.getMeasuredHeight() + m3871c(this.f1813c);
            i5 = gq.m4748a(i5, bu.m1953j(this.f1813c));
        }
        if (m3866a(this.f1814d)) {
            contentInsetStart = Math.max(contentInsetStart, m3859a(this.f1814d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1814d.getMeasuredHeight() + m3871c(this.f1814d);
            i5 = gq.m4748a(i5, bu.m1953j(this.f1814d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = bu.m1920a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = bu.m1920a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m3881r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        if (bu.m1951h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1800D;
        iArr[1] = 0;
        iArr[0] = 0;
        int p = bu.m1959p(this);
        if (!m3866a(this.f1815e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m3869b(this.f1815e, i8, iArr, p);
            i5 = paddingLeft;
        } else {
            i5 = m3860a(this.f1815e, paddingLeft, iArr, p);
        }
        if (m3866a(this.f1819i)) {
            if (obj != null) {
                i8 = m3869b(this.f1819i, i8, iArr, p);
            } else {
                i5 = m3860a(this.f1819i, i5, iArr, p);
            }
        }
        if (m3866a(this.f1812b)) {
            if (obj != null) {
                i5 = m3860a(this.f1812b, i5, iArr, p);
            } else {
                i8 = m3869b(this.f1812b, i8, iArr, p);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m3866a(this.f1811a)) {
            if (obj != null) {
                i8 = m3869b(this.f1811a, i8, iArr, p);
            } else {
                i5 = m3860a(this.f1811a, i5, iArr, p);
            }
        }
        if (!m3866a(this.f1816f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m3869b(this.f1816f, i8, iArr, p);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m3860a(this.f1816f, i5, iArr, p);
        }
        boolean a = m3866a(this.f1813c);
        boolean a2 = m3866a(this.f1814d);
        i5 = 0;
        if (a) {
            gg ggVar = (gg) this.f1813c.getLayoutParams();
            i5 = 0 + (ggVar.bottomMargin + (ggVar.topMargin + this.f1813c.getMeasuredHeight()));
        }
        if (a2) {
            ggVar = (gg) this.f1814d.getLayoutParams();
            measuredHeight = (ggVar.bottomMargin + (ggVar.topMargin + this.f1814d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            ggVar = (gg) (a ? this.f1813c : this.f1814d).getLayoutParams();
            gg ggVar2 = (gg) (a2 ? this.f1814d : this.f1813c).getLayoutParams();
            Object obj2 = ((!a || this.f1813c.getMeasuredWidth() <= 0) && (!a2 || this.f1814d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1831u & 112) {
                case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                    paddingTop2 = (ggVar.topMargin + getPaddingTop()) + this.f1828r;
                    break;
                case R.AppCompatTheme_panelMenuListTheme /*80*/:
                    paddingTop2 = (((height - paddingBottom) - ggVar2.bottomMargin) - this.f1829s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < ggVar.topMargin + this.f1828r) {
                        i8 = ggVar.topMargin + this.f1828r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < ggVar.bottomMargin + this.f1829s) {
                            i8 = Math.max(0, paddingTop2 - ((ggVar2.bottomMargin + this.f1829s) - measuredHeight));
                        } else {
                            i8 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1826p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    ggVar = (gg) this.f1813c.getLayoutParams();
                    measuredWidth = i5 - this.f1813c.getMeasuredWidth();
                    i6 = this.f1813c.getMeasuredHeight() + paddingTop2;
                    this.f1813c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + ggVar.bottomMargin;
                    i6 = measuredWidth - this.f1827q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    ggVar = (gg) this.f1814d.getLayoutParams();
                    measuredWidth = ggVar.topMargin + paddingTop2;
                    measuredHeight = this.f1814d.getMeasuredHeight() + measuredWidth;
                    this.f1814d.layout(i5 - this.f1814d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = ggVar.bottomMargin + measuredHeight;
                    i8 = i5 - this.f1827q;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.f1826p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    ggVar = (gg) this.f1813c.getLayoutParams();
                    i5 = this.f1813c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1813c.getMeasuredHeight() + paddingTop2;
                    this.f1813c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = ggVar.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1827q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    ggVar = (gg) this.f1814d.getLayoutParams();
                    i5 += ggVar.topMargin;
                    paddingTop2 = this.f1814d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1814d.getMeasuredHeight() + i5;
                    this.f1814d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = ggVar.bottomMargin + measuredHeight;
                    i8 = this.f1827q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m3865a(this.f1798B, 3);
        int size = this.f1798B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m3860a((View) this.f1798B.get(measuredWidth), i5, iArr, p);
        }
        m3865a(this.f1798B, 5);
        i7 = this.f1798B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m3869b((View) this.f1798B.get(measuredWidth), i6, iArr, p);
        }
        m3865a(this.f1798B, 1);
        measuredWidth = m3861a(this.f1798B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1798B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m3860a((View) this.f1798B.get(i5), measuredWidth, iArr, p);
        }
        this.f1798B.clear();
    }

    private int m3861a(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            gg ggVar = (gg) view.getLayoutParams();
            i6 = ggVar.leftMargin - i6;
            i = ggVar.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m3860a(View view, int i, int[] iArr, int i2) {
        gg ggVar = (gg) view.getLayoutParams();
        int i3 = ggVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m3858a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (ggVar.rightMargin + measuredWidth) + max;
    }

    private int m3869b(View view, int i, int[] iArr, int i2) {
        gg ggVar = (gg) view.getLayoutParams();
        int i3 = ggVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m3858a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (ggVar.leftMargin + measuredWidth);
    }

    private int m3858a(View view, int i) {
        gg ggVar = (gg) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m3857a(ggVar.a)) {
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                return getPaddingTop() - i2;
            case R.AppCompatTheme_panelMenuListTheme /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - ggVar.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < ggVar.topMargin) {
                    i3 = ggVar.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < ggVar.bottomMargin ? Math.max(0, i2 - (ggVar.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m3857a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
            case R.AppCompatTheme_panelMenuListTheme /*80*/:
                return i2;
            default:
                return this.f1831u & 112;
        }
    }

    private void m3865a(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (bu.m1951h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = GravityCompat.m2407a(i, bu.m1951h(this));
        list.clear();
        gg ggVar;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                ggVar = (gg) childAt.getLayoutParams();
                if (ggVar.f2308b == 0 && m3866a(childAt) && m3867b(ggVar.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            ggVar = (gg) childAt2.getLayoutParams();
            if (ggVar.f2308b == 0 && m3866a(childAt2) && m3867b(ggVar.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m3867b(int i) {
        int h = bu.m1951h(this);
        int a = GravityCompat.m2407a(i, h) & 7;
        switch (a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean m3866a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m3868b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return am.m1781b(marginLayoutParams) + am.m1780a(marginLayoutParams);
    }

    private int m3871c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public gg m3882a(AttributeSet attributeSet) {
        return new gg(getContext(), attributeSet);
    }

    protected gg m3883a(LayoutParams layoutParams) {
        if (layoutParams instanceof gg) {
            return new gg((gg) layoutParams);
        }
        if (layoutParams instanceof ActionBar) {
            return new gg((ActionBar) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new gg((MarginLayoutParams) layoutParams);
        }
        return new gg(layoutParams);
    }

    protected gg m3897i() {
        return new gg(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof gg);
    }

    public by getWrapper() {
        if (this.f1803G == null) {
            this.f1803G = new gj(this, true);
        }
        return this.f1803G;
    }

    void m3898j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((gg) childAt.getLayoutParams()).f2308b == 2 || childAt == this.f1812b)) {
                removeViewAt(childCount);
                this.f1799C.add(childAt);
            }
        }
    }

    void m3899k() {
        for (int size = this.f1799C.size() - 1; size >= 0; size--) {
            addView((View) this.f1799C.get(size));
        }
        this.f1799C.clear();
    }

    private boolean m3874d(View view) {
        return view.getParent() == this || this.f1799C.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f1808L = z;
        requestLayout();
    }

    public void m3887a(MenuPresenter menuPresenter, MenuBuilder menuBuilder) {
        this.f1806J = menuPresenter;
        this.f1807K = menuBuilder;
        if (this.f1812b != null) {
            this.f1812b.m3450a(menuPresenter, menuBuilder);
        }
    }
}
