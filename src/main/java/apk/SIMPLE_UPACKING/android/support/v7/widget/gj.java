package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p002h.bu;
import android.support.v4.p002h.di;
import android.support.v7.p018b.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

/* compiled from: ToolbarWidgetWrapper */
public class gj implements by {
    private Toolbar f2309a;
    private int f2310b;
    private View f2311c;
    private View f2312d;
    private Drawable f2313e;
    private Drawable f2314f;
    private Drawable f2315g;
    private boolean f2316h;
    private CharSequence f2317i;
    private CharSequence f2318j;
    private CharSequence f2319k;
    private Callback f2320l;
    private boolean f2321m;
    private ActionMenuPresenter f2322n;
    private int f2323o;
    private final ar f2324p;
    private int f2325q;
    private Drawable f2326r;

    public gj(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.abc_action_bar_up_description, R.abc_ic_ab_back_mtrl_am_alpha);
    }

    public gj(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2323o = 0;
        this.f2325q = 0;
        this.f2309a = toolbar;
        this.f2317i = toolbar.getTitle();
        this.f2318j = toolbar.getSubtitle();
        this.f2316h = this.f2317i != null;
        this.f2315g = toolbar.getNavigationIcon();
        if (z) {
            gb a = gb.m4646a(toolbar.getContext(), null, R.ActionBar, R.actionBarStyle, 0);
            CharSequence c = a.m4655c(R.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m4699b(c);
            }
            c = a.m4655c(R.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m4703c(c);
            }
            Drawable a2 = a.m4649a(R.ActionBar_logo);
            if (a2 != null) {
                m4702c(a2);
            }
            a2 = a.m4649a(R.ActionBar_icon);
            if (this.f2315g == null && a2 != null) {
                m4688a(a2);
            }
            a2 = a.m4649a(R.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m4707d(a2);
            }
            m4701c(a.m4648a(R.ActionBar_displayOptions, 0));
            int g = a.m4662g(R.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m4692a(LayoutInflater.from(this.f2309a.getContext()).inflate(g, this.f2309a, false));
                m4701c(this.f2310b | 16);
            }
            g = a.m4660f(R.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2309a.getLayoutParams();
                layoutParams.height = g;
                this.f2309a.setLayoutParams(layoutParams);
            }
            g = a.m4656d(R.ActionBar_contentInsetStart, -1);
            int d = a.m4656d(R.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2309a.m3884a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m4662g(R.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2309a.m3885a(this.f2309a.getContext(), g);
            }
            g = a.m4662g(R.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2309a.m3889b(this.f2309a.getContext(), g);
            }
            int g2 = a.m4662g(R.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2309a.setPopupTheme(g2);
            }
            a.m4650a();
        } else {
            this.f2310b = m4681s();
        }
        this.f2324p = ar.m3972a();
        m4706d(i);
        this.f2319k = this.f2309a.getNavigationContentDescription();
        m4698b(this.f2324p.m3993a(m4696b(), i2));
        this.f2309a.setNavigationOnClickListener(new gk(this));
    }

    public void m4706d(int i) {
        if (i != this.f2325q) {
            this.f2325q = i;
            if (TextUtils.isEmpty(this.f2309a.getNavigationContentDescription())) {
                m4710e(this.f2325q);
            }
        }
    }

    public void m4698b(Drawable drawable) {
        if (this.f2326r != drawable) {
            this.f2326r = drawable;
            m4684v();
        }
    }

    private int m4681s() {
        if (this.f2309a.getNavigationIcon() != null) {
            return 15;
        }
        return 11;
    }

    public ViewGroup m4686a() {
        return this.f2309a;
    }

    public Context m4696b() {
        return this.f2309a.getContext();
    }

    public boolean m4704c() {
        return this.f2309a.m3895g();
    }

    public void m4705d() {
        this.f2309a.m3896h();
    }

    public void m4693a(Callback callback) {
        this.f2320l = callback;
    }

    public void m4694a(CharSequence charSequence) {
        if (!this.f2316h) {
            m4680e(charSequence);
        }
    }

    public CharSequence m4709e() {
        return this.f2309a.getTitle();
    }

    public void m4699b(CharSequence charSequence) {
        this.f2316h = true;
        m4680e(charSequence);
    }

    private void m4680e(CharSequence charSequence) {
        this.f2317i = charSequence;
        if ((this.f2310b & 8) != 0) {
            this.f2309a.setTitle(charSequence);
        }
    }

    public void m4703c(CharSequence charSequence) {
        this.f2318j = charSequence;
        if ((this.f2310b & 8) != 0) {
            this.f2309a.setSubtitle(charSequence);
        }
    }

    public void m4711f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m4712g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m4687a(int i) {
        m4688a(i != 0 ? this.f2324p.m3993a(m4696b(), i) : null);
    }

    public void m4688a(Drawable drawable) {
        this.f2313e = drawable;
        m4682t();
    }

    public void m4697b(int i) {
        m4702c(i != 0 ? this.f2324p.m3993a(m4696b(), i) : null);
    }

    public void m4702c(Drawable drawable) {
        this.f2314f = drawable;
        m4682t();
    }

    private void m4682t() {
        Drawable drawable = null;
        if ((this.f2310b & 2) != 0) {
            drawable = (this.f2310b & 1) != 0 ? this.f2314f != null ? this.f2314f : this.f2313e : this.f2313e;
        }
        this.f2309a.setLogo(drawable);
    }

    public boolean m4713h() {
        return this.f2309a.m3888a();
    }

    public boolean m4714i() {
        return this.f2309a.m3890b();
    }

    public boolean m4715j() {
        return this.f2309a.m3891c();
    }

    public boolean m4716k() {
        return this.f2309a.m3892d();
    }

    public boolean m4717l() {
        return this.f2309a.m3893e();
    }

    public void m4718m() {
        this.f2321m = true;
    }

    public void m4691a(Menu menu, MenuPresenter menuPresenter) {
        if (this.f2322n == null) {
            this.f2322n = new ActionMenuPresenter(this.f2309a.getContext());
            this.f2322n.m3292a(R.action_menu_presenter);
        }
        this.f2322n.m3296a(menuPresenter);
        this.f2309a.m3886a((MenuBuilder) menu, this.f2322n);
    }

    public void m4719n() {
        this.f2309a.m3894f();
    }

    public int m4720o() {
        return this.f2310b;
    }

    public void m4701c(int i) {
        int i2 = this.f2310b ^ i;
        this.f2310b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4684v();
                    m4683u();
                } else {
                    this.f2309a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m4682t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2309a.setTitle(this.f2317i);
                    this.f2309a.setSubtitle(this.f2318j);
                } else {
                    this.f2309a.setTitle(null);
                    this.f2309a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2312d != null) {
                if ((i & 16) != 0) {
                    this.f2309a.addView(this.f2312d);
                } else {
                    this.f2309a.removeView(this.f2312d);
                }
            }
        }
    }

    public void m4690a(fd fdVar) {
        if (this.f2311c != null && this.f2311c.getParent() == this.f2309a) {
            this.f2309a.removeView(this.f2311c);
        }
        this.f2311c = fdVar;
        if (fdVar != null && this.f2323o == 2) {
            this.f2309a.addView(this.f2311c, 0);
            gg ggVar = (gg) this.f2311c.getLayoutParams();
            ggVar.width = -2;
            ggVar.height = -2;
            ggVar.a = 8388691;
            fdVar.setAllowCollapse(true);
        }
    }

    public void m4695a(boolean z) {
        this.f2309a.setCollapsible(z);
    }

    public void m4700b(boolean z) {
    }

    public int m4721p() {
        return this.f2323o;
    }

    public void m4692a(View view) {
        if (!(this.f2312d == null || (this.f2310b & 16) == 0)) {
            this.f2309a.removeView(this.f2312d);
        }
        this.f2312d = view;
        if (view != null && (this.f2310b & 16) != 0) {
            this.f2309a.addView(this.f2312d);
        }
    }

    public di m4685a(int i, long j) {
        return bu.m1960q(this.f2309a).m2284a(i == 0 ? 1.0f : 0.0f).m2285a(j).m2286a(new gl(this, i));
    }

    public void m4707d(Drawable drawable) {
        this.f2315g = drawable;
        m4684v();
    }

    public void m4708d(CharSequence charSequence) {
        this.f2319k = charSequence;
        m4683u();
    }

    public void m4710e(int i) {
        m4708d(i == 0 ? null : m4696b().getString(i));
    }

    private void m4683u() {
        if ((this.f2310b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2319k)) {
            this.f2309a.setNavigationContentDescription(this.f2325q);
        } else {
            this.f2309a.setNavigationContentDescription(this.f2319k);
        }
    }

    private void m4684v() {
        if ((this.f2310b & 4) != 0) {
            this.f2309a.setNavigationIcon(this.f2315g != null ? this.f2315g : this.f2326r);
        }
    }

    public int m4722q() {
        return this.f2309a.getVisibility();
    }

    public void m4689a(MenuPresenter menuPresenter, MenuBuilder menuBuilder) {
        this.f2309a.m3887a(menuPresenter, menuBuilder);
    }

    public Menu m4723r() {
        return this.f2309a.getMenu();
    }
}
