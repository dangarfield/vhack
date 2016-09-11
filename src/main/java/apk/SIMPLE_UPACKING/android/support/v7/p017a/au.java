package android.support.v7.p017a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;

/* compiled from: AppCompatViewInflater */
/* renamed from: android.support.v7.a.au */
class au implements OnClickListener {
    private final View f1171a;
    private final String f1172b;
    private Method f1173c;
    private Context f1174d;

    public au(View view, String str) {
        this.f1171a = view;
        this.f1172b = str;
    }

    public void onClick(View view) {
        if (this.f1173c == null) {
            m2907a(this.f1171a.getContext(), this.f1172b);
        }
        try {
            this.f1173c.invoke(this.f1174d, new Object[]{view});
        } catch (Throwable e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void m2907a(Context context, String str) {
        Context context2 = context;
        while (context2 != null) {
            try {
                if (!context2.isRestricted()) {
                    Method method = context2.getClass().getMethod(this.f1172b, new Class[]{View.class});
                    if (method != null) {
                        this.f1173c = method;
                        this.f1174d = context2;
                        return;
                    }
                }
            } catch (NoSuchMethodException e) {
            }
            if (context2 instanceof ContextWrapper) {
                context2 = ((ContextWrapper) context2).getBaseContext();
            } else {
                context2 = null;
            }
        }
        int id = this.f1171a.getId();
        throw new IllegalStateException("Could not find method " + this.f1172b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1171a.getClass() + (id == -1 ? "" : " with id '" + this.f1171a.getContext().getResources().getResourceEntryName(id) + "'"));
    }
}
