package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

/* compiled from: ListViewCompat */
public final class aa {
    public static void m2488a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            ac.m2490a(listView, i);
        } else {
            ab.m2489a(listView, i);
        }
    }
}
