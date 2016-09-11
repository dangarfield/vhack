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

/* compiled from: GameActivity */
class cb extends AsyncTask {
    final /* synthetic */ GameActivity a;

    cb(GameActivity gameActivity) {
        this.a = gameActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558763).setVisibility(0);
        this.a.findViewById(2131558758).setEnabled(false);
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
        boolean z = false;
        this.a.findViewById(2131558763).setVisibility(8);
        this.a.findViewById(2131558758).setEnabled(true);
        if (str.length() > 20) {
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
                    edit.putString("myip", jSONObject.getString("ip"));
                    edit.putString("fw", jSONObject.getString("fw"));
                    edit.putString("av", jSONObject.getString("av"));
                    edit.putString("sdk", jSONObject.getString("sdk"));
                    edit.putString("ipsp", jSONObject.getString("ipsp"));
                    edit.putString("spam", jSONObject.getString("spam"));
                    edit.putString("scan", jSONObject.getString("scan"));
                    edit.putString("adw", jSONObject.getString("adw"));
                    edit.putString("score", jSONObject.getString("score"));
                    edit.putString("netcoins", jSONObject.getString("netcoins"));
                    edit.putString("energy", jSONObject.getString("energy"));
                    edit.putString("urmail", jSONObject.getString("urmail"));
                    edit.putString("active", jSONObject.getString("active"));
                    edit.putString("elo", jSONObject.getString("elo"));
                    edit.putString("strUser", this.a.m);
                    edit.putString("strPass", this.a.n);
                    edit.putString("hash", jSONObject.getString("hash"));
                    edit.putString("uhash", jSONObject.getString("uhash"));
                    edit.commit();
                    Intent intent = new Intent(this.a.getApplicationContext(), MainActivity.class);
                    intent.putExtra("chat", true);
                    this.a.startActivity(intent);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        String replace = str.replace("\n", "").replace("\r", "").replace("\t", "").replace(" ", "");
        switch (replace.hashCode()) {
            case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                if (replace.equals("5")) {
                    break;
                }
            case l.AppCompatTheme_dividerHorizontal /*56*/:
                if (replace.equals("8")) {
                    z = true;
                    break;
                }
            case 1567:
                if (replace.equals("10")) {
                    z = true;
                    break;
                }
            case 1572:
                if (replace.equals("15")) {
                    z = true;
                    break;
                }
            case 1824:
                if (replace.equals("99")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        switch (z) {
            case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                Toast.makeText(this.a, 2131165285, 1).show();
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                Toast.makeText(this.a, 2131165431, 1).show();
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                Toast.makeText(this.a, 2131165345, 1).show();
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                Toast.makeText(this.a, "Server is down for Maintenance, please be patient.", 1).show();
            case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                Toast.makeText(this.a, 2131165333, 1).show();
            default:
        }
    }
}
