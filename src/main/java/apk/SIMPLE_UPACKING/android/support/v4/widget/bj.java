package android.support.v4.widget;

import android.content.Context;
import android.support.v4.p002h.az;
import android.support.v4.p002h.bp;
import android.support.v4.p002h.bu;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
public class bj {
    private static final Interpolator f1032v;
    private int f1033a;
    private int f1034b;
    private int f1035c;
    private float[] f1036d;
    private float[] f1037e;
    private float[] f1038f;
    private float[] f1039g;
    private int[] f1040h;
    private int[] f1041i;
    private int[] f1042j;
    private int f1043k;
    private VelocityTracker f1044l;
    private float f1045m;
    private float f1046n;
    private int f1047o;
    private int f1048p;
    private as f1049q;
    private final bm f1050r;
    private View f1051s;
    private boolean f1052t;
    private final ViewGroup f1053u;
    private final Runnable f1054w;

    static {
        f1032v = new bk();
    }

    public static bj m2616a(ViewGroup viewGroup, bm bmVar) {
        return new bj(viewGroup.getContext(), viewGroup, bmVar);
    }

    public static bj m2615a(ViewGroup viewGroup, float f, bm bmVar) {
        bj a = m2616a(viewGroup, bmVar);
        a.f1034b = (int) (((float) a.f1034b) * (1.0f / f));
        return a;
    }

    private bj(Context context, ViewGroup viewGroup, bm bmVar) {
        this.f1035c = -1;
        this.f1054w = new bl(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (bmVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1053u = viewGroup;
            this.f1050r = bmVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1047o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1034b = viewConfiguration.getScaledTouchSlop();
            this.f1045m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1046n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1049q = as.m2533a(context, f1032v);
        }
    }

    public void m2633a(View view, int i) {
        if (view.getParent() != this.f1053u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1053u + ")");
        }
        this.f1051s = view;
        this.f1035c = i;
        this.f1050r.m597b(view, i);
        m2640b(1);
    }

    public int m2632a() {
        return this.f1034b;
    }

    public void m2639b() {
        this.f1035c = -1;
        m2625c();
        if (this.f1044l != null) {
            this.f1044l.recycle();
            this.f1044l = null;
        }
    }

    public boolean m2637a(View view, int i, int i2) {
        this.f1051s = view;
        this.f1035c = -1;
        boolean a = m2620a(i, i2, 0, 0);
        if (!(a || this.f1033a != 0 || this.f1051s == null)) {
            this.f1051s = null;
        }
        return a;
    }

    public boolean m2635a(int i, int i2) {
        if (this.f1052t) {
            return m2620a(i, i2, (int) bp.m1905a(this.f1044l, this.f1035c), (int) bp.m1906b(this.f1044l, this.f1035c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m2620a(int i, int i2, int i3, int i4) {
        int left = this.f1051s.getLeft();
        int top = this.f1051s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1049q.m2546h();
            m2640b(0);
            return false;
        }
        this.f1049q.m2535a(left, top, i5, i6, m2614a(this.f1051s, i5, i6, i3, i4));
        m2640b(2);
        return true;
    }

    private int m2614a(View view, int i, int i2, int i3, int i4) {
        int b = m2622b(i3, (int) this.f1046n, (int) this.f1045m);
        int b2 = m2622b(i4, (int) this.f1046n, (int) this.f1045m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2613a(i2, b2, this.f1050r.m587a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2613a(i, b, this.f1050r.m594b(view)))));
    }

    private int m2613a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1053u.getWidth();
        int i4 = width / 2;
        float a = (m2611a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m2622b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m2612a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m2611a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m2638a(boolean z) {
        if (this.f1033a == 2) {
            int i;
            boolean g = this.f1049q.m2545g();
            int b = this.f1049q.m2540b();
            int c = this.f1049q.m2541c();
            int left = b - this.f1051s.getLeft();
            int top = c - this.f1051s.getTop();
            if (left != 0) {
                bu.m1949f(this.f1051s, left);
            }
            if (top != 0) {
                bu.m1947e(this.f1051s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1050r.m592a(this.f1051s, b, c, left, top);
            }
            if (g && b == this.f1049q.m2542d() && c == this.f1049q.m2543e()) {
                this.f1049q.m2546h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1053u.post(this.f1054w);
                } else {
                    m2640b(0);
                }
            }
        }
        return this.f1033a == 2;
    }

    private void m2617a(float f, float f2) {
        this.f1052t = true;
        this.f1050r.m591a(this.f1051s, f, f2);
        this.f1052t = false;
        if (this.f1033a == 1) {
            m2640b(0);
        }
    }

    private void m2625c() {
        if (this.f1036d != null) {
            Arrays.fill(this.f1036d, 0.0f);
            Arrays.fill(this.f1037e, 0.0f);
            Arrays.fill(this.f1038f, 0.0f);
            Arrays.fill(this.f1039g, 0.0f);
            Arrays.fill(this.f1040h, 0);
            Arrays.fill(this.f1041i, 0);
            Arrays.fill(this.f1042j, 0);
            this.f1043k = 0;
        }
    }

    private void m2626c(int i) {
        if (this.f1036d != null) {
            this.f1036d[i] = 0.0f;
            this.f1037e[i] = 0.0f;
            this.f1038f[i] = 0.0f;
            this.f1039g[i] = 0.0f;
            this.f1040h[i] = 0;
            this.f1041i[i] = 0;
            this.f1042j[i] = 0;
            this.f1043k &= (1 << i) ^ -1;
        }
    }

    private void m2630d(int i) {
        if (this.f1036d == null || this.f1036d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1036d != null) {
                System.arraycopy(this.f1036d, 0, obj, 0, this.f1036d.length);
                System.arraycopy(this.f1037e, 0, obj2, 0, this.f1037e.length);
                System.arraycopy(this.f1038f, 0, obj3, 0, this.f1038f.length);
                System.arraycopy(this.f1039g, 0, obj4, 0, this.f1039g.length);
                System.arraycopy(this.f1040h, 0, obj5, 0, this.f1040h.length);
                System.arraycopy(this.f1041i, 0, obj6, 0, this.f1041i.length);
                System.arraycopy(this.f1042j, 0, obj7, 0, this.f1042j.length);
            }
            this.f1036d = obj;
            this.f1037e = obj2;
            this.f1038f = obj3;
            this.f1039g = obj4;
            this.f1040h = obj5;
            this.f1041i = obj6;
            this.f1042j = obj7;
        }
    }

    private void m2618a(float f, float f2, int i) {
        m2630d(i);
        float[] fArr = this.f1036d;
        this.f1038f[i] = f;
        fArr[i] = f;
        fArr = this.f1037e;
        this.f1039g[i] = f2;
        fArr[i] = f2;
        this.f1040h[i] = m2628d((int) f, (int) f2);
        this.f1043k |= 1 << i;
    }

    private void m2627c(MotionEvent motionEvent) {
        int c = az.m1830c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = az.m1828b(motionEvent, i);
            float c2 = az.m1829c(motionEvent, i);
            float d = az.m1831d(motionEvent, i);
            this.f1038f[b] = c2;
            this.f1039g[b] = d;
        }
    }

    public boolean m2634a(int i) {
        return (this.f1043k & (1 << i)) != 0;
    }

    void m2640b(int i) {
        this.f1053u.removeCallbacks(this.f1054w);
        if (this.f1033a != i) {
            this.f1033a = i;
            this.f1050r.m589a(i);
            if (this.f1033a == 0) {
                this.f1051s = null;
            }
        }
    }

    boolean m2643b(View view, int i) {
        if (view == this.f1051s && this.f1035c == i) {
            return true;
        }
        if (view == null || !this.f1050r.m593a(view, i)) {
            return false;
        }
        this.f1035c = i;
        m2633a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2636a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.p002h.az.m1825a(r14);
        r1 = android.support.v4.p002h.az.m1827b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2639b();
    L_0x000d:
        r2 = r13.f1044l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1044l = r2;
    L_0x0017:
        r2 = r13.f1044l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1033a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.p002h.az.m1828b(r14, r2);
        r13.m2618a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2645c(r0, r1);
        r1 = r13.f1051s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1033a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2643b(r0, r2);
    L_0x0048:
        r0 = r13.f1040h;
        r0 = r0[r2];
        r1 = r13.f1048p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1050r;
        r3 = r13.f1048p;
        r0 = r0 & r3;
        r1.m590a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.p002h.az.m1828b(r14, r1);
        r2 = android.support.v4.p002h.az.m1829c(r14, r1);
        r1 = android.support.v4.p002h.az.m1831d(r14, r1);
        r13.m2618a(r2, r1, r0);
        r3 = r13.f1033a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1040h;
        r1 = r1[r0];
        r2 = r13.f1048p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1050r;
        r3 = r13.f1048p;
        r1 = r1 & r3;
        r2.m590a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1033a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2645c(r2, r1);
        r2 = r13.f1051s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2643b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1036d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1037e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.p002h.az.m1830c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.p002h.az.m1828b(r14, r1);
        r0 = r13.m2631e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.p002h.az.m1829c(r14, r1);
        r4 = android.support.v4.p002h.az.m1831d(r14, r1);
        r5 = r13.f1036d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1037e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2645c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2621a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1050r;
        r10 = (int) r5;
        r8 = r9.m595b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1050r;
        r12 = (int) r6;
        r10 = r11.m588a(r4, r10, r12);
        r11 = r13.f1050r;
        r11 = r11.m594b(r4);
        r12 = r13.f1050r;
        r12 = r12.m587a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2627c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2623b(r5, r6, r3);
        r5 = r13.f1033a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2643b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.p002h.az.m1828b(r14, r1);
        r13.m2626c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2639b();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.bj.a(android.view.MotionEvent):boolean");
    }

    public void m2641b(MotionEvent motionEvent) {
        int i = 0;
        int a = az.m1825a(motionEvent);
        int b = az.m1827b(motionEvent);
        if (a == 0) {
            m2639b();
        }
        if (this.f1044l == null) {
            this.f1044l = VelocityTracker.obtain();
        }
        this.f1044l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (a) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = az.m1828b(motionEvent, 0);
                c = m2645c((int) x, (int) y);
                m2618a(x, y, i);
                m2643b(c, i);
                i2 = this.f1040h[i];
                if ((this.f1048p & i2) != 0) {
                    this.f1050r.m590a(i2 & this.f1048p, i);
                }
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                if (this.f1033a == 1) {
                    m2629d();
                }
                m2639b();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                if (this.f1033a != 1) {
                    i2 = az.m1830c(motionEvent);
                    while (i < i2) {
                        a = az.m1828b(motionEvent, i);
                        if (m2631e(a)) {
                            float c2 = az.m1829c(motionEvent, i);
                            float d = az.m1831d(motionEvent, i);
                            float f = c2 - this.f1036d[a];
                            float f2 = d - this.f1037e[a];
                            m2623b(f, f2, a);
                            if (this.f1033a != 1) {
                                c = m2645c((int) c2, (int) d);
                                if (m2621a(c, f, f2) && m2643b(c, a)) {
                                }
                            }
                            m2627c(motionEvent);
                        }
                        i++;
                    }
                    m2627c(motionEvent);
                } else if (m2631e(this.f1035c)) {
                    i = az.m1826a(motionEvent, this.f1035c);
                    x = az.m1829c(motionEvent, i);
                    i2 = (int) (x - this.f1038f[this.f1035c]);
                    i = (int) (az.m1831d(motionEvent, i) - this.f1039g[this.f1035c]);
                    m2624b(this.f1051s.getLeft() + i2, this.f1051s.getTop() + i, i2, i);
                    m2627c(motionEvent);
                }
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (this.f1033a == 1) {
                    m2617a(0.0f, 0.0f);
                }
                m2639b();
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                i = az.m1828b(motionEvent, b);
                x = az.m1829c(motionEvent, b);
                y = az.m1831d(motionEvent, b);
                m2618a(x, y, i);
                if (this.f1033a == 0) {
                    m2643b(m2645c((int) x, (int) y), i);
                    i2 = this.f1040h[i];
                    if ((this.f1048p & i2) != 0) {
                        this.f1050r.m590a(i2 & this.f1048p, i);
                    }
                } else if (m2642b((int) x, (int) y)) {
                    m2643b(this.f1051s, i);
                }
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                a = az.m1828b(motionEvent, b);
                if (this.f1033a == 1 && a == this.f1035c) {
                    b = az.m1830c(motionEvent);
                    while (i < b) {
                        int b2 = az.m1828b(motionEvent, i);
                        if (b2 != this.f1035c) {
                            if (m2645c((int) az.m1829c(motionEvent, i), (int) az.m1831d(motionEvent, i)) == this.f1051s && m2643b(this.f1051s, b2)) {
                                i = this.f1035c;
                                if (i == -1) {
                                    m2629d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2629d();
                    }
                }
                m2626c(a);
            default:
        }
    }

    private void m2623b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2619a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2619a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2619a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2619a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1041i;
            iArr[i] = iArr[i] | i2;
            this.f1050r.m596b(i2, i);
        }
    }

    private boolean m2619a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1040h[i] & i2) != i2 || (this.f1048p & i2) == 0 || (this.f1042j[i] & i2) == i2 || (this.f1041i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1034b) && abs2 <= ((float) this.f1034b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1050r.m598b(i2)) {
            int[] iArr = this.f1042j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f1041i[i] & i2) != 0 || abs <= ((float) this.f1034b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m2621a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f1050r.m594b(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1050r.m587a(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f1034b * this.f1034b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f1034b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f1034b)) {
                return false;
            }
            return true;
        }
    }

    private void m2629d() {
        this.f1044l.computeCurrentVelocity(1000, this.f1045m);
        m2617a(m2612a(bp.m1905a(this.f1044l, this.f1035c), this.f1046n, this.f1045m), m2612a(bp.m1906b(this.f1044l, this.f1035c), this.f1046n, this.f1045m));
    }

    private void m2624b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f1051s.getLeft();
        int top = this.f1051s.getTop();
        if (i3 != 0) {
            b = this.f1050r.m595b(this.f1051s, i, i3);
            bu.m1949f(this.f1051s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f1050r.m588a(this.f1051s, i2, i4);
            bu.m1947e(this.f1051s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1050r.m592a(this.f1051s, b, a, b - left, a - top);
        }
    }

    public boolean m2642b(int i, int i2) {
        return m2644b(this.f1051s, i, i2);
    }

    public boolean m2644b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m2645c(int i, int i2) {
        for (int childCount = this.f1053u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1053u.getChildAt(this.f1050r.m599c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m2628d(int i, int i2) {
        int i3 = 0;
        if (i < this.f1053u.getLeft() + this.f1047o) {
            i3 = 1;
        }
        if (i2 < this.f1053u.getTop() + this.f1047o) {
            i3 |= 4;
        }
        if (i > this.f1053u.getRight() - this.f1047o) {
            i3 |= 2;
        }
        if (i2 > this.f1053u.getBottom() - this.f1047o) {
            return i3 | 8;
        }
        return i3;
    }

    private boolean m2631e(int i) {
        if (m2634a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
