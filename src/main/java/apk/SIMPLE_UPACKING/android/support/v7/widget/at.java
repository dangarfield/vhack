package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p000a.p001a.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDrawableManager */
class at implements av {
    private at() {
    }

    public Drawable m3998a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        try {
            return AnimatedVectorDrawableCompat.m3a(context, context.getResources(), xmlPullParser, attributeSet, theme);
        } catch (Throwable e) {
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }
    }
}
