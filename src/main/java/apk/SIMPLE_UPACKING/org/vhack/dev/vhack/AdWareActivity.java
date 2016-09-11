package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: org.vhack.dev.vhack.j */
class AdWareActivity extends AsyncTask {
    final /* synthetic */ AdWareActivity f5472a;

    AdWareActivity(AdWareActivity adWareActivity) {
        this.f5472a = adWareActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9182a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9183a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        ((Button) this.f5472a.findViewById(2131558548)).setEnabled(false);
    }

    protected String m9182a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5472a.getApplicationContext(), "", "", "vh_removeAdware.php")).openConnection();
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

    protected void m9183a(String str) {
        if (str.equals("0")) {
            Toast.makeText(this.f5472a.getApplicationContext(), 2131165259, 0).show();
            ((TextView) this.f5472a.findViewById(2131558547)).setText(2131165409);
            return;
        }
        Toast.makeText(this.f5472a.getApplicationContext(), 2131165258, 0).show();
        ((Button) this.f5472a.findViewById(2131558548)).setEnabled(true);
    }
}
