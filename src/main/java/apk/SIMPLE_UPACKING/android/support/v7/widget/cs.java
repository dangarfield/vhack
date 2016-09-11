package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p002h.GravityCompat;
import android.support.v4.p002h.bu;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: LinearLayoutCompat */
public class cs extends ViewGroup {
    private boolean f90a;
    private int f91b;
    private int f92c;
    private int f93d;
    private int f94e;
    private int f95f;
    private float f96g;
    private boolean f97h;
    private int[] f98i;
    private int[] f99j;
    private Drawable f100k;
    private int f101l;
    private int f102m;
    private int f103n;
    private int f104o;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m94j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m85b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m86b(layoutParams);
    }

    public cs(Context context) {
        this(context, null);
    }

    public cs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public cs(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f90a = true;
        this.f91b = -1;
        this.f92c = 0;
        this.f94e = 8388659;
        gb a = gb.m4646a(context, attributeSet, R.LinearLayoutCompat, i, 0);
        int a2 = a.m4648a(R.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m4648a(R.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m4651a(R.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f96g = a.m4647a(R.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f91b = a.m4648a(R.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f97h = a.m4651a(R.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m4649a(R.LinearLayoutCompat_divider));
        this.f103n = a.m4648a(R.LinearLayoutCompat_showDividers, 0);
        this.f104o = a.m4658e(R.LinearLayoutCompat_dividerPadding, 0);
        a.m4650a();
    }

    public void setShowDividers(int i) {
        if (i != this.f103n) {
            requestLayout();
        }
        this.f103n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f103n;
    }

    public Drawable getDividerDrawable() {
        return this.f100k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f100k) {
            this.f100k = drawable;
            if (drawable != null) {
                this.f101l = drawable.getIntrinsicWidth();
                this.f102m = drawable.getIntrinsicHeight();
            } else {
                this.f101l = 0;
                this.f102m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f104o = i;
    }

    public int getDividerPadding() {
        return this.f104o;
    }

    public int getDividerWidth() {
        return this.f101l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f100k != null) {
            if (this.f93d == 1) {
                m81a(canvas);
            } else {
                m90b(canvas);
            }
        }
    }

    void m81a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m87b(i);
            if (!(b == null || b.getVisibility() == 8 || !m92c(i))) {
                m82a(canvas, (b.getTop() - ((ct) b.getLayoutParams()).topMargin) - this.f102m);
            }
            i++;
        }
        if (m92c(virtualChildCount)) {
            int height;
            View b2 = m87b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f102m;
            } else {
                ct ctVar = (ct) b2.getLayoutParams();
                height = ctVar.bottomMargin + b2.getBottom();
            }
            m82a(canvas, height);
        }
    }

    void m90b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = gq.m4750a(this);
        int i = 0;
        while (i < virtualChildCount) {
            ct ctVar;
            int right;
            View b = m87b(i);
            if (!(b == null || b.getVisibility() == 8 || !m92c(i))) {
                ctVar = (ct) b.getLayoutParams();
                if (a) {
                    right = ctVar.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - ctVar.leftMargin) - this.f101l;
                }
                m91b(canvas, right);
            }
            i++;
        }
        if (m92c(virtualChildCount)) {
            View b2 = m87b(virtualChildCount - 1);
            if (b2 != null) {
                ctVar = (ct) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - ctVar.leftMargin) - this.f101l;
                } else {
                    right = ctVar.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f101l;
            }
            m91b(canvas, right);
        }
    }

    void m82a(Canvas canvas, int i) {
        this.f100k.setBounds(getPaddingLeft() + this.f104o, i, (getWidth() - getPaddingRight()) - this.f104o, this.f102m + i);
        this.f100k.draw(canvas);
    }

    void m91b(Canvas canvas, int i) {
        this.f100k.setBounds(i, getPaddingTop() + this.f104o, this.f101l + i, (getHeight() - getPaddingBottom()) - this.f104o);
        this.f100k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f90a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f97h = z;
    }

    public int getBaseline() {
        if (this.f91b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f91b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f91b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f92c;
            if (this.f93d == 1) {
                i = this.f94e & 112;
                if (i != 48) {
                    switch (i) {
                        case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f95f) / 2);
                            break;
                        case R.AppCompatTheme_panelMenuListTheme /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f95f;
                            break;
                    }
                }
            }
            i = i2;
            return (((ct) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f91b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f91b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f91b = i;
    }

    View m87b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f96g;
    }

    public void setWeightSum(float f) {
        this.f96g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f93d == 1) {
            m79a(i, i2);
        } else {
            m88b(i, i2);
        }
    }

    protected boolean m92c(int i) {
        if (i == 0) {
            if ((this.f103n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f103n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f103n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void m79a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        View b;
        this.f95f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i9 = this.f91b;
        boolean z = this.f97h;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            int i12;
            int i13;
            View b2 = m87b(i11);
            if (b2 == null) {
                this.f95f += m93d(i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += m78a(b2, i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else {
                if (m92c(i11)) {
                    this.f95f += this.f102m;
                }
                ct ctVar = (ct) b2.getLayoutParams();
                float f2 = f + ctVar.f2081g;
                if (mode2 == 1073741824 && ctVar.height == 0 && ctVar.f2081g > 0.0f) {
                    i3 = this.f95f;
                    this.f95f = Math.max(i3, (ctVar.topMargin + i3) + ctVar.bottomMargin);
                    obj4 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (ctVar.height == 0 && ctVar.f2081g > 0.0f) {
                        i3 = 0;
                        ctVar.height = -2;
                    }
                    int i14 = i3;
                    m83a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f95f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        ctVar.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f95f;
                    this.f95f = Math.max(i15, (((i15 + i3) + ctVar.topMargin) + ctVar.bottomMargin) + m84b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.f92c = this.f95f;
                }
                if (i11 >= i9 || ctVar.f2081g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || ctVar.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = ctVar.rightMargin + ctVar.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = gq.m4748a(i6, bu.m1953j(b2));
                    obj = (obj2 == null || ctVar.width != -1) ? null : 1;
                    if (ctVar.f2081g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i12;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i8, i3);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += m78a(b2, i11);
                    obj5 = obj4;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj4 = obj5;
            obj2 = obj;
            i6 = i12;
            i5 = i13;
        }
        if (this.f95f > 0 && m92c(virtualChildCount)) {
            this.f95f += this.f102m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f95f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = m87b(i4);
                if (b == null) {
                    this.f95f += m93d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = m78a(b, i4) + i4;
                } else {
                    ct ctVar2 = (ct) b.getLayoutParams();
                    int i16 = this.f95f;
                    this.f95f = Math.max(i16, (ctVar2.bottomMargin + ((i16 + i10) + ctVar2.topMargin)) + m84b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f95f += getPaddingTop() + getPaddingBottom();
        int a2 = bu.m1920a(Math.max(this.f95f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (16777215 & a2) - this.f95f;
        int i17;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f96g > 0.0f) {
                f = this.f96g;
            }
            this.f95f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = m87b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    ctVar2 = (ct) b3.getLayoutParams();
                    float f6 = ctVar2.f2081g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + ctVar2.leftMargin) + ctVar2.rightMargin, ctVar2.width);
                        if (ctVar2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = gq.m4748a(i16, bu.m1953j(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = ctVar2.leftMargin + ctVar2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || ctVar2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj = (obj8 == null || ctVar2.width != -1) ? null : 1;
                    i13 = this.f95f;
                    this.f95f = Math.max(i13, (ctVar2.bottomMargin + ((b3.getMeasuredHeight() + i13) + ctVar2.topMargin)) + m84b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj;
                i16 = i4;
            }
            this.f95f += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = m87b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((ct) b.getLayoutParams()).f2081g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(bu.m1920a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), a2);
        if (obj3 != null) {
            m75c(virtualChildCount, i2);
        }
    }

    private void m75c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m87b(i3);
            if (b.getVisibility() != 8) {
                ct ctVar = (ct) b.getLayoutParams();
                if (ctVar.width == -1) {
                    int i4 = ctVar.height;
                    ctVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    ctVar.height = i4;
                }
            }
        }
    }

    void m88b(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        ct ctVar;
        this.f95f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.f98i == null || this.f99j == null) {
            this.f98i = new int[4];
            this.f99j = new int[4];
        }
        int[] iArr = this.f98i;
        int[] iArr2 = this.f99j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f90a;
        boolean z2 = this.f97h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = m87b(i10);
            if (b == null) {
                this.f95f += m93d(i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m78a(b, i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m92c(i10)) {
                    this.f95f += this.f101l;
                }
                ct ctVar2 = (ct) b.getLayoutParams();
                float f2 = f + ctVar2.f2081g;
                if (mode == 1073741824 && ctVar2.width == 0 && ctVar2.f2081g > 0.0f) {
                    if (obj != null) {
                        this.f95f += ctVar2.leftMargin + ctVar2.rightMargin;
                    } else {
                        i3 = this.f95f;
                        this.f95f = Math.max(i3, (ctVar2.leftMargin + i3) + ctVar2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (ctVar2.width == 0 && ctVar2.f2081g > 0.0f) {
                        i3 = 0;
                        ctVar2.width = -2;
                    }
                    int i13 = i3;
                    m83a(b, i10, i, f2 == 0.0f ? this.f95f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        ctVar2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f95f += ((ctVar2.leftMargin + i3) + ctVar2.rightMargin) + m84b(b);
                    } else {
                        int i14 = this.f95f;
                        this.f95f = Math.max(i14, (((i14 + i3) + ctVar2.leftMargin) + ctVar2.rightMargin) + m84b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || ctVar2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = ctVar2.bottomMargin + ctVar2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = gq.m4748a(i6, bu.m1953j(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((ctVar2.f2082h < 0 ? this.f94e : ctVar2.f2082h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj2 == null || ctVar2.height != -1) ? null : 1;
                if (ctVar2.f2081g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i11;
                    } else {
                        i3 = i12;
                    }
                    i3 = Math.max(i8, i3);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m78a(b, i10);
                obj5 = obj4;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj3 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj4 = obj5;
            obj2 = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f95f > 0 && m92c(virtualChildCount)) {
            this.f95f += this.f101l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i10 = i5;
        } else {
            i10 = Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f95f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m87b(i4);
                if (b2 == null) {
                    this.f95f += m93d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m78a(b2, i4) + i4;
                } else {
                    ctVar = (ct) b2.getLayoutParams();
                    if (obj != null) {
                        this.f95f = ((ctVar.rightMargin + (ctVar.leftMargin + i9)) + m84b(b2)) + this.f95f;
                        i3 = i4;
                    } else {
                        i11 = this.f95f;
                        this.f95f = Math.max(i11, (ctVar.rightMargin + ((i11 + i9) + ctVar.leftMargin)) + m84b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f95f += getPaddingLeft() + getPaddingRight();
        int a2 = bu.m1920a(Math.max(this.f95f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f95f;
        int i16;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f96g > 0.0f) {
                f = this.f96g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f95f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m87b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    ctVar = (ct) b3.getLayoutParams();
                    float f6 = ctVar.f2081g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + ctVar.topMargin) + ctVar.bottomMargin, ctVar.height);
                        if (ctVar.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = gq.m4748a(i15, bu.m1953j(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f95f += ((b3.getMeasuredWidth() + ctVar.leftMargin) + ctVar.rightMargin) + m84b(b3);
                    } else {
                        i4 = this.f95f;
                        this.f95f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + ctVar.leftMargin) + ctVar.rightMargin) + m84b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || ctVar.height != -1) ? null : 1;
                    i10 = ctVar.topMargin + ctVar.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    if (obj5 != null) {
                        i4 = i10;
                    } else {
                        i4 = i14;
                    }
                    i10 = Math.max(i16, i4);
                    obj5 = (obj9 == null || ctVar.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((ctVar.f2082h < 0 ? this.f94e : ctVar.f2082h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f95f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m87b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((ct) b4.getLayoutParams()).f2081g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, bu.m1920a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj3 != null) {
            m76d(virtualChildCount, i);
        }
    }

    private void m76d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m87b(i3);
            if (b.getVisibility() != 8) {
                ct ctVar = (ct) b.getLayoutParams();
                if (ctVar.height == -1) {
                    int i4 = ctVar.width;
                    ctVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    ctVar.width = i4;
                }
            }
        }
    }

    int m78a(View view, int i) {
        return 0;
    }

    int m93d(int i) {
        return 0;
    }

    void m83a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m77a(View view) {
        return 0;
    }

    int m84b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f93d == 1) {
            m80a(i, i2, i3, i4);
        } else {
            m89b(i, i2, i3, i4);
        }
    }

    void m80a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f94e & 8388615;
        switch (this.f94e & 112) {
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.f95f) / 2);
                break;
            case R.AppCompatTheme_panelMenuListTheme /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f95f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m87b(i7);
            if (b == null) {
                i8 += m93d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                ct ctVar = (ct) b.getLayoutParams();
                i5 = ctVar.f2082h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (GravityCompat.m2407a(i5, bu.m1951h(this)) & 7) {
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + ctVar.leftMargin) - ctVar.rightMargin;
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        i9 = (paddingRight - measuredWidth) - ctVar.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + ctVar.leftMargin;
                        break;
                }
                if (m92c(i7)) {
                    i5 = this.f102m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + ctVar.topMargin;
                m74a(b, i9, i10 + m77a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((ctVar.bottomMargin + measuredHeight) + m84b(b));
                i5 = m78a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m89b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = gq.m4750a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f94e & 8388615;
        int i8 = this.f94e & 112;
        boolean z = this.f90a;
        int[] iArr = this.f98i;
        int[] iArr2 = this.f99j;
        switch (GravityCompat.m2407a(i7, bu.m1951h(this))) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f95f) / 2);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f95f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m87b(i10);
            if (b == null) {
                paddingLeft += m93d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                ct ctVar = (ct) b.getLayoutParams();
                if (!z || ctVar.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = ctVar.f2082h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ctVar.topMargin) - ctVar.bottomMargin;
                        break;
                    case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                        i11 = paddingTop + ctVar.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case R.AppCompatTheme_panelMenuListTheme /*80*/:
                        i11 = (paddingBottom - measuredHeight) - ctVar.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (m92c(i10)) {
                    i7 = this.f101l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + ctVar.leftMargin;
                m74a(b, paddingLeft + m77a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (ctVar.rightMargin + measuredWidth) + m84b(b);
                i7 = m78a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void m74a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f93d != i) {
            this.f93d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f93d;
    }

    public void setGravity(int i) {
        if (this.f94e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f94e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f94e & 8388615) != i2) {
            this.f94e = i2 | (this.f94e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f94e & 112) != i2) {
            this.f94e = i2 | (this.f94e & -113);
            requestLayout();
        }
    }

    public ct m85b(AttributeSet attributeSet) {
        return new ct(getContext(), attributeSet);
    }

    protected ct m94j() {
        if (this.f93d == 0) {
            return new ct(-2, -2);
        }
        if (this.f93d == 1) {
            return new ct(-1, -2);
        }
        return null;
    }

    protected ct m86b(LayoutParams layoutParams) {
        return new ct(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof ct;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(cs.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(cs.class.getName());
        }
    }
}
