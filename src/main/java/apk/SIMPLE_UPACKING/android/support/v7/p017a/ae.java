package android.support.v7.p017a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.bb;
import android.support.v4.p002h.ab;
import android.support.v4.p002h.al;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.ct;
import android.support.v4.p002h.di;
import android.support.v4.widget.ag;
import android.support.v7.p018b.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.bx;
import android.support.v7.widget.cm;
import android.support.v7.widget.gq;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.ae */
class ae extends AppCompatDelegateImplBase implements al, MenuBuilder {
    private boolean f1092A;
    private aq[] f1093B;
    private aq f1094C;
    private boolean f1095D;
    private boolean f1096E;
    private int f1097F;
    private final Runnable f1098G;
    private boolean f1099H;
    private Rect f1100I;
    private Rect f1101J;
    private at f1102K;
    ActionMode f1103m;
    ActionBarContextView f1104n;
    PopupWindow f1105o;
    Runnable f1106p;
    di f1107q;
    private bx f1108r;
    private am f1109s;
    private ar f1110t;
    private boolean f1111u;
    private ViewGroup f1112v;
    private TextView f1113w;
    private View f1114x;
    private boolean f1115y;
    private boolean f1116z;

    ae(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f1107q = null;
        this.f1098G = new af(this);
    }

    public void m2822a(Bundle bundle) {
        if ((this.c instanceof Activity) && bb.m958b((Activity) this.c) != null) {
            ActionBar k = m2771k();
            if (k == null) {
                this.f1099H = true;
            } else {
                k.m2726c(true);
            }
        }
    }

    public void m2833b(Bundle bundle) {
        m2811r();
    }

    public void m2846j() {
        m2811r();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new bd((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new bd((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.m2726c(this.f1099H);
            }
        }
    }

    public View m2818a(int i) {
        m2811r();
        return this.b.findViewById(i);
    }

    public void m2821a(Configuration configuration) {
        if (this.h && this.f1111u) {
            ActionBar a = m2757a();
            if (a != null) {
                a.m2719a(configuration);
            }
        }
    }

    public void m2839c() {
        ActionBar a = m2757a();
        if (a != null) {
            a.m2728d(false);
        }
    }

    public void m2842d() {
        ActionBar a = m2757a();
        if (a != null) {
            a.m2728d(true);
        }
    }

    public void m2824a(View view) {
        m2811r();
        ViewGroup viewGroup = (ViewGroup) this.f1112v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void m2832b(int i) {
        m2811r();
        ViewGroup viewGroup = (ViewGroup) this.f1112v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void m2825a(View view, LayoutParams layoutParams) {
        m2811r();
        ViewGroup viewGroup = (ViewGroup) this.f1112v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void m2834b(View view, LayoutParams layoutParams) {
        m2811r();
        ((ViewGroup) this.f1112v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void m2844f() {
        super.m2768f();
        if (this.f != null) {
            this.f.m2733h();
            this.f = null;
        }
    }

    private void m2811r() {
        if (!this.f1111u) {
            this.f1112v = m2812s();
            CharSequence p = m2776p();
            if (!TextUtils.isEmpty(p)) {
                m2835b(p);
            }
            m2813t();
            m2826a(this.f1112v);
            this.f1111u = true;
            aq a = m2780a(0, false);
            if (!m2774n()) {
                if (a == null || a.f1154j == null) {
                    m2806e(R.AppCompatTheme_ratingBarStyleSmall);
                }
            }
        }
    }

    private ViewGroup m2812s() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(R.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(R.AppCompatTheme_windowNoTitle, false)) {
                m2840c(1);
            } else if (obtainStyledAttributes.getBoolean(R.AppCompatTheme_windowActionBar, false)) {
                m2840c((int) R.AppCompatTheme_ratingBarStyleSmall);
            }
            if (obtainStyledAttributes.getBoolean(R.AppCompatTheme_windowActionBarOverlay, false)) {
                m2840c((int) R.AppCompatTheme_seekBarStyle);
            }
            if (obtainStyledAttributes.getBoolean(R.AppCompatTheme_windowActionModeOverlay, false)) {
                m2840c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(R.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2;
                if (this.j) {
                    view2 = (ViewGroup) from.inflate(R.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view2 = (ViewGroup) from.inflate(R.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    bu.m1930a(view2, new ag(this));
                    view = view2;
                } else {
                    ((cm) view2).setOnFitSystemWindowsListener(new ah(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(R.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                Context contextThemeWrapper;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(R.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(this.a, typedValue.resourceId);
                } else {
                    contextThemeWrapper = this.a;
                }
                r0 = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(R.abc_screen_toolbar, null);
                this.f1108r = (bx) r0.findViewById(R.decor_content_parent);
                this.f1108r.setWindowCallback(m2775o());
                if (this.i) {
                    this.f1108r.m3407a(R.AppCompatTheme_seekBarStyle);
                }
                if (this.f1115y) {
                    this.f1108r.m3407a(2);
                }
                if (this.f1116z) {
                    this.f1108r.m3407a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1108r == null) {
                this.f1113w = (TextView) view.findViewById(R.title);
            }
            gq.m4751b(view);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(R.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.b.setContentView(view);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            contentFrameLayout.setAttachListener(new ai(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    void m2826a(ViewGroup viewGroup) {
    }

    private void m2813t() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1112v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m2884a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(R.AppCompatTheme);
        obtainStyledAttributes.getValue(R.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean m2840c(int i) {
        int h = m2810h(i);
        if (this.l && h == R.AppCompatTheme_ratingBarStyleSmall) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m2815v();
                this.l = true;
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m2815v();
                this.f1115y = true;
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m2815v();
                this.f1116z = true;
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                m2815v();
                this.j = true;
                return true;
            case R.AppCompatTheme_ratingBarStyleSmall /*108*/:
                m2815v();
                this.h = true;
                return true;
            case R.AppCompatTheme_seekBarStyle /*109*/:
                m2815v();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    void m2835b(CharSequence charSequence) {
        if (this.f1108r != null) {
            this.f1108r.setWindowTitle(charSequence);
        } else if (m2771k() != null) {
            m2771k().m2720a(charSequence);
        } else if (this.f1113w != null) {
            this.f1113w.setText(charSequence);
        }
    }

    void m2820a(int i, Menu menu) {
        if (i == R.AppCompatTheme_ratingBarStyleSmall) {
            ActionBar a = m2757a();
            if (a != null) {
                a.m2729e(false);
            }
        } else if (i == 0) {
            aq a2 = m2780a(i, true);
            if (a2.f1159o) {
                m2789a(a2, false);
            }
        }
    }

    boolean m2837b(int i, Menu menu) {
        if (i != R.AppCompatTheme_ratingBarStyleSmall) {
            return false;
        }
        ActionBar a = m2757a();
        if (a == null) {
            return true;
        }
        a.m2729e(true);
        return true;
    }

    public boolean m2828a(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback o = m2775o();
        if (!(o == null || m2774n())) {
            aq a = m2782a(menuBuilder.m3254p());
            if (a != null) {
                return o.onMenuItemSelected(a.f1145a, menuItem);
            }
        }
        return false;
    }

    public void m2823a(MenuBuilder menuBuilder) {
        m2790a(menuBuilder, true);
    }

    public ActionMode m2830b(ActionMode actionMode) {
        if (actionMode == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1103m != null) {
            this.f1103m.m3003c();
        }
        ActionMode anVar = new an(this, actionMode);
        ActionBar a = m2757a();
        if (a != null) {
            this.f1103m = a.m2717a(anVar);
            if (!(this.f1103m == null || this.e == null)) {
                this.e.m2894a(this.f1103m);
            }
        }
        if (this.f1103m == null) {
            this.f1103m = m2817a(anVar);
        }
        return this.f1103m;
    }

    public void m2843e() {
        ActionBar a = m2757a();
        if (a == null || !a.m2730e()) {
            m2806e(0);
        }
    }

    ActionMode m2817a(ActionMode actionMode) {
        ActionMode actionMode2;
        m2814u();
        if (this.f1103m != null) {
            this.f1103m.m3003c();
        }
        ActionMode anVar = new an(this, actionMode);
        if (this.e == null || m2774n()) {
            actionMode2 = null;
        } else {
            try {
                actionMode2 = this.e.m2893a(anVar);
            } catch (AbstractMethodError e) {
                actionMode2 = null;
            }
        }
        if (actionMode2 != null) {
            this.f1103m = actionMode2;
        } else {
            if (this.f1104n == null) {
                if (this.k) {
                    Context contextThemeWrapper;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(R.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        contextThemeWrapper = new ContextThemeWrapper(this.a, 0);
                        contextThemeWrapper.getTheme().setTo(newTheme);
                    } else {
                        contextThemeWrapper = this.a;
                    }
                    this.f1104n = new ActionBarContextView(contextThemeWrapper);
                    this.f1105o = new PopupWindow(contextThemeWrapper, null, R.actionModePopupWindowStyle);
                    ag.m2497a(this.f1105o, 2);
                    this.f1105o.setContentView(this.f1104n);
                    this.f1105o.setWidth(-1);
                    contextThemeWrapper.getTheme().resolveAttribute(R.actionBarSize, typedValue, true);
                    this.f1104n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                    this.f1105o.setHeight(-2);
                    this.f1106p = new aj(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1112v.findViewById(R.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2772l()));
                        this.f1104n = (ActionBarContextView) viewStubCompat.m3900a();
                    }
                }
            }
            if (this.f1104n != null) {
                boolean z;
                m2814u();
                this.f1104n.m3405c();
                Context context = this.f1104n.getContext();
                ActionBarContextView actionBarContextView = this.f1104n;
                if (this.f1105o == null) {
                    z = true;
                } else {
                    z = false;
                }
                ActionMode standaloneActionMode = new StandaloneActionMode(context, actionBarContextView, anVar, z);
                if (actionMode.m2876a(standaloneActionMode, standaloneActionMode.m3000b())) {
                    standaloneActionMode.m3004d();
                    this.f1104n.m3402a(standaloneActionMode);
                    this.f1103m = standaloneActionMode;
                    bu.m1939c(this.f1104n, 0.0f);
                    this.f1107q = bu.m1960q(this.f1104n).m2284a(1.0f);
                    this.f1107q.m2286a(new al(this));
                    if (this.f1105o != null) {
                        this.b.getDecorView().post(this.f1106p);
                    }
                } else {
                    this.f1103m = null;
                }
            }
        }
        if (!(this.f1103m == null || this.e == null)) {
            this.e.m2894a(this.f1103m);
        }
        return this.f1103m;
    }

    private void m2814u() {
        if (this.f1107q != null) {
            this.f1107q.m2291b();
        }
    }

    boolean m2847q() {
        if (this.f1103m != null) {
            this.f1103m.m3003c();
            return true;
        }
        ActionBar a = m2757a();
        if (a == null || !a.m2731f()) {
            return false;
        }
        return true;
    }

    boolean m2827a(int i, KeyEvent keyEvent) {
        ActionBar a = m2757a();
        if (a != null && a.m2722a(i, keyEvent)) {
            return true;
        }
        if (this.f1094C == null || !m2793a(this.f1094C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1094C == null) {
                aq a2 = m2780a(0, true);
                m2799b(a2, keyEvent);
                boolean a3 = m2793a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1157m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1094C == null) {
            return true;
        } else {
            this.f1094C.f1158n = true;
            return true;
        }
    }

    boolean m2829a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m2841c(keyCode, keyEvent) : m2836b(keyCode, keyEvent);
    }

    boolean m2836b(int i, KeyEvent keyEvent) {
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                boolean z = this.f1095D;
                this.f1095D = false;
                aq a = m2780a(0, false);
                if (a == null || !a.f1159o) {
                    if (m2847q()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2789a(a, true);
                    return true;
                }
                break;
            case R.AppCompatTheme_colorPrimary /*82*/:
                m2807e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m2841c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1095D = z;
                break;
            case R.AppCompatTheme_colorPrimary /*82*/:
                m2805d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            m2827a(i, keyEvent);
        }
        return false;
    }

    public View m2838c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = VERSION.SDK_INT < 21;
        if (this.f1102K == null) {
            this.f1102K = new at();
        }
        if (z2 && m2794a((ViewParent) view)) {
            z = true;
        } else {
            z = false;
        }
        return this.f1102K.m2906a(view, str, context, attributeSet, z, z2, true, z2);
    }

    private boolean m2794a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || bu.m1917C((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public void m2845g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            ab.m1768a(from, this);
        } else if (!(ab.m1767a(from) instanceof ae)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View m2819a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = m2831b(view, str, context, attributeSet);
        return b != null ? b : m2838c(view, str, context, attributeSet);
    }

    View m2831b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2788a(android.support.v7.p017a.aq r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1159o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2774n();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1145a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2775o();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1145a;
        r5 = r11.f1154j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2789a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2799b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1151g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1161q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1151g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2792a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1151g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2802c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m2890a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1152h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1146b;
        r4 = r11.f1151g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1152h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1152h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1151g;
        r4 = r11.f1152h;
        r0.addView(r4, r1);
        r0 = r11.f1152h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1152h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1158n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1148d;
        r4 = r11.f1149e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1147c;
        r0.gravity = r1;
        r1 = r11.f1150f;
        r0.windowAnimations = r1;
        r1 = r11.f1151g;
        r8.addView(r1, r0);
        r11.f1159o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1161q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1151g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1151g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1153i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1153i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.ae.a(android.support.v7.a.aq, android.view.KeyEvent):void");
    }

    private boolean m2792a(aq aqVar) {
        aqVar.m2888a(m2772l());
        aqVar.f1151g = new ap(this, aqVar.f1156l);
        aqVar.f1147c = 81;
        return true;
    }

    private void m2790a(MenuBuilder menuBuilder, boolean z) {
        if (this.f1108r == null || !this.f1108r.m3409d() || (ct.m2232b(ViewConfiguration.get(this.a)) && !this.f1108r.m3411f())) {
            aq a = m2780a(0, true);
            a.f1161q = true;
            m2789a(a, false);
            m2788a(a, null);
            return;
        }
        Callback o = m2775o();
        if (this.f1108r.m3410e() && z) {
            this.f1108r.m3413h();
            if (!m2774n()) {
                o.onPanelClosed(R.AppCompatTheme_ratingBarStyleSmall, m2780a(0, true).f1154j);
            }
        } else if (o != null && !m2774n()) {
            if (this.f1096E && (this.f1097F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1098G);
                this.f1098G.run();
            }
            aq a2 = m2780a(0, true);
            if (a2.f1154j != null && !a2.f1162r && o.onPreparePanel(0, a2.f1153i, a2.f1154j)) {
                o.onMenuOpened(R.AppCompatTheme_ratingBarStyleSmall, a2.f1154j);
                this.f1108r.m3412g();
            }
        }
    }

    private boolean m2798b(aq aqVar) {
        Context contextThemeWrapper;
        MenuBuilder menuBuilder;
        Context context = this.a;
        if ((aqVar.f1145a == 0 || aqVar.f1145a == R.AppCompatTheme_ratingBarStyleSmall) && this.f1108r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(R.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme3);
                menuBuilder = new MenuBuilder(contextThemeWrapper);
                menuBuilder.m3221a((MenuBuilder) this);
                aqVar.m2889a(menuBuilder);
                return true;
            }
        }
        contextThemeWrapper = context;
        menuBuilder = new MenuBuilder(contextThemeWrapper);
        menuBuilder.m3221a((MenuBuilder) this);
        aqVar.m2889a(menuBuilder);
        return true;
    }

    private boolean m2802c(aq aqVar) {
        if (aqVar.f1153i != null) {
            aqVar.f1152h = aqVar.f1153i;
            return true;
        } else if (aqVar.f1154j == null) {
            return false;
        } else {
            if (this.f1110t == null) {
                this.f1110t = new ar();
            }
            aqVar.f1152h = (View) aqVar.m2887a(this.f1110t);
            return aqVar.f1152h != null;
        }
    }

    private boolean m2799b(aq aqVar, KeyEvent keyEvent) {
        if (m2774n()) {
            return false;
        }
        if (aqVar.f1157m) {
            return true;
        }
        if (!(this.f1094C == null || this.f1094C == aqVar)) {
            m2789a(this.f1094C, false);
        }
        Callback o = m2775o();
        if (o != null) {
            aqVar.f1153i = o.onCreatePanelView(aqVar.f1145a);
        }
        boolean z = aqVar.f1145a == 0 || aqVar.f1145a == R.AppCompatTheme_ratingBarStyleSmall;
        if (z && this.f1108r != null) {
            this.f1108r.m3414i();
        }
        if (aqVar.f1153i == null && !(z && (m2771k() instanceof av))) {
            if (aqVar.f1154j == null || aqVar.f1162r) {
                if (aqVar.f1154j == null && (!m2798b(aqVar) || aqVar.f1154j == null)) {
                    return false;
                }
                if (z && this.f1108r != null) {
                    if (this.f1109s == null) {
                        this.f1109s = new am();
                    }
                    this.f1108r.m3408a(aqVar.f1154j, this.f1109s);
                }
                aqVar.f1154j.m3245g();
                if (o.onCreatePanelMenu(aqVar.f1145a, aqVar.f1154j)) {
                    aqVar.f1162r = false;
                } else {
                    aqVar.m2889a(null);
                    if (!z || this.f1108r == null) {
                        return false;
                    }
                    this.f1108r.m3408a(null, this.f1109s);
                    return false;
                }
            }
            aqVar.f1154j.m3245g();
            if (aqVar.f1163s != null) {
                aqVar.f1154j.m3232b(aqVar.f1163s);
                aqVar.f1163s = null;
            }
            if (o.onPreparePanel(0, aqVar.f1153i, aqVar.f1154j)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                aqVar.f1160p = z;
                aqVar.f1154j.setQwertyMode(aqVar.f1160p);
                aqVar.f1154j.m3246h();
            } else {
                if (z && this.f1108r != null) {
                    this.f1108r.m3408a(null, this.f1109s);
                }
                aqVar.f1154j.m3246h();
                return false;
            }
        }
        aqVar.f1157m = true;
        aqVar.f1158n = false;
        this.f1094C = aqVar;
        return true;
    }

    private void m2797b(MenuBuilder menuBuilder) {
        if (!this.f1092A) {
            this.f1092A = true;
            this.f1108r.m3415j();
            Callback o = m2775o();
            if (!(o == null || m2774n())) {
                o.onPanelClosed(R.AppCompatTheme_ratingBarStyleSmall, menuBuilder);
            }
            this.f1092A = false;
        }
    }

    private void m2803d(int i) {
        m2789a(m2780a(i, true), true);
    }

    private void m2789a(aq aqVar, boolean z) {
        if (z && aqVar.f1145a == 0 && this.f1108r != null && this.f1108r.m3410e()) {
            m2797b(aqVar.f1154j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !aqVar.f1159o || aqVar.f1151g == null)) {
            windowManager.removeView(aqVar.f1151g);
            if (z) {
                m2783a(aqVar.f1145a, aqVar, null);
            }
        }
        aqVar.f1157m = false;
        aqVar.f1158n = false;
        aqVar.f1159o = false;
        aqVar.f1152h = null;
        aqVar.f1161q = true;
        if (this.f1094C == aqVar) {
            this.f1094C = null;
        }
    }

    private boolean m2805d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            aq a = m2780a(i, true);
            if (!a.f1159o) {
                return m2799b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean m2807e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1103m != null) {
            return false;
        }
        aq a = m2780a(i, true);
        if (i != 0 || this.f1108r == null || !this.f1108r.m3409d() || ct.m2232b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1159o || a.f1158n) {
                z2 = a.f1159o;
                m2789a(a, true);
                z = z2;
            } else {
                if (a.f1157m) {
                    if (a.f1162r) {
                        a.f1157m = false;
                        z2 = m2799b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2788a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1108r.m3410e()) {
            z = this.f1108r.m3413h();
        } else {
            if (!m2774n() && m2799b(a, keyEvent)) {
                z = this.f1108r.m3412g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m2783a(int i, aq aqVar, Menu menu) {
        if (menu == null) {
            if (aqVar == null && i >= 0 && i < this.f1093B.length) {
                aqVar = this.f1093B[i];
            }
            if (aqVar != null) {
                menu = aqVar.f1154j;
            }
        }
        if ((aqVar == null || aqVar.f1159o) && !m2774n()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    private aq m2782a(Menu menu) {
        aq[] aqVarArr = this.f1093B;
        int length = aqVarArr != null ? aqVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            aq aqVar = aqVarArr[i];
            if (aqVar != null && aqVar.f1154j == menu) {
                return aqVar;
            }
        }
        return null;
    }

    private aq m2780a(int i, boolean z) {
        Object obj = this.f1093B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new aq[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1093B = obj2;
            obj = obj2;
        }
        aq aqVar = obj[i];
        if (aqVar != null) {
            return aqVar;
        }
        aqVar = new aq(i);
        obj[i] = aqVar;
        return aqVar;
    }

    private boolean m2793a(aq aqVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((aqVar.f1157m || m2799b(aqVar, keyEvent)) && aqVar.f1154j != null) {
                z = aqVar.f1154j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1108r == null) {
                m2789a(aqVar, true);
            }
        }
        return z;
    }

    private void m2806e(int i) {
        this.f1097F |= 1 << i;
        if (!this.f1096E) {
            bu.m1931a(this.b.getDecorView(), this.f1098G);
            this.f1096E = true;
        }
    }

    private void m2808f(int i) {
        aq a = m2780a(i, true);
        if (a.f1154j != null) {
            Bundle bundle = new Bundle();
            a.f1154j.m3220a(bundle);
            if (bundle.size() > 0) {
                a.f1163s = bundle;
            }
            a.f1154j.m3245g();
            a.f1154j.clear();
        }
        a.f1162r = true;
        a.f1161q = true;
        if ((i == R.AppCompatTheme_ratingBarStyleSmall || i == 0) && this.f1108r != null) {
            a = m2780a(0, false);
            if (a != null) {
                a.f1157m = false;
                m2799b(a, null);
            }
        }
    }

    private int m2809g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1104n == null || !(this.f1104n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1104n.getLayoutParams();
            if (this.f1104n.isShown()) {
                if (this.f1100I == null) {
                    this.f1100I = new Rect();
                    this.f1101J = new Rect();
                }
                Rect rect = this.f1100I;
                Rect rect2 = this.f1101J;
                rect.set(0, i, 0, 0);
                gq.m4749a(this.f1112v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1114x == null) {
                        this.f1114x = new View(this.a);
                        this.f1114x.setBackgroundColor(this.a.getResources().getColor(R.abc_input_method_navigation_guard));
                        this.f1112v.addView(this.f1114x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1114x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1114x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1114x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1104n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1114x != null) {
            View view = this.f1114x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m2815v() {
        if (this.f1111u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int m2810h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return R.AppCompatTheme_ratingBarStyleSmall;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return R.AppCompatTheme_seekBarStyle;
        }
    }

    private void m2816w() {
        if (this.f1108r != null) {
            this.f1108r.m3415j();
        }
        if (this.f1105o != null) {
            this.b.getDecorView().removeCallbacks(this.f1106p);
            if (this.f1105o.isShowing()) {
                try {
                    this.f1105o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1105o = null;
        }
        m2814u();
        aq a = m2780a(0, false);
        if (a != null && a.f1154j != null) {
            a.f1154j.close();
        }
    }
}
