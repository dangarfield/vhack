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
    final /* synthetic */ LogActivity f5325a;

    cc(LogActivity logActivity) {
        this.f5325a = logActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9129a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9130a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5325a.findViewById(2131558773).setVisibility(0);
    }

    protected String m9129a(String... strArr) {
        String str = strArr[0];
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5325a.getApplicationContext(), "", "", "vh_getSysLog.php")).openConnection();
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

    protected void m9130a(String str) {
        int i = 0;
        if (str.length() > 20) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                this.f5325a.f5075p = new Integer[jSONArray.length()];
                this.f5325a.f5076q = new String[jSONArray.length()];
                this.f5325a.f5077r = new String[jSONArray.length()];
                this.f5325a.f5083x = new String[jSONArray.length()];
                this.f5325a.f5082w = new String[jSONArray.length()];
                this.f5325a.f5078s = new String[jSONArray.length()];
                this.f5325a.f5079t = new String[jSONArray.length()];
                this.f5325a.f5080u = new String[jSONArray.length()];
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.f5325a.f5075p[i] = Integer.valueOf(Integer.parseInt(jSONObject.getString("time")));
                    this.f5325a.f5076q[i] = jSONObject.getString("result");
                    this.f5325a.f5077r[i] = jSONObject.getString("rep");
                    this.f5325a.f5083x[i] = jSONObject.getString("from");
                    this.f5325a.f5082w[i] = jSONObject.getString("to");
                    this.f5325a.f5078s[i] = jSONObject.getString("fromID");
                    this.f5325a.f5079t[i] = jSONObject.getString("toID");
                    this.f5325a.f5080u[i] = jSONObject.getString("money");
                    i++;
                }
                this.f5325a.f5073n = new ce(this.f5325a, this.f5325a.f5076q, this.f5325a.f5077r, this.f5325a.f5075p, this.f5325a.f5083x, this.f5325a.f5082w, this.f5325a.f5078s, this.f5325a.f5079t, this.f5325a.f5080u);
                this.f5325a.f5074o.setAdapter(this.f5325a.f5073n);
                this.f5325a.f5074o.setOnItemClickListener(new cd(this));
                this.f5325a.findViewById(2131558774).setVisibility(8);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.f5325a.findViewById(2131558774).setVisibility(0);
        }
        this.f5325a.findViewById(2131558773).setVisibility(8);
    }
}
