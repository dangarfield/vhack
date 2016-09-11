package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;
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

/* compiled from: TasksActivity */
class fq extends AsyncTask {
    final /* synthetic */ TasksActivity f5467a;

    fq(TasksActivity tasksActivity) {
        this.f5467a = tasksActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9180a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9181a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9180a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5467a.getApplicationContext(), "", "", "vh_tasks.php")).openConnection();
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

    protected void m9181a(String str) {
        if (str.length() > 10) {
            int i;
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                this.f5467a.f5206v = new String[jSONArray.length()];
                this.f5467a.f5207w = new String[jSONArray.length()];
                this.f5467a.f5208x = new String[jSONArray.length()];
                this.f5467a.f5209y = new String[jSONArray.length()];
                this.f5467a.f5210z = new String[jSONArray.length()];
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    this.f5467a.f5206v[i] = jSONObject2.getString("taskid");
                    this.f5467a.f5207w[i] = jSONObject2.getString("wto");
                    this.f5467a.f5208x[i] = jSONObject2.getString("end");
                    this.f5467a.f5209y[i] = jSONObject2.getString("start");
                    this.f5467a.f5210z[i] = jSONObject2.getString("type");
                }
                Editor edit = this.f5467a.getSharedPreferences("loginData.xml", 0).edit();
                edit.putString("money", jSONObject.getString("money"));
                edit.putString("inet", jSONObject.getString("inet"));
                edit.putString("hdd", jSONObject.getString("hdd"));
                edit.putString("cpu", jSONObject.getString("cpu"));
                edit.putString("ram", jSONObject.getString("ram"));
                edit.putString("fw", jSONObject.getString("fw"));
                edit.putString("av", jSONObject.getString("av"));
                edit.putString("sdk", jSONObject.getString("sdk"));
                edit.putString("ipsp", jSONObject.getString("ipsp"));
                edit.putString("spam", jSONObject.getString("spam"));
                edit.putString("scan", jSONObject.getString("scan"));
                edit.putString("adw", jSONObject.getString("adw"));
                edit.putString("netcoins", jSONObject.getString("netcoins"));
                edit.putString("urmail", jSONObject.getString("urmail"));
                edit.putString("energy", jSONObject.getString("energy"));
                edit.putString("score", jSONObject.getString("score"));
                edit.commit();
                this.f5467a.findViewById(2131558949).setVisibility(8);
                this.f5467a.f5193E = true;
            } catch (JSONException e) {
                if (str.equals("0")) {
                    this.f5467a.findViewById(2131558949).setVisibility(0);
                }
                e.printStackTrace();
            }
            if (this.f5467a.f5210z != null) {
                this.f5467a.f5191C = new fj(this.f5467a, this.f5467a.f5210z, this.f5467a.f5209y, this.f5467a.f5207w, this.f5467a.f5203s, this.f5467a.f5208x, this.f5467a.f5204t, this.f5467a.f5206v);
                this.f5467a.f5195G = (ListView) this.f5467a.findViewById(2131558947);
                this.f5467a.f5195G.setAdapter(this.f5467a.f5191C);
                this.f5467a.f5195G.setClickable(true);
                this.f5467a.f5195G.setEnabled(true);
                this.f5467a.f5195G.setOnItemClickListener(new fr(this));
            }
            String l = Long.toString(System.currentTimeMillis());
            ((TextView) this.f5467a.findViewById(2131558946)).setText(this.f5467a.f5201q);
            long parseLong = Long.parseLong(l.substring(0, 10));
            if (this.f5467a.f5210z != null) {
                ((TextView) this.f5467a.findViewById(2131558948)).setText(this.f5467a.f5210z.length + this.f5467a.getString(2131165415));
                for (i = 0; i < this.f5467a.f5210z.length; i++) {
                    l = this.f5467a.f5208x[i];
                    String str2 = this.f5467a.f5209y[i];
                    long parseLong2 = Long.parseLong(l.substring(0, 10)) - parseLong;
                    this.f5467a.f5203s[i] = Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / (Long.parseLong(l.substring(0, 10)) - Long.parseLong(str2.substring(0, 10))))) + "";
                    l = l.substring(0, 10);
                    this.f5467a.f5204t[i] = parseLong2 + "";
                    this.f5467a.f5205u[i] = parseLong2 + "";
                    if (parseLong > Long.parseLong(l)) {
                        this.f5467a.f5193E = false;
                    }
                }
                return;
            }
            ((TextView) this.f5467a.findViewById(2131558948)).setText("");
            return;
        }
        if (str.equals("0")) {
            this.f5467a.f5193E = false;
            this.f5467a.f5210z = null;
            this.f5467a.findViewById(2131558947).setVisibility(8);
            this.f5467a.findViewById(2131558949).setVisibility(0);
        }
    }
}
