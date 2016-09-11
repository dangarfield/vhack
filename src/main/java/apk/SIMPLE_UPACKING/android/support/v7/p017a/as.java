package android.support.v7.p017a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p018b.R;
import android.support.v7.view.ActionMode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: AppCompatDialog */
/* renamed from: android.support.v7.a.as */
public class as extends Dialog implements AppCompatCallback {
    private AppCompatDelegate f1165a;

    public as(Context context, int i) {
        super(context, as.m2896a(context, i));
        m2897a().m2741a(null);
        m2897a().m2756h();
    }

    protected void onCreate(Bundle bundle) {
        m2897a().m2755g();
        super.onCreate(bundle);
        m2897a().m2741a(bundle);
    }

    public void setContentView(int i) {
        m2897a().m2746b(i);
    }

    public void setContentView(View view) {
        m2897a().m2742a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2897a().m2743a(view, layoutParams);
    }

    public View findViewById(int i) {
        return m2897a().m2739a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m2897a().m2744a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m2897a().m2744a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2897a().m2748b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m2897a().m2749c();
    }

    public boolean m2900a(int i) {
        return m2897a().m2751c(i);
    }

    public void invalidateOptionsMenu() {
        m2897a().m2753e();
    }

    public AppCompatDelegate m2897a() {
        if (this.f1165a == null) {
            this.f1165a = AppCompatDelegate.m2735a((Dialog) this, (AppCompatCallback) this);
        }
        return this.f1165a;
    }

    private static int m2896a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void m2899a(ActionMode actionMode) {
    }

    public void m2901b(ActionMode actionMode) {
    }

    public ActionMode m2898a(ActionMode actionMode) {
        return null;
    }
}
