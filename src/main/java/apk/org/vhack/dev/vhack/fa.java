package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.support.v7.b.l;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.R;
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

/* compiled from: RankingActivity */
class fa extends AsyncTask {
    final /* synthetic */ RankingActivity a;

    fa(RankingActivity rankingActivity) {
        this.a = rankingActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558921).setVisibility(0);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_rankingCluster.php")).openConnection();
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
        int i = 0;
        this.a.findViewById(2131558921).setVisibility(8);
        ((TextView) this.a.findViewById(2131558913)).setText("Top 50 Clusters");
        Button button = (Button) this.a.findViewById(2131558920);
        ((Button) this.a.findViewById(2131558919)).setEnabled(true);
        button.setEnabled(true);
        if (str.length() > 20) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                String[] strArr = new String[jSONArray.length()];
                String[] strArr2 = new String[jSONArray.length()];
                String[] strArr3 = new String[jSONArray.length()];
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    strArr[i] = jSONObject.getString("username");
                    strArr2[i] = jSONObject.getString("score");
                    strArr3[i] = jSONObject.getString("elo");
                    i++;
                }
                this.a.l = new fb(this.a, strArr, strArr2, strArr3, null);
                this.a.m = (ListView) this.a.findViewById(2131558914);
                this.a.m.setAdapter(this.a.l);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        int i2 = -1;
        switch (str.hashCode()) {
            case l.AppCompatTheme_dividerHorizontal /*56*/:
                if (str.equals("8")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        switch (i2) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                Toast.makeText(this.a, 2131165247, 0).show();
            default:
                Toast.makeText(this.a, 2131165428, 0).show();
        }
    }
}
