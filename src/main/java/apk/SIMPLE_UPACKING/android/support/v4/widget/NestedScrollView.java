package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bi;
import android.support.v4.p002h.bj;
import android.support.v4.p002h.bk;
import android.support.v4.p002h.bl;
import android.support.v4.p002h.bn;
import android.support.v4.p002h.bp;
import android.support.v4.p002h.bu;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

public class NestedScrollView extends FrameLayout implements bi, bk, bn {
    private static final ad f968v;
    private static final int[] f969w;
    private ae f970A;
    private long f971a;
    private final Rect f972b;
    private as f973c;
    private EdgeEffectCompat f974d;
    private EdgeEffectCompat f975e;
    private int f976f;
    private boolean f977g;
    private boolean f978h;
    private View f979i;
    private boolean f980j;
    private VelocityTracker f981k;
    private boolean f982l;
    private boolean f983m;
    private int f984n;
    private int f985o;
    private int f986p;
    private int f987q;
    private final int[] f988r;
    private final int[] f989s;
    private int f990t;
    private SavedState f991u;
    private final bl f992x;
    private final bj f993y;
    private float f994z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        public int f967a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f967a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f967a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f967a + "}";
        }

        static {
            CREATOR = new af();
        }
    }

    static {
        f968v = new ad();
        f969w = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f972b = new Rect();
        this.f977g = true;
        this.f978h = false;
        this.f979i = null;
        this.f980j = false;
        this.f983m = true;
        this.f987q = -1;
        this.f988r = new int[2];
        this.f989s = new int[2];
        m2426a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f969w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f992x = new bl(this);
        this.f993y = new bj(this);
        setNestedScrollingEnabled(true);
        bu.m1929a((View) this, f968v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f993y.m1893a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f993y.m1894a();
    }

    public boolean startNestedScroll(int i) {
        return this.f993y.m1897a(i);
    }

    public void stopNestedScroll() {
        this.f993y.m1901c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f993y.m1900b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f993y.m1898a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f993y.m1899a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f993y.m1896a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f993y.m1895a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f992x.m1904a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f992x.m1903a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2442f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f992x.m1902a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m2426a() {
        this.f973c = as.m2533a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f984n = viewConfiguration.getScaledTouchSlop();
        this.f985o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f986p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(ae aeVar) {
        this.f970A = aeVar;
    }

    private boolean m2435b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f982l) {
            this.f982l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f983m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f970A != null) {
            this.f970A.m2494a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f982l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2448a(keyEvent);
    }

    public boolean m2448a(KeyEvent keyEvent) {
        int i = 33;
        this.f972b.setEmpty();
        if (m2435b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case R.Toolbar_collapseContentDescription /*19*/:
                    if (keyEvent.isAltPressed()) {
                        return m2450b(33);
                    }
                    return m2451c(33);
                case R.Toolbar_navigationIcon /*20*/:
                    if (keyEvent.isAltPressed()) {
                        return m2450b(130);
                    }
                    return m2451c(130);
                case R.AppCompatTheme_editTextColor /*62*/:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2446a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m2437c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m2436c() {
        if (this.f981k == null) {
            this.f981k = VelocityTracker.obtain();
        } else {
            this.f981k.clear();
        }
    }

    private void m2438d() {
        if (this.f981k == null) {
            this.f981k = VelocityTracker.obtain();
        }
    }

    private void m2439e() {
        if (this.f981k != null) {
            this.f981k.recycle();
            this.f981k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2439e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f980j) {
            return true;
        }
        switch (action & 255) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                action = (int) motionEvent.getY();
                if (!m2437c((int) motionEvent.getX(), action)) {
                    this.f980j = false;
                    m2439e();
                    break;
                }
                this.f976f = action;
                this.f987q = az.m1828b(motionEvent, 0);
                m2436c();
                this.f981k.addMovement(motionEvent);
                this.f973c.m2545g();
                if (!this.f973c.m2538a()) {
                    z = true;
                }
                this.f980j = z;
                startNestedScroll(2);
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f980j = false;
                this.f987q = -1;
                m2439e();
                if (this.f973c.m2539a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bu.m1943d(this);
                }
                stopNestedScroll();
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                action = this.f987q;
                if (action != -1) {
                    int a = az.m1826a(motionEvent, action);
                    if (a != -1) {
                        action = (int) az.m1831d(motionEvent, a);
                        if (Math.abs(action - this.f976f) > this.f984n && (getNestedScrollAxes() & 2) == 0) {
                            this.f980j = true;
                            this.f976f = action;
                            m2438d();
                            this.f981k.addMovement(motionEvent);
                            this.f990t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                m2427a(motionEvent);
                break;
        }
        return this.f980j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2438d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = az.m1825a(motionEvent);
        if (a == 0) {
            this.f990t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f990t);
        switch (a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                if (getChildCount() != 0) {
                    boolean z = !this.f973c.m2538a();
                    this.f980j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f973c.m2538a()) {
                        this.f973c.m2546h();
                    }
                    this.f976f = (int) motionEvent.getY();
                    this.f987q = az.m1828b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (this.f980j) {
                    VelocityTracker velocityTracker = this.f981k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f986p);
                    a = (int) bp.m1906b(velocityTracker, this.f987q);
                    if (Math.abs(a) > this.f985o) {
                        m2442f(-a);
                    } else if (this.f973c.m2539a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        bu.m1943d(this);
                    }
                }
                this.f987q = -1;
                m2441f();
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                int a2 = az.m1826a(motionEvent, this.f987q);
                if (a2 != -1) {
                    int i;
                    int d = (int) az.m1831d(motionEvent, a2);
                    a = this.f976f - d;
                    if (dispatchNestedPreScroll(0, a, this.f989s, this.f988r)) {
                        a -= this.f989s[1];
                        obtain.offsetLocation(0.0f, (float) this.f988r[1]);
                        this.f990t += this.f988r[1];
                    }
                    if (this.f980j || Math.abs(a) <= this.f984n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f980j = true;
                        if (a > 0) {
                            i = a - this.f984n;
                        } else {
                            i = a + this.f984n;
                        }
                    }
                    if (this.f980j) {
                        Object obj;
                        this.f976f = d - this.f988r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = bu.m1921a(this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m2447a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f981k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f988r)) {
                            if (obj != null) {
                                m2443g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f974d.m2679a(((float) i) / ((float) getHeight()), az.m1829c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f975e.m2678a()) {
                                        this.f975e.m2682b();
                                    }
                                } else if (a > scrollRange) {
                                    this.f975e.m2679a(((float) i) / ((float) getHeight()), 1.0f - (az.m1829c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f974d.m2678a()) {
                                        this.f974d.m2682b();
                                    }
                                }
                                if (!(this.f974d == null || (this.f974d.m2678a() && this.f975e.m2678a()))) {
                                    bu.m1943d(this);
                                    break;
                                }
                            }
                        }
                        this.f976f -= this.f988r[1];
                        obtain.offsetLocation(0.0f, (float) this.f988r[1]);
                        this.f990t += this.f988r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f987q + " in onTouchEvent");
                break;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (this.f980j && getChildCount() > 0 && this.f973c.m2539a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    bu.m1943d(this);
                }
                this.f987q = -1;
                m2441f();
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                a = az.m1827b(motionEvent);
                this.f976f = (int) az.m1831d(motionEvent, a);
                this.f987q = az.m1828b(motionEvent, a);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                m2427a(motionEvent);
                this.f976f = (int) az.m1831d(motionEvent, az.m1826a(motionEvent, this.f987q));
                break;
        }
        if (this.f981k != null) {
            this.f981k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m2427a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (az.m1828b(motionEvent, action) == this.f987q) {
            action = action == 0 ? 1 : 0;
            this.f976f = (int) az.m1831d(motionEvent, action);
            this.f987q = az.m1828b(motionEvent, action);
            if (this.f981k != null) {
                this.f981k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((az.m1832d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                if (this.f980j) {
                    return false;
                }
                float e = az.m1833e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f994z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f994z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f994z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m2447a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = bu.m1921a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f973c.m2539a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m2425a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m2446a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f972b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f972b.top + height > childAt.getBottom()) {
                    this.f972b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f972b.top = getScrollY() - height;
            if (this.f972b.top < 0) {
                this.f972b.top = 0;
            }
        }
        this.f972b.bottom = this.f972b.top + height;
        return m2428a(i, this.f972b.top, this.f972b.bottom);
    }

    public boolean m2450b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f972b.top = 0;
        this.f972b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f972b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f972b.top = this.f972b.bottom - height;
            }
        }
        return m2428a(i, this.f972b.top, this.f972b.bottom);
    }

    private boolean m2428a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2425a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2440e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m2451c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2431a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2440e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f972b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f972b);
            m2440e(m2444a(this.f972b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2430a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m2430a(View view) {
        return !m2431a(view, 0, getHeight());
    }

    private boolean m2431a(View view, int i, int i2) {
        view.getDrawingRect(this.f972b);
        offsetDescendantRectToMyCoords(view, this.f972b);
        return this.f972b.bottom + i >= getScrollY() && this.f972b.top - i <= getScrollY() + i2;
    }

    private void m2440e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f983m) {
            m2445a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m2445a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f971a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f973c.m2534a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                bu.m1943d(this);
            } else {
                if (!this.f973c.m2538a()) {
                    this.f973c.m2546h();
                }
                scrollBy(i, i2);
            }
            this.f971a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m2449b(int i, int i2) {
        m2445a(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f973c.m2545g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f973c.m2540b();
            int c = this.f973c.m2541c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = bu.m1921a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2447a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2443g();
                    if (c <= 0 && scrollY > 0) {
                        this.f974d.m2680a((int) this.f973c.m2544f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f975e.m2680a((int) this.f973c.m2544f());
                    }
                }
            }
        }
    }

    private void m2434b(View view) {
        view.getDrawingRect(this.f972b);
        offsetDescendantRectToMyCoords(view, this.f972b);
        int a = m2444a(this.f972b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2429a(Rect rect, boolean z) {
        int a = m2444a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2445a(0, a);
            }
        }
        return z2;
    }

    protected int m2444a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f977g) {
            this.f979i = view2;
        } else {
            m2434b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || m2430a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2429a(rect, z);
    }

    public void requestLayout() {
        this.f977g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f977g = false;
        if (this.f979i != null && m2432a(this.f979i, (View) this)) {
            m2434b(this.f979i);
        }
        this.f979i = null;
        if (!this.f978h) {
            if (this.f991u != null) {
                scrollTo(getScrollX(), this.f991u.f967a);
                this.f991u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f978h = true;
    }

    public void onAttachedToWindow() {
        this.f978h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2431a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f972b);
            offsetDescendantRectToMyCoords(findFocus, this.f972b);
            m2440e(m2444a(this.f972b));
        }
    }

    private static boolean m2432a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2432a((View) parent, view2);
        return z;
    }

    public void m2452d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f973c.m2537a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            bu.m1943d(this);
        }
    }

    private void m2442f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2452d(i);
            }
        }
    }

    private void m2441f() {
        this.f980j = false;
        m2439e();
        stopNestedScroll();
        if (this.f974d != null) {
            this.f974d.m2682b();
            this.f975e.m2682b();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2433b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2433b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m2443g() {
        if (bu.m1921a(this) == 2) {
            this.f974d = null;
            this.f975e = null;
        } else if (this.f974d == null) {
            Context context = getContext();
            this.f974d = new EdgeEffectCompat(context);
            this.f975e = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f974d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f974d.m2678a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f974d.m2677a(width, getHeight());
                if (this.f974d.m2681a(canvas)) {
                    bu.m1943d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f975e.m2678a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f975e.m2677a(width, height);
                if (this.f975e.m2681a(canvas)) {
                    bu.m1943d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m2433b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f991u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f967a = getScrollY();
        return savedState;
    }
}
