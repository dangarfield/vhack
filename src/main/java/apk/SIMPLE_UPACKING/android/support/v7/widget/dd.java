package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.p002h.az;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: ListPopupWindow */
public abstract class dd implements OnTouchListener {
    private final float f1494a;
    private final int f1495b;
    private final int f1496c;
    private final View f1497d;
    private Runnable f1498e;
    private Runnable f1499f;
    private boolean f1500g;
    private boolean f1501h;
    private int f1502i;
    private final int[] f1503j;

    public abstract cy m3276a();

    public dd(View view) {
        this.f1503j = new int[2];
        this.f1497d = view;
        this.f1494a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1495b = ViewConfiguration.getTapTimeout();
        this.f1496c = (this.f1495b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean b;
        boolean z = this.f1500g;
        if (z) {
            b = this.f1501h ? m3272b(motionEvent) : m3272b(motionEvent) || !m3278c();
        } else {
            boolean z2 = m3268a(motionEvent) && m3277b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1497d.onTouchEvent(obtain);
                obtain.recycle();
            }
            b = z2;
        }
        this.f1500g = b;
        if (b || z) {
            return true;
        }
        return false;
    }

    protected boolean m3277b() {
        cy a = m3276a();
        if (!(a == null || a.m4055k())) {
            a.m4041c();
        }
        return true;
    }

    protected boolean m3278c() {
        cy a = m3276a();
        if (a != null && a.m4055k()) {
            a.m4053i();
        }
        return true;
    }

    private boolean m3268a(MotionEvent motionEvent) {
        View view = this.f1497d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (az.m1825a(motionEvent)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                this.f1502i = motionEvent.getPointerId(0);
                this.f1501h = false;
                if (this.f1498e == null) {
                    this.f1498e = new de();
                }
                view.postDelayed(this.f1498e, (long) this.f1495b);
                if (this.f1499f == null) {
                    this.f1499f = new df();
                }
                view.postDelayed(this.f1499f, (long) this.f1496c);
                return false;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m3274d();
                return false;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1502i);
                if (findPointerIndex < 0 || m3269a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1494a)) {
                    return false;
                }
                m3274d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void m3274d() {
        if (this.f1499f != null) {
            this.f1497d.removeCallbacks(this.f1499f);
        }
        if (this.f1498e != null) {
            this.f1497d.removeCallbacks(this.f1498e);
        }
    }

    private void m3275e() {
        m3274d();
        View view = this.f1497d;
        if (view.isEnabled() && !view.isLongClickable() && m3277b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1500g = true;
            this.f1501h = true;
        }
    }

    private boolean m3272b(MotionEvent motionEvent) {
        boolean z = true;
        View view = this.f1497d;
        cy a = m3276a();
        if (a == null || !a.m4055k()) {
            return false;
        }
        View a2 = a.f1964g;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m3273b(view, obtainNoHistory);
        m3270a(a2, obtainNoHistory);
        boolean a3 = a2.m4289a(obtainNoHistory, this.f1502i);
        obtainNoHistory.recycle();
        int a4 = az.m1825a(motionEvent);
        boolean z2;
        if (a4 == 1 || a4 == 3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(a3 && r2)) {
            z = false;
        }
        return z;
    }

    private static boolean m3269a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m3270a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1503j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m3273b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1503j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
