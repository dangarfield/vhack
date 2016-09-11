package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.b.l;
import android.widget.TextView;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ConsoleActivity */
class bk extends AsyncTask {
    final /* synthetic */ ConsoleActivity a;

    bk(ConsoleActivity consoleActivity) {
        this.a = consoleActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558696).setVisibility(0);
    }

    protected String a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "target", strArr[0], "vh_scan.php")).openConnection();
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
        this.a.findViewById(2131558696).setVisibility(8);
        String str2 = "";
        if (str.length() <= 40) {
            Object obj = -1;
            switch (str.hashCode()) {
                case l.AppCompatTheme_buttonBarStyle /*50*/:
                    if (str.equals("2")) {
                        obj = 1;
                        break;
                    }
                    break;
                case l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                    if (str.equals("3")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    str = this.a.getString(2131165410);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str = this.a.getString(2131165404);
                    break;
                case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = this.a.getString(2131165333);
                    break;
                default:
                    str = str2;
                    break;
            }
        }
        Editor edit = this.a.m.edit();
        edit.putString("urmail", "1");
        edit.commit();
        ((TextView) this.a.findViewById(2131558686)).append(str);
    }
}
