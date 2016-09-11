package com.google.android.gms.p051b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@fi
/* renamed from: com.google.android.gms.b.gt */
public final class gt extends fn {
    private final String f3716a;
    private final Context f3717b;
    private final String f3718c;
    private String f3719d;

    public gt(Context context, String str, String str2) {
        this.f3719d = null;
        this.f3717b = context;
        this.f3716a = str;
        this.f3718c = str2;
    }

    public gt(Context context, String str, String str2, String str3) {
        this.f3719d = null;
        this.f3717b = context;
        this.f3716a = str;
        this.f3718c = str2;
        this.f3719d = str3;
    }

    public void m6609a() {
        HttpURLConnection httpURLConnection;
        try {
            fp.m6505e("Pinging URL: " + this.f3718c);
            httpURLConnection = (HttpURLConnection) new URL(this.f3718c).openConnection();
            if (TextUtils.isEmpty(this.f3719d)) {
                C0056g.m5439c().m6539a(this.f3717b, this.f3716a, true, httpURLConnection);
            } else {
                C0056g.m5439c().m6540a(this.f3717b, this.f3716a, true, httpURLConnection, this.f3719d);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                C0099b.m5643d("Received non-success response code " + responseCode + " from pinging URL: " + this.f3718c);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            C0099b.m5643d("Error while parsing ping URL: " + this.f3718c + ". " + e.getMessage());
        } catch (IOException e2) {
            C0099b.m5643d("Error while pinging URL: " + this.f3718c + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            C0099b.m5643d("Error while pinging URL: " + this.f3718c + ". " + e3.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
