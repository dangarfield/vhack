package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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

/* compiled from: AdWareActivity */
class f extends AsyncTask {
    final /* synthetic */ AdWareActivity a;

    f(AdWareActivity adWareActivity) {
        this.a = adWareActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "user::::pass::::target", this.a.l + "::::" + this.a.m + "::::" + strArr[0], "vh_removeAdwareRemote.php")).openConnection();
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
        if (str.length() > 5) {
            Toast.makeText(this.a.getApplicationContext(), "AdWare removed successfuly.", 0).show();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Integer.valueOf(0);
                Integer valueOf = Integer.valueOf(Integer.parseInt(jSONObject.getString("local")));
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(jSONObject.getString("remote")));
                TextView textView = (TextView) this.a.findViewById(2131558547);
                if (valueOf.intValue() < 1) {
                    textView.setText(2131165409);
                } else {
                    textView.setText(valueOf + this.a.getString(2131165346));
                    ((Button) this.a.findViewById(2131558548)).setEnabled(true);
                }
                if (valueOf2.intValue() > 0) {
                    ((TextView) this.a.findViewById(2131558556)).setText("$" + this.a.a(Integer.valueOf(Integer.parseInt(jSONObject.getString("earntotal"))) + ""));
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    this.a.o = new String[jSONArray.length()];
                    this.a.p = new String[jSONArray.length()];
                    this.a.q = new String[jSONArray.length()];
                    this.a.r = new String[jSONArray.length()];
                    ((TextView) this.a.findViewById(2131558557)).setText(valueOf2 + this.a.getString(2131165408));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        this.a.o[i] = jSONObject2.getString("av");
                        this.a.p[i] = jSONObject2.getString("ip");
                        this.a.q[i] = jSONObject2.getString("earn");
                        this.a.r[i] = jSONObject2.getString("level");
                    }
                    this.a.n = new k(this.a, this.a.p, this.a.o, this.a.q, this.a.r);
                    this.a.t = (ListView) this.a.findViewById(2131558554);
                    this.a.t.setAdapter(this.a.n);
                    this.a.t.setOnItemClickListener(new g(this));
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        Toast.makeText(this.a.getApplicationContext(), "Remove AdWare failed.", 0).show();
    }
}
