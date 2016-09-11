package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.TextView;
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

/* compiled from: ClusterActivity */
class bf extends AsyncTask {
    final /* synthetic */ ClusterActivity a;

    bf(ClusterActivity clusterActivity) {
        this.a = clusterActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558681).setVisibility(0);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "msg", strArr[0], "vh_clusterMessage.php")).openConnection();
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
        if (str.length() > 10) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("time");
                Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
                edit.putString("lastcmsg", string);
                edit.commit();
                if (jSONObject.getString("result").equals("0")) {
                    Toast.makeText(this.a.getApplicationContext(), "Message was sent successfuly.", 1).show();
                    ((TextView) this.a.findViewById(2131558675)).append("\n" + this.a.l + ": " + this.a.p);
                } else {
                    Toast.makeText(this.a.getApplicationContext(), "Error while sending message", 1).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this.a.getApplicationContext(), "Try again: no special chars! [a-z, 0-9]", 1).show();
        }
        this.a.findViewById(2131558681).setVisibility(8);
    }
}
