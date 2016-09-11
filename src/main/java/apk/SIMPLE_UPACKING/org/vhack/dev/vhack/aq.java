package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: BuyActivity */
class aq extends AsyncTask {
    final /* synthetic */ BuyActivity f5276a;

    aq(BuyActivity buyActivity) {
        this.f5276a = buyActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9076a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9077a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9076a(String... strArr) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5276a.getApplicationContext(), "fff::::siggi::::sh", strArr[0] + "::::" + strArr[1] + "::::" + strArr[2], "vh_addshit.php")).openConnection();
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

    protected void m9077a(String str) {
        if (str.equals("0")) {
            Toast.makeText(this.f5276a.getApplicationContext(), 2131165416, 1).show();
        } else {
            Toast.makeText(this.f5276a, this.f5276a.getString(2131165284) + this.f5276a.f5024v, 0).show();
        }
    }
}
