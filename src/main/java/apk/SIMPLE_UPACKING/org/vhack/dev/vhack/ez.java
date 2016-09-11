package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.support.v7.p018b.R;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.C0001R;
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
class ez extends AsyncTask {
    final /* synthetic */ RankingActivity f5429a;

    ez(RankingActivity rankingActivity) {
        this.f5429a = rankingActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9157a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9158a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5429a.findViewById(2131558921).setVisibility(0);
    }

    protected String m9157a(String... strArr) {
        String a = fc.m9164a(this.f5429a.getApplicationContext(), "", "", "vh_ranking.php");
        String str = strArr[0];
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

    protected void m9158a(String str) {
        int i = 0;
        this.f5429a.findViewById(2131558921).setVisibility(8);
        ((TextView) this.f5429a.findViewById(2131558913)).setText("Top 100 Hackers");
        Button button = (Button) this.f5429a.findViewById(2131558920);
        ((Button) this.f5429a.findViewById(2131558919)).setEnabled(true);
        button.setEnabled(true);
        if (str.length() > 20) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("rank");
                String string2 = jSONObject.getString("score");
                String string3 = jSONObject.getString("elo");
                TextView textView = (TextView) this.f5429a.findViewById(2131558916);
                ((TextView) this.f5429a.findViewById(2131558918)).setText(this.f5429a.m9029a(string2) + " / " + this.f5429a.m9029a(string3) + " / " + this.f5429a.m9029a((Integer.parseInt(string2) + Integer.parseInt(string3)) + ""));
                textView.setText(string + ".");
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                String[] strArr = new String[jSONArray.length()];
                String[] strArr2 = new String[jSONArray.length()];
                String[] strArr3 = new String[jSONArray.length()];
                String[] strArr4 = new String[jSONArray.length()];
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    strArr[i] = jSONObject2.getString("username");
                    strArr2[i] = jSONObject2.getString("score");
                    strArr3[i] = jSONObject2.getString("elo");
                    strArr4[i] = jSONObject2.getString("medal");
                    i++;
                }
                this.f5429a.f5156l = new fb(this.f5429a, strArr, strArr2, strArr3, strArr4);
                this.f5429a.f5157m = (ListView) this.f5429a.findViewById(2131558914);
                this.f5429a.f5157m.setAdapter(this.f5429a.f5156l);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        int i2 = -1;
        switch (str.hashCode()) {
            case R.AppCompatTheme_dividerHorizontal /*56*/:
                if (str.equals("8")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        switch (i2) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                Toast.makeText(this.f5429a, 2131165247, 0).show();
            default:
                Toast.makeText(this.f5429a, 2131165428, 0).show();
                Toast.makeText(this.f5429a, str, 0).show();
        }
    }
}
