package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.AsyncTask;

/* renamed from: com.google.android.gms.gcm.c */
class C0338c extends AsyncTask {
    final /* synthetic */ Intent f4547a;
    final /* synthetic */ C0336a f4548b;

    C0338c(C0336a c0336a, Intent intent) {
        this.f4548b = c0336a;
        this.f4547a = intent;
    }

    protected Void m8085a(Void... voidArr) {
        this.f4548b.m8077c(this.f4547a);
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8085a((Void[]) objArr);
    }
}
