package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: NetworkActivity */
class er extends AsyncTask {
    final /* synthetic */ NetworkActivity f5417a;

    er(NetworkActivity networkActivity) {
        this.f5417a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9153a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9154a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5417a.findViewById(2131558689).setEnabled(false);
        this.f5417a.findViewById(2131558690).setEnabled(false);
        this.f5417a.findViewById(2131558689).setEnabled(false);
        this.f5417a.findViewById(2131558903).setEnabled(false);
        this.f5417a.findViewById(2131558866).setEnabled(false);
        this.f5417a.findViewById(2131558870).setEnabled(false);
        this.f5417a.findViewById(2131558874).setEnabled(false);
        this.f5417a.findViewById(2131558878).setEnabled(false);
        this.f5417a.findViewById(2131558882).setEnabled(false);
        this.f5417a.findViewById(2131558886).setEnabled(false);
        this.f5417a.findViewById(2131558890).setEnabled(false);
        this.f5417a.findViewById(2131558894).setEnabled(false);
        this.f5417a.findViewById(2131558898).setEnabled(false);
    }

    protected String m9153a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5417a.getApplicationContext(), "target", strArr[0], "vh_scan.php")).openConnection();
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

    protected void m9154a(String str) {
        String str2 = "";
        if (str.length() <= 40) {
            int i = -1;
            switch (str.hashCode()) {
                case R.AppCompatTheme_buttonBarStyle /*50*/:
                    if (str.equals("2")) {
                        boolean z = true;
                        break;
                    }
                    break;
                case R.AppCompatTheme_buttonBarButtonStyle /*51*/:
                    if (str.equals("3")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    str = this.f5417a.getString(2131165410);
                    break;
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    str = this.f5417a.getString(2131165404);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    str = this.f5417a.getString(2131165333);
                    break;
                default:
                    str = str2;
                    break;
            }
        }
        this.f5417a.f5152w = str;
        str2 = this.f5417a.getString(2131165406) + " " + this.f5417a.f5146q + ":\n" + str;
        this.f5417a.f5151v = 0;
        this.f5417a.f5150u = str2.split("\n");
        this.f5417a.f5148s.m9018a(str2, "\n");
        this.f5417a.f5148s.m9017a(120, true);
        new Thread(new es(this)).start();
    }
}
