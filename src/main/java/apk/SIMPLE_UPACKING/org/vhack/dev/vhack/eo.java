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
class eo extends AsyncTask {
    final /* synthetic */ NetworkActivity f5414a;

    eo(NetworkActivity networkActivity) {
        this.f5414a = networkActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9151a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9152a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5414a.findViewById(2131558689).setEnabled(false);
        this.f5414a.findViewById(2131558690).setEnabled(false);
        this.f5414a.findViewById(2131558689).setEnabled(false);
        this.f5414a.findViewById(2131558903).setEnabled(false);
        this.f5414a.findViewById(2131558866).setEnabled(false);
        this.f5414a.findViewById(2131558870).setEnabled(false);
        this.f5414a.findViewById(2131558874).setEnabled(false);
        this.f5414a.findViewById(2131558878).setEnabled(false);
        this.f5414a.findViewById(2131558882).setEnabled(false);
        this.f5414a.findViewById(2131558886).setEnabled(false);
        this.f5414a.findViewById(2131558890).setEnabled(false);
        this.f5414a.findViewById(2131558894).setEnabled(false);
        this.f5414a.findViewById(2131558898).setEnabled(false);
    }

    protected String m9151a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5414a.getApplicationContext(), "target", strArr[0], "vh_adwareUpload.php")).openConnection();
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

    protected void m9152a(String str) {
        String str2 = "";
        int i = -1;
        switch (str.hashCode()) {
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (str.equals("0")) {
                    i = 0;
                    break;
                }
                break;
            case R.AppCompatTheme_actionButtonStyle /*49*/:
                if (str.equals("1")) {
                    boolean z = true;
                    break;
                }
                break;
            case R.AppCompatTheme_dividerVertical /*55*/:
                if (str.equals("7")) {
                    i = 2;
                    break;
                }
                break;
            case R.AppCompatTheme_dividerHorizontal /*56*/:
                if (str.equals("8")) {
                    i = 3;
                    break;
                }
                break;
            case R.AppCompatTheme_activityChooserViewStyle /*57*/:
                if (str.equals("9")) {
                    i = 4;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    i = 5;
                    break;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    i = 6;
                    break;
                }
                break;
        }
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                str2 = this.f5414a.getString(2131165249);
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                str2 = this.f5414a.getString(2131165253);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                str2 = this.f5414a.getString(2131165255);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                str2 = this.f5414a.getString(2131165252);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                str2 = this.f5414a.getString(2131165256);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                str2 = this.f5414a.getString(2131165251);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                str2 = this.f5414a.getString(2131165254);
                break;
        }
        this.f5414a.f5152w = str2;
        str2 = this.f5414a.getString(2131165430) + str2;
        this.f5414a.f5151v = 0;
        this.f5414a.f5150u = str2.split("\n");
        this.f5414a.f5148s.m9018a(str2, "\n");
        this.f5414a.f5148s.m9017a(120, true);
        new Thread(new ep(this)).start();
    }
}
