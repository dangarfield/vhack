package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p002h.az;
import android.support.v4.p002h.di;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.p018b.R;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: ListPopupWindow */
class dc extends dl {
    private boolean f2115g;
    private boolean f2116h;
    private boolean f2117i;
    private di f2118j;
    private ListViewAutoScrollHelper f2119k;

    public dc(Context context, boolean z) {
        super(context, null, R.dropDownListViewStyle);
        this.f2116h = z;
        setCacheColorHint(0);
    }

    public boolean m4289a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = az.m1825a(motionEvent);
        switch (a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                z = false;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                z = true;
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m4285a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m4284a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m4287d();
        }
        if (z2) {
            if (this.f2119k == null) {
                this.f2119k = new ListViewAutoScrollHelper(this);
            }
            this.f2119k.m2477a(true);
            this.f2119k.onTouch(this, motionEvent);
        } else if (this.f2119k != null) {
            this.f2119k.m2477a(false);
        }
        return z2;
    }

    private void m4284a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void m4287d() {
        this.f2117i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f2118j != null) {
            this.f2118j.m2291b();
            this.f2118j = null;
        }
    }

    private void m4285a(View view, int i, float f, float f2) {
        this.f2117i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4278a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean m4288a() {
        return this.f2117i || super.m4280a();
    }

    public boolean isInTouchMode() {
        return (this.f2116h && this.f2115g) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f2116h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f2116h || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f2116h || super.hasFocus();
    }
}
