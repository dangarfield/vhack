package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

/* compiled from: TextViewCompat */
public final class az {
    static final bf f1031a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1031a = new ba();
        } else if (i >= 18) {
            f1031a = new bd();
        } else if (i >= 17) {
            f1031a = new bc();
        } else if (i >= 16) {
            f1031a = new be();
        } else {
            f1031a = new bb();
        }
    }

    public static void m2604a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1031a.m2605a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
