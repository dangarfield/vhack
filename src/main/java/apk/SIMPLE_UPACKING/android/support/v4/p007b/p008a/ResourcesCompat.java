package android.support.v4.p007b.p008a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.a.a */
public final class ResourcesCompat {
    public static Drawable m1238a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.m1239a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
