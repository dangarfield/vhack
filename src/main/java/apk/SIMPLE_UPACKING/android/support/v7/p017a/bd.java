package android.support.v7.p017a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.support.v4.p002h.dz;
import android.support.v4.p002h.eb;
import android.support.v7.p018b.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.by;
import android.support.v7.widget.fd;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
/* renamed from: android.support.v7.a.bd */
public class bd extends ActionBar implements ActionBarOverlayLayout {
    static final /* synthetic */ boolean f1199h;
    private static final Interpolator f1200i;
    private static final Interpolator f1201j;
    private static final boolean f1202k;
    private boolean f1203A;
    private int f1204B;
    private boolean f1205C;
    private boolean f1206D;
    private boolean f1207E;
    private boolean f1208F;
    private boolean f1209G;
    private ViewPropertyAnimatorCompatSet f1210H;
    private boolean f1211I;
    bh f1212a;
    ActionMode f1213b;
    ActionMode f1214c;
    boolean f1215d;
    final dz f1216e;
    final dz f1217f;
    final eb f1218g;
    private Context f1219l;
    private Context f1220m;
    private Activity f1221n;
    private Dialog f1222o;
    private ActionBarOverlayLayout f1223p;
    private ActionBarContainer f1224q;
    private by f1225r;
    private ActionBarContextView f1226s;
    private View f1227t;
    private fd f1228u;
    private ArrayList f1229v;
    private int f1230w;
    private boolean f1231x;
    private boolean f1232y;
    private ArrayList f1233z;

    static {
        boolean z = true;
        f1199h = !bd.class.desiredAssertionStatus();
        f1200i = new AccelerateInterpolator();
        f1201j = new DecelerateInterpolator();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1202k = z;
    }

    public bd(Activity activity, boolean z) {
        this.f1229v = new ArrayList();
        this.f1230w = -1;
        this.f1233z = new ArrayList();
        this.f1204B = 0;
        this.f1205C = true;
        this.f1209G = true;
        this.f1216e = new be(this);
        this.f1217f = new bf(this);
        this.f1218g = new bg(this);
        this.f1221n = activity;
        View decorView = activity.getWindow().getDecorView();
        m2945a(decorView);
        if (!z) {
            this.f1227t = decorView.findViewById(16908290);
        }
    }

    public bd(Dialog dialog) {
        this.f1229v = new ArrayList();
        this.f1230w = -1;
        this.f1233z = new ArrayList();
        this.f1204B = 0;
        this.f1205C = true;
        this.f1209G = true;
        this.f1216e = new be(this);
        this.f1217f = new bf(this);
        this.f1218g = new bg(this);
        this.f1222o = dialog;
        m2945a(dialog.getWindow().getDecorView());
    }

    private void m2945a(View view) {
        this.f1223p = (ActionBarOverlayLayout) view.findViewById(R.decor_content_parent);
        if (this.f1223p != null) {
            this.f1223p.setActionBarVisibilityCallback(this);
        }
        this.f1225r = m2948b(view.findViewById(R.action_bar));
        this.f1226s = (ActionBarContextView) view.findViewById(R.action_context_bar);
        this.f1224q = (ActionBarContainer) view.findViewById(R.action_bar_container);
        if (this.f1225r == null || this.f1226s == null || this.f1224q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1219l = this.f1225r.m4125b();
        boolean z = (this.f1225r.m4141o() & 4) != 0;
        if (z) {
            this.f1231x = true;
        }
        ActionBarPolicy a = ActionBarPolicy.m3102a(this.f1219l);
        if (a.m3108f() || z) {
            z = true;
        } else {
            z = false;
        }
        m2969a(z);
        m2958k(a.m3106d());
        TypedArray obtainStyledAttributes = this.f1219l.obtainStyledAttributes(null, R.ActionBar, R.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.ActionBar_hideOnContentScroll, false)) {
            m2970b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m2964a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private by m2948b(View view) {
        if (view instanceof by) {
            return (by) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void m2964a(float f) {
        bu.m1944d(this.f1224q, f);
    }

    public void m2967a(Configuration configuration) {
        m2958k(ActionBarPolicy.m3102a(this.f1219l).m3106d());
    }

    private void m2958k(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f1203A = z;
        if (this.f1203A) {
            this.f1224q.setTabContainer(null);
            this.f1225r.m4120a(this.f1228u);
        } else {
            this.f1225r.m4120a(null);
            this.f1224q.setTabContainer(this.f1228u);
        }
        if (m2984j() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f1228u != null) {
            if (z2) {
                this.f1228u.setVisibility(0);
                if (this.f1223p != null) {
                    bu.m1962s(this.f1223p);
                }
            } else {
                this.f1228u.setVisibility(8);
            }
        }
        by byVar = this.f1225r;
        if (this.f1203A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        byVar.m4124a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1223p;
        if (this.f1203A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    void m2982i() {
        if (this.f1214c != null) {
            this.f1214c.m2875a(this.f1213b);
            this.f1213b = null;
            this.f1214c = null;
        }
    }

    public void m2965a(int i) {
        this.f1204B = i;
    }

    public void m2975d(boolean z) {
        this.f1211I = z;
        if (!z && this.f1210H != null) {
            this.f1210H.m3166b();
        }
    }

    public void m2976e(boolean z) {
        if (z != this.f1232y) {
            this.f1232y = z;
            int size = this.f1233z.size();
            for (int i = 0; i < size; i++) {
                ((ActionBar) this.f1233z.get(i)).m3028a(z);
            }
        }
    }

    public void m2977f(boolean z) {
        m2966a(z ? 4 : 0, 4);
    }

    public void m2969a(boolean z) {
        this.f1225r.m4127b(z);
    }

    public void m2968a(CharSequence charSequence) {
        this.f1225r.m4123a(charSequence);
    }

    public boolean m2980g() {
        ViewGroup a = this.f1225r.m4116a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m2966a(int i, int i2) {
        int o = this.f1225r.m4141o();
        if ((i2 & 4) != 0) {
            this.f1231x = true;
        }
        this.f1225r.m4128c((o & (i2 ^ -1)) | (i & i2));
    }

    public int m2984j() {
        return this.f1225r.m4142p();
    }

    public int m2962a() {
        return this.f1225r.m4141o();
    }

    public ActionMode m2963a(ActionMode actionMode) {
        if (this.f1212a != null) {
            this.f1212a.m3021c();
        }
        this.f1223p.setHideOnContentScrollEnabled(false);
        this.f1226s.m3405c();
        ActionMode bhVar = new bh(this, this.f1226s.getContext(), actionMode);
        if (!bhVar.m3023e()) {
            return null;
        }
        bhVar.m3022d();
        this.f1226s.m3402a(bhVar);
        m2985j(true);
        this.f1226s.sendAccessibilityEvent(32);
        this.f1212a = bhVar;
        return bhVar;
    }

    public int m2986k() {
        return this.f1224q.getHeight();
    }

    public void m2979g(boolean z) {
        this.f1205C = z;
    }

    private void m2960p() {
        if (!this.f1208F) {
            this.f1208F = true;
            if (this.f1223p != null) {
                this.f1223p.setShowingForActionMode(true);
            }
            m2959l(false);
        }
    }

    public void m2987l() {
        if (this.f1207E) {
            this.f1207E = false;
            m2959l(true);
        }
    }

    private void m2961q() {
        if (this.f1208F) {
            this.f1208F = false;
            if (this.f1223p != null) {
                this.f1223p.setShowingForActionMode(false);
            }
            m2959l(false);
        }
    }

    public void m2988m() {
        if (!this.f1207E) {
            this.f1207E = true;
            m2959l(true);
        }
    }

    public void m2970b(boolean z) {
        if (!z || this.f1223p.m3433a()) {
            this.f1215d = z;
            this.f1223p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int m2974d() {
        return this.f1223p.getActionBarHideOffset();
    }

    private static boolean m2950b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m2959l(boolean z) {
        if (bd.m2950b(this.f1206D, this.f1207E, this.f1208F)) {
            if (!this.f1209G) {
                this.f1209G = true;
                m2981h(z);
            }
        } else if (this.f1209G) {
            this.f1209G = false;
            m2983i(z);
        }
    }

    public void m2981h(boolean z) {
        if (this.f1210H != null) {
            this.f1210H.m3166b();
        }
        this.f1224q.setVisibility(0);
        if (this.f1204B == 0 && f1202k && (this.f1211I || z)) {
            bu.m1935b(this.f1224q, 0.0f);
            float f = (float) (-this.f1224q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1224q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            bu.m1935b(this.f1224q, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            di c = bu.m1960q(this.f1224q).m2292c(0.0f);
            c.m2287a(this.f1218g);
            viewPropertyAnimatorCompatSet.m3161a(c);
            if (this.f1205C && this.f1227t != null) {
                bu.m1935b(this.f1227t, f);
                viewPropertyAnimatorCompatSet.m3161a(bu.m1960q(this.f1227t).m2292c(0.0f));
            }
            viewPropertyAnimatorCompatSet.m3164a(f1201j);
            viewPropertyAnimatorCompatSet.m3160a(250);
            viewPropertyAnimatorCompatSet.m3163a(this.f1217f);
            this.f1210H = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m3165a();
        } else {
            bu.m1939c(this.f1224q, 1.0f);
            bu.m1935b(this.f1224q, 0.0f);
            if (this.f1205C && this.f1227t != null) {
                bu.m1935b(this.f1227t, 0.0f);
            }
            this.f1217f.m544b(null);
        }
        if (this.f1223p != null) {
            bu.m1962s(this.f1223p);
        }
    }

    public void m2983i(boolean z) {
        if (this.f1210H != null) {
            this.f1210H.m3166b();
        }
        if (this.f1204B == 0 && f1202k && (this.f1211I || z)) {
            bu.m1939c(this.f1224q, 1.0f);
            this.f1224q.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = (float) (-this.f1224q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1224q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            di c = bu.m1960q(this.f1224q).m2292c(f);
            c.m2287a(this.f1218g);
            viewPropertyAnimatorCompatSet.m3161a(c);
            if (this.f1205C && this.f1227t != null) {
                viewPropertyAnimatorCompatSet.m3161a(bu.m1960q(this.f1227t).m2292c(f));
            }
            viewPropertyAnimatorCompatSet.m3164a(f1200i);
            viewPropertyAnimatorCompatSet.m3160a(250);
            viewPropertyAnimatorCompatSet.m3163a(this.f1216e);
            this.f1210H = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.m3165a();
            return;
        }
        this.f1216e.m544b(null);
    }

    public boolean m2971b() {
        int k = m2986k();
        return this.f1209G && (k == 0 || m2974d() < k);
    }

    public void m2985j(boolean z) {
        di a;
        di a2;
        if (z) {
            m2960p();
        } else {
            m2961q();
        }
        if (z) {
            a = this.f1225r.m4115a(4, 100);
            a2 = this.f1226s.m3401a(0, 200);
        } else {
            a2 = this.f1225r.m4115a(0, 200);
            a = this.f1226s.m3401a(8, 100);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.m3162a(a, a2);
        viewPropertyAnimatorCompatSet.m3165a();
    }

    public Context m2972c() {
        if (this.f1220m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1219l.getTheme().resolveAttribute(R.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1220m = new ContextThemeWrapper(this.f1219l, i);
            } else {
                this.f1220m = this.f1219l;
            }
        }
        return this.f1220m;
    }

    public void m2989n() {
        if (this.f1210H != null) {
            this.f1210H.m3166b();
            this.f1210H = null;
        }
    }

    public void m2990o() {
    }

    public boolean m2978f() {
        if (this.f1225r == null || !this.f1225r.m4129c()) {
            return false;
        }
        this.f1225r.m4130d();
        return true;
    }

    public void m2973c(boolean z) {
        if (!this.f1231x) {
            m2977f(z);
        }
    }
}
