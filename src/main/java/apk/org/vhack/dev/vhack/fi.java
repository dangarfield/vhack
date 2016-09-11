package org.vhack.dev.vhack;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.b.l;
import android.widget.Toast;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashActivity */
class fi extends AsyncTask {
    final /* synthetic */ SplashActivity a;

    fi(SplashActivity splashActivity) {
        this.a = splashActivity;
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
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_update.php")).openConnection();
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void a(String str) {
        int i = 0;
        if (str.length() <= 20) {
            switch (str.hashCode()) {
                case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                    if (str.equals("5")) {
                        break;
                    }
                case l.AppCompatTheme_dividerHorizontal /*56*/:
                    if (str.equals("8")) {
                        i = 1;
                        break;
                    }
                case 1567:
                    if (str.equals("10")) {
                        i = 2;
                        break;
                    }
                case 1572:
                    if (str.equals("15")) {
                        i = 4;
                        break;
                    }
                case 1824:
                    if (str.equals("99")) {
                        i = 3;
                        break;
                    }
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    Toast.makeText(this.a, 2131165285, 1).show();
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    Toast.makeText(this.a, 2131165431, 1).show();
                    this.a.startActivity(new Intent(this.a.getApplicationContext(), MainActivity.class));
                case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    Toast.makeText(this.a, 2131165333, 1).show();
                case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    Toast.makeText(this.a, "Server is down for Maintenance, please be patient.", 1).show();
                case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    Toast.makeText(this.a, 2131165247, 1).show();
                    this.a.l();
                default:
            }
        } else if (str.length() > 20) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
                if (jSONObject.getString("active").equals("0")) {
                    Toast.makeText(this.a, 2131165369, 1).show();
                }
                if (jSONObject.getString("active").equals("2")) {
                    Toast.makeText(this.a, 2131165247, 1).show();
                }
                if (jSONObject.getString("active").equals("1")) {
                    edit.putString("money", jSONObject.getString("money"));
                    edit.putString("id", jSONObject.getString("id"));
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
                    edit.putString("actadw", jSONObject.getString("actadw"));
                    edit.putString("netcoins", jSONObject.getString("netcoins"));
                    edit.putString("urmail", jSONObject.getString("urmail"));
                    edit.putString("score", jSONObject.getString("score"));
                    edit.putString("energy", jSONObject.getString("energy"));
                    edit.putString("active", jSONObject.getString("active"));
                    edit.putString("elo", jSONObject.getString("elo"));
                    edit.putString("clusterID", jSONObject.getString("clusterID"));
                    edit.putString("position", jSONObject.getString("position"));
                    edit.putString("syslog", jSONObject.getString("syslog"));
                    edit.putString("rank", jSONObject.getString("rank"));
                    edit.putString("bonus", jSONObject.getString("bonus"));
                    edit.putString("mystery", jSONObject.getString("mystery"));
                    edit.putString("hash", jSONObject.getString("hash"));
                    edit.putString("uhash", jSONObject.getString("uhash"));
                    edit.commit();
                    if (jSONObject.getString("active").equals("1")) {
                        Intent intent = new Intent(this.a.getApplicationContext(), MainActivity.class);
                        intent.putExtra("chat", true);
                        this.a.startActivity(intent);
                        return;
                    }
                    Toast.makeText(this.a, 2131165369, 1).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
