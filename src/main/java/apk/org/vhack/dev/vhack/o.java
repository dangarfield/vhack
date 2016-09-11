package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.b.l;
import android.widget.ImageView;
import android.widget.TextView;
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

/* compiled from: BonusBoxActivity */
class o extends AsyncTask {
    final /* synthetic */ BonusBoxActivity a;

    o(BonusBoxActivity bonusBoxActivity) {
        this.a = bonusBoxActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558571).setVisibility(0);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "", "", "vh_openFreeBonus.php")).openConnection();
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
        this.a.findViewById(2131558571).setVisibility(8);
        if (str.length() > 5) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ImageView imageView = (ImageView) this.a.findViewById(2131558574);
                TextView textView = (TextView) this.a.findViewById(2131558575);
                TextView textView2 = (TextView) this.a.findViewById(2131558576);
                String string = jSONObject.getString("type");
                switch (string.hashCode()) {
                    case l.AppCompatTheme_homeAsUpIndicator /*48*/:
                        if (string.equals("0")) {
                            break;
                        }
                    case l.AppCompatTheme_actionButtonStyle /*49*/:
                        if (string.equals("1")) {
                            i = 1;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarStyle /*50*/:
                        if (string.equals("2")) {
                            i = 2;
                            break;
                        }
                    case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                        if (string.equals("3")) {
                            i = 3;
                            break;
                        }
                    default:
                        i = -1;
                        break;
                }
                TextView textView3;
                int parseInt;
                Editor edit;
                switch (i) {
                    case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        imageView.setBackground(this.a.getResources().getDrawable(2130837619));
                        textView.setText("NetCoins");
                        textView3 = (TextView) this.a.findViewById(2131558562);
                        parseInt = Integer.parseInt(this.a.n.getString("netcoins", "0"));
                        i = Integer.parseInt(jSONObject.getString("win"));
                        int parseInt2 = Integer.parseInt(this.a.n.getString("bonus", "0"));
                        textView3.setText(this.a.a((parseInt + i) + ""));
                        textView2.setText("+" + this.a.a(i + ""));
                        ((TextView) this.a.findViewById(2131558565)).setText(jSONObject.getString("bleft"));
                        edit = this.a.n.edit();
                        edit.putString("netcoins", (parseInt + i) + "");
                        edit.putString("bonus", (parseInt2 - 1) + "");
                        edit.commit();
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        textView.setText("Money");
                        imageView.setBackground(this.a.getResources().getDrawable(2130837720));
                        textView3 = (TextView) this.a.findViewById(2131558560);
                        long parseLong = Long.parseLong(this.a.n.getString("money", "0"));
                        parseInt = Integer.parseInt(jSONObject.getString("win"));
                        i = Integer.parseInt(this.a.n.getString("bonus", "0"));
                        textView3.setText(this.a.a((((long) parseInt) + parseLong) + ""));
                        textView2.setText("+" + this.a.a(parseInt + ""));
                        ((TextView) this.a.findViewById(2131558565)).setText(jSONObject.getString("bleft"));
                        edit = this.a.n.edit();
                        edit.putString("money", (parseLong + ((long) parseInt)) + "");
                        edit.putString("bonus", (i - 1) + "");
                        edit.commit();
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        String str2;
                        int parseInt3;
                        Editor edit2;
                        Integer.parseInt(this.a.n.getString("bonus", "0"));
                        ((TextView) this.a.findViewById(2131558565)).setText(jSONObject.getString("bleft"));
                        String str3 = "";
                        i = Integer.parseInt(jSONObject.getString("lvl"));
                        textView2.setText("+" + this.a.a(i + ""));
                        if (jSONObject.getString("win").equals("1")) {
                            str2 = "Firewall";
                            textView.setText("Firewall");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837674));
                            parseInt3 = Integer.parseInt(this.a.n.getString("fw", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("fw", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("2")) {
                            str2 = "Antivirus";
                            textView.setText("Antivirus");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837584));
                            parseInt3 = Integer.parseInt(this.a.n.getString("av", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("av", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("3")) {
                            str2 = "SDK";
                            textView.setText("SDK");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837764));
                            parseInt3 = Integer.parseInt(this.a.n.getString("sdk", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("sdk", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("4")) {
                            str2 = "IP-Spoofing";
                            textView.setText("IP-Spoofing");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837707));
                            parseInt3 = Integer.parseInt(this.a.n.getString("ipsp", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("ipsp", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("5")) {
                            str2 = "Spam";
                            textView.setText("Spam");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837779));
                            parseInt3 = Integer.parseInt(this.a.n.getString("spam", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("spam", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("6")) {
                            str2 = "Scan";
                            textView.setText("Scan");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837761));
                            parseInt3 = Integer.parseInt(this.a.n.getString("scan", "0"));
                            edit2 = this.a.n.edit();
                            edit2.putString("scan", (parseInt3 + i) + "");
                            edit2.commit();
                        }
                        if (jSONObject.getString("win").equals("7")) {
                            str2 = "AdWare";
                            textView.setText("AdWare");
                            imageView.setBackground(this.a.getResources().getDrawable(2130837582));
                            int parseInt4 = Integer.parseInt(this.a.n.getString("adw", "0"));
                            Editor edit3 = this.a.n.edit();
                            edit3.putString("adw", (parseInt4 + i) + "");
                            edit3.commit();
                            break;
                        }
                        break;
                    case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        imageView.setBackground(this.a.getResources().getDrawable(2130837678));
                        textView.setText("Botnet PC");
                        textView2.setText("+1");
                        ((TextView) this.a.findViewById(2131558565)).setText(jSONObject.getString("bleft"));
                        edit = this.a.n.edit();
                        edit.putString("bonus", jSONObject.getString("bleft"));
                        edit.commit();
                        break;
                }
                this.a.findViewById(2131558572).setVisibility(0);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        Toast.makeText(this.a.getApplicationContext(), "You dont have any Bonus Packages.", 0).show();
    }
}
