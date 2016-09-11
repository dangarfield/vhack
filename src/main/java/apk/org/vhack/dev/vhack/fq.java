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
    final /* synthetic */ TasksActivity a;

    fq(TasksActivity tasksActivity) {
        this.a = tasksActivity;
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
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_tasks.php")).openConnection();
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
            int i;
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                this.a.v = new String[jSONArray.length()];
                this.a.w = new String[jSONArray.length()];
                this.a.x = new String[jSONArray.length()];
                this.a.y = new String[jSONArray.length()];
                this.a.z = new String[jSONArray.length()];
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    this.a.v[i] = jSONObject2.getString("taskid");
                    this.a.w[i] = jSONObject2.getString("wto");
                    this.a.x[i] = jSONObject2.getString("end");
                    this.a.y[i] = jSONObject2.getString("start");
                    this.a.z[i] = jSONObject2.getString("type");
                }
                Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
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
                this.a.findViewById(2131558949).setVisibility(8);
                this.a.E = true;
            } catch (JSONException e) {
                if (str.equals("0")) {
                    this.a.findViewById(2131558949).setVisibility(0);
                }
                e.printStackTrace();
            }
            if (this.a.z != null) {
                this.a.C = new fj(this.a, this.a.z, this.a.y, this.a.w, this.a.s, this.a.x, this.a.t, this.a.v);
                this.a.G = (ListView) this.a.findViewById(2131558947);
                this.a.G.setAdapter(this.a.C);
                this.a.G.setClickable(true);
                this.a.G.setEnabled(true);
                this.a.G.setOnItemClickListener(new fr(this));
            }
            String l = Long.toString(System.currentTimeMillis());
            ((TextView) this.a.findViewById(2131558946)).setText(this.a.q);
            long parseLong = Long.parseLong(l.substring(0, 10));
            if (this.a.z != null) {
                ((TextView) this.a.findViewById(2131558948)).setText(this.a.z.length + this.a.getString(2131165415));
                for (i = 0; i < this.a.z.length; i++) {
                    l = this.a.x[i];
                    String str2 = this.a.y[i];
                    long parseLong2 = Long.parseLong(l.substring(0, 10)) - parseLong;
                    this.a.s[i] = Math.round((float) ((100 * (parseLong - Long.parseLong(str2.substring(0, 10)))) / (Long.parseLong(l.substring(0, 10)) - Long.parseLong(str2.substring(0, 10))))) + "";
                    l = l.substring(0, 10);
                    this.a.t[i] = parseLong2 + "";
                    this.a.u[i] = parseLong2 + "";
                    if (parseLong > Long.parseLong(l)) {
                        this.a.E = false;
                    }
                }
                return;
            }
            ((TextView) this.a.findViewById(2131558948)).setText("");
            return;
        }
        if (str.equals("0")) {
            this.a.E = false;
            this.a.z = null;
            this.a.findViewById(2131558947).setVisibility(8);
            this.a.findViewById(2131558949).setVisibility(0);
        }
    }
}
