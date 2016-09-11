package org.vhack.dev.vhack;

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
class ca extends AsyncTask {
    final /* synthetic */ GameActivity a;

    ca(GameActivity gameActivity) {
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
        this.a.findViewById(2131558756).setEnabled(false);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "user1::::pass2::::mail", strArr[0] + "::::" + strArr[1] + "::::" + strArr[2], "vh_register.php")).openConnection();
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
        this.a.findViewById(2131558756).setEnabled(true);
        if (str.length() > 6) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = jSONObject.getString("result") + "";
                String str3 = jSONObject.getString("needact") + "";
                String string = jSONObject.getString("user");
                String string2 = jSONObject.getString("pass");
                switch (str2.hashCode()) {
                    case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                        if (str2.equals("0")) {
                            break;
                        }
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (str2.equals("1")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (str2.equals("2")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (str2.equals("3")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackground /*52*/:
                        if (str2.equals("4")) {
                            z = true;
                            break;
                        }
                    case l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                        if (str2.equals("5")) {
                            z = true;
                            break;
                        }
                    case 1567:
                        if (str2.equals("10")) {
                            z = true;
                            break;
                        }
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        if (str3.equals("0")) {
                            Toast.makeText(this.a, 2131165396, 1).show();
                            Editor edit = this.a.getSharedPreferences("loginData.xml", 0).edit();
                            edit.putString("strUser", string);
                            edit.putString("strPass", string2);
                            edit.commit();
                            new cb(this.a).execute(new String[0]);
                            return;
                        }
                        Toast.makeText(this.a, 2131165397, 1).show();
                        this.a.findViewById(2131558757).setVisibility(0);
                        this.a.findViewById(2131558750).setVisibility(8);
                        return;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        Toast.makeText(this.a, 2131165432, 1).show();
                        return;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        Toast.makeText(this.a, 2131165267, 1).show();
                        return;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        Toast.makeText(this.a, 2131165327, 1).show();
                        return;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        Toast.makeText(this.a, 2131165428, 1).show();
                        return;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        Toast.makeText(this.a, 2131165330, 1).show();
                        return;
                    case R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        Toast.makeText(this.a, 2131165333, 1).show();
                        return;
                    default:
                        return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
