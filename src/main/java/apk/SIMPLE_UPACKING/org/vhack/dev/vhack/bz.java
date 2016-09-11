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

/* compiled from: GameActivity */
class bz extends AsyncTask {
    final /* synthetic */ GameActivity f5321a;

    bz(GameActivity gameActivity) {
        this.f5321a = gameActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9123a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9124a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5321a.findViewById(2131558763).setVisibility(0);
    }

    protected String m9123a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5321a.getApplicationContext(), "regmail", strArr[0], "vh_requestPass.php")).openConnection();
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

    protected void m9124a(String str) {
        this.f5321a.findViewById(2131558763).setVisibility(8);
        String replace = str.replace("\r", "").replace("\n", "");
        int i = -1;
        switch (replace.hashCode()) {
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (replace.equals("0")) {
                    i = 0;
                    break;
                }
                break;
            case R.AppCompatTheme_actionButtonStyle /*49*/:
                if (replace.equals("1")) {
                    i = 1;
                    break;
                }
                break;
            case R.AppCompatTheme_buttonBarStyle /*50*/:
                if (replace.equals("2")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                Toast.makeText(this.f5321a.getApplicationContext(), "Recovery informations were sent successfuly!", 1).show();
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                Toast.makeText(this.f5321a.getApplicationContext(), "E-Mail address not found!", 1).show();
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                Toast.makeText(this.f5321a.getApplicationContext(), "You already requested a new password. Please wait 10 minutes.", 1).show();
            default:
        }
    }
}
