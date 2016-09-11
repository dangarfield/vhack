package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class fy extends ContextWrapper {
    private static final ArrayList f2291a;
    private Resources f2292b;
    private final Theme f2293c;

    static {
        f2291a = new ArrayList();
    }

    public static Context m4641a(Context context) {
        if (!m4642b(context)) {
            return context;
        }
        Context context2;
        int size = f2291a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f2291a.get(i);
            context2 = weakReference != null ? (fy) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new fy(context);
        f2291a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m4642b(Context context) {
        if ((context instanceof fy) || (context.getResources() instanceof ga)) {
            return false;
        }
        return true;
    }

    private fy(Context context) {
        super(context);
        this.f2293c = getResources().newTheme();
        this.f2293c.setTo(context.getTheme());
    }

    public Theme getTheme() {
        return this.f2293c;
    }

    public void setTheme(int i) {
        this.f2293c.applyStyle(i, true);
    }

    public Resources getResources() {
        if (this.f2292b == null) {
            this.f2292b = new ga(this, super.getResources());
        }
        return this.f2292b;
    }
}
