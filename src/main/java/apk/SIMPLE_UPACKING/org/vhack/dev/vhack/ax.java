package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
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

/* compiled from: ClusterActivity */
class ax extends AsyncTask {
    final /* synthetic */ ClusterActivity f5283a;

    ax(ClusterActivity clusterActivity) {
        this.f5283a = clusterActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9078a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9079a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5283a.findViewById(2131558681).setVisibility(0);
    }

    protected String m9078a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5283a.getApplicationContext(), "", "", "vh_ClusterData.php")).openConnection();
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

    protected void m9079a(String str) {
        if (str.equals("8")) {
            this.f5283a.findViewById(2131558632).setVisibility(0);
            this.f5283a.findViewById(2131558643).setVisibility(8);
        } else {
            if (str.length() > 20) {
                try {
                    int i;
                    JSONObject jSONObject;
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONArray jSONArray = jSONObject2.getJSONArray("messages");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("cusers");
                    this.f5283a.f5035r = new String[jSONArray2.length()];
                    this.f5283a.f5036s = new String[jSONArray2.length()];
                    this.f5283a.f5037t = new String[jSONArray2.length()];
                    String string = jSONObject2.getString("cName");
                    String string2 = jSONObject2.getString("cTag");
                    String string3 = jSONObject2.getString("cMember");
                    Object string4 = jSONObject2.getString("cLeader");
                    String string5 = jSONObject2.getString("cScore");
                    String string6 = jSONObject2.getString("cMoney");
                    String string7 = jSONObject2.getString("cElo");
                    TextView textView = (TextView) this.f5283a.findViewById(2131558651);
                    TextView textView2 = (TextView) this.f5283a.findViewById(2131558650);
                    TextView textView3 = (TextView) this.f5283a.findViewById(2131558652);
                    TextView textView4 = (TextView) this.f5283a.findViewById(2131558653);
                    ((TextView) this.f5283a.findViewById(2131558649)).setText(string2 + " / " + string);
                    textView.setText(string4);
                    textView2.setText(string3 + "/10");
                    textView3.setText(this.f5283a.m9008a(string5) + " /" + this.f5283a.m9008a(string7));
                    textView4.setText("$" + this.f5283a.m9008a(string6));
                    CharSequence charSequence = "";
                    TextView textView5 = (TextView) this.f5283a.findViewById(2131558675);
                    for (i = 0; i < jSONArray.length(); i++) {
                        jSONObject = jSONArray.getJSONObject(i);
                        charSequence = charSequence + jSONObject.getString("from") + ": " + jSONObject.getString("message") + "\n";
                    }
                    for (i = 0; i < jSONArray2.length(); i++) {
                        jSONObject = jSONArray2.getJSONObject(i);
                        this.f5283a.f5035r[i] = jSONObject.getString("username");
                        this.f5283a.f5036s[i] = jSONObject.getString("userelo");
                        this.f5283a.f5037t[i] = jSONObject.getString("userscore");
                    }
                    this.f5283a.f5034q = new bg(this.f5283a, this.f5283a.f5035r, this.f5283a.f5037t, this.f5283a.f5036s);
                    this.f5283a.f5038u = (ListView) this.f5283a.findViewById(2131558656);
                    this.f5283a.f5038u.setAdapter(this.f5283a.f5034q);
                    if (string4.toLowerCase().equals(this.f5283a.f5029l.toLowerCase())) {
                        this.f5283a.f5038u.setOnItemClickListener(new ay(this));
                    }
                    if (charSequence.contains("\n")) {
                        String[] split = charSequence.split("\n");
                        for (i = split.length - 1; i >= 0; i--) {
                            textView5.append("\n" + split[i]);
                        }
                    } else {
                        textView5.setText(charSequence);
                    }
                    textView5.setMovementMethod(new ScrollingMovementMethod());
                    this.f5283a.m9009l();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f5283a.findViewById(2131558643).setVisibility(0);
            this.f5283a.findViewById(2131558632).setVisibility(8);
        }
        this.f5283a.findViewById(2131558681).setVisibility(8);
    }
}
