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
class bl extends AsyncTask {
    final /* synthetic */ ConsoleActivity f5301a;

    bl(ConsoleActivity consoleActivity) {
        this.f5301a = consoleActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9095a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9096a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5301a.findViewById(2131558696).setVisibility(0);
    }

    protected String m9095a(String... strArr) {
        String str = strArr[0];
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5301a.getApplicationContext(), "target", strArr[0], "vh_trTransfer.php")).openConnection();
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
    protected void m9096a(java.lang.String r14) {
        /*
        r13 = this;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = r13.f5301a;
        r1 = 2131558696; // 0x7f0d0128 float:1.8742715E38 double:1.053129924E-314;
        r0 = r0.findViewById(r1);
        r1 = 8;
        r0.setVisibility(r1);
        r3 = "4";
        r2 = "0";
        r5 = "0";
        r1 = "";
        r0 = "";
        r4 = "";
        r9 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a1 }
        r9.<init>(r14);	 Catch:{ JSONException -> 0x00a1 }
        r0 = "result";
        r3 = r9.getString(r0);	 Catch:{ JSONException -> 0x00a1 }
        r0 = "0";
        r0 = r3.equals(r0);	 Catch:{ JSONException -> 0x00a1 }
        if (r0 == 0) goto L_0x0052;
    L_0x0030:
        r0 = "amount";
        r2 = r9.getString(r0);	 Catch:{ JSONException -> 0x00a1 }
        r0 = "eloch";
        r1 = r9.getString(r0);	 Catch:{ JSONException -> 0x00a1 }
        r0 = "elo";
        r0 = r9.getString(r0);	 Catch:{ JSONException -> 0x00a1 }
        r10 = r13.f5301a;	 Catch:{ JSONException -> 0x00a1 }
        r10 = r10.f5040m;	 Catch:{ JSONException -> 0x00a1 }
        r10 = r10.edit();	 Catch:{ JSONException -> 0x00a1 }
        r11 = "elo";
        r10.putString(r11, r0);	 Catch:{ JSONException -> 0x00a1 }
        r10.commit();	 Catch:{ JSONException -> 0x00a1 }
    L_0x0052:
        r0 = r1;
        r1 = "1";
        r1 = r3.equals(r1);	 Catch:{ JSONException -> 0x01cc }
        if (r1 == 0) goto L_0x01d5;
    L_0x005b:
        r1 = "time";
        r1 = r9.getString(r1);	 Catch:{ JSONException -> 0x01cc }
    L_0x0061:
        r5 = "2";
        r5 = r3.equals(r5);	 Catch:{ JSONException -> 0x01d2 }
        if (r5 == 0) goto L_0x0085;
    L_0x0069:
        r5 = "eloch";
        r0 = r9.getString(r5);	 Catch:{ JSONException -> 0x01d2 }
        r5 = "elo";
        r5 = r9.getString(r5);	 Catch:{ JSONException -> 0x01d2 }
        r9 = r13.f5301a;	 Catch:{ JSONException -> 0x01d2 }
        r9 = r9.f5040m;	 Catch:{ JSONException -> 0x01d2 }
        r9 = r9.edit();	 Catch:{ JSONException -> 0x01d2 }
        r10 = "elo";
        r9.putString(r10, r5);	 Catch:{ JSONException -> 0x01d2 }
        r9.commit();	 Catch:{ JSONException -> 0x01d2 }
    L_0x0085:
        r5 = -1;
        r9 = r3.hashCode();
        switch(r9) {
            case 48: goto L_0x00aa;
            case 49: goto L_0x00b4;
            case 50: goto L_0x00be;
            case 51: goto L_0x00c8;
            case 52: goto L_0x00d2;
            default: goto L_0x008d;
        };
    L_0x008d:
        r3 = r5;
    L_0x008e:
        switch(r3) {
            case 0: goto L_0x00dc;
            case 1: goto L_0x0153;
            case 2: goto L_0x016b;
            case 3: goto L_0x01b4;
            case 4: goto L_0x01c0;
            default: goto L_0x0091;
        };
    L_0x0091:
        r1 = r4;
    L_0x0092:
        r0 = r13.f5301a;
        r2 = 2131558686; // 0x7f0d011e float:1.8742695E38 double:1.053129919E-314;
        r0 = r0.findViewById(r2);
        r0 = (android.widget.TextView) r0;
        r0.append(r1);
        return;
    L_0x00a1:
        r0 = move-exception;
        r12 = r0;
        r0 = r1;
        r1 = r5;
        r5 = r12;
    L_0x00a6:
        r5.printStackTrace();
        goto L_0x0085;
    L_0x00aa:
        r9 = "0";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x008d;
    L_0x00b2:
        r3 = r6;
        goto L_0x008e;
    L_0x00b4:
        r9 = "1";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x008d;
    L_0x00bc:
        r3 = r7;
        goto L_0x008e;
    L_0x00be:
        r9 = "2";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x008d;
    L_0x00c6:
        r3 = r8;
        goto L_0x008e;
    L_0x00c8:
        r9 = "3";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x008d;
    L_0x00d0:
        r3 = 3;
        goto L_0x008e;
    L_0x00d2:
        r9 = "4";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x008d;
    L_0x00da:
        r3 = 4;
        goto L_0x008e;
    L_0x00dc:
        r1 = java.lang.Integer.parseInt(r0);
        if (r1 <= 0) goto L_0x00f5;
    L_0x00e2:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "+";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x00f5:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "Reputation ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r13.f5301a;
        r3 = 2131165425; // 0x7f0700f1 float:1.7945067E38 double:1.052935622E-314;
        r1 = r1.getString(r3);
        r3 = "{TARGET}";
        r4 = r13.f5301a;
        r4 = r4.f5047t;
        r1 = r1.replace(r3, r4);
        r3 = "{GOT}";
        r4 = r13.f5301a;
        r2 = r4.m9011b(r2);
        r1 = r1.replace(r3, r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r1 = r2.append(r1);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = new org.vhack.dev.vhack.bm;
        r2 = r13.f5301a;
        r1.<init>(r2);
        r2 = new java.lang.String[r8];
        r3 = r13.f5301a;
        r3 = r3.f5042o;
        r2[r6] = r3;
        r3 = r13.f5301a;
        r3 = r3.f5043p;
        r2[r7] = r3;
        r1.execute(r2);
        r1 = r0;
        goto L_0x0092;
    L_0x0153:
        r0 = r13.f5301a;
        r2 = 2131165426; // 0x7f0700f2 float:1.7945069E38 double:1.0529356226E-314;
        r0 = r0.getString(r2);
        r2 = "{LEFT}";
        r3 = r13.f5301a;
        r1 = r3.m9010a(r1);
        r0 = r0.replace(r2, r1);
        r1 = r0;
        goto L_0x0092;
    L_0x016b:
        r1 = java.lang.Integer.parseInt(r0);
        if (r1 <= 0) goto L_0x0184;
    L_0x0171:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "+";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0184:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Reputation ";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r13.f5301a;
        r3 = 2131165422; // 0x7f0700ee float:1.794506E38 double:1.0529356206E-314;
        r2 = r2.getString(r3);
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r1 = r0;
        goto L_0x0092;
    L_0x01b4:
        r0 = r13.f5301a;
        r1 = 2131165421; // 0x7f0700ed float:1.7945059E38 double:1.05293562E-314;
        r0 = r0.getString(r1);
        r1 = r0;
        goto L_0x0092;
    L_0x01c0:
        r0 = r13.f5301a;
        r1 = 2131165423; // 0x7f0700ef float:1.7945063E38 double:1.052935621E-314;
        r0 = r0.getString(r1);
        r1 = r0;
        goto L_0x0092;
    L_0x01cc:
        r1 = move-exception;
        r12 = r1;
        r1 = r5;
        r5 = r12;
        goto L_0x00a6;
    L_0x01d2:
        r5 = move-exception;
        goto L_0x00a6;
    L_0x01d5:
        r1 = r5;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.bl.a(java.lang.String):void");
    }
}
