package com.google.android.gms.p051b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@fi
/* renamed from: com.google.android.gms.b.hm */
public class hm extends MutableContextWrapper {
    private Activity f3794a;
    private Context f3795b;
    private Context f3796c;

    public hm(Context context) {
        super(context);
        setBaseContext(context);
    }

    public Activity m6787a() {
        return this.f3794a;
    }

    public Context m6788b() {
        return this.f3796c;
    }

    public Object getSystemService(String str) {
        return this.f3796c.getSystemService(str);
    }

    public void setBaseContext(Context context) {
        this.f3795b = context.getApplicationContext();
        this.f3794a = context instanceof Activity ? (Activity) context : null;
        this.f3796c = context;
        super.setBaseContext(this.f3795b);
    }

    public void startActivity(Intent intent) {
        if (this.f3794a == null || kn.m6940h()) {
            intent.setFlags(268435456);
            this.f3795b.startActivity(intent);
            return;
        }
        this.f3794a.startActivity(intent);
    }
}
