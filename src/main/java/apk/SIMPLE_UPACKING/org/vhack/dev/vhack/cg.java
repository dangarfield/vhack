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
    final /* synthetic */ MailsActivity f5341a;

    cg(MailsActivity mailsActivity) {
        this.f5341a = mailsActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9133a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9134a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5341a.findViewById(2131558789).setVisibility(0);
    }

    protected String m9133a(String... strArr) {
        Log.e("mails", "REQUEST!");
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5341a.getApplicationContext(), "action", "list", "vh_mails.php")).openConnection();
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

    protected void m9134a(String str) {
        this.f5341a.findViewById(2131558789).setVisibility(8);
        if (str.length() > 20) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("money");
                String string2 = jSONObject.getString("elo");
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                Editor edit = this.f5341a.f5085m.edit();
                edit.putString("elo", string2);
                edit.putString("money", string);
                edit.commit();
                this.f5341a.f5090r = new String[jSONArray.length()];
                this.f5341a.f5091s = new String[jSONArray.length()];
                this.f5341a.f5092t = new String[jSONArray.length()];
                this.f5341a.f5093u = new String[jSONArray.length()];
                this.f5341a.f5094v = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    this.f5341a.f5090r[i] = jSONObject2.getString("from");
                    this.f5341a.f5091s[i] = jSONObject2.getString("subject");
                    this.f5341a.f5092t[i] = jSONObject2.getString("read");
                    this.f5341a.f5093u[i] = jSONObject2.getString("id");
                    this.f5341a.f5094v[i] = jSONObject2.getString("time");
                }
                this.f5341a.f5089q = new cf(this.f5341a, this.f5341a.f5091s, this.f5341a.f5090r, this.f5341a.f5092t);
                this.f5341a.f5096x = (ListView) this.f5341a.findViewById(2131558788);
                this.f5341a.f5096x.setAdapter(this.f5341a.f5089q);
                this.f5341a.f5096x.setOnItemClickListener(new ch(this));
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("PARSE", "ERROR");
                return;
            }
        }
        Toast.makeText(this.f5341a, 2131165373, 1).show();
    }
}
