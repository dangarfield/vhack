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
    final /* synthetic */ BotnetActivity f5262a;

    ag(BotnetActivity botnetActivity) {
        this.f5262a = botnetActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9068a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9069a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String m9068a(String... strArr) {
        String str = "";
        if (strArr[0].equals("1")) {
            str = fc.m9164a(this.f5262a.getApplicationContext(), "company", strArr[0], "vh_attackCompany.php");
        }
        if (strArr[0].equals("2")) {
            str = fc.m9164a(this.f5262a.getApplicationContext(), "company", strArr[0], "vh_attackCompany2.php");
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

    protected void m9069a(String str) {
        if (this.f5262a.f5001w == 1) {
            this.f5262a.findViewById(2131558587).setEnabled(false);
            this.f5262a.findViewById(2131558587).setClickable(false);
            TextView textView = (TextView) this.f5262a.findViewById(2131558591);
            textView.setTextColor(-65536);
            textView.setText("Ready in: 3h, 59m.");
        }
        if (this.f5262a.f5001w == 2) {
            this.f5262a.findViewById(2131558593).setEnabled(false);
            this.f5262a.findViewById(2131558593).setClickable(false);
            textView = (TextView) this.f5262a.findViewById(2131558597);
            textView.setTextColor(-65536);
            textView.setText("Ready in: 7h, 59m.");
        }
        if (str.equals("0")) {
            this.f5262a.f4999u = 1;
        }
        if (str.equals("1")) {
            this.f5262a.f4999u = 2;
        }
        if (str.equals("2")) {
            this.f5262a.f4999u = 3;
        }
        if (str.equals("3")) {
            this.f5262a.f4999u = 4;
        }
    }
}
