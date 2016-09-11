package android.support.v4.p006a;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.a.a */
public final class AnimatorCompatHelper {
    private static final AnimatorProvider f453a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f453a = new HoneycombMr1AnimatorCompatProvider();
        } else {
            f453a = new DonutAnimatorCompatProvider();
        }
    }

    public static void m735a(View view) {
        f453a.m736a(view);
    }
}
