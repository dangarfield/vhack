package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: NetworkActivity */
class eu extends AsyncTask {
    final /* synthetic */ NetworkActivity f5420a;

    eu(NetworkActivity networkActivity) {
        this.f5420a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9155a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9156a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5420a.findViewById(2131558689).setEnabled(false);
        this.f5420a.findViewById(2131558690).setEnabled(false);
        this.f5420a.findViewById(2131558689).setEnabled(false);
        this.f5420a.findViewById(2131558903).setEnabled(false);
        this.f5420a.findViewById(2131558866).setEnabled(false);
        this.f5420a.findViewById(2131558870).setEnabled(false);
        this.f5420a.findViewById(2131558874).setEnabled(false);
        this.f5420a.findViewById(2131558878).setEnabled(false);
        this.f5420a.findViewById(2131558882).setEnabled(false);
        this.f5420a.findViewById(2131558886).setEnabled(false);
        this.f5420a.findViewById(2131558890).setEnabled(false);
        this.f5420a.findViewById(2131558894).setEnabled(false);
        this.f5420a.findViewById(2131558898).setEnabled(false);
    }

    protected String m9155a(String... strArr) {
        String str = strArr[0];
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5420a.getApplicationContext(), "target", strArr[0], "vh_trTransfer.php")).openConnection();
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
    protected void m9156a(java.lang.String r14) {
        /*
        r13 = this;
        r11 = 2131165427; // 0x7f0700f3 float:1.794507E38 double:1.052935623E-314;
        r6 = 1;
        r3 = "4";
        r2 = "0";
        r5 = "0";
        r1 = "";
        r0 = "";
        r4 = "";
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00e2 }
        r7.<init>(r14);	 Catch:{ JSONException -> 0x00e2 }
        r0 = "result";
        r3 = r7.getString(r0);	 Catch:{ JSONException -> 0x00e2 }
        r0 = "0";
        r0 = r3.equals(r0);	 Catch:{ JSONException -> 0x00e2 }
        if (r0 == 0) goto L_0x0050;
    L_0x0023:
        r0 = "amount";
        r2 = r7.getString(r0);	 Catch:{ JSONException -> 0x00e2 }
        r0 = "eloch";
        r1 = r7.getString(r0);	 Catch:{ JSONException -> 0x00e2 }
        r0 = "elo";
        r0 = r7.getString(r0);	 Catch:{ JSONException -> 0x00e2 }
        r8 = "newmoney";
        r8 = r7.getString(r8);	 Catch:{ JSONException -> 0x00e2 }
        r9 = r13.f5420a;	 Catch:{ JSONException -> 0x00e2 }
        r9 = r9.f5143n;	 Catch:{ JSONException -> 0x00e2 }
        r9 = r9.edit();	 Catch:{ JSONException -> 0x00e2 }
        r10 = "elo";
        r9.putString(r10, r0);	 Catch:{ JSONException -> 0x00e2 }
        r0 = "money";
        r9.putString(r0, r8);	 Catch:{ JSONException -> 0x00e2 }
        r9.commit();	 Catch:{ JSONException -> 0x00e2 }
    L_0x0050:
        r0 = r1;
        r1 = "1";
        r1 = r3.equals(r1);	 Catch:{ JSONException -> 0x01f2 }
        if (r1 == 0) goto L_0x01fb;
    L_0x0059:
        r1 = "time";
        r1 = r7.getString(r1);	 Catch:{ JSONException -> 0x01f2 }
    L_0x005f:
        r5 = "2";
        r5 = r3.equals(r5);	 Catch:{ JSONException -> 0x01f8 }
        if (r5 == 0) goto L_0x0083;
    L_0x0067:
        r5 = "eloch";
        r0 = r7.getString(r5);	 Catch:{ JSONException -> 0x01f8 }
        r5 = "elo";
        r5 = r7.getString(r5);	 Catch:{ JSONException -> 0x01f8 }
        r7 = r13.f5420a;	 Catch:{ JSONException -> 0x01f8 }
        r7 = r7.f5143n;	 Catch:{ JSONException -> 0x01f8 }
        r7 = r7.edit();	 Catch:{ JSONException -> 0x01f8 }
        r8 = "elo";
        r7.putString(r8, r5);	 Catch:{ JSONException -> 0x01f8 }
        r7.commit();	 Catch:{ JSONException -> 0x01f8 }
    L_0x0083:
        r5 = -1;
        r7 = r3.hashCode();
        switch(r7) {
            case 48: goto L_0x00eb;
            case 49: goto L_0x00f5;
            case 50: goto L_0x00ff;
            case 51: goto L_0x0109;
            case 52: goto L_0x0114;
            default: goto L_0x008b;
        };
    L_0x008b:
        r3 = r5;
    L_0x008c:
        switch(r3) {
            case 0: goto L_0x011f;
            case 1: goto L_0x017d;
            case 2: goto L_0x0194;
            case 3: goto L_0x01dc;
            case 4: goto L_0x01e7;
            default: goto L_0x008f;
        };
    L_0x008f:
        r0 = r4;
    L_0x0090:
        r1 = r13.f5420a;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r13.f5420a;
        r3 = r3.getString(r11);
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        r1.f5152w = r2;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r13.f5420a;
        r2 = r2.getString(r11);
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r13.f5420a;
        r1 = r1.f5148s;
        r2 = "\n";
        r1.m9018a(r0, r2);
        r0 = r13.f5420a;
        r0 = r0.f5148s;
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0.m9017a(r1, r6);
        r0 = new java.lang.Thread;
        r1 = new org.vhack.dev.vhack.ev;
        r1.<init>(r13);
        r0.<init>(r1);
        r0.start();
        return;
    L_0x00e2:
        r0 = move-exception;
        r12 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r12;
    L_0x00e7:
        r5.printStackTrace();
        goto L_0x0083;
    L_0x00eb:
        r7 = "0";
        r3 = r3.equals(r7);
        if (r3 == 0) goto L_0x008b;
    L_0x00f3:
        r3 = 0;
        goto L_0x008c;
    L_0x00f5:
        r7 = "1";
        r3 = r3.equals(r7);
        if (r3 == 0) goto L_0x008b;
    L_0x00fd:
        r3 = r6;
        goto L_0x008c;
    L_0x00ff:
        r7 = "2";
        r3 = r3.equals(r7);
        if (r3 == 0) goto L_0x008b;
    L_0x0107:
        r3 = 2;
        goto L_0x008c;
    L_0x0109:
        r7 = "3";
        r3 = r3.equals(r7);
        if (r3 == 0) goto L_0x008b;
    L_0x0111:
        r3 = 3;
        goto L_0x008c;
    L_0x0114:
        r7 = "4";
        r3 = r3.equals(r7);
        if (r3 == 0) goto L_0x008b;
    L_0x011c:
        r3 = 4;
        goto L_0x008c;
    L_0x011f:
        r1 = java.lang.Integer.parseInt(r0);
        if (r1 <= 0) goto L_0x0138;
    L_0x0125:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "+";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0138:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "Reputation ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r13.f5420a;
        r3 = 2131165425; // 0x7f0700f1 float:1.7945067E38 double:1.052935622E-314;
        r1 = r1.getString(r3);
        r3 = "{TARGET}";
        r4 = r13.f5420a;
        r4 = r4.f5147r;
        r1 = r1.replace(r3, r4);
        r3 = "{GOT}";
        r4 = r13.f5420a;
        r2 = r4.m9027b(r2);
        r1 = r1.replace(r3, r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0090;
    L_0x017d:
        r0 = r13.f5420a;
        r2 = 2131165426; // 0x7f0700f2 float:1.7945069E38 double:1.0529356226E-314;
        r0 = r0.getString(r2);
        r2 = "{LEFT}";
        r3 = r13.f5420a;
        r1 = r3.m9026a(r1);
        r0 = r0.replace(r2, r1);
        goto L_0x0090;
    L_0x0194:
        r1 = java.lang.Integer.parseInt(r0);
        if (r1 <= 0) goto L_0x01ad;
    L_0x019a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "+";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x01ad:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Reputation ";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r13.f5420a;
        r3 = 2131165422; // 0x7f0700ee float:1.794506E38 double:1.0529356206E-314;
        r2 = r2.getString(r3);
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0090;
    L_0x01dc:
        r0 = r13.f5420a;
        r1 = 2131165421; // 0x7f0700ed float:1.7945059E38 double:1.05293562E-314;
        r0 = r0.getString(r1);
        goto L_0x0090;
    L_0x01e7:
        r0 = r13.f5420a;
        r1 = 2131165423; // 0x7f0700ef float:1.7945063E38 double:1.052935621E-314;
        r0 = r0.getString(r1);
        goto L_0x0090;
    L_0x01f2:
        r1 = move-exception;
        r12 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x00e7;
    L_0x01f8:
        r5 = move-exception;
        goto L_0x00e7;
    L_0x01fb:
        r1 = r5;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.eu.a(java.lang.String):void");
    }
}
