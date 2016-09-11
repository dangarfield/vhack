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
class cb extends AsyncTask {
    final /* synthetic */ GameActivity f5324a;

    cb(GameActivity gameActivity) {
        this.f5324a = gameActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9127a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9128a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5324a.findViewById(2131558763).setVisibility(0);
        this.f5324a.findViewById(2131558758).setEnabled(false);
    }

    protected String m9127a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5324a.getApplicationContext(), "", "", "vh_update.php")).openConnection();
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
    protected void m9128a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        r2 = 1;
        r1 = r5.f5324a;
        r3 = 2131558763; // 0x7f0d016b float:1.874285E38 double:1.053129957E-314;
        r1 = r1.findViewById(r3);
        r3 = 8;
        r1.setVisibility(r3);
        r1 = r5.f5324a;
        r3 = 2131558758; // 0x7f0d0166 float:1.874284E38 double:1.0531299544E-314;
        r1 = r1.findViewById(r3);
        r1.setEnabled(r2);
        r1 = r6.length();
        r3 = 20;
        if (r1 <= r3) goto L_0x019f;
    L_0x0024:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x019a }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x019a }
        r1 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r2 = "loginData.xml";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r1 = r1.edit();	 Catch:{ JSONException -> 0x019a }
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x019a }
        r3 = "0";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x019a }
        if (r2 == 0) goto L_0x0051;
    L_0x0044:
        r2 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r3 = 2131165369; // 0x7f0700b9 float:1.7944953E38 double:1.0529355944E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x019a }
        r2.show();	 Catch:{ JSONException -> 0x019a }
    L_0x0051:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x019a }
        r3 = "2";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x019a }
        if (r2 == 0) goto L_0x006c;
    L_0x005f:
        r2 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r3 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4 = 1;
        r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ JSONException -> 0x019a }
        r2.show();	 Catch:{ JSONException -> 0x019a }
    L_0x006c:
        r2 = "active";
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x019a }
        r3 = "1";
        r2 = r2.equals(r3);	 Catch:{ JSONException -> 0x019a }
        if (r2 == 0) goto L_0x0199;
    L_0x007a:
        r2 = "money";
        r3 = "money";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "id";
        r3 = "id";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "inet";
        r3 = "inet";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "hdd";
        r3 = "hdd";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "cpu";
        r3 = "cpu";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "ram";
        r3 = "ram";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "myip";
        r3 = "ip";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "fw";
        r3 = "fw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "av";
        r3 = "av";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "sdk";
        r3 = "sdk";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "ipsp";
        r3 = "ipsp";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "spam";
        r3 = "spam";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "scan";
        r3 = "scan";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "adw";
        r3 = "adw";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "score";
        r3 = "score";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "netcoins";
        r3 = "netcoins";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "energy";
        r3 = "energy";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "urmail";
        r3 = "urmail";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "active";
        r3 = "active";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "elo";
        r3 = "elo";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "strUser";
        r3 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r3 = r3.f5059m;	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "strPass";
        r3 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r3 = r3.f5060n;	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "hash";
        r3 = "hash";
        r3 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r3);	 Catch:{ JSONException -> 0x019a }
        r2 = "uhash";
        r3 = "uhash";
        r0 = r0.getString(r3);	 Catch:{ JSONException -> 0x019a }
        r1.putString(r2, r0);	 Catch:{ JSONException -> 0x019a }
        r1.commit();	 Catch:{ JSONException -> 0x019a }
        r0 = new android.content.Intent;	 Catch:{ JSONException -> 0x019a }
        r1 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r1 = r1.getApplicationContext();	 Catch:{ JSONException -> 0x019a }
        r2 = org.vhack.dev.vhack.MainActivity.class;
        r0.<init>(r1, r2);	 Catch:{ JSONException -> 0x019a }
        r1 = "chat";
        r2 = 1;
        r0.putExtra(r1, r2);	 Catch:{ JSONException -> 0x019a }
        r1 = r5.f5324a;	 Catch:{ JSONException -> 0x019a }
        r1.startActivity(r0);	 Catch:{ JSONException -> 0x019a }
    L_0x0199:
        return;
    L_0x019a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0199;
    L_0x019f:
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
            case 53: goto L_0x01d9;
            case 56: goto L_0x01e2;
            case 1567: goto L_0x0200;
            case 1572: goto L_0x01ec;
            case 1824: goto L_0x01f6;
            default: goto L_0x01c7;
        };
    L_0x01c7:
        r0 = r1;
    L_0x01c8:
        switch(r0) {
            case 0: goto L_0x01cc;
            case 1: goto L_0x020a;
            case 2: goto L_0x0217;
            case 3: goto L_0x0225;
            case 4: goto L_0x0232;
            default: goto L_0x01cb;
        };
    L_0x01cb:
        goto L_0x0199;
    L_0x01cc:
        r0 = r5.f5324a;
        r1 = 2131165285; // 0x7f070065 float:1.7944783E38 double:1.052935553E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x0199;
    L_0x01d9:
        r4 = "5";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x01c7;
    L_0x01e1:
        goto L_0x01c8;
    L_0x01e2:
        r0 = "8";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x01c7;
    L_0x01ea:
        r0 = r2;
        goto L_0x01c8;
    L_0x01ec:
        r0 = "15";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x01c7;
    L_0x01f4:
        r0 = 2;
        goto L_0x01c8;
    L_0x01f6:
        r0 = "99";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x01c7;
    L_0x01fe:
        r0 = 3;
        goto L_0x01c8;
    L_0x0200:
        r0 = "10";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x01c7;
    L_0x0208:
        r0 = 4;
        goto L_0x01c8;
    L_0x020a:
        r0 = r5.f5324a;
        r1 = 2131165431; // 0x7f0700f7 float:1.7945079E38 double:1.052935625E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x0199;
    L_0x0217:
        r0 = r5.f5324a;
        r1 = 2131165345; // 0x7f0700a1 float:1.7944904E38 double:1.0529355826E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x0199;
    L_0x0225:
        r0 = r5.f5324a;
        r1 = "Server is down for Maintenance, please be patient.";
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x0199;
    L_0x0232:
        r0 = r5.f5324a;
        r1 = 2131165333; // 0x7f070095 float:1.794488E38 double:1.0529355766E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x0199;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.cb.a(java.lang.String):void");
    }
}
