package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageButton;
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

/* compiled from: BotnetActivity */
class q extends AsyncTask {
    final /* synthetic */ BotnetActivity a;

    q(BotnetActivity botnetActivity) {
        this.a = botnetActivity;
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
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_botnetInfo.php")).openConnection();
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
            try {
                JSONObject jSONObject = new JSONObject(str);
                Integer.valueOf(0);
                Integer valueOf = Integer.valueOf(Integer.parseInt(jSONObject.getString("count")));
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(jSONObject.getString("canAtt1")));
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(jSONObject.getString("canAtt2")));
                Integer.valueOf(0);
                TextView textView = (TextView) this.a.findViewById(2131558591);
                TextView textView2 = (TextView) this.a.findViewById(2131558597);
                if (valueOf2.intValue() == 2) {
                    textView.setTextColor(-65536);
                    textView.setText("Ready in " + jSONObject.getString("resethours1") + "h, " + jSONObject.getString("resetminutes1") + "m.");
                }
                if (valueOf2.intValue() == 1) {
                    textView.setTextColor(-16711936);
                    textView.setText("READY!");
                }
                if (valueOf3.intValue() == 2) {
                    textView2.setTextColor(-65536);
                    textView2.setText("Ready in " + jSONObject.getString("resethours2") + "h, " + jSONObject.getString("resetminutes2") + "m.");
                }
                if (valueOf3.intValue() == 1) {
                    textView2.setTextColor(-16711936);
                    textView2.setText("READY!");
                }
                int parseInt = Integer.parseInt(jSONObject.getString("strength"));
                ((TextView) this.a.findViewById(2131558602)).setText(valueOf + " / 50");
                ((TextView) this.a.findViewById(2131558604)).setText(parseInt + "%");
                this.a.x = parseInt;
                if (valueOf.intValue() > 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    this.a.n = new String[jSONArray.length()];
                    this.a.o = new String[jSONArray.length()];
                    this.a.p = new String[jSONArray.length()];
                    this.a.q = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        this.a.n[i] = jSONObject2.getString("bID");
                        this.a.o[i] = jSONObject2.getString("bLVL");
                        this.a.p[i] = jSONObject2.getString("bSTR");
                        this.a.q[i] = jSONObject2.getString("bPRICE");
                    }
                    this.a.s = new ai(this.a, this.a.n, this.a.o, this.a.p, this.a.q);
                    this.a.y = (ListView) this.a.findViewById(2131558584);
                    this.a.y.setAdapter(this.a.s);
                    this.a.y.setOnItemClickListener(new r(this));
                    if (valueOf2.intValue() == 1) {
                        ((ImageButton) this.a.findViewById(2131558587)).setOnClickListener(new u(this));
                        ((Button) this.a.findViewById(2131558612)).setOnClickListener(new v(this));
                    }
                    ((Button) this.a.findViewById(2131558613)).setOnClickListener(new z(this));
                    if (valueOf3.intValue() == 1) {
                        ((ImageButton) this.a.findViewById(2131558593)).setOnClickListener(new aa(this));
                        ((Button) this.a.findViewById(2131558621)).setOnClickListener(new ab(this));
                    }
                    ((Button) this.a.findViewById(2131558622)).setOnClickListener(new af(this));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
