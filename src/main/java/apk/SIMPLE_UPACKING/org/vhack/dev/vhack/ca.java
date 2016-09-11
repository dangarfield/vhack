package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: GameActivity */
class ca extends AsyncTask {
    final /* synthetic */ GameActivity f5323a;

    ca(GameActivity gameActivity) {
        this.f5323a = gameActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9125a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9126a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5323a.findViewById(2131558763).setVisibility(0);
        this.f5323a.findViewById(2131558756).setEnabled(false);
    }

    protected String m9125a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5323a.getApplicationContext(), "user1::::pass2::::mail", strArr[0] + "::::" + strArr[1] + "::::" + strArr[2], "vh_register.php")).openConnection();
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
    protected void m9126a(java.lang.String r10) {
        /*
        r9 = this;
        r5 = 8;
        r3 = 6;
        r0 = 0;
        r2 = 1;
        r1 = r9.f5323a;
        r4 = 2131558763; // 0x7f0d016b float:1.874285E38 double:1.053129957E-314;
        r1 = r1.findViewById(r4);
        r1.setVisibility(r5);
        r1 = r9.f5323a;
        r4 = 2131558756; // 0x7f0d0164 float:1.8742837E38 double:1.0531299534E-314;
        r1 = r1.findViewById(r4);
        r1.setEnabled(r2);
        r1 = r10.length();
        if (r1 <= r3) goto L_0x0072;
    L_0x0023:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f6 }
        r1.<init>(r10);	 Catch:{ JSONException -> 0x00f6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00f6 }
        r4.<init>();	 Catch:{ JSONException -> 0x00f6 }
        r5 = "result";
        r5 = r1.getString(r5);	 Catch:{ JSONException -> 0x00f6 }
        r4 = r4.append(r5);	 Catch:{ JSONException -> 0x00f6 }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ JSONException -> 0x00f6 }
        r4 = r4.toString();	 Catch:{ JSONException -> 0x00f6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00f6 }
        r5.<init>();	 Catch:{ JSONException -> 0x00f6 }
        r6 = "needact";
        r6 = r1.getString(r6);	 Catch:{ JSONException -> 0x00f6 }
        r5 = r5.append(r6);	 Catch:{ JSONException -> 0x00f6 }
        r6 = "";
        r5 = r5.append(r6);	 Catch:{ JSONException -> 0x00f6 }
        r5 = r5.toString();	 Catch:{ JSONException -> 0x00f6 }
        r6 = "user";
        r6 = r1.getString(r6);	 Catch:{ JSONException -> 0x00f6 }
        r7 = "pass";
        r7 = r1.getString(r7);	 Catch:{ JSONException -> 0x00f6 }
        r1 = -1;
        r8 = r4.hashCode();	 Catch:{ JSONException -> 0x00f6 }
        switch(r8) {
            case 48: goto L_0x0073;
            case 49: goto L_0x009a;
            case 50: goto L_0x007c;
            case 51: goto L_0x0086;
            case 52: goto L_0x0090;
            case 53: goto L_0x00a4;
            case 1567: goto L_0x00ae;
            default: goto L_0x006e;
        };	 Catch:{ JSONException -> 0x00f6 }
    L_0x006e:
        r0 = r1;
    L_0x006f:
        switch(r0) {
            case 0: goto L_0x00b8;
            case 1: goto L_0x0126;
            case 2: goto L_0x0135;
            case 3: goto L_0x0144;
            case 4: goto L_0x0153;
            case 5: goto L_0x0162;
            case 6: goto L_0x0171;
            default: goto L_0x0072;
        };	 Catch:{ JSONException -> 0x00f6 }
    L_0x0072:
        return;
    L_0x0073:
        r2 = "0";
        r2 = r4.equals(r2);	 Catch:{ JSONException -> 0x00f6 }
        if (r2 == 0) goto L_0x006e;
    L_0x007b:
        goto L_0x006f;
    L_0x007c:
        r0 = "2";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x0084:
        r0 = r2;
        goto L_0x006f;
    L_0x0086:
        r0 = "3";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x008e:
        r0 = 2;
        goto L_0x006f;
    L_0x0090:
        r0 = "4";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x0098:
        r0 = 3;
        goto L_0x006f;
    L_0x009a:
        r0 = "1";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x00a2:
        r0 = 4;
        goto L_0x006f;
    L_0x00a4:
        r0 = "5";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x00ac:
        r0 = 5;
        goto L_0x006f;
    L_0x00ae:
        r0 = "10";
        r0 = r4.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x006e;
    L_0x00b6:
        r0 = r3;
        goto L_0x006f;
    L_0x00b8:
        r0 = "0";
        r0 = r5.equals(r0);	 Catch:{ JSONException -> 0x00f6 }
        if (r0 == 0) goto L_0x00fc;
    L_0x00c0:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165396; // 0x7f0700d4 float:1.7945008E38 double:1.052935608E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = "loginData.xml";
        r2 = 0;
        r0 = r0.getSharedPreferences(r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0 = r0.edit();	 Catch:{ JSONException -> 0x00f6 }
        r1 = "strUser";
        r0.putString(r1, r6);	 Catch:{ JSONException -> 0x00f6 }
        r1 = "strPass";
        r0.putString(r1, r7);	 Catch:{ JSONException -> 0x00f6 }
        r0.commit();	 Catch:{ JSONException -> 0x00f6 }
        r0 = new org.vhack.dev.vhack.cb;	 Catch:{ JSONException -> 0x00f6 }
        r1 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x00f6 }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ JSONException -> 0x00f6 }
        r0.execute(r1);	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x00f6:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0072;
    L_0x00fc:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165397; // 0x7f0700d5 float:1.794501E38 double:1.0529356083E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131558757; // 0x7f0d0165 float:1.8742839E38 double:1.053129954E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x00f6 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ JSONException -> 0x00f6 }
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131558750; // 0x7f0d015e float:1.8742825E38 double:1.0531299505E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x00f6 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0126:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165432; // 0x7f0700f8 float:1.794508E38 double:1.0529356256E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0135:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165267; // 0x7f070053 float:1.7944746E38 double:1.052935544E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0144:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165327; // 0x7f07008f float:1.7944868E38 double:1.0529355737E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0153:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165428; // 0x7f0700f4 float:1.7945073E38 double:1.0529356236E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0162:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165330; // 0x7f070092 float:1.7944874E38 double:1.052935575E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
    L_0x0171:
        r0 = r9.f5323a;	 Catch:{ JSONException -> 0x00f6 }
        r1 = 2131165333; // 0x7f070095 float:1.794488E38 double:1.0529355766E-314;
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ JSONException -> 0x00f6 }
        r0.show();	 Catch:{ JSONException -> 0x00f6 }
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.ca.a(java.lang.String):void");
    }
}
