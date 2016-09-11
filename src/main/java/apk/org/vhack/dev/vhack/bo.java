package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DailysActivity */
class bo extends AsyncTask {
    final /* synthetic */ DailysActivity a;

    bo(DailysActivity dailysActivity) {
        this.a = dailysActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558725).setVisibility(0);
    }

    protected String a(String... strArr) {
        String a = fc.a(this.a.getApplicationContext(), "", "", "vh_getDailyData.php");
        Log.e("REHH", a);
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
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
        Log.e("String", str);
        if (str.length() > 20) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("logins");
                String string2 = jSONObject.getString("scans");
                String string3 = jSONObject.getString("transfers");
                TextView textView = (TextView) this.a.findViewById(2131558705);
                TextView textView2 = (TextView) this.a.findViewById(2131558709);
                TextView textView3 = (TextView) this.a.findViewById(2131558713);
                TextView textView4 = (TextView) this.a.findViewById(2131558717);
                TextView textView5 = (TextView) this.a.findViewById(2131558721);
                ((TextView) this.a.findViewById(2131558724)).setText("Reset in " + jSONObject.getString("resethours") + " hours, " + jSONObject.getString("resetminutes") + " minutes.");
                if (string.equals("1")) {
                    ((CheckBox) this.a.findViewById(2131558706)).setChecked(true);
                    textView.setText("1/1");
                } else {
                    textView.setText("0/1");
                }
                if (Integer.parseInt(string2) >= 10) {
                    ((CheckBox) this.a.findViewById(2131558710)).setChecked(true);
                    textView2.setText("10/10");
                } else {
                    textView2.setText(string2 + "/10");
                }
                if (Integer.parseInt(string2) >= 50) {
                    ((CheckBox) this.a.findViewById(2131558714)).setChecked(true);
                    textView3.setText("50/50");
                } else {
                    textView3.setText(string2 + "/50");
                }
                if (Integer.parseInt(string3) >= 10) {
                    ((CheckBox) this.a.findViewById(2131558718)).setChecked(true);
                    textView4.setText("10/10");
                } else {
                    textView4.setText(string3 + "/10");
                }
                if (Integer.parseInt(string3) >= 50) {
                    ((CheckBox) this.a.findViewById(2131558722)).setChecked(true);
                    textView5.setText("50/50");
                } else {
                    textView5.setText(string3 + "/50");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("PARSE", "ERROR");
            }
        }
        this.a.findViewById(2131558725).setVisibility(8);
    }
}
