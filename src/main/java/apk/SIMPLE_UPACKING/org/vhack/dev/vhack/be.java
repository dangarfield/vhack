package org.vhack.dev.vhack;

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
class be extends AsyncTask {
    final /* synthetic */ ClusterActivity f5291a;

    be(ClusterActivity clusterActivity) {
        this.f5291a = clusterActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9088a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9089a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5291a.findViewById(2131558681).setVisibility(0);
    }

    protected String m9088a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5291a.getApplicationContext(), "", "", "vh_clusterLeave.php")).openConnection();
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

    protected void m9089a(String str) {
        this.f5291a.findViewById(2131558681).setVisibility(8);
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
                    i = 1;
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
                this.f5291a.getSharedPreferences("loginData.xml", 0);
                Toast.makeText(this.f5291a.getApplicationContext(), 2131165298, 1).show();
                this.f5291a.f5031n = "0";
                this.f5291a.m9009l();
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                Toast.makeText(this.f5291a.getApplicationContext(), 2131165301, 1).show();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                Toast.makeText(this.f5291a.getApplicationContext(), 2131165333, 1).show();
            default:
                Toast.makeText(this.f5291a.getApplicationContext(), str, 1).show();
        }
    }
}
