package org.vhack.dev.vhack;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: MailsActivity */
class ci extends AsyncTask {
    final /* synthetic */ MailsActivity f5343a;

    ci(MailsActivity mailsActivity) {
        this.f5343a = mailsActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9135a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9136a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5343a.findViewById(2131558789).setVisibility(0);
    }

    protected String m9135a(String... strArr) {
        Log.e("mails", "REQUEST!");
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.m9164a(this.f5343a.getApplicationContext(), "action::::mID", "getmail::::" + strArr[0], "vh_mails.php")).openConnection();
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

    protected void m9136a(String str) {
        this.f5343a.findViewById(2131558778).setVisibility(0);
        this.f5343a.findViewById(2131558785).setVisibility(0);
        ((TextView) this.f5343a.findViewById(2131558783)).setText(str);
        ((TextView) this.f5343a.findViewById(2131558780)).setText(this.f5343a.f5090r[this.f5343a.f5095w]);
        ((TextView) this.f5343a.findViewById(2131558782)).setText(this.f5343a.f5091s[this.f5343a.f5095w]);
        String str2 = "";
        ((TextView) this.f5343a.findViewById(2131558784)).setText(new SimpleDateFormat("dd.MM. / HH:mm").format(new Date(Long.parseLong(this.f5343a.f5094v[this.f5343a.f5095w]) * 1000)));
        this.f5343a.f5092t[this.f5343a.f5095w] = "1";
        this.f5343a.f5089q.notifyDataSetChanged();
        this.f5343a.findViewById(2131558789).setVisibility(8);
        if (this.f5343a.f5091s[this.f5343a.f5095w].contains("Cluster request")) {
            Button button = (Button) this.f5343a.findViewById(2131558786);
            Button button2 = (Button) this.f5343a.findViewById(2131558787);
            button.setVisibility(0);
            button2.setVisibility(0);
            String substring = str.substring(str.indexOf(":[") + 2, str.indexOf("]"));
            button.setOnClickListener(new cj(this, substring));
            button2.setOnClickListener(new ck(this, substring));
            return;
        }
        button2 = (Button) this.f5343a.findViewById(2131558787);
        ((Button) this.f5343a.findViewById(2131558786)).setVisibility(8);
        button2.setVisibility(8);
    }
}
