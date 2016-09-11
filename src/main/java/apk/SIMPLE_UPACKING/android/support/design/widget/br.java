package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;

/* compiled from: ThemeUtils */
class br {
    private static final int[] f381a;

    static {
        f381a = new int[]{R.colorPrimary};
    }

    static void m609a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f381a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
