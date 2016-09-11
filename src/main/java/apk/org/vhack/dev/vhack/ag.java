package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: BotnetActivity */
class ag extends AsyncTask {
    final /* synthetic */ BotnetActivity a;

    ag(BotnetActivity botnetActivity) {
        this.a = botnetActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String a(String... strArr) {
        String str = "";
        if (strArr[0].equals("1")) {
            str = fc.a(this.a.getApplicationContext(), "company", strArr[0], "vh_attackCompany.php");
        }
        if (strArr[0].equals("2")) {
            str = fc.a(this.a.getApplicationContext(), "company", strArr[0], "vh_attackCompany2.php");
        }
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
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
        if (this.a.w == 1) {
            this.a.findViewById(2131558587).setEnabled(false);
            this.a.findViewById(2131558587).setClickable(false);
            TextView textView = (TextView) this.a.findViewById(2131558591);
            textView.setTextColor(-65536);
            textView.setText("Ready in: 3h, 59m.");
        }
        if (this.a.w == 2) {
            this.a.findViewById(2131558593).setEnabled(false);
            this.a.findViewById(2131558593).setClickable(false);
            textView = (TextView) this.a.findViewById(2131558597);
            textView.setTextColor(-65536);
            textView.setText("Ready in: 7h, 59m.");
        }
        if (str.equals("0")) {
            this.a.u = 1;
        }
        if (str.equals("1")) {
            this.a.u = 2;
        }
        if (str.equals("2")) {
            this.a.u = 3;
        }
        if (str.equals("3")) {
            this.a.u = 4;
        }
    }
}
