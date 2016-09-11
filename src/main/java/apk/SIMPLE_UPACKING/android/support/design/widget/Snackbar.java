package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.R;
import android.support.v4.p002h.bu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler f267a;
    private final ViewGroup f268b;
    private final SnackbarLayout f269c;
    private be f270d;
    private final AccessibilityManager f271e;
    private final bj f272f;

    public class SnackbarLayout extends LinearLayout {
        private TextView f261a;
        private Button f262b;
        private int f263c;
        private int f264d;
        private bg f265e;
        private bf f266f;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.SnackbarLayout);
            this.f263c = obtainStyledAttributes.getDimensionPixelSize(R.SnackbarLayout_android_maxWidth, -1);
            this.f264d = obtainStyledAttributes.getDimensionPixelSize(R.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(R.SnackbarLayout_elevation)) {
                bu.m1944d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(R.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.design_layout_snackbar_include, this);
            bu.m1945d((View) this, 1);
            bu.m1940c((View) this, 1);
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f261a = (TextView) findViewById(R.snackbar_text);
            this.f262b = (Button) findViewById(R.snackbar_action);
        }

        TextView getMessageView() {
            return this.f261a;
        }

        Button getActionView() {
            return this.f262b;
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f263c > 0 && getMeasuredWidth() > this.f263c) {
                i = MeasureSpec.makeMeasureSpec(this.f263c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.design_snackbar_padding_vertical);
            int i3 = this.f261a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f264d <= 0 || this.f262b.getMeasuredWidth() <= this.f264d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m418a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m418a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void m419a(int i, int i2) {
            bu.m1939c(this.f261a, 0.0f);
            bu.m1960q(this.f261a).m2284a(1.0f).m2285a((long) i2).m2290b((long) i).m2293c();
            if (this.f262b.getVisibility() == 0) {
                bu.m1939c(this.f262b, 0.0f);
                bu.m1960q(this.f262b).m2284a(1.0f).m2285a((long) i2).m2290b((long) i).m2293c();
            }
        }

        void m420b(int i, int i2) {
            bu.m1939c(this.f261a, 1.0f);
            bu.m1960q(this.f261a).m2284a(0.0f).m2285a((long) i2).m2290b((long) i).m2293c();
            if (this.f262b.getVisibility() == 0) {
                bu.m1939c(this.f262b, 1.0f);
                bu.m1960q(this.f262b).m2284a(0.0f).m2285a((long) i2).m2290b((long) i).m2293c();
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f265e != null) {
                this.f265e.m541a(this, i, i2, i3, i4);
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f266f != null) {
                this.f266f.m537a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f266f != null) {
                this.f266f.m538b(this);
            }
        }

        void setOnLayoutChangeListener(bg bgVar) {
            this.f265e = bgVar;
        }

        void setOnAttachStateChangeListener(bf bfVar) {
            this.f266f = bfVar;
        }

        private boolean m418a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f261a.getPaddingTop() == i2 && this.f261a.getPaddingBottom() == i3) {
                return z;
            }
            m417a(this.f261a, i2, i3);
            return true;
        }

        private static void m417a(View view, int i, int i2) {
            if (bu.m1966w(view)) {
                bu.m1925a(view, bu.m1954k(view), i, bu.m1955l(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }
    }

    static {
        f267a = new Handler(Looper.getMainLooper(), new au());
    }

    private void m423b(int i) {
        bh.m558a().m567a(this.f272f, i);
    }

    public boolean m435a() {
        return bh.m558a().m571e(this.f272f);
    }

    final void m436b() {
        if (this.f269c.getParent() == null) {
            LayoutParams layoutParams = this.f269c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout) {
                CoordinatorLayout bdVar = new bd(this);
                bdVar.m449a(0.1f);
                bdVar.m454b(0.6f);
                bdVar.m450a(0);
                bdVar.m451a(new aw(this));
                ((CoordinatorLayout) layoutParams).m708a(bdVar);
            }
            this.f268b.addView(this.f269c);
        }
        this.f269c.setOnAttachStateChangeListener(new ax(this));
        if (bu.m1915A(this.f269c)) {
            m430d();
        } else {
            this.f269c.setOnLayoutChangeListener(new az(this));
        }
    }

    private void m430d() {
        if (VERSION.SDK_INT >= 14) {
            bu.m1935b(this.f269c, (float) this.f269c.getHeight());
            bu.m1960q(this.f269c).m2292c(0.0f).m2288a(AnimationUtils.f284b).m2285a(250).m2286a(new ba(this)).m2293c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f269c.getContext(), R.design_snackbar_in);
        loadAnimation.setInterpolator(AnimationUtils.f284b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new bb(this));
        this.f269c.startAnimation(loadAnimation);
    }

    private void m428c(int i) {
        if (VERSION.SDK_INT >= 14) {
            bu.m1960q(this.f269c).m2292c((float) this.f269c.getHeight()).m2288a(AnimationUtils.f284b).m2285a(250).m2286a(new bc(this, i)).m2293c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f269c.getContext(), R.design_snackbar_out);
        loadAnimation.setInterpolator(AnimationUtils.f284b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new av(this, i));
        this.f269c.startAnimation(loadAnimation);
    }

    final void m434a(int i) {
        if (this.f269c.getVisibility() != 0) {
            m431d(i);
        } else {
            m428c(i);
        }
    }

    private void m432e() {
        bh.m558a().m568b(this.f272f);
        if (this.f270d != null) {
            this.f270d.m556a(this);
        }
    }

    private void m431d(int i) {
        bh.m558a().m566a(this.f272f);
        if (this.f270d != null) {
            this.f270d.m557a(this, i);
        }
        ViewParent parent = this.f269c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f269c);
        }
    }
}
