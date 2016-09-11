package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.support.v4.p007b.ContextCompat;
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
    final /* synthetic */ NetworkActivity f5413a;

    en(NetworkActivity networkActivity) {
        this.f5413a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9149a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9150a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5413a.findViewById(2131558905).setVisibility(0);
    }

    protected String m9149a(String... strArr) {
        String str = strArr[0];
        str = "";
        if (strArr[0].equals("1")) {
            str = fc.m9164a(this.f5413a.getApplicationContext(), "global", "1", "vh_network.php");
        } else {
            str = fc.m9164a(this.f5413a.getApplicationContext(), "global", "0", "vh_network.php");
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

    protected void m9150a(String str) {
        String[] strArr;
        Object obj;
        JSONException e;
        String[] strArr2;
        String[] strArr3;
        Object obj2;
        String[] strArr4;
        int i;
        this.f5413a.findViewById(2131558905).setVisibility(8);
        if (str.length() > 20) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                strArr = new String[jSONArray.length()];
                try {
                    obj = new String[jSONArray.length()];
                } catch (JSONException e2) {
                    e = e2;
                    strArr2 = null;
                    obj = null;
                    e.printStackTrace();
                    strArr3 = strArr;
                    obj2 = obj;
                    strArr4 = strArr2;
                    if (strArr3 != null) {
                    }
                    return;
                }
                try {
                    strArr2 = new String[jSONArray.length()];
                    i = 0;
                    while (i < jSONArray.length()) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            strArr[i] = jSONObject.getString("ip");
                            obj[i] = jSONObject.getString("fw");
                            strArr2[i] = jSONObject.getString("attacked");
                            i++;
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    }
                    strArr3 = strArr;
                    obj2 = obj;
                    strArr4 = strArr2;
                } catch (JSONException e4) {
                    e = e4;
                    strArr2 = null;
                    e.printStackTrace();
                    strArr3 = strArr;
                    obj2 = obj;
                    strArr4 = strArr2;
                    if (strArr3 != null) {
                        return;
                    }
                }
            } catch (JSONException e5) {
                e = e5;
                strArr2 = null;
                obj = null;
                strArr = null;
                e.printStackTrace();
                strArr3 = strArr;
                obj2 = obj;
                strArr4 = strArr2;
                if (strArr3 != null) {
                    return;
                }
            }
        }
        obj = null;
        obj2 = null;
        strArr3 = null;
        if (strArr3 != null && !obj2.equals(null)) {
            this.f5413a.findViewById(2131558905).setVisibility(8);
            this.f5413a.f5141l = strArr3;
            this.f5413a.f5142m = obj2;
            for (i = 0; i < this.f5413a.f5141l.length; i++) {
                if (i < 9) {
                    int random = (int) ((((float) ((((int) (Math.random() * 80.0d)) + 1) - 40)) * this.f5413a.getResources().getDisplayMetrics().density) + 0.5f);
                    this.f5413a.f5153x[i].setPadding(random, (int) ((((float) ((((int) (Math.random() * 80.0d)) + 1) - 40)) * this.f5413a.getResources().getDisplayMetrics().density) + 0.5f), 0, 0);
                    int round = Math.round((float) ((Integer.parseInt(obj2[i]) * 70) / 700)) + 40;
                    if (round > 70) {
                        round = 70;
                    }
                    round = (int) ((((float) round) * this.f5413a.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
                    this.f5413a.f5138A[i].getLayoutParams().height = round;
                    this.f5413a.f5138A[i].getLayoutParams().width = round;
                    this.f5413a.f5154y[i].setText(this.f5413a.f5141l[i]);
                    this.f5413a.f5155z[i].setText(this.f5413a.f5142m[i]);
                    if (strArr4[i].equals("1")) {
                        this.f5413a.f5138A[i].setBackground(ContextCompat.m741a(this.f5413a.getApplicationContext(), 2130837736));
                    } else {
                        this.f5413a.f5138A[i].setBackground(ContextCompat.m741a(this.f5413a.getApplicationContext(), 2130837735));
                    }
                    this.f5413a.f5138A[i].setVisibility(0);
                }
            }
            this.f5413a.findViewById(2131558866).setEnabled(true);
            this.f5413a.findViewById(2131558870).setEnabled(true);
            this.f5413a.findViewById(2131558874).setEnabled(true);
            this.f5413a.findViewById(2131558878).setEnabled(true);
            this.f5413a.findViewById(2131558882).setEnabled(true);
            this.f5413a.findViewById(2131558886).setEnabled(true);
            this.f5413a.findViewById(2131558890).setEnabled(true);
            this.f5413a.findViewById(2131558894).setEnabled(true);
            this.f5413a.findViewById(2131558898).setEnabled(true);
        }
    }
}
