package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: SplashActivity */
class fi extends AsyncTask {
    final /* synthetic */ SplashActivity f5451a;

    fi(SplashActivity splashActivity) {
        this.f5451a = splashActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9173a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9174a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9173a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5451a.getApplicationContext(), "", "", "vh_update.php")).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (responseCode != 200) {
                        return "Request failed!";
                    }
                    try {
                        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                                byteArrayOutputStream.write(read);
                            }
                            return byteArrayOutputStream.toString();
                        } catch (IOException e) {
                            return "Failed to read Response";
                        }
                    } catch (IOException e2) {
                        return "Failed to get API Response";
                    }
                } catch (IOException e3) {
                    return "Failed to get Response Code";
                }
            } catch (IOException e4) {
                return "Failed to open Connection";
            }
        } catch (MalformedURLException e5) {
            return "URL isn't valid";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m9174a(java.lang.String r6) {
        /*
        r5 = this;
        r4 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r3 = 20;
        r0 = 0;
        r2 = 1;
        r1 = r6.length();
        if (r1 <= r3) goto L_0x01da;
    L_0x000d:
        r0 = r6.length();
        if (r0 <= r3) goto L_0x01c6;
    L_0x0013:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01d5 }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x01d5 }
        r1 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r2 = "loginData.xml";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r1 = r1.edit();	 Catch:{ JSONException -> 0x01d5 }
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x01d5 }
        r3 = "0";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x01d5 }
        if (r2 == 0) goto L_0x0040;
    L_0x0033:
        r2 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r3 = 2131165369; // 0x7f0700b9 float:1.7944953E38 double:1.0529355944E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x01d5 }
        r2.show();	 Catch:{ JSONException -> 0x01d5 }
    L_0x0040:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x01d5 }
        r3 = "2";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x01d5 }
        if (r2 == 0) goto L_0x005b;
    L_0x004e:
        r2 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r3 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x01d5 }
        r2.show();	 Catch:{ JSONException -> 0x01d5 }
    L_0x005b:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x01d5 }
        r3 = "1";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x01d5 }
        if (r2 == 0) goto L_0x01c6;
    L_0x0069:
        r2 = "money";
        r3 = "money";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "id";
        r3 = "id";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "inet";
        r3 = "inet";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "hdd";
        r3 = "hdd";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "cpu";
        r3 = "cpu";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "ram";
        r3 = "ram";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "fw";
        r3 = "fw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "av";
        r3 = "av";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "sdk";
        r3 = "sdk";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "ipsp";
        r3 = "ipsp";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "spam";
        r3 = "spam";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "scan";
        r3 = "scan";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "adw";
        r3 = "adw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "actadw";
        r3 = "actadw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "netcoins";
        r3 = "netcoins";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "urmail";
        r3 = "urmail";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "score";
        r3 = "score";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "energy";
        r3 = "energy";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "active";
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "elo";
        r3 = "elo";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "clusterID";
        r3 = "clusterID";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "position";
        r3 = "position";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "syslog";
        r3 = "syslog";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "rank";
        r3 = "rank";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "bonus";
        r3 = "bonus";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "mystery";
        r3 = "mystery";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "hash";
        r3 = "hash";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r2 = "uhash";
        r3 = "uhash";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x01d5 }
        r1.commit();	 Catch:{ JSONException -> 0x01d5 }
        r1 = "active";
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x01d5 }
        r1 = "1";
        r0 = r0.equals(r1);	 Catch:{ JSONException -> 0x01d5 }
        if (r0 == 0) goto L_0x01c7;
    L_0x01ae:
        r0 = new android.content.Intent;	 Catch:{ JSONException -> 0x01d5 }
        r1 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r1 = r1.getApplicationContext();	 Catch:{ JSONException -> 0x01d5 }
        r2 = org.vhack.dev.vhack.MainActivity.class;
        r0.<init>(r1, r2);	 Catch:{ JSONException -> 0x01d5 }
        r1 = "chat";
        r2 = 1;
        r0.putExtra(r1, r2);	 Catch:{ JSONException -> 0x01d5 }
        r1 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r1.startActivity(r0);	 Catch:{ JSONException -> 0x01d5 }
    L_0x01c6:
        return;
    L_0x01c7:
        r0 = r5.f5451a;	 Catch:{ JSONException -> 0x01d5 }
        r1 = 2131165369; // 0x7f0700b9 float:1.7944953E38 double:1.0529355944E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x01d5 }
        r0.show();	 Catch:{ JSONException -> 0x01d5 }
        goto L_0x01c6;
    L_0x01d5:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x01c6;
    L_0x01da:
        r1 = -1;
        r3 = r6.hashCode();
        switch(r3) {
            case 53: goto L_0x01f4;
            case 56: goto L_0x01fd;
            case 1567: goto L_0x0207;
            case 1572: goto L_0x021b;
            case 1824: goto L_0x0211;
            default: goto L_0x01e2;
        };
    L_0x01e2:
        r0 = r1;
    L_0x01e3:
        switch(r0) {
            case 0: goto L_0x01e7;
            case 1: goto L_0x0225;
            case 2: goto L_0x0244;
            case 3: goto L_0x0252;
            case 4: goto L_0x025f;
            default: goto L_0x01e6;
        };
    L_0x01e6:
        goto L_0x01c6;
    L_0x01e7:
        r0 = r5.f5451a;
        r1 = 2131165285; // 0x7f070065 float:1.7944783E38 double:1.052935553E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x01c6;
    L_0x01f4:
        r3 = "5";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x01e2;
    L_0x01fc:
        goto L_0x01e3;
    L_0x01fd:
        r0 = "8";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x01e2;
    L_0x0205:
        r0 = r2;
        goto L_0x01e3;
    L_0x0207:
        r0 = "10";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x01e2;
    L_0x020f:
        r0 = 2;
        goto L_0x01e3;
    L_0x0211:
        r0 = "99";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x01e2;
    L_0x0219:
        r0 = 3;
        goto L_0x01e3;
    L_0x021b:
        r0 = "15";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x01e2;
    L_0x0223:
        r0 = 4;
        goto L_0x01e3;
    L_0x0225:
        r0 = r5.f5451a;
        r1 = 2131165431; // 0x7f0700f7 float:1.7945079E38 double:1.052935625E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        r0 = new android.content.Intent;
        r1 = r5.f5451a;
        r1 = r1.getApplicationContext();
        r2 = org.vhack.dev.vhack.MainActivity.class;
        r0.<init>(r1, r2);
        r1 = r5.f5451a;
        r1.startActivity(r0);
        goto L_0x01c6;
    L_0x0244:
        r0 = r5.f5451a;
        r1 = 2131165333; // 0x7f070095 float:1.794488E38 double:1.0529355766E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x01c6;
    L_0x0252:
        r0 = r5.f5451a;
        r1 = "Server is down for Maintenance, please be patient.";
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x01c6;
    L_0x025f:
        r0 = r5.f5451a;
        r0 = android.widget.Toast.makeText(r0, r4, r2);
        r0.show();
        r0 = r5.f5451a;
        r0.m9031l();
        goto L_0x01c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.fi.a(java.lang.String):void");
    }
}
