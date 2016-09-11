package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p018b.R;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.e */
public class ContextThemeWrapper extends ContextWrapper {
    private int f1358a;
    private Theme f1359b;
    private LayoutInflater f1360c;

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f1358a = i;
    }

    public ContextThemeWrapper(Context context, Theme theme) {
        super(context);
        this.f1359b = theme;
    }

    public void setTheme(int i) {
        if (this.f1358a != i) {
            this.f1358a = i;
            m3112b();
        }
    }

    public int m3113a() {
        return this.f1358a;
    }

    public Theme getTheme() {
        if (this.f1359b != null) {
            return this.f1359b;
        }
        if (this.f1358a == 0) {
            this.f1358a = R.Theme_AppCompat_Light;
        }
        m3112b();
        return this.f1359b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1360c == null) {
            this.f1360c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1360c;
    }

    protected void m3114a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void m3112b() {
        boolean z = this.f1359b == null;
        if (z) {
            this.f1359b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1359b.setTo(theme);
            }
        }
        m3114a(this.f1359b, this.f1358a, z);
    }
}
