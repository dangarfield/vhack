package android.support.design.widget;

import android.support.v4.p002h.bu;
import android.support.v4.widget.bm;
import android.view.View;
import android.view.ViewParent;

/* compiled from: SwipeDismissBehavior */
class bo extends bm {
    final /* synthetic */ SwipeDismissBehavior f376a;
    private int f377b;

    bo(SwipeDismissBehavior swipeDismissBehavior) {
        this.f376a = swipeDismissBehavior;
    }

    public boolean m605a(View view, int i) {
        return this.f376a.m453a(view);
    }

    public void m608b(View view, int i) {
        this.f377b = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void m602a(int i) {
        if (this.f376a.f274b != null) {
            this.f376a.f274b.m533a(i);
        }
    }

    public void m603a(View view, float f, float f2) {
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int width = view.getWidth();
        if (m600a(view, f)) {
            width = view.getLeft() < this.f377b ? this.f377b - width : this.f377b + width;
            z = true;
        } else {
            width = this.f377b;
        }
        if (this.f376a.f273a.m2635a(width, view.getTop())) {
            bu.m1931a(view, new bq(this.f376a, view, z));
        } else if (z && this.f376a.f274b != null) {
            this.f376a.f274b.m534a(view);
        }
    }

    private boolean m600a(View view, float f) {
        if (f != 0.0f) {
            boolean z = bu.m1951h(view) == 1;
            if (this.f376a.f278f == 2) {
                return true;
            }
            if (this.f376a.f278f == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                    return true;
                } else if (f <= 0.0f) {
                    return false;
                } else {
                    return true;
                }
            } else if (this.f376a.f278f != 1) {
                return false;
            } else {
                if (z) {
                    if (f <= 0.0f) {
                        return false;
                    }
                    return true;
                } else if (f >= 0.0f) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (Math.abs(view.getLeft() - this.f377b) < Math.round(((float) view.getWidth()) * this.f376a.f279g)) {
            return false;
        }
        return true;
    }

    public int m606b(View view) {
        return view.getWidth();
    }

    public int m607b(View view, int i, int i2) {
        int width;
        int i3;
        Object obj = bu.m1951h(view) == 1 ? 1 : null;
        if (this.f376a.f278f == 0) {
            if (obj != null) {
                width = this.f377b - view.getWidth();
                i3 = this.f377b;
            } else {
                width = this.f377b;
                i3 = this.f377b + view.getWidth();
            }
        } else if (this.f376a.f278f != 1) {
            width = this.f377b - view.getWidth();
            i3 = this.f377b + view.getWidth();
        } else if (obj != null) {
            width = this.f377b;
            i3 = this.f377b + view.getWidth();
        } else {
            width = this.f377b - view.getWidth();
            i3 = this.f377b;
        }
        return SwipeDismissBehavior.m442b(width, i, i3);
    }

    public int m601a(View view, int i, int i2) {
        return view.getTop();
    }

    public void m604a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f377b) + (((float) view.getWidth()) * this.f376a.f280h);
        float width2 = ((float) this.f377b) + (((float) view.getWidth()) * this.f376a.f281i);
        if (((float) i) <= width) {
            bu.m1939c(view, 1.0f);
        } else if (((float) i) >= width2) {
            bu.m1939c(view, 0.0f);
        } else {
            bu.m1939c(view, SwipeDismissBehavior.m444c(0.0f, 1.0f - SwipeDismissBehavior.m437a(width, width2, (float) i), 1.0f));
        }
    }
}
