package android.support.v7.p017a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.bb;
import android.support.v4.app.dd;
import android.support.v4.app.de;
import android.support.v4.p002h.KeyEventCompat;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ga;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.u */
public class AppCompatActivity extends FragmentActivity implements de, AppCompatCallback {
    private AppCompatDelegate f1352l;
    private int f1353m;
    private boolean f1354n;
    private Resources f1355o;

    public AppCompatActivity() {
        this.f1353m = 0;
    }

    protected void onCreate(Bundle bundle) {
        AppCompatDelegate k = m3100k();
        k.m2755g();
        k.m2741a(bundle);
        if (k.m2756h() && this.f1353m != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1353m, false);
            } else {
                setTheme(this.f1353m);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f1353m = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m3100k().m2747b(bundle);
    }

    public ActionBar m3097h() {
        return m3100k().m2738a();
    }

    public MenuInflater getMenuInflater() {
        return m3100k().m2745b();
    }

    public void setContentView(int i) {
        m3100k().m2746b(i);
    }

    public void setContentView(View view) {
        m3100k().m2742a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3100k().m2743a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3100k().m2748b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3100k().m2740a(configuration);
        if (this.f1355o != null) {
            this.f1355o.updateConfiguration(configuration, null);
        }
    }

    protected void onStop() {
        super.onStop();
        m3100k().m2749c();
    }

    protected void onPostResume() {
        super.onPostResume();
        m3100k().m2752d();
    }

    public View findViewById(int i) {
        return m3100k().m2739a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar h = m3097h();
        if (menuItem.getItemId() != 16908332 || h == null || (h.m2716a() & 4) == 0) {
            return false;
        }
        return m3098i();
    }

    protected void onDestroy() {
        super.onDestroy();
        m3100k().m2754f();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m3100k().m2744a(charSequence);
    }

    public void m3096d() {
        m3100k().m2753e();
    }

    public void invalidateOptionsMenu() {
        m3100k().m2753e();
    }

    public void m3091a(ActionMode actionMode) {
    }

    public void m3095b(ActionMode actionMode) {
    }

    public ActionMode m3089a(ActionMode actionMode) {
        return null;
    }

    public void m3090a(dd ddVar) {
        ddVar.m1065a((Activity) this);
    }

    public void m3094b(dd ddVar) {
    }

    public boolean m3098i() {
        Intent a = m3088a();
        if (a == null) {
            return false;
        }
        if (m3092a(a)) {
            dd a2 = dd.m1064a((Context) this);
            m3090a(a2);
            m3094b(a2);
            a2.m1068a();
            try {
                ActivityCompat.m745a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m3093b(a);
        }
        return true;
    }

    public Intent m3088a() {
        return bb.m955a(this);
    }

    public boolean m3092a(Intent intent) {
        return bb.m957a((Activity) this, intent);
    }

    public void m3093b(Intent intent) {
        bb.m960b((Activity) this, intent);
    }

    public void onContentChanged() {
        m3099j();
    }

    @Deprecated
    public void m3099j() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m3100k().m2750c(bundle);
    }

    public AppCompatDelegate m3100k() {
        if (this.f1352l == null) {
            this.f1352l = AppCompatDelegate.m2734a((Activity) this, (AppCompatCallback) this);
        }
        return this.f1352l;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 19) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (KeyEventCompat.m2417a(keyEvent, 2)) {
                    ActionBar h = m3097h();
                    if (h != null && h.m2724b() && h.m2732g()) {
                        this.f1354n = true;
                        return true;
                    }
                }
            } else if (action == 1 && this.f1354n) {
                this.f1354n = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f1355o == null) {
            this.f1355o = new ga(this, super.getResources());
        }
        return this.f1355o;
    }
}
