package android.support.design.widget;

import android.os.Build.VERSION;

/* compiled from: ViewUtils */
final class cm implements bv {
    cm() {
    }

    public bs m675a() {
        return new bs(VERSION.SDK_INT >= 12 ? new cb() : new bz());
    }
}
