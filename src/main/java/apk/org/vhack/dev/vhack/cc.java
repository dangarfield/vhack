package org.vhack.dev.vhack;

import android.os.AsyncTask;
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

/* compiled from: LogActivity */
class cc extends AsyncTask {
    final /* synthetic */ LogActivity a;

    cc(LogActivity logActivity) {
        this.a = logActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558773).setVisibility(0);
    }

    protected String a(String... strArr) {
        String str = strArr[0];
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_getSysLog.php")).openConnection();
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
        int i = 0;
        if (str.length() > 20) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                this.a.p = new Integer[jSONArray.length()];
                this.a.q = new String[jSONArray.length()];
                this.a.r = new String[jSONArray.length()];
                this.a.x = new String[jSONArray.length()];
                this.a.w = new String[jSONArray.length()];
                this.a.s = new String[jSONArray.length()];
                this.a.t = new String[jSONArray.length()];
                this.a.u = new String[jSONArray.length()];
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.a.p[i] = Integer.valueOf(Integer.parseInt(jSONObject.getString("time")));
                    this.a.q[i] = jSONObject.getString("result");
                    this.a.r[i] = jSONObject.getString("rep");
                    this.a.x[i] = jSONObject.getString("from");
                    this.a.w[i] = jSONObject.getString("to");
                    this.a.s[i] = jSONObject.getString("fromID");
                    this.a.t[i] = jSONObject.getString("toID");
                    this.a.u[i] = jSONObject.getString("money");
                    i++;
                }
                this.a.n = new ce(this.a, this.a.q, this.a.r, this.a.p, this.a.x, this.a.w, this.a.s, this.a.t, this.a.u);
                this.a.o.setAdapter(this.a.n);
                this.a.o.setOnItemClickListener(new cd(this));
                this.a.findViewById(2131558774).setVisibility(8);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.a.findViewById(2131558774).setVisibility(0);
        }
        this.a.findViewById(2131558773).setVisibility(8);
    }
}
