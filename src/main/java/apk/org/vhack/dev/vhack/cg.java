package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
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

/* compiled from: MailsActivity */
class cg extends AsyncTask {
    final /* synthetic */ MailsActivity a;

    cg(MailsActivity mailsActivity) {
        this.a = mailsActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558789).setVisibility(0);
    }

    protected String a(String... strArr) {
        Log.e("mails", "REQUEST!");
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "action", "list", "vh_mails.php")).openConnection();
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
        this.a.findViewById(2131558789).setVisibility(8);
        if (str.length() > 20) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("money");
                String string2 = jSONObject.getString("elo");
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                Editor edit = this.a.m.edit();
                edit.putString("elo", string2);
                edit.putString("money", string);
                edit.commit();
                this.a.r = new String[jSONArray.length()];
                this.a.s = new String[jSONArray.length()];
                this.a.t = new String[jSONArray.length()];
                this.a.u = new String[jSONArray.length()];
                this.a.v = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    this.a.r[i] = jSONObject2.getString("from");
                    this.a.s[i] = jSONObject2.getString("subject");
                    this.a.t[i] = jSONObject2.getString("read");
                    this.a.u[i] = jSONObject2.getString("id");
                    this.a.v[i] = jSONObject2.getString("time");
                }
                this.a.q = new cf(this.a, this.a.s, this.a.r, this.a.t);
                this.a.x = (ListView) this.a.findViewById(2131558788);
                this.a.x.setAdapter(this.a.q);
                this.a.x.setOnItemClickListener(new ch(this));
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("PARSE", "ERROR");
                return;
            }
        }
        Toast.makeText(this.a, 2131165373, 1).show();
    }
}
