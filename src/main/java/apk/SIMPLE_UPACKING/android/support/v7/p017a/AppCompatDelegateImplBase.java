package android.support.v7.p017a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.x */
abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
    final Context f1078a;
    final Window f1079b;
    final Callback f1080c;
    final Callback f1081d;
    final AppCompatCallback f1082e;
    ActionBar f1083f;
    MenuInflater f1084g;
    boolean f1085h;
    boolean f1086i;
    boolean f1087j;
    boolean f1088k;
    boolean f1089l;
    private CharSequence f1090m;
    private boolean f1091n;

    abstract ActionMode m2758a(ActionMode actionMode);

    abstract void m2760a(int i, Menu menu);

    abstract boolean m2762a(int i, KeyEvent keyEvent);

    abstract boolean m2763a(KeyEvent keyEvent);

    abstract void m2765b(CharSequence charSequence);

    abstract boolean m2766b(int i, Menu menu);

    abstract void m2770j();

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appCompatCallback) {
        this.f1078a = context;
        this.f1079b = window;
        this.f1082e = appCompatCallback;
        this.f1080c = this.f1079b.getCallback();
        if (this.f1080c instanceof AppCompatDelegateImplBase) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1081d = m2759a(this.f1080c);
        this.f1079b.setCallback(this.f1081d);
    }

    Callback m2759a(Callback callback) {
        return new AppCompatDelegateImplBase(this, callback);
    }

    public ActionBar m2757a() {
        m2770j();
        return this.f1083f;
    }

    final ActionBar m2771k() {
        return this.f1083f;
    }

    public MenuInflater m2764b() {
        if (this.f1084g == null) {
            m2770j();
            this.f1084g = new SupportMenuInflater(this.f1083f != null ? this.f1083f.m2725c() : this.f1078a);
        }
        return this.f1084g;
    }

    final Context m2772l() {
        Context context = null;
        ActionBar a = m2757a();
        if (a != null) {
            context = a.m2725c();
        }
        if (context == null) {
            return this.f1078a;
        }
        return context;
    }

    public void m2768f() {
        this.f1091n = true;
    }

    public boolean m2773m() {
        return false;
    }

    public boolean m2769h() {
        return false;
    }

    final boolean m2774n() {
        return this.f1091n;
    }

    final Callback m2775o() {
        return this.f1079b.getCallback();
    }

    public final void m2761a(CharSequence charSequence) {
        this.f1090m = charSequence;
        m2765b(charSequence);
    }

    public void m2767c(Bundle bundle) {
    }

    final CharSequence m2776p() {
        if (this.f1080c instanceof Activity) {
            return ((Activity) this.f1080c).getTitle();
        }
        return this.f1090m;
    }
}
