package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p007b.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class dd implements Iterable {
    private static final df f645a;
    private final ArrayList f646b;
    private final Context f647c;

    static {
        if (VERSION.SDK_INT >= 11) {
            f645a = new dh();
        } else {
            f645a = new dg();
        }
    }

    private dd(Context context) {
        this.f646b = new ArrayList();
        this.f647c = context;
    }

    public static dd m1064a(Context context) {
        return new dd(context);
    }

    public dd m1067a(Intent intent) {
        this.f646b.add(intent);
        return this;
    }

    public dd m1065a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof de) {
            intent = ((de) activity).m1070a();
        }
        if (intent == null) {
            a = bb.m955a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f647c.getPackageManager());
            }
            m1066a(component);
            m1067a(a);
        }
        return this;
    }

    public dd m1066a(ComponentName componentName) {
        int size = this.f646b.size();
        try {
            Intent a = bb.m956a(this.f647c, componentName);
            while (a != null) {
                this.f646b.add(size, a);
                a = bb.m956a(this.f647c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator iterator() {
        return this.f646b.iterator();
    }

    public void m1068a() {
        m1069a(null);
    }

    public void m1069a(Bundle bundle) {
        if (this.f646b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f646b.toArray(new Intent[this.f646b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!ContextCompat.m743a(this.f647c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f647c.startActivity(intent);
        }
    }
}
