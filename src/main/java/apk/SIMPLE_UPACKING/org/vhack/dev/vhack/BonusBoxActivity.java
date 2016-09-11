package org.vhack.dev.vhack;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: org.vhack.dev.vhack.o */
class BonusBoxActivity extends AsyncTask {
    final /* synthetic */ BonusBoxActivity f5481a;

    BonusBoxActivity(BonusBoxActivity bonusBoxActivity) {
        this.f5481a = bonusBoxActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9185a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9186a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5481a.findViewById(2131558571).setVisibility(0);
    }

    protected String m9185a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5481a.getApplicationContext(), "", "", "vh_openFreeBonus.php")).openConnection();
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
    protected void m9186a(java.lang.String r13) {
        /*
        r12 = this;
        r3 = 0;
        r0 = r12.f5481a;
        r1 = 2131558571; // 0x7f0d00ab float:1.8742462E38 double:1.053129862E-314;
        r0 = r0.findViewById(r1);
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r13.length();
        r1 = 5;
        if (r0 <= r1) goto L_0x0575;
    L_0x0016:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x016e }
        r5.<init>(r13);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = 2131558574; // 0x7f0d00ae float:1.8742468E38 double:1.0531298635E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.ImageView) r0;	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = 2131558575; // 0x7f0d00af float:1.874247E38 double:1.053129864E-314;
        r1 = r1.findViewById(r2);	 Catch:{ JSONException -> 0x016e }
        r1 = (android.widget.TextView) r1;	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = 2131558576; // 0x7f0d00b0 float:1.8742472E38 double:1.0531298645E-314;
        r2 = r2.findViewById(r4);	 Catch:{ JSONException -> 0x016e }
        r2 = (android.widget.TextView) r2;	 Catch:{ JSONException -> 0x016e }
        r4 = "type";
        r6 = r5.getString(r4);	 Catch:{ JSONException -> 0x016e }
        r4 = -1;
        r7 = r6.hashCode();	 Catch:{ JSONException -> 0x016e }
        switch(r7) {
            case 48: goto L_0x005c;
            case 49: goto L_0x0065;
            case 50: goto L_0x006f;
            case 51: goto L_0x0079;
            default: goto L_0x004a;
        };	 Catch:{ JSONException -> 0x016e }
    L_0x004a:
        r3 = r4;
    L_0x004b:
        switch(r3) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0174;
            case 2: goto L_0x0260;
            case 3: goto L_0x052f;
            default: goto L_0x004e;
        };	 Catch:{ JSONException -> 0x016e }
    L_0x004e:
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = 2131558572; // 0x7f0d00ac float:1.8742464E38 double:1.0531298625E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x016e }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ JSONException -> 0x016e }
    L_0x005b:
        return;
    L_0x005c:
        r7 = "0";
        r6 = r6.equals(r7);	 Catch:{ JSONException -> 0x016e }
        if (r6 == 0) goto L_0x004a;
    L_0x0064:
        goto L_0x004b;
    L_0x0065:
        r3 = "1";
        r3 = r6.equals(r3);	 Catch:{ JSONException -> 0x016e }
        if (r3 == 0) goto L_0x004a;
    L_0x006d:
        r3 = 1;
        goto L_0x004b;
    L_0x006f:
        r3 = "2";
        r3 = r6.equals(r3);	 Catch:{ JSONException -> 0x016e }
        if (r3 == 0) goto L_0x004a;
    L_0x0077:
        r3 = 2;
        goto L_0x004b;
    L_0x0079:
        r3 = "3";
        r3 = r6.equals(r3);	 Catch:{ JSONException -> 0x016e }
        if (r3 == 0) goto L_0x004a;
    L_0x0081:
        r3 = 3;
        goto L_0x004b;
    L_0x0083:
        r3 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r3 = r3.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837619; // 0x7f020073 float:1.7280197E38 double:1.0527736644E-314;
        r3 = r3.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r3);	 Catch:{ JSONException -> 0x016e }
        r0 = "NetCoins";
        r1.setText(r0);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = 2131558562; // 0x7f0d00a2 float:1.8742443E38 double:1.0531298576E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.TextView) r0;	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.f4989n;	 Catch:{ JSONException -> 0x016e }
        r3 = "netcoins";
        r4 = "0";
        r1 = r1.getString(r3, r4);	 Catch:{ JSONException -> 0x016e }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ JSONException -> 0x016e }
        r3 = "win";
        r3 = r5.getString(r3);	 Catch:{ JSONException -> 0x016e }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r6 = "bonus";
        r7 = "0";
        r4 = r4.getString(r6, r7);	 Catch:{ JSONException -> 0x016e }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ JSONException -> 0x016e }
        r6 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r8 = r1 + r3;
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x016e }
        r8 = "";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x016e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x016e }
        r6 = r6.m9006a(r7);	 Catch:{ JSONException -> 0x016e }
        r0.setText(r6);	 Catch:{ JSONException -> 0x016e }
        r0 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r0.<init>();	 Catch:{ JSONException -> 0x016e }
        r6 = "+";
        r0 = r0.append(r6);	 Catch:{ JSONException -> 0x016e }
        r6 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r7 = r7.append(r3);	 Catch:{ JSONException -> 0x016e }
        r8 = "";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x016e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x016e }
        r6 = r6.m9006a(r7);	 Catch:{ JSONException -> 0x016e }
        r0 = r0.append(r6);	 Catch:{ JSONException -> 0x016e }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x016e }
        r2.setText(r0);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = 2131558565; // 0x7f0d00a5 float:1.874245E38 double:1.053129859E-314;
        r0 = r0.findViewById(r2);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.TextView) r0;	 Catch:{ JSONException -> 0x016e }
        r2 = "bleft";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r0.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.f4989n;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.edit();	 Catch:{ JSONException -> 0x016e }
        r2 = "netcoins";
        r5 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r5.<init>();	 Catch:{ JSONException -> 0x016e }
        r1 = r1 + r3;
        r1 = r5.append(r1);	 Catch:{ JSONException -> 0x016e }
        r3 = "";
        r1 = r1.append(r3);	 Catch:{ JSONException -> 0x016e }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x016e }
        r0.putString(r2, r1);	 Catch:{ JSONException -> 0x016e }
        r1 = "bonus";
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r2.<init>();	 Catch:{ JSONException -> 0x016e }
        r3 = r4 + -1;
        r2 = r2.append(r3);	 Catch:{ JSONException -> 0x016e }
        r3 = "";
        r2 = r2.append(r3);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r0.putString(r1, r2);	 Catch:{ JSONException -> 0x016e }
        r0.commit();	 Catch:{ JSONException -> 0x016e }
        goto L_0x004e;
    L_0x016e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x005b;
    L_0x0174:
        r3 = "Money";
        r1.setText(r3);	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.getResources();	 Catch:{ JSONException -> 0x016e }
        r3 = 2130837720; // 0x7f0200d8 float:1.7280402E38 double:1.0527737143E-314;
        r1 = r1.getDrawable(r3);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = 2131558560; // 0x7f0d00a0 float:1.874244E38 double:1.0531298566E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.TextView) r0;	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.f4989n;	 Catch:{ JSONException -> 0x016e }
        r3 = "money";
        r4 = "0";
        r1 = r1.getString(r3, r4);	 Catch:{ JSONException -> 0x016e }
        r6 = java.lang.Long.parseLong(r1);	 Catch:{ JSONException -> 0x016e }
        r1 = "win";
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x016e }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ JSONException -> 0x016e }
        r3 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r3 = r3.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "bonus";
        r8 = "0";
        r3 = r3.getString(r4, r8);	 Catch:{ JSONException -> 0x016e }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r8.<init>();	 Catch:{ JSONException -> 0x016e }
        r10 = (long) r1;	 Catch:{ JSONException -> 0x016e }
        r10 = r10 + r6;
        r8 = r8.append(r10);	 Catch:{ JSONException -> 0x016e }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ JSONException -> 0x016e }
        r8 = r8.toString();	 Catch:{ JSONException -> 0x016e }
        r4 = r4.m9006a(r8);	 Catch:{ JSONException -> 0x016e }
        r0.setText(r4);	 Catch:{ JSONException -> 0x016e }
        r0 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r0.<init>();	 Catch:{ JSONException -> 0x016e }
        r4 = "+";
        r0 = r0.append(r4);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r8.<init>();	 Catch:{ JSONException -> 0x016e }
        r8 = r8.append(r1);	 Catch:{ JSONException -> 0x016e }
        r9 = "";
        r8 = r8.append(r9);	 Catch:{ JSONException -> 0x016e }
        r8 = r8.toString();	 Catch:{ JSONException -> 0x016e }
        r4 = r4.m9006a(r8);	 Catch:{ JSONException -> 0x016e }
        r0 = r0.append(r4);	 Catch:{ JSONException -> 0x016e }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x016e }
        r2.setText(r0);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = 2131558565; // 0x7f0d00a5 float:1.874245E38 double:1.053129859E-314;
        r0 = r0.findViewById(r2);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.TextView) r0;	 Catch:{ JSONException -> 0x016e }
        r2 = "bleft";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r0.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.f4989n;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.edit();	 Catch:{ JSONException -> 0x016e }
        r2 = "money";
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r4.<init>();	 Catch:{ JSONException -> 0x016e }
        r8 = (long) r1;	 Catch:{ JSONException -> 0x016e }
        r6 = r6 + r8;
        r1 = r4.append(r6);	 Catch:{ JSONException -> 0x016e }
        r4 = "";
        r1 = r1.append(r4);	 Catch:{ JSONException -> 0x016e }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x016e }
        r0.putString(r2, r1);	 Catch:{ JSONException -> 0x016e }
        r1 = "bonus";
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r2.<init>();	 Catch:{ JSONException -> 0x016e }
        r3 = r3 + -1;
        r2 = r2.append(r3);	 Catch:{ JSONException -> 0x016e }
        r3 = "";
        r2 = r2.append(r3);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r0.putString(r1, r2);	 Catch:{ JSONException -> 0x016e }
        r0.commit();	 Catch:{ JSONException -> 0x016e }
        goto L_0x004e;
    L_0x0260:
        r3 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r3 = r3.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "bonus";
        r6 = "0";
        r3 = r3.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        java.lang.Integer.parseInt(r3);	 Catch:{ JSONException -> 0x016e }
        r3 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = 2131558565; // 0x7f0d00a5 float:1.874245E38 double:1.053129859E-314;
        r3 = r3.findViewById(r4);	 Catch:{ JSONException -> 0x016e }
        r3 = (android.widget.TextView) r3;	 Catch:{ JSONException -> 0x016e }
        r4 = "bleft";
        r4 = r5.getString(r4);	 Catch:{ JSONException -> 0x016e }
        r3.setText(r4);	 Catch:{ JSONException -> 0x016e }
        r3 = "";
        r3 = "lvl";
        r3 = r5.getString(r3);	 Catch:{ JSONException -> 0x016e }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ JSONException -> 0x016e }
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r4.<init>();	 Catch:{ JSONException -> 0x016e }
        r6 = "+";
        r4 = r4.append(r6);	 Catch:{ JSONException -> 0x016e }
        r6 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r7 = r7.append(r3);	 Catch:{ JSONException -> 0x016e }
        r8 = "";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x016e }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x016e }
        r6 = r6.m9006a(r7);	 Catch:{ JSONException -> 0x016e }
        r4 = r4.append(r6);	 Catch:{ JSONException -> 0x016e }
        r4 = r4.toString();	 Catch:{ JSONException -> 0x016e }
        r2.setText(r4);	 Catch:{ JSONException -> 0x016e }
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "1";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x0317;
    L_0x02cc:
        r2 = "Firewall";
        r2 = "Firewall";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837674; // 0x7f0200aa float:1.7280309E38 double:1.0527736916E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "fw";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "fw";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x0317:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "2";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x0370;
    L_0x0325:
        r2 = "Antivirus";
        r2 = "Antivirus";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837584; // 0x7f020050 float:1.7280126E38 double:1.052773647E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "av";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "av";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x0370:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "3";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x03c9;
    L_0x037e:
        r2 = "SDK";
        r2 = "SDK";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837764; // 0x7f020104 float:1.7280491E38 double:1.052773736E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "sdk";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "sdk";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x03c9:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "4";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x0422;
    L_0x03d7:
        r2 = "IP-Spoofing";
        r2 = "IP-Spoofing";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837707; // 0x7f0200cb float:1.7280376E38 double:1.052773708E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "ipsp";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "ipsp";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x0422:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "5";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x047b;
    L_0x0430:
        r2 = "Spam";
        r2 = "Spam";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837779; // 0x7f020113 float:1.7280522E38 double:1.0527737435E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "spam";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "spam";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x047b:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "6";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x04d4;
    L_0x0489:
        r2 = "Scan";
        r2 = "Scan";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837761; // 0x7f020101 float:1.7280485E38 double:1.0527737346E-314;
        r2 = r2.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r2);	 Catch:{ JSONException -> 0x016e }
        r2 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r2 = r2.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = "scan";
        r6 = "0";
        r2 = r2.getString(r4, r6);	 Catch:{ JSONException -> 0x016e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.f4989n;	 Catch:{ JSONException -> 0x016e }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x016e }
        r6 = "scan";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r7.<init>();	 Catch:{ JSONException -> 0x016e }
        r2 = r2 + r3;
        r2 = r7.append(r2);	 Catch:{ JSONException -> 0x016e }
        r7 = "";
        r2 = r2.append(r7);	 Catch:{ JSONException -> 0x016e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x016e }
        r4.putString(r6, r2);	 Catch:{ JSONException -> 0x016e }
        r4.commit();	 Catch:{ JSONException -> 0x016e }
    L_0x04d4:
        r2 = "win";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r4 = "7";
        r2 = r2.equals(r4);	 Catch:{ JSONException -> 0x016e }
        if (r2 == 0) goto L_0x004e;
    L_0x04e2:
        r2 = "AdWare";
        r2 = "AdWare";
        r1.setText(r2);	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.getResources();	 Catch:{ JSONException -> 0x016e }
        r2 = 2130837582; // 0x7f02004e float:1.7280122E38 double:1.052773646E-314;
        r1 = r1.getDrawable(r2);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.f4989n;	 Catch:{ JSONException -> 0x016e }
        r1 = "adw";
        r2 = "0";
        r0 = r0.getString(r1, r2);	 Catch:{ JSONException -> 0x016e }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ JSONException -> 0x016e }
        r1 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.f4989n;	 Catch:{ JSONException -> 0x016e }
        r1 = r1.edit();	 Catch:{ JSONException -> 0x016e }
        r2 = "adw";
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x016e }
        r4.<init>();	 Catch:{ JSONException -> 0x016e }
        r0 = r0 + r3;
        r0 = r4.append(r0);	 Catch:{ JSONException -> 0x016e }
        r3 = "";
        r0 = r0.append(r3);	 Catch:{ JSONException -> 0x016e }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x016e }
        r1.putString(r2, r0);	 Catch:{ JSONException -> 0x016e }
        r1.commit();	 Catch:{ JSONException -> 0x016e }
        goto L_0x004e;
    L_0x052f:
        r3 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r3 = r3.getResources();	 Catch:{ JSONException -> 0x016e }
        r4 = 2130837678; // 0x7f0200ae float:1.7280317E38 double:1.0527736936E-314;
        r3 = r3.getDrawable(r4);	 Catch:{ JSONException -> 0x016e }
        r0.setBackground(r3);	 Catch:{ JSONException -> 0x016e }
        r0 = "Botnet PC";
        r1.setText(r0);	 Catch:{ JSONException -> 0x016e }
        r0 = "+1";
        r2.setText(r0);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r1 = 2131558565; // 0x7f0d00a5 float:1.874245E38 double:1.053129859E-314;
        r0 = r0.findViewById(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = (android.widget.TextView) r0;	 Catch:{ JSONException -> 0x016e }
        r1 = "bleft";
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x016e }
        r0.setText(r1);	 Catch:{ JSONException -> 0x016e }
        r0 = r12.f5481a;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.f4989n;	 Catch:{ JSONException -> 0x016e }
        r0 = r0.edit();	 Catch:{ JSONException -> 0x016e }
        r1 = "bonus";
        r2 = "bleft";
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x016e }
        r0.putString(r1, r2);	 Catch:{ JSONException -> 0x016e }
        r0.commit();	 Catch:{ JSONException -> 0x016e }
        goto L_0x004e;
    L_0x0575:
        r0 = r12.f5481a;
        r0 = r0.getApplicationContext();
        r1 = "You dont have any Bonus Packages.";
        r0 = android.widget.Toast.makeText(r0, r1, r3);
        r0.show();
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.vhack.dev.vhack.o.a(java.lang.String):void");
    }
}
