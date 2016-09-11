package android.support.v7.p017a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.a.w */
public abstract class AppCompatDelegate {
    private static int f1077a;

    public abstract ActionBar m2738a();

    public abstract View m2739a(int i);

    public abstract void m2740a(Configuration configuration);

    public abstract void m2741a(Bundle bundle);

    public abstract void m2742a(View view);

    public abstract void m2743a(View view, LayoutParams layoutParams);

    public abstract void m2744a(CharSequence charSequence);

    public abstract MenuInflater m2745b();

    public abstract void m2746b(int i);

    public abstract void m2747b(Bundle bundle);

    public abstract void m2748b(View view, LayoutParams layoutParams);

    public abstract void m2749c();

    public abstract void m2750c(Bundle bundle);

    public abstract boolean m2751c(int i);

    public abstract void m2752d();

    public abstract void m2753e();

    public abstract void m2754f();

    public abstract void m2755g();

    public abstract boolean m2756h();

    static {
        f1077a = -1;
    }

    public static AppCompatDelegate m2734a(Activity activity, AppCompatCallback appCompatCallback) {
        return AppCompatDelegate.m2736a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate m2735a(Dialog dialog, AppCompatCallback appCompatCallback) {
        return AppCompatDelegate.m2736a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    private static AppCompatDelegate m2736a(Context context, Window window, AppCompatCallback appCompatCallback) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new ac(context, window, appCompatCallback);
        }
        if (i >= 14) {
            return new aa(context, window, appCompatCallback);
        }
        if (i >= 11) {
            return new AppCompatDelegateImplV11(context, window, appCompatCallback);
        }
        return new ae(context, window, appCompatCallback);
    }

    AppCompatDelegate() {
    }

    public static int m2737i() {
        return f1077a;
    }
}
