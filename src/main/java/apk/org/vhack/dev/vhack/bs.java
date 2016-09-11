package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.gcm.d;
import com.google.android.gms.iid.a;
import java.io.IOException;

/* compiled from: GCMClientManager */
class bs extends AsyncTask {
    final /* synthetic */ bt a;
    final /* synthetic */ br b;

    bs(br brVar, bt btVar) {
        this.b = brVar;
        this.a = btVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected String a(Void... voidArr) {
        try {
            if (this.b.a == null) {
                this.b.a = d.a(this.b.b());
            }
            this.b.b = a.b(this.b.b()).getUpdate(this.b.c, "GCM", null);
            Log.i("GCMClientManager", this.b.b);
            this.b.a(this.b.b(), this.b.b);
        } catch (IOException e) {
            this.a.a("Error :" + e.getMessage());
        }
        return this.b.b;
    }

    protected void a(String str) {
        if (str != null) {
            this.a.a(str, true);
        }
    }
}
