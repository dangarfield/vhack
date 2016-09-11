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
    final /* synthetic */ MailsActivity a;

    ci(MailsActivity mailsActivity) {
        this.a = mailsActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.a.findViewById(2131558789).setVisibility(0);
    }

    protected String a(String... strArr) {
        Log.e("mails", "REQUEST!");
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fc.a(this.a.getApplicationContext(), "action::::mID", "getmail::::" + strArr[0], "vh_mails.php")).openConnection();
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
        this.a.findViewById(2131558778).setVisibility(0);
        this.a.findViewById(2131558785).setVisibility(0);
        ((TextView) this.a.findViewById(2131558783)).setText(str);
        ((TextView) this.a.findViewById(2131558780)).setText(this.a.r[this.a.w]);
        ((TextView) this.a.findViewById(2131558782)).setText(this.a.s[this.a.w]);
        String str2 = "";
        ((TextView) this.a.findViewById(2131558784)).setText(new SimpleDateFormat("dd.MM. / HH:mm").format(new Date(Long.parseLong(this.a.v[this.a.w]) * 1000)));
        this.a.t[this.a.w] = "1";
        this.a.q.notifyDataSetChanged();
        this.a.findViewById(2131558789).setVisibility(8);
        if (this.a.s[this.a.w].contains("Cluster request")) {
            Button button = (Button) this.a.findViewById(2131558786);
            Button button2 = (Button) this.a.findViewById(2131558787);
            button.setVisibility(0);
            button2.setVisibility(0);
            String substring = str.substring(str.indexOf(":[") + 2, str.indexOf("]"));
            button.setOnClickListener(new cj(this, substring));
            button2.setOnClickListener(new ck(this, substring));
            return;
        }
        button2 = (Button) this.a.findViewById(2131558787);
        ((Button) this.a.findViewById(2131558786)).setVisibility(8);
        button2.setVisibility(8);
    }
}
