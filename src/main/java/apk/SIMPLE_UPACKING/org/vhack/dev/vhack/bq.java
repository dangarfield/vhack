package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.text.Html;
import android.widget.LinearLayout;
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

/* compiled from: EventsActivity */
class bq extends AsyncTask {
    final /* synthetic */ EventsActivity f5309a;

    bq(EventsActivity eventsActivity) {
        this.f5309a = eventsActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9101a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9102a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5309a.findViewById(2131558739).setVisibility(0);
    }

    protected String m9101a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5309a.getApplicationContext(), "", "", "vh_getEvents.php")).openConnection();
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

    protected void m9102a(String str) {
        if (str.length() > 20) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                String[] strArr = new String[jSONArray.length()];
                strArr = new String[jSONArray.length()];
                LinearLayout[] linearLayoutArr = new LinearLayout[]{(LinearLayout) this.f5309a.findViewById(2131558727), (LinearLayout) this.f5309a.findViewById(2131558731), (LinearLayout) this.f5309a.findViewById(2131558735)};
                TextView[] textViewArr = new TextView[]{(TextView) this.f5309a.findViewById(2131558729), (TextView) this.f5309a.findViewById(2131558733), (TextView) this.f5309a.findViewById(2131558737)};
                TextView[] textViewArr2 = new TextView[]{(TextView) this.f5309a.findViewById(2131558730), (TextView) this.f5309a.findViewById(2131558734), (TextView) this.f5309a.findViewById(2131558738)};
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    textViewArr[i].setText(jSONObject.getString("title"));
                    textViewArr2[i].setText(Html.fromHtml(jSONObject.getString("body")));
                    linearLayoutArr[i].setVisibility(0);
                }
                this.f5309a.findViewById(2131558740).setVisibility(8);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.f5309a.findViewById(2131558740).setVisibility(0);
        }
        this.f5309a.findViewById(2131558739).setVisibility(8);
    }
}
