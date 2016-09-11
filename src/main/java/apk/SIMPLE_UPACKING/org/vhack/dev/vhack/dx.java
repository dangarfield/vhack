package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: MainActivity */
class dx extends AsyncTask {
    final /* synthetic */ MainActivity f5396a;

    dx(MainActivity mainActivity) {
        this.f5396a = mainActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9147a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9148a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9147a(String... strArr) {
        String[] strArr2 = new String[2];
        String str = strArr[0];
        if (this.f5396a.f5109M.equals("")) {
            if (this.f5396a.f5134w.equals("")) {
                str = fc.m9164a(this.f5396a.getApplicationContext(), "", "", "vh_update.php");
            } else {
                str = fc.m9164a(this.f5396a.getApplicationContext(), "fyber", this.f5396a.f5134w, "vh_update.php");
            }
        } else if (this.f5396a.f5134w.equals("")) {
            str = fc.m9164a(this.f5396a.getApplicationContext(), "gcm", this.f5396a.f5109M, "vh_update.php");
        } else {
            str = fc.m9164a(this.f5396a.getApplicationContext(), "gcm::::fyber", this.f5396a.f5109M + "::::" + this.f5396a.f5134w, "vh_update.php");
        }
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
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
    protected void m9148a(java.lang.String r7) {
        /*
        r6 = this;
        r3 = 20;
        r0 = 0;
        r2 = 1;
        r1 = r7.length();
        if (r1 <= r3) goto L_0x01fe;
    L_0x000a:
        r0 = r7.length();
        if (r0 <= r3) goto L_0x01f8;
    L_0x0010:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01f9 }
        r0.<init>(r7);	 Catch:{ JSONException -> 0x01f9 }
        r1 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r2 = "loginData.xml";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ JSONException -> 0x01f9 }
        r2 = r1.edit();	 Catch:{ JSONException -> 0x01f9 }
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r4 = "0";
        r3 = r3.equals(r4);	 Catch:{ JSONException -> 0x01f9 }
        if (r3 == 0) goto L_0x0042;
    L_0x0030:
        r3 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r4 = 2131165369; // 0x7f0700b9 float:1.7944953E38 double:1.0529355944E-314;
        r5 = 1;
        r3 = android.widget.Toast.makeText(r3, r4, r5);	 Catch:{ JSONException -> 0x01f9 }
        r3.show();	 Catch:{ JSONException -> 0x01f9 }
        r3 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r3.m9023m();	 Catch:{ JSONException -> 0x01f9 }
    L_0x0042:
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r4 = "2";
        r3 = r3.equals(r4);	 Catch:{ JSONException -> 0x01f9 }
        if (r3 == 0) goto L_0x0062;
    L_0x0050:
        r3 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r4 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5 = 1;
        r3 = android.widget.Toast.makeText(r3, r4, r5);	 Catch:{ JSONException -> 0x01f9 }
        r3.show();	 Catch:{ JSONException -> 0x01f9 }
        r3 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r3.m9023m();	 Catch:{ JSONException -> 0x01f9 }
    L_0x0062:
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r4 = "1";
        r3 = r3.equals(r4);	 Catch:{ JSONException -> 0x01f9 }
        if (r3 == 0) goto L_0x01f8;
    L_0x0070:
        r3 = "lastcmsg";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r4 = "0";
        r3 = r3.equals(r4);	 Catch:{ JSONException -> 0x01f9 }
        if (r3 != 0) goto L_0x00b1;
    L_0x007e:
        r3 = "lastcmsg";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r4 = "";
        r3 = r3.equals(r4);	 Catch:{ JSONException -> 0x01f9 }
        if (r3 != 0) goto L_0x00b1;
    L_0x008c:
        r3 = "lastcmsg";
        r4 = "0";
        r1 = r1.getString(r3, r4);	 Catch:{ JSONException -> 0x01f9 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ JSONException -> 0x01f9 }
        r3 = "lastcmsg";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ JSONException -> 0x01f9 }
        if (r1 >= r3) goto L_0x00b1;
    L_0x00a4:
        r1 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r3 = 2131558842; // 0x7f0d01ba float:1.8743011E38 double:1.053129996E-314;
        r1 = r1.findViewById(r3);	 Catch:{ JSONException -> 0x01f9 }
        r3 = 0;
        r1.setVisibility(r3);	 Catch:{ JSONException -> 0x01f9 }
    L_0x00b1:
        r1 = "money";
        r3 = "money";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "inet";
        r3 = "inet";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "hdd";
        r3 = "hdd";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "myip";
        r3 = "ip";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "cpu";
        r3 = "cpu";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "ram";
        r3 = "ram";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "fw";
        r3 = "fw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "av";
        r3 = "av";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "sdk";
        r3 = "sdk";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "ipsp";
        r3 = "ipsp";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "spam";
        r3 = "spam";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "scan";
        r3 = "scan";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "adw";
        r3 = "adw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "actadw";
        r3 = "actadw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "netcoins";
        r3 = "netcoins";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "urmail";
        r3 = "urmail";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "score";
        r3 = "score";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "energy";
        r3 = "energy";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "active";
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "elo";
        r3 = "elo";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "clusterID";
        r3 = "clusterID";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "position";
        r3 = "position";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "syslog";
        r3 = "syslog";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "lastcmsg";
        r3 = "lastcmsg";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "rank";
        r3 = "rank";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "event";
        r3 = "event";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "bonus";
        r3 = "bonus";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "mystery";
        r3 = "mystery";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r3);	 Catch:{ JSONException -> 0x01f9 }
        r1 = "uhash";
        r3 = "uhash";
        r0 = r0.getString(r3);	 Catch:{ JSONException -> 0x01f9 }
        r2.putString(r1, r0);	 Catch:{ JSONException -> 0x01f9 }
        r2.commit();	 Catch:{ JSONException -> 0x01f9 }
        r0 = r6.f5396a;	 Catch:{ JSONException -> 0x01f9 }
        r0.m9022l();	 Catch:{ JSONException -> 0x01f9 }
    L_0x01f8:
        return;
    L_0x01f9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x01f8;
    L_0x01fe:
        r1 = -1;
        r3 = r7.hashCode();
        switch(r3) {
            case 53: goto L_0x0218;
            case 56: goto L_0x0221;
            case 1567: goto L_0x022b;
            case 1572: goto L_0x023f;
            case 1824: goto L_0x0235;
            default: goto L_0x0206;
        };
    L_0x0206:
        r0 = r1;
    L_0x0207:
        switch(r0) {
            case 0: goto L_0x020b;
            case 1: goto L_0x0249;
            case 2: goto L_0x01f8;
            case 3: goto L_0x025b;
            case 4: goto L_0x026c;
            default: goto L_0x020a;
        };
    L_0x020a:
        goto L_0x01f8;
    L_0x020b:
        r0 = r6.f5396a;
        r1 = 2131165285; // 0x7f070065 float:1.7944783E38 double:1.052935553E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x01f8;
    L_0x0218:
        r3 = "5";
        r3 = r7.equals(r3);
        if (r3 == 0) goto L_0x0206;
    L_0x0220:
        goto L_0x0207;
    L_0x0221:
        r0 = "8";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0206;
    L_0x0229:
        r0 = r2;
        goto L_0x0207;
    L_0x022b:
        r0 = "10";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0206;
    L_0x0233:
        r0 = 2;
        goto L_0x0207;
    L_0x0235:
        r0 = "99";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0206;
    L_0x023d:
        r0 = 3;
        goto L_0x0207;
    L_0x023f:
        r0 = "15";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0206;
    L_0x0247:
        r0 = 4;
        goto L_0x0207;
    L_0x0249:
        r0 = r6.f5396a;
        r1 = 2131165431; // 0x7f0700f7 float:1.7945079E38 double:1.052935625E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        r0 = r6.f5396a;
        r0.m9023m();
        goto L_0x01f8;
    L_0x025b:
        r0 = r6.f5396a;
        r1 = "Server is down for Maintenance, please be patient.";
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        r0 = r6.f5396a;
        r0.m9023m();
        goto L_0x01f8;
    L_0x026c:
        r0 = r6.f5396a;
        r1 = 2131165345; // 0x7f0700a1 float:1.7944904E38 double:1.0529355826E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        r0 = r6.f5396a;
        r0.m9023m();
        goto L_0x01f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.dx.a(java.lang.String):void");
    }
}
