package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.p014g.LruCache;

/* compiled from: AppCompatDrawableManager */
class au extends LruCache {
    public au(int i) {
        super(i);
    }

    PorterDuffColorFilter m4000a(int i, Mode mode) {
        return (PorterDuffColorFilter) m1515a((Object) Integer.valueOf(m3999b(i, mode)));
    }

    PorterDuffColorFilter m4001a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) m1516a(Integer.valueOf(m3999b(i, mode)), porterDuffColorFilter);
    }

    private static int m3999b(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }
}
