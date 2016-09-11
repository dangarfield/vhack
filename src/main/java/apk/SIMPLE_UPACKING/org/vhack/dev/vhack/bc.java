package org.vhack.dev.vhack;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v7.p018b.R;
import android.widget.Toast;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ClusterActivity */
class bc extends AsyncTask {
    final /* synthetic */ ClusterActivity f5289a;

    bc(ClusterActivity clusterActivity) {
        this.f5289a = clusterActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9084a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9085a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5289a.findViewById(2131558681).setVisibility(0);
    }

    protected String m9084a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5289a.getApplicationContext(), "cname::::ctag", strArr[0] + "::::" + strArr[1], "vh_clusterAdd.php")).openConnection();
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

    protected void m9085a(String str) {
        this.f5289a.findViewById(2131558681).setVisibility(8);
        int i = -1;
        switch (str.hashCode()) {
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (str.equals("0")) {
                    i = 0;
                    break;
                }
                break;
            case R.AppCompatTheme_buttonBarStyle /*50*/:
                if (str.equals("2")) {
                    i = 1;
                    break;
                }
                break;
            case R.AppCompatTheme_buttonBarButtonStyle /*51*/:
                if (str.equals("3")) {
                    i = 2;
                    break;
                }
                break;
            case R.AppCompatTheme_borderlessButtonStyle /*54*/:
                if (str.equals("6")) {
                    i = 3;
                    break;
                }
                break;
            case R.AppCompatTheme_dividerVertical /*55*/:
                if (str.equals("7")) {
                    i = 4;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    i = 5;
                    break;
                }
                break;
        }
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                Editor edit = this.f5289a.getSharedPreferences("loginData.xml", 0).edit();
                edit.putString("clusterID", "1");
                edit.commit();
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165293, 1).show();
                this.f5289a.f5031n = "1";
                new ax(this.f5289a).execute(new String[]{""});
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165300, 1).show();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165286, 1).show();
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165288, 1).show();
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165375, 1).show();
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                Toast.makeText(this.f5289a.getApplicationContext(), 2131165331, 1).show();
            default:
                Toast.makeText(this.f5289a.getApplicationContext(), str, 1).show();
        }
    }
}
