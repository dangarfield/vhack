package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.support.v4.b.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetworkActivity */
class en extends AsyncTask {
    final /* synthetic */ NetworkActivity a;

    en(NetworkActivity networkActivity) {
        this.a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558905).setVisibility(0);
    }

    protected String a(String... strArr) {
        String str = strArr[0];
        str = "";
        if (strArr[0].equals("1")) {
            str = fc.a(this.a.getApplicationContext(), "global", "1", "vh_network.php");
        } else {
            str = fc.a(this.a.getApplicationContext(), "global", "0", "vh_network.php");
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

    protected void a(String str) {
        JSONException e;
        String[] strArr;
        Object obj;
        String[] strArr2;
        int i;
        this.a.findViewById(2131558905).setVisibility(8);
        Object obj2;
        if (str.length() > 20) {
            String[] strArr3;
            String[] strArr4;
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                strArr3 = new String[jSONArray.length()];
                try {
                    obj2 = new String[jSONArray.length()];
                } catch (JSONException e2) {
                    e = e2;
                    strArr4 = null;
                    obj2 = null;
                    e.printStackTrace();
                    strArr = strArr3;
                    obj = obj2;
                    strArr2 = strArr4;
                    if (strArr != null) {
                    }
                    return;
                }
                try {
                    strArr4 = new String[jSONArray.length()];
                    i = 0;
                    while (i < jSONArray.length()) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            strArr3[i] = jSONObject.getString("ip");
                            obj2[i] = jSONObject.getString("fw");
                            strArr4[i] = jSONObject.getString("attacked");
                            i++;
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    }
                    strArr = strArr3;
                    obj = obj2;
                    strArr2 = strArr4;
                } catch (JSONException e4) {
                    e = e4;
                    strArr4 = null;
                    e.printStackTrace();
                    strArr = strArr3;
                    obj = obj2;
                    strArr2 = strArr4;
                    if (strArr != null) {
                        return;
                    }
                }
            } catch (JSONException e5) {
                e = e5;
                strArr4 = null;
                obj2 = null;
                strArr3 = null;
                e.printStackTrace();
                strArr = strArr3;
                obj = obj2;
                strArr2 = strArr4;
                if (strArr != null) {
                    return;
                }
            }
        }
        obj2 = null;
        obj = null;
        strArr = null;
        if (strArr != null && !obj.equals(null)) {
            this.a.findViewById(2131558905).setVisibility(8);
            this.a.l = strArr;
            this.a.m = obj;
            for (i = 0; i < this.a.l.length; i++) {
                if (i < 9) {
                    int random = (int) ((((float) ((((int) (Math.random() * 80.0d)) + 1) - 40)) * this.a.getResources().getDisplayMetrics().density) + 0.5f);
                    this.a.x[i].setPadding(random, (int) ((((float) ((((int) (Math.random() * 80.0d)) + 1) - 40)) * this.a.getResources().getDisplayMetrics().density) + 0.5f), 0, 0);
                    int round = Math.round((float) ((Integer.parseInt(obj[i]) * 70) / 700)) + 40;
                    if (round > 70) {
                        round = 70;
                    }
                    round = (int) ((((float) round) * this.a.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
                    this.a.A[i].getLayoutParams().height = round;
                    this.a.A[i].getLayoutParams().width = round;
                    this.a.y[i].setText(this.a.l[i]);
                    this.a.z[i].setText(this.a.m[i]);
                    if (strArr2[i].equals("1")) {
                        this.a.A[i].setBackground(c.a(this.a.getApplicationContext(), 2130837736));
                    } else {
                        this.a.A[i].setBackground(c.a(this.a.getApplicationContext(), 2130837735));
                    }
                    this.a.A[i].setVisibility(0);
                }
            }
            this.a.findViewById(2131558866).setEnabled(true);
            this.a.findViewById(2131558870).setEnabled(true);
            this.a.findViewById(2131558874).setEnabled(true);
            this.a.findViewById(2131558878).setEnabled(true);
            this.a.findViewById(2131558882).setEnabled(true);
            this.a.findViewById(2131558886).setEnabled(true);
            this.a.findViewById(2131558890).setEnabled(true);
            this.a.findViewById(2131558894).setEnabled(true);
            this.a.findViewById(2131558898).setEnabled(true);
        }
    }
}
