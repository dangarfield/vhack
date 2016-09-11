package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bi;
import android.support.v4.p002h.bj;
import android.support.v4.p002h.bn;
import android.support.v4.p002h.bp;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.ct;
import android.support.v4.p002h.p015a.AccessibilityEventCompat;
import android.support.v4.p005e.TraceCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.p019d.R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements bi, bn {
    private static final Interpolator ao;
    private static final boolean f117j;
    private static final Class[] f118k;
    private boolean f119A;
    private boolean f120B;
    private int f121C;
    private boolean f122D;
    private final boolean f123E;
    private final AccessibilityManager f124F;
    private List f125G;
    private boolean f126H;
    private int f127I;
    private EdgeEffectCompat f128J;
    private EdgeEffectCompat f129K;
    private EdgeEffectCompat f130L;
    private EdgeEffectCompat f131M;
    private int f132N;
    private int f133O;
    private VelocityTracker f134P;
    private int f135Q;
    private int f136R;
    private int f137S;
    private int f138T;
    private int f139U;
    private final int f140V;
    private final int f141W;
    final ep f142a;
    private float aa;
    private final ex ab;
    private en ac;
    private List ad;
    private ee ae;
    private boolean af;
    private ez ag;
    private eb ah;
    private final int[] ai;
    private final bj aj;
    private final int[] ak;
    private final int[] al;
    private final int[] am;
    private Runnable an;
    private final go ap;
    ai f143b;
    bt f144c;
    final gm f145d;
    ei f146e;
    ec f147f;
    final ev f148g;
    boolean f149h;
    boolean f150i;
    private final er f151l;
    private SavedState f152m;
    private boolean f153n;
    private final Runnable f154o;
    private final Rect f155p;
    private dy f156q;
    private eq f157r;
    private final ArrayList f158s;
    private final ArrayList f159t;
    private em f160u;
    private boolean f161v;
    private boolean f162w;
    private boolean f163x;
    private int f164y;
    private boolean f165z;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        Parcelable f1709a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1709a = parcel.readParcelable(ei.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1709a, 0);
        }

        private void m3716a(SavedState savedState) {
            this.f1709a = savedState.f1709a;
        }

        static {
            CREATOR = new es();
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = false;
        }
        f117j = z;
        f118k = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        ao = new du();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.f151l = new er();
        this.f142a = new ep(this);
        this.f145d = new gm();
        this.f154o = new ds(this);
        this.f155p = new Rect();
        this.f158s = new ArrayList();
        this.f159t = new ArrayList();
        this.f164y = 0;
        this.f126H = false;
        this.f127I = 0;
        this.f147f = new bz();
        this.f132N = 0;
        this.f133O = -1;
        this.aa = Float.MIN_VALUE;
        this.ab = new ex(this);
        this.f148g = new ev();
        this.f149h = false;
        this.f150i = false;
        this.ae = new eg();
        this.af = false;
        this.ai = new int[2];
        this.ak = new int[2];
        this.al = new int[2];
        this.am = new int[2];
        this.an = new dt(this);
        this.ap = new dv(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f123E = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f139U = viewConfiguration.getScaledTouchSlop();
        this.f140V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f141W = viewConfiguration.getScaledMaximumFlingVelocity();
        if (bu.m1921a(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.f147f.m4149a(this.ae);
        m177a();
        m166s();
        if (bu.m1946e(this) == 0) {
            bu.m1940c((View) this, 1);
        }
        this.f124F = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ez(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(R.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            m112a(context, string, attributeSet, i, 0);
        }
        this.aj = new bj(this);
        setNestedScrollingEnabled(true);
    }

    public ez getCompatAccessibilityDelegate() {
        return this.ag;
    }

    public void setAccessibilityDelegateCompat(ez ezVar) {
        this.ag = ezVar;
        bu.m1929a((View) this, this.ag);
    }

    private void m112a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m109a(context, trim);
                try {
                    ClassLoader classLoader;
                    Object[] objArr;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(a).asSubclass(ei.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(f118k);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((ei) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private String m109a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void m166s() {
        this.f144c = new bt(new dw(this));
    }

    void m177a() {
        this.f143b = new ai(new dx(this));
    }

    public void setHasFixedSize(boolean z) {
        this.f162w = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f153n) {
            m206h();
        }
        this.f153n = z;
        super.setClipToPadding(z);
        if (this.f163x) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f139U = ct.m2231a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f139U = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(dy dyVar) {
        setLayoutFrozen(false);
        m119a(dyVar, false, true);
        requestLayout();
    }

    private void m119a(dy dyVar, boolean z, boolean z2) {
        if (this.f156q != null) {
            this.f156q.m4377b(this.f151l);
            this.f156q.m4376b(this);
        }
        if (!z || z2) {
            if (this.f147f != null) {
                this.f147f.m4155c();
            }
            if (this.f146e != null) {
                this.f146e.m3559c(this.f142a);
                this.f146e.m3548b(this.f142a);
            }
            this.f142a.m4416a();
        }
        this.f143b.m3927a();
        dy dyVar2 = this.f156q;
        this.f156q = dyVar;
        if (dyVar != null) {
            dyVar.m4370a(this.f151l);
            dyVar.m4369a(this);
        }
        if (this.f146e != null) {
            this.f146e.m3514a(dyVar2, this.f156q);
        }
        this.f142a.m4419a(dyVar2, this.f156q, z);
        this.f148g.f2181g = true;
        m214o();
    }

    public dy getAdapter() {
        return this.f156q;
    }

    public void setRecyclerListener(eq eqVar) {
        this.f157r = eqVar;
    }

    public int getBaseline() {
        if (this.f146e != null) {
            return this.f146e.m3602r();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(ei eiVar) {
        if (eiVar != this.f146e) {
            m190c();
            if (this.f146e != null) {
                if (this.f161v) {
                    this.f146e.m3547b(this, this.f142a);
                }
                this.f146e.m3545b(null);
            }
            this.f142a.m4416a();
            this.f144c.m4080a();
            this.f146e = eiVar;
            if (eiVar != null) {
                if (eiVar.f1682q != null) {
                    throw new IllegalArgumentException("LayoutManager " + eiVar + " is already attached to a RecyclerView: " + eiVar.f1682q);
                }
                this.f146e.m3545b(this);
                if (this.f161v) {
                    this.f146e.m3557c(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f152m != null) {
            savedState.m3716a(this.f152m);
        } else if (this.f146e != null) {
            savedState.f1709a = this.f146e.m3554c();
        } else {
            savedState.f1709a = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.f152m = (SavedState) parcelable;
        super.onRestoreInstanceState(this.f152m.getSuperState());
        if (this.f146e != null && this.f152m.f1709a != null) {
            this.f146e.m3507a(this.f152m.f1709a);
        }
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void m133b(ey eyVar) {
        View view = eyVar.f2195a;
        boolean z = view.getParent() == this;
        this.f142a.m4437d(m176a(view));
        if (eyVar.m4538r()) {
            this.f144c.m4083a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f144c.m4093d(view);
        } else {
            this.f144c.m4085a(view, true);
        }
    }

    private boolean m151h(View view) {
        m187b();
        boolean f = this.f144c.m4095f(view);
        if (f) {
            ey c = m138c(view);
            this.f142a.m4437d(c);
            this.f142a.m4428b(c);
        }
        m183a(!f);
        return f;
    }

    public ei getLayoutManager() {
        return this.f146e;
    }

    public eo getRecycledViewPool() {
        return this.f142a.m4441f();
    }

    public void setRecycledViewPool(eo eoVar) {
        this.f142a.m4420a(eoVar);
    }

    public void setViewCacheExtension(ew ewVar) {
        this.f142a.m4421a(ewVar);
    }

    public void setItemViewCacheSize(int i) {
        this.f142a.m4417a(i);
    }

    public int getScrollState() {
        return this.f132N;
    }

    private void setScrollState(int i) {
        if (i != this.f132N) {
            this.f132N = i;
            if (i != 2) {
                m169v();
            }
            m195d(i);
        }
    }

    public void setChildDrawingOrderCallback(eb ebVar) {
        if (ebVar != this.ah) {
            this.ah = ebVar;
            setChildrenDrawingOrderEnabled(this.ah != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(en enVar) {
        this.ac = enVar;
    }

    private void m146e(int i) {
        if (this.f146e != null) {
            this.f146e.m3568d(i);
            awakenScrollBars();
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f119A) {
            boolean d = this.f146e.m3571d();
            boolean e = this.f146e.m3575e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                m184a(i, i2, null);
            }
        }
    }

    private void m167t() {
        if (!this.f163x) {
            return;
        }
        if (this.f126H) {
            TraceCompat.m1435a("RV FullInvalidate");
            m210k();
            TraceCompat.m1434a();
        } else if (!this.f143b.m3936d()) {
        } else {
            if (this.f143b.m3931a(4) && !this.f143b.m3931a(11)) {
                TraceCompat.m1435a("RV PartialInvalidate");
                m187b();
                this.f143b.m3933b();
                if (!this.f165z) {
                    if (m168u()) {
                        m210k();
                    } else {
                        this.f143b.m3935c();
                    }
                }
                m183a(true);
                TraceCompat.m1434a();
            } else if (this.f143b.m3936d()) {
                TraceCompat.m1435a("RV FullInvalidate");
                m210k();
                TraceCompat.m1434a();
            }
        }
    }

    private boolean m168u() {
        int b = this.f144c.m4086b();
        for (int i = 0; i < b; i++) {
            ey c = m138c(this.f144c.m4088b(i));
            if (c != null && !c.m4523c() && c.m4544x()) {
                return true;
            }
        }
        return false;
    }

    boolean m184a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        m167t();
        if (this.f156q != null) {
            int b;
            m187b();
            m173z();
            TraceCompat.m1435a("RV Scroll");
            if (i != 0) {
                a = this.f146e.m3498a(i, this.f142a, this.f148g);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f146e.m3541b(i2, this.f142a, this.f148g);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            TraceCompat.m1434a();
            m108I();
            m100A();
            m183a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.f158s.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.ak)) {
            this.f137S -= this.ak[0];
            this.f138T -= this.ak[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.ak[0], (float) this.ak[1]);
            }
            int[] iArr = this.am;
            iArr[0] = iArr[0] + this.ak[0];
            iArr = this.am;
            iArr[1] = iArr[1] + this.ak[1];
        } else if (bu.m1921a(this) != 2) {
            if (motionEvent != null) {
                m110a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            m152i(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            m207h(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && a == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f146e != null && this.f146e.m3571d()) {
            return this.f146e.m3543b(this.f148g);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f146e != null && this.f146e.m3571d()) {
            return this.f146e.m3565d(this.f148g);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f146e != null && this.f146e.m3571d()) {
            return this.f146e.m3577f(this.f148g);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f146e != null && this.f146e.m3575e()) {
            return this.f146e.m3553c(this.f148g);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f146e != null && this.f146e.m3575e()) {
            return this.f146e.m3572e(this.f148g);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f146e != null && this.f146e.m3575e()) {
            return this.f146e.m3581g(this.f148g);
        }
        return 0;
    }

    void m187b() {
        this.f164y++;
        if (this.f164y == 1 && !this.f119A) {
            this.f165z = false;
        }
    }

    void m183a(boolean z) {
        if (this.f164y < 1) {
            this.f164y = 1;
        }
        if (!z) {
            this.f165z = false;
        }
        if (this.f164y == 1) {
            if (!(!z || !this.f165z || this.f119A || this.f146e == null || this.f156q == null)) {
                m210k();
            }
            if (!this.f119A) {
                this.f165z = false;
            }
        }
        this.f164y--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f119A) {
            m182a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f119A = true;
                this.f120B = true;
                m190c();
                return;
            }
            this.f119A = false;
            if (!(!this.f165z || this.f146e == null || this.f156q == null)) {
                requestLayout();
            }
            this.f165z = false;
        }
    }

    public void m179a(int i, int i2) {
        int i3 = 0;
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f119A) {
            if (!this.f146e.m3571d()) {
                i = 0;
            }
            if (this.f146e.m3575e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ab.m4499b(i, i3);
            }
        }
    }

    public boolean m189b(int i, int i2) {
        if (this.f146e == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f119A) {
            return false;
        } else {
            boolean d = this.f146e.m3571d();
            boolean e = this.f146e.m3575e();
            if (!d || Math.abs(i) < this.f140V) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.f140V) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (!d) {
                return false;
            }
            this.ab.m4494a(Math.max(-this.f141W, Math.min(i, this.f141W)), Math.max(-this.f141W, Math.min(i2, this.f141W)));
            return true;
        }
    }

    public void m190c() {
        setScrollState(0);
        m169v();
    }

    private void m169v() {
        this.ab.m4498b();
        if (this.f146e != null) {
            this.f146e.m3495E();
        }
    }

    public int getMinFlingVelocity() {
        return this.f140V;
    }

    public int getMaxFlingVelocity() {
        return this.f141W;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m110a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m194d();
        r2 = r7.f128J;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m2679a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m200f();
        r2 = r7.f129K;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m2679a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.p002h.bu.m1943d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m197e();
        r2 = r7.f130L;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m2679a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m204g();
        r2 = r7.f131M;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m2679a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m170w() {
        int i = 0;
        if (this.f128J != null) {
            i = this.f128J.m2682b();
        }
        if (this.f129K != null) {
            i |= this.f129K.m2682b();
        }
        if (this.f130L != null) {
            i |= this.f130L.m2682b();
        }
        if (this.f131M != null) {
            i |= this.f131M.m2682b();
        }
        if (i != 0) {
            bu.m1943d(this);
        }
    }

    private void m152i(int i, int i2) {
        int i3 = 0;
        if (!(this.f128J == null || this.f128J.m2678a() || i <= 0)) {
            i3 = this.f128J.m2682b();
        }
        if (!(this.f130L == null || this.f130L.m2678a() || i >= 0)) {
            i3 |= this.f130L.m2682b();
        }
        if (!(this.f129K == null || this.f129K.m2678a() || i2 <= 0)) {
            i3 |= this.f129K.m2682b();
        }
        if (!(this.f131M == null || this.f131M.m2678a() || i2 >= 0)) {
            i3 |= this.f131M.m2682b();
        }
        if (i3 != 0) {
            bu.m1943d(this);
        }
    }

    void m192c(int i, int i2) {
        if (i < 0) {
            m194d();
            this.f128J.m2680a(-i);
        } else if (i > 0) {
            m197e();
            this.f130L.m2680a(i);
        }
        if (i2 < 0) {
            m200f();
            this.f129K.m2680a(-i2);
        } else if (i2 > 0) {
            m204g();
            this.f131M.m2680a(i2);
        }
        if (i != 0 || i2 != 0) {
            bu.m1943d(this);
        }
    }

    void m194d() {
        if (this.f128J == null) {
            this.f128J = new EdgeEffectCompat(getContext());
            if (this.f153n) {
                this.f128J.m2677a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f128J.m2677a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m197e() {
        if (this.f130L == null) {
            this.f130L = new EdgeEffectCompat(getContext());
            if (this.f153n) {
                this.f130L.m2677a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f130L.m2677a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m200f() {
        if (this.f129K == null) {
            this.f129K = new EdgeEffectCompat(getContext());
            if (this.f153n) {
                this.f129K.m2677a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f129K.m2677a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m204g() {
        if (this.f131M == null) {
            this.f131M = new EdgeEffectCompat(getContext());
            if (this.f153n) {
                this.f131M.m2677a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f131M.m2677a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m206h() {
        this.f131M = null;
        this.f129K = null;
        this.f130L = null;
        this.f128J = null;
    }

    public View focusSearch(View view, int i) {
        View d = this.f146e.m3567d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(d != null || this.f156q == null || this.f146e == null || m209j() || this.f119A)) {
            m187b();
            d = this.f146e.m3503a(view, i, this.f142a, this.f148g);
            m183a(false);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f146e.m3531a(this, this.f148g, view, view2) || view2 == null)) {
            Rect rect;
            boolean z;
            this.f155p.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ek) {
                ek ekVar = (ek) layoutParams;
                if (!ekVar.f2068c) {
                    Rect rect2 = ekVar.f2067b;
                    rect = this.f155p;
                    rect.left -= rect2.left;
                    rect = this.f155p;
                    rect.right += rect2.right;
                    rect = this.f155p;
                    rect.top -= rect2.top;
                    rect = this.f155p;
                    rect.bottom = rect2.bottom + rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f155p);
            offsetRectIntoDescendantCoords(view, this.f155p);
            rect = this.f155p;
            if (this.f163x) {
                z = false;
            } else {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f146e.m3532a(this, view, rect, z);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (this.f146e == null || !this.f146e.m3534a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f127I = 0;
        this.f161v = true;
        this.f163x = false;
        if (this.f146e != null) {
            this.f146e.m3557c(this);
        }
        this.af = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f147f != null) {
            this.f147f.m4155c();
        }
        this.f163x = false;
        m190c();
        this.f161v = false;
        if (this.f146e != null) {
            this.f146e.m3547b(this, this.f142a);
        }
        removeCallbacks(this.an);
        this.f145d.m4735b();
    }

    public boolean isAttachedToWindow() {
        return this.f161v;
    }

    void m182a(String str) {
        if (!m209j()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    private boolean m127a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f160u = null;
        }
        int size = this.f159t.size();
        int i = 0;
        while (i < size) {
            em emVar = (em) this.f159t.get(i);
            if (!emVar.m4398a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f160u = emVar;
                return true;
            }
        }
        return false;
    }

    private boolean m137b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f160u != null) {
            if (action == 0) {
                this.f160u = null;
            } else {
                this.f160u.m4399b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f160u = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f159t.size();
            for (int i = 0; i < size; i++) {
                em emVar = (em) this.f159t.get(i);
                if (emVar.m4398a(this, motionEvent)) {
                    this.f160u = emVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.f119A) {
            return false;
        }
        if (m127a(motionEvent)) {
            m172y();
            return true;
        } else if (this.f146e == null) {
            return false;
        } else {
            boolean d = this.f146e.m3571d();
            boolean e = this.f146e.m3575e();
            if (this.f134P == null) {
                this.f134P = VelocityTracker.obtain();
            }
            this.f134P.addMovement(motionEvent);
            int a = az.m1825a(motionEvent);
            int b = az.m1827b(motionEvent);
            int i2;
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    if (this.f120B) {
                        this.f120B = false;
                    }
                    this.f133O = az.m1828b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.f137S = i;
                    this.f135Q = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.f138T = i;
                    this.f136R = i;
                    if (this.f132N == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.am;
                    this.am[1] = 0;
                    iArr[0] = 0;
                    if (d) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    this.f134P.clear();
                    stopNestedScroll();
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    a = az.m1826a(motionEvent, this.f133O);
                    if (a >= 0) {
                        b = (int) (az.m1829c(motionEvent, a) + 0.5f);
                        a = (int) (az.m1831d(motionEvent, a) + 0.5f);
                        if (this.f132N != 1) {
                            b -= this.f135Q;
                            a -= this.f136R;
                            if (!d || Math.abs(b) <= this.f139U) {
                                d = false;
                            } else {
                                this.f137S = ((b < 0 ? -1 : 1) * this.f139U) + this.f135Q;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.f139U) {
                                i2 = this.f136R;
                                int i3 = this.f139U;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.f138T = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f133O + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    m172y();
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    this.f133O = az.m1828b(motionEvent, b);
                    i2 = (int) (az.m1829c(motionEvent, b) + 0.5f);
                    this.f137S = i2;
                    this.f135Q = i2;
                    i2 = (int) (az.m1831d(motionEvent, b) + 0.5f);
                    this.f138T = i2;
                    this.f136R = i2;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    m141c(motionEvent);
                    break;
            }
            if (this.f132N != 1) {
                z = false;
            }
            return z;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f159t.size();
        for (int i = 0; i < size; i++) {
            ((em) this.f159t.get(i)).m4397a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f119A || this.f120B) {
            return false;
        }
        if (m137b(motionEvent)) {
            m172y();
            return true;
        } else if (this.f146e == null) {
            return false;
        } else {
            boolean d = this.f146e.m3571d();
            boolean e = this.f146e.m3575e();
            if (this.f134P == null) {
                this.f134P = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = az.m1825a(motionEvent);
            int b = az.m1827b(motionEvent);
            if (a == 0) {
                int[] iArr = this.am;
                this.am[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    this.f133O = az.m1828b(motionEvent, 0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.f137S = a;
                    this.f135Q = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.f138T = a;
                    this.f136R = a;
                    if (d) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    this.f134P.addMovement(obtain);
                    this.f134P.computeCurrentVelocity(1000, (float) this.f141W);
                    float f = d ? -bp.m1905a(this.f134P, this.f133O) : 0.0f;
                    float f2;
                    if (e) {
                        f2 = -bp.m1906b(this.f134P, this.f133O);
                    } else {
                        f2 = 0.0f;
                    }
                    if ((f == 0.0f && r0 == 0.0f) || !m189b((int) f, (int) r0)) {
                        setScrollState(0);
                    }
                    m171x();
                    z = true;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    a = az.m1826a(motionEvent, this.f133O);
                    if (a >= 0) {
                        int c = (int) (az.m1829c(motionEvent, a) + 0.5f);
                        int d2 = (int) (az.m1831d(motionEvent, a) + 0.5f);
                        int i = this.f137S - c;
                        a = this.f138T - d2;
                        if (dispatchNestedPreScroll(i, a, this.al, this.ak)) {
                            i -= this.al[0];
                            a -= this.al[1];
                            obtain.offsetLocation((float) this.ak[0], (float) this.ak[1]);
                            int[] iArr2 = this.am;
                            iArr2[0] = iArr2[0] + this.ak[0];
                            iArr2 = this.am;
                            iArr2[1] = iArr2[1] + this.ak[1];
                        }
                        if (this.f132N != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.f139U) {
                                z2 = false;
                            } else {
                                if (i > 0) {
                                    i -= this.f139U;
                                } else {
                                    i += this.f139U;
                                }
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.f139U) {
                                if (a > 0) {
                                    a -= this.f139U;
                                } else {
                                    a += this.f139U;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.f132N == 1) {
                            this.f137S = c - this.ak[0];
                            this.f138T = d2 - this.ak[1];
                            if (!d) {
                                i = 0;
                            }
                            if (!e) {
                                a = 0;
                            }
                            if (m184a(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f133O + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    m172y();
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    this.f133O = az.m1828b(motionEvent, b);
                    a = (int) (az.m1829c(motionEvent, b) + 0.5f);
                    this.f137S = a;
                    this.f135Q = a;
                    a = (int) (az.m1831d(motionEvent, b) + 0.5f);
                    this.f138T = a;
                    this.f136R = a;
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    m141c(motionEvent);
                    break;
            }
            if (!z) {
                this.f134P.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void m171x() {
        if (this.f134P != null) {
            this.f134P.clear();
        }
        stopNestedScroll();
        m170w();
    }

    private void m172y() {
        m171x();
        setScrollState(0);
    }

    private void m141c(MotionEvent motionEvent) {
        int b = az.m1827b(motionEvent);
        if (az.m1828b(motionEvent, b) == this.f133O) {
            b = b == 0 ? 1 : 0;
            this.f133O = az.m1828b(motionEvent, b);
            int c = (int) (az.m1829c(motionEvent, b) + 0.5f);
            this.f137S = c;
            this.f135Q = c;
            b = (int) (az.m1831d(motionEvent, b) + 0.5f);
            this.f138T = b;
            this.f136R = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f146e == null || this.f119A || (az.m1832d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f146e.m3575e()) {
                f = -az.m1833e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f146e.m3571d()) {
                e = az.m1833e(motionEvent, 10);
            } else {
                e = 0.0f;
            }
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m184a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.aa == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.aa = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.aa;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f146e == null) {
            m196d(i, i2);
        } else if (this.f146e.f1677b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f146e.m3516a(this.f142a, this.f148g, i, i2);
            if (!z && this.f156q != null) {
                if (this.f148g.f2177c == 1) {
                    m105F();
                }
                this.f146e.m3504a(i, i2);
                this.f148g.f2186l = true;
                m106G();
                this.f146e.m3544b(i, i2);
                if (this.f146e.m3590j()) {
                    this.f146e.m3504a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f148g.f2186l = true;
                    m106G();
                    this.f146e.m3544b(i, i2);
                }
            }
        } else if (this.f162w) {
            this.f146e.m3516a(this.f142a, this.f148g, i, i2);
        } else {
            if (this.f122D) {
                m187b();
                m104E();
                if (this.f148g.f2184j) {
                    this.f148g.f2182h = true;
                } else {
                    this.f143b.m3937e();
                    this.f148g.f2182h = false;
                }
                this.f122D = false;
                m183a(false);
            }
            if (this.f156q != null) {
                this.f148g.f2175a = this.f156q.m4366a();
            } else {
                this.f148g.f2175a = 0;
            }
            m187b();
            this.f146e.m3516a(this.f142a, this.f148g, i, i2);
            m183a(false);
            this.f148g.f2182h = false;
        }
    }

    void m196d(int i, int i2) {
        setMeasuredDimension(ei.m3479a(i, getPaddingLeft() + getPaddingRight(), bu.m1958o(this)), ei.m3479a(i2, getPaddingTop() + getPaddingBottom(), bu.m1959p(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m206h();
        }
    }

    public void setItemAnimator(ec ecVar) {
        if (this.f147f != null) {
            this.f147f.m4155c();
            this.f147f.m4149a(null);
        }
        this.f147f = ecVar;
        if (this.f147f != null) {
            this.f147f.m4149a(this.ae);
        }
    }

    private void m173z() {
        this.f127I++;
    }

    private void m100A() {
        this.f127I--;
        if (this.f127I < 1) {
            this.f127I = 0;
            m101B();
        }
    }

    boolean m208i() {
        return this.f124F != null && this.f124F.isEnabled();
    }

    private void m101B() {
        int i = this.f121C;
        this.f121C = 0;
        if (i != 0 && m208i()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.m1547a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean m209j() {
        return this.f127I > 0;
    }

    boolean m185a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m209j()) {
            return false;
        }
        int b;
        if (accessibilityEvent != null) {
            b = AccessibilityEventCompat.m1548b(accessibilityEvent);
        } else {
            b = 0;
        }
        if (b != 0) {
            i = b;
        }
        this.f121C = i | this.f121C;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m185a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ec getItemAnimator() {
        return this.f147f;
    }

    private void m102C() {
        if (!this.af && this.f161v) {
            bu.m1931a((View) this, this.an);
            this.af = true;
        }
    }

    private boolean m103D() {
        return this.f147f != null && this.f146e.m3551b();
    }

    private void m104E() {
        boolean z;
        boolean z2 = true;
        if (this.f126H) {
            this.f143b.m3927a();
            m214o();
            this.f146e.m3509a(this);
        }
        if (m103D()) {
            this.f143b.m3933b();
        } else {
            this.f143b.m3937e();
        }
        boolean z3;
        if (this.f149h || this.f150i) {
            z3 = true;
        } else {
            z3 = false;
        }
        ev evVar = this.f148g;
        if (!this.f163x || this.f147f == null || (!(this.f126H || r0 || this.f146e.f1676a) || (this.f126H && !this.f156q.m4379b()))) {
            z = false;
        } else {
            z = true;
        }
        evVar.f2183i = z;
        ev evVar2 = this.f148g;
        if (!(this.f148g.f2183i && r0 && !this.f126H && m103D())) {
            z2 = false;
        }
        evVar2.f2184j = z2;
    }

    void m210k() {
        if (this.f156q == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f146e == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f148g.f2186l = false;
            if (this.f148g.f2177c == 1) {
                m105F();
                this.f146e.m3580f(this);
                m106G();
            } else if (!this.f143b.m3938f() && this.f146e.m3606v() == getWidth() && this.f146e.m3607w() == getHeight()) {
                this.f146e.m3580f(this);
            } else {
                this.f146e.m3580f(this);
                m106G();
            }
            m107H();
        }
    }

    private void m105F() {
        int b;
        int i;
        ey c;
        boolean z = true;
        this.f148g.m4482a(1);
        this.f148g.f2186l = false;
        m187b();
        this.f145d.m4729a();
        m173z();
        m104E();
        ev evVar = this.f148g;
        if (!(this.f148g.f2183i && this.f150i)) {
            z = false;
        }
        evVar.f2185k = z;
        this.f150i = false;
        this.f149h = false;
        this.f148g.f2182h = this.f148g.f2184j;
        this.f148g.f2175a = this.f156q.m4366a();
        m123a(this.ai);
        if (this.f148g.f2183i) {
            b = this.f144c.m4086b();
            for (i = 0; i < b; i++) {
                c = m138c(this.f144c.m4088b(i));
                if (!c.m4523c() && (!c.m4534n() || this.f156q.m4379b())) {
                    this.f145d.m4731a(c, this.f147f.m4147a(this.f148g, c, ec.m4145d(c), c.m4541u()));
                    if (!(!this.f148g.f2185k || !c.m4544x() || c.m4537q() || c.m4523c() || c.m4534n())) {
                        this.f145d.m4730a(m174a(c), c);
                    }
                }
            }
        }
        if (this.f148g.f2184j) {
            m212m();
            z = this.f148g.f2181g;
            this.f148g.f2181g = false;
            this.f146e.m3560c(this.f142a, this.f148g);
            this.f148g.f2181g = z;
            for (i = 0; i < this.f144c.m4086b(); i++) {
                c = m138c(this.f144c.m4088b(i));
                if (!(c.m4523c() || this.f145d.m4739d(c))) {
                    b = ec.m4145d(c);
                    boolean a = c.m4520a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    ef a2 = this.f147f.m4147a(this.f148g, c, b, c.m4541u());
                    if (a) {
                        m120a(c, a2);
                    } else {
                        this.f145d.m4736b(c, a2);
                    }
                }
            }
            m213n();
        } else {
            m213n();
        }
        m100A();
        m183a(false);
        this.f148g.f2177c = 2;
    }

    private void m106G() {
        boolean z;
        m187b();
        m173z();
        this.f148g.m4482a(6);
        this.f143b.m3937e();
        this.f148g.f2175a = this.f156q.m4366a();
        this.f148g.f2180f = 0;
        this.f148g.f2182h = false;
        this.f146e.m3560c(this.f142a, this.f148g);
        this.f148g.f2181g = false;
        this.f152m = null;
        ev evVar = this.f148g;
        if (!this.f148g.f2183i || this.f147f == null) {
            z = false;
        } else {
            z = true;
        }
        evVar.f2183i = z;
        this.f148g.f2177c = 4;
        m100A();
        m183a(false);
    }

    private void m107H() {
        this.f148g.m4482a(4);
        m187b();
        m173z();
        this.f148g.f2177c = 1;
        if (this.f148g.f2183i) {
            for (int b = this.f144c.m4086b() - 1; b >= 0; b--) {
                ey c = m138c(this.f144c.m4088b(b));
                if (!c.m4523c()) {
                    long a = m174a(c);
                    ef a2 = this.f147f.m4146a(this.f148g, c);
                    ey a3 = this.f145d.m4728a(a);
                    if (a3 == null || a3.m4523c()) {
                        this.f145d.m4738c(c, a2);
                    } else {
                        boolean a4 = this.f145d.m4733a(a3);
                        boolean a5 = this.f145d.m4733a(c);
                        if (a4 && a3 == c) {
                            this.f145d.m4738c(c, a2);
                        } else {
                            ef b2 = this.f145d.m4734b(a3);
                            this.f145d.m4738c(c, a2);
                            ef c2 = this.f145d.m4737c(c);
                            if (b2 == null) {
                                m111a(a, c, a3);
                            } else {
                                m122a(a3, c, b2, c2, a4, a5);
                            }
                        }
                    }
                }
            }
            this.f145d.m4732a(this.ap);
        }
        this.f146e.m3548b(this.f142a);
        this.f148g.f2179e = this.f148g.f2175a;
        this.f126H = false;
        this.f148g.f2183i = false;
        this.f148g.f2184j = false;
        this.f146e.f1676a = false;
        if (this.f142a.f2155d != null) {
            this.f142a.f2155d.clear();
        }
        m100A();
        m183a(false);
        this.f145d.m4729a();
        if (m157j(this.ai[0], this.ai[1])) {
            m207h(0, 0);
        }
    }

    private void m111a(long j, ey eyVar, ey eyVar2) {
        int b = this.f144c.m4086b();
        int i = 0;
        while (i < b) {
            ey c = m138c(this.f144c.m4088b(i));
            if (c == eyVar || m174a(c) != j) {
                i++;
            } else if (this.f156q == null || !this.f156q.m4379b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + c + " \n View Holder 2:" + eyVar);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + c + " \n View Holder 2:" + eyVar);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + eyVar2 + " cannot be found but it is necessary for " + eyVar);
    }

    private void m120a(ey eyVar, ef efVar) {
        eyVar.m4514a(0, 8192);
        if (this.f148g.f2185k && eyVar.m4544x() && !eyVar.m4537q() && !eyVar.m4523c()) {
            this.f145d.m4730a(m174a(eyVar), eyVar);
        }
        this.f145d.m4731a(eyVar, efVar);
    }

    private void m123a(int[] iArr) {
        int b = this.f144c.m4086b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            ey c = m138c(this.f144c.m4088b(i3));
            if (c.m4523c()) {
                i4 = i;
            } else {
                i4 = c.m4524d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m157j(int i, int i2) {
        int b = this.f144c.m4086b();
        if (b != 0) {
            for (int i3 = 0; i3 < b; i3++) {
                ey c = m138c(this.f144c.m4088b(i3));
                if (!c.m4523c()) {
                    int d = c.m4524d();
                    if (d < i || d > i2) {
                        return true;
                    }
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        ey c = m138c(view);
        if (c != null) {
            if (c.m4538r()) {
                c.m4533m();
            } else if (!c.m4523c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c);
            }
        }
        m154i(view);
        super.removeDetachedView(view, z);
    }

    long m174a(ey eyVar) {
        return this.f156q.m4379b() ? eyVar.m4527g() : (long) eyVar.f2196b;
    }

    private void m121a(ey eyVar, ef efVar, ef efVar2) {
        eyVar.m4519a(false);
        if (this.f147f.m4154b(eyVar, efVar, efVar2)) {
            m102C();
        }
    }

    private void m134b(ey eyVar, ef efVar, ef efVar2) {
        m133b(eyVar);
        eyVar.m4519a(false);
        if (this.f147f.m4150a(eyVar, efVar, efVar2)) {
            m102C();
        }
    }

    private void m122a(ey eyVar, ey eyVar2, ef efVar, ef efVar2, boolean z, boolean z2) {
        eyVar.m4519a(false);
        if (z) {
            m133b(eyVar);
        }
        if (eyVar != eyVar2) {
            if (z2) {
                m133b(eyVar2);
            }
            eyVar.f2201g = eyVar2;
            m133b(eyVar);
            this.f142a.m4437d(eyVar);
            eyVar2.m4519a(false);
            eyVar2.f2202h = eyVar;
        }
        if (this.f147f.m4151a(eyVar, eyVar2, efVar, efVar2)) {
            m102C();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.m1435a("RV OnLayout");
        m210k();
        TraceCompat.m1434a();
        this.f163x = true;
    }

    public void requestLayout() {
        if (this.f164y != 0 || this.f119A) {
            this.f165z = true;
        } else {
            super.requestLayout();
        }
    }

    void m211l() {
        int c = this.f144c.m4089c();
        for (int i = 0; i < c; i++) {
            ((ek) this.f144c.m4090c(i).getLayoutParams()).f2068c = true;
        }
        this.f142a.m4445i();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f158s.size();
        for (i = 0; i < size; i++) {
            ((eh) this.f158s.get(i)).m4394b(canvas, this, this.f148g);
        }
        if (this.f128J == null || this.f128J.m2678a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f153n ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.f128J == null || !this.f128J.m2681a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.f129K == null || this.f129K.m2678a())) {
            size = canvas.save();
            if (this.f153n) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.f129K == null || !this.f129K.m2681a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f130L == null || this.f130L.m2678a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.f153n) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.f130L == null || !this.f130L.m2681a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f131M == null || this.f131M.m2678a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f153n) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f131M != null && this.f131M.m2681a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f147f == null || this.f158s.size() <= 0 || !this.f147f.m4153b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            bu.m1943d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f158s.size();
        for (int i = 0; i < size; i++) {
            ((eh) this.f158s.get(i)).m4390a(canvas, this, this.f148g);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ek) && this.f146e.m3535a((ek) layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f146e != null) {
            return this.f146e.m3500a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f146e != null) {
            return this.f146e.m3501a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f146e != null) {
            return this.f146e.m3502a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void m212m() {
        int c = this.f144c.m4089c();
        for (int i = 0; i < c; i++) {
            ey c2 = m138c(this.f144c.m4090c(i));
            if (!c2.m4523c()) {
                c2.m4521b();
            }
        }
    }

    void m213n() {
        int c = this.f144c.m4089c();
        for (int i = 0; i < c; i++) {
            ey c2 = m138c(this.f144c.m4090c(i));
            if (!c2.m4523c()) {
                c2.m4513a();
            }
        }
        this.f142a.m4444h();
    }

    void m198e(int i, int i2) {
        int i3;
        int c = this.f144c.m4089c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            ey c2 = m138c(this.f144c.m4090c(i6));
            if (c2 != null && c2.f2196b >= r3 && c2.f2196b <= r2) {
                if (c2.f2196b == i) {
                    c2.m4516a(i2 - i, false);
                } else {
                    c2.m4516a(i3, false);
                }
                this.f148g.f2181g = true;
            }
        }
        this.f142a.m4418a(i, i2);
        requestLayout();
    }

    void m201f(int i, int i2) {
        int c = this.f144c.m4089c();
        for (int i3 = 0; i3 < c; i3++) {
            ey c2 = m138c(this.f144c.m4090c(i3));
            if (!(c2 == null || c2.m4523c() || c2.f2196b < i)) {
                c2.m4516a(i2, false);
                this.f148g.f2181g = true;
            }
        }
        this.f142a.m4426b(i, i2);
        requestLayout();
    }

    void m181a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f144c.m4089c();
        for (int i4 = 0; i4 < c; i4++) {
            ey c2 = m138c(this.f144c.m4090c(i4));
            if (!(c2 == null || c2.m4523c())) {
                if (c2.f2196b >= i3) {
                    c2.m4516a(-i2, z);
                    this.f148g.f2181g = true;
                } else if (c2.f2196b >= i) {
                    c2.m4515a(i - 1, -i2, z);
                    this.f148g.f2181g = true;
                }
            }
        }
        this.f142a.m4427b(i, i2, z);
        requestLayout();
    }

    void m180a(int i, int i2, Object obj) {
        int c = this.f144c.m4089c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f144c.m4090c(i4);
            ey c3 = m138c(c2);
            if (c3 != null && !c3.m4523c() && c3.f2196b >= i && c3.f2196b < i3) {
                c3.m4522b(2);
                c3.m4518a(obj);
                ((ek) c2.getLayoutParams()).f2068c = true;
            }
        }
        this.f142a.m4432c(i, i2);
    }

    private boolean m143c(ey eyVar) {
        return this.f147f == null || this.f147f.m4152a(eyVar, eyVar.m4541u());
    }

    void m214o() {
        int c = this.f144c.m4089c();
        for (int i = 0; i < c; i++) {
            ey c2 = m138c(this.f144c.m4090c(i));
            if (!(c2 == null || c2.m4523c())) {
                c2.m4522b(6);
            }
        }
        m211l();
        this.f142a.m4443g();
    }

    public ey m176a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m138c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View m186b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    static ey m138c(View view) {
        if (view == null) {
            return null;
        }
        return ((ek) view.getLayoutParams()).f2066a;
    }

    public int m193d(View view) {
        ey c = m138c(view);
        return c != null ? c.m4524d() : -1;
    }

    ey m175a(int i, boolean z) {
        int c = this.f144c.m4089c();
        for (int i2 = 0; i2 < c; i2++) {
            ey c2 = m138c(this.f144c.m4090c(i2));
            if (!(c2 == null || c2.m4537q())) {
                if (z) {
                    if (c2.f2196b == i) {
                        return c2;
                    }
                } else if (c2.m4524d() == i) {
                    return c2;
                }
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void m178a(int i) {
        int b = this.f144c.m4086b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f144c.m4088b(i2).offsetTopAndBottom(i);
        }
    }

    public void m199e(View view) {
    }

    public void m202f(View view) {
    }

    public void m188b(int i) {
        int b = this.f144c.m4086b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f144c.m4088b(i2).offsetLeftAndRight(i);
        }
    }

    Rect m203g(View view) {
        ek ekVar = (ek) view.getLayoutParams();
        if (!ekVar.f2068c) {
            return ekVar.f2067b;
        }
        Rect rect = ekVar.f2067b;
        rect.set(0, 0, 0, 0);
        int size = this.f158s.size();
        for (int i = 0; i < size; i++) {
            this.f155p.set(0, 0, 0, 0);
            ((eh) this.f158s.get(i)).m4392a(this.f155p, view, this, this.f148g);
            rect.left += this.f155p.left;
            rect.top += this.f155p.top;
            rect.right += this.f155p.right;
            rect.bottom += this.f155p.bottom;
        }
        ekVar.f2068c = false;
        return rect;
    }

    public void m205g(int i, int i2) {
    }

    void m207h(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m205g(i, i2);
        if (this.ac != null) {
            this.ac.m4401a(this, i, i2);
        }
        if (this.ad != null) {
            for (scrollY = this.ad.size() - 1; scrollY >= 0; scrollY--) {
                ((en) this.ad.get(scrollY)).m4401a(this, i, i2);
            }
        }
    }

    public void m191c(int i) {
    }

    void m195d(int i) {
        if (this.f146e != null) {
            this.f146e.m3592k(i);
        }
        m191c(i);
        if (this.ac != null) {
            this.ac.m4400a(this, i);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                ((en) this.ad.get(size)).m4400a(this, i);
            }
        }
    }

    public boolean m215p() {
        return !this.f163x || this.f126H || this.f143b.m3936d();
    }

    private void m108I() {
        int b = this.f144c.m4086b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f144c.m4088b(i);
            ey a = m176a(b2);
            if (!(a == null || a.f2202h == null)) {
                View view = a.f2202h.f2195a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void m154i(View view) {
        ey c = m138c(view);
        m202f(view);
        if (!(this.f156q == null || c == null)) {
            this.f156q.m4382d(c);
        }
        if (this.f125G != null) {
            for (int size = this.f125G.size() - 1; size >= 0; size--) {
                ((el) this.f125G.get(size)).m4396b(view);
            }
        }
    }

    private void m156j(View view) {
        ey c = m138c(view);
        m199e(view);
        if (!(this.f156q == null || c == null)) {
            this.f156q.m4381c(c);
        }
        if (this.f125G != null) {
            for (int size = this.f125G.size() - 1; size >= 0; size--) {
                ((el) this.f125G.get(size)).m4395a(view);
            }
        }
    }

    private int m144d(ey eyVar) {
        if (eyVar.m4520a(524) || !eyVar.m4536p()) {
            return -1;
        }
        return this.f143b.m3934c(eyVar.f2196b);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.aj.m1893a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.aj.m1894a();
    }

    public boolean startNestedScroll(int i) {
        return this.aj.m1897a(i);
    }

    public void stopNestedScroll() {
        this.aj.m1901c();
    }

    public boolean hasNestedScrollingParent() {
        return this.aj.m1900b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.aj.m1898a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.aj.m1899a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.aj.m1896a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.aj.m1895a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.ah.m4383a(i, i2);
    }
}
