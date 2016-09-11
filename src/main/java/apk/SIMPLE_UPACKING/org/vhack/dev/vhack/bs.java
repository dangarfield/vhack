package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.gcm.C0339d;
import com.google.android.gms.iid.C0344a;
import java.io.IOException;

/* compiled from: GCMClientManager */
class bs extends AsyncTask {
    final /* synthetic */ bt f5314a;
    final /* synthetic */ br f5315b;

    bs(br brVar, bt btVar) {
        this.f5315b = brVar;
        this.f5314a = btVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9119a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9120a((String) obj);
    }

    protected String m9119a(Void... voidArr) {
        try {
            if (this.f5315b.f5310a == null) {
                this.f5315b.f5310a = C0339d.m8086a(this.f5315b.m9110b());
            }
            this.f5315b.f5311b = C0344a.m8125b(this.f5315b.m9110b()).m8126a(this.f5315b.f5312c, "GCM", null);
            Log.i("GCMClientManager", this.f5315b.f5311b);
            this.f5315b.m9107a(this.f5315b.m9110b(), this.f5315b.f5311b);
        } catch (IOException e) {
            this.f5314a.m9121a("Error :" + e.getMessage());
        }
        return this.f5315b.f5311b;
    }

    protected void m9120a(String str) {
        if (str != null) {
            this.f5314a.m9122a(str, true);
        }
    }
}
