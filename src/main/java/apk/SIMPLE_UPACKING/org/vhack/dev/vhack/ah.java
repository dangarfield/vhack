package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BotnetActivity */
class ah extends AsyncTask {
    final /* synthetic */ BotnetActivity f5263a;

    ah(BotnetActivity botnetActivity) {
        this.f5263a = botnetActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9070a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9071a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9070a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5263a.getApplicationContext(), "bID", strArr[0], "vh_upgradeBotnet.php")).openConnection();
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

    protected void m9071a(String str) {
        if (str.length() > 5) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("old"));
                String string = jSONObject.getString("money");
                Editor edit = this.f5263a.f4996r.edit();
                edit.putString("money", string);
                edit.commit();
                this.f5263a.f4993o[parseInt - 1] = (Integer.parseInt(this.f5263a.f4993o[parseInt - 1]) + 1) + "";
                this.f5263a.f4994p[parseInt - 1] = (Integer.parseInt(this.f5263a.f4994p[parseInt - 1]) + 1) + "";
                this.f5263a.f4995q[parseInt - 1] = (Integer.parseInt(this.f5263a.f4995q[parseInt - 1]) + 100000) + "";
                this.f5263a.f4997s.notifyDataSetChanged();
                Toast.makeText(this.f5263a.getApplicationContext(), "Upgrade successful.", 0).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (str.equals("1")) {
            Toast.makeText(this.f5263a.getApplicationContext(), "Not enough money.", 0).show();
        } else if (str.equals("2")) {
            Toast.makeText(this.f5263a.getApplicationContext(), "This computer is already on max level.", 0).show();
        } else {
            Toast.makeText(this.f5263a.getApplicationContext(), "-" + str + "-", 0).show();
        }
    }
}
