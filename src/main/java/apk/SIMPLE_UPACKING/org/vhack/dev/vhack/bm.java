package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ConsoleActivity */
class bm extends AsyncTask {
    final /* synthetic */ ConsoleActivity f5302a;

    bm(ConsoleActivity consoleActivity) {
        this.f5302a = consoleActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9097a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9098a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9097a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://vhack.biz/api/v3/vh_update.php?user=" + strArr[0] + "&pass=" + strArr[1]).openConnection();
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
    protected void m9098a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        r2 = 1;
        r1 = r6.length();
        r3 = 20;
        if (r1 <= r3) goto L_0x0141;
    L_0x000a:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x013c }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x013c }
        r1 = r5.f5302a;	 Catch:{ JSONException -> 0x013c }
        r2 = "loginData.xml";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r1 = r1.edit();	 Catch:{ JSONException -> 0x013c }
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x013c }
        r3 = "0";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x013c }
        if (r2 == 0) goto L_0x0037;
    L_0x002a:
        r2 = r5.f5302a;	 Catch:{ JSONException -> 0x013c }
        r3 = 2131165369; // 0x7f0700b9 float:1.7944953E38 double:1.0529355944E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x013c }
        r2.show();	 Catch:{ JSONException -> 0x013c }
    L_0x0037:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x013c }
        r3 = "2";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x013c }
        if (r2 == 0) goto L_0x0052;
    L_0x0045:
        r2 = r5.f5302a;	 Catch:{ JSONException -> 0x013c }
        r3 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x013c }
        r2.show();	 Catch:{ JSONException -> 0x013c }
    L_0x0052:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x013c }
        r3 = "1";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x013c }
        if (r2 == 0) goto L_0x013b;
    L_0x0060:
        r2 = "money";
        r3 = "money";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "inet";
        r3 = "inet";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "hdd";
        r3 = "hdd";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "cpu";
        r3 = "cpu";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "ram";
        r3 = "ram";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "myip";
        r3 = "ip";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "fw";
        r3 = "fw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "av";
        r3 = "av";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "sdk";
        r3 = "sdk";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "ipsp";
        r3 = "ipsp";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "spam";
        r3 = "spam";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "scan";
        r3 = "scan";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "score";
        r3 = "score";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "netcoins";
        r3 = "netcoins";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "energy";
        r3 = "energy";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "active";
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "syslog";
        r3 = "syslog";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x013c }
        r2 = "urmail";
        r3 = "urmail";
        r0 = r0.getString(r3);	 Catch:{ JSONException -> 0x013c }
        r1.putString(r2, r0);	 Catch:{ JSONException -> 0x013c }
        r0 = "strUser";
        r2 = r5.f5302a;	 Catch:{ JSONException -> 0x013c }
        r2 = r2.f5042o;	 Catch:{ JSONException -> 0x013c }
        r1.putString(r0, r2);	 Catch:{ JSONException -> 0x013c }
        r0 = "strPass";
        r2 = r5.f5302a;	 Catch:{ JSONException -> 0x013c }
        r2 = r2.f5043p;	 Catch:{ JSONException -> 0x013c }
        r1.putString(r0, r2);	 Catch:{ JSONException -> 0x013c }
        r1.commit();	 Catch:{ JSONException -> 0x013c }
    L_0x013b:
        return;
    L_0x013c:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x013b;
    L_0x0141:
        r1 = "\n";
        r3 = "";
        r1 = r6.replace(r1, r3);
        r3 = "\r";
        r4 = "";
        r1 = r1.replace(r3, r4);
        r3 = "\t";
        r4 = "";
        r1 = r1.replace(r3, r4);
        r3 = " ";
        r4 = "";
        r3 = r1.replace(r3, r4);
        r1 = -1;
        r4 = r3.hashCode();
        switch(r4) {
            case 53: goto L_0x017b;
            case 54: goto L_0x0169;
            case 55: goto L_0x0169;
            case 56: goto L_0x0184;
            default: goto L_0x0169;
        };
    L_0x0169:
        r0 = r1;
    L_0x016a:
        switch(r0) {
            case 0: goto L_0x016e;
            case 1: goto L_0x018e;
            default: goto L_0x016d;
        };
    L_0x016d:
        goto L_0x013b;
    L_0x016e:
        r0 = r5.f5302a;
        r1 = 2131165285; // 0x7f070065 float:1.7944783E38 double:1.052935553E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x013b;
    L_0x017b:
        r4 = "5";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0169;
    L_0x0183:
        goto L_0x016a;
    L_0x0184:
        r0 = "8";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0169;
    L_0x018c:
        r0 = r2;
        goto L_0x016a;
    L_0x018e:
        r0 = r5.f5302a;
        r1 = 2131165431; // 0x7f0700f7 float:1.7945079E38 double:1.052935625E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x013b;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.bm.a(java.lang.String):void");
    }
}
