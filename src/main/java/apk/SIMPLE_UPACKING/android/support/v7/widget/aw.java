package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p000a.p001a.VectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDrawableManager */
class aw implements av {
    private aw() {
    }

    public Drawable m4002a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        try {
            return VectorDrawableCompat.m27a(context.getResources(), xmlPullParser, attributeSet, theme);
        } catch (Throwable e) {
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
            return null;
        }
    }
}
