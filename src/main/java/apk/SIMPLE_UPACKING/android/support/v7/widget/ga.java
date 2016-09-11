package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
public class ga extends Resources {
    private final WeakReference f2299a;

    public ga(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2299a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2299a.get();
        if (context != null) {
            return ar.m3972a().m3995a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable m4644a(int i) {
        return super.getDrawable(i);
    }
}
