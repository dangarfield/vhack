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

/* compiled from: TasksActivity */
class fp extends AsyncTask {
    final /* synthetic */ TasksActivity f5466a;

    fp(TasksActivity tasksActivity) {
        this.f5466a = tasksActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9178a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9179b((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f5466a.f5194F = true;
        this.f5466a.findViewById(2131558958).setVisibility(0);
    }

    protected String m9178a(String... strArr) {
        String str = "";
        if (strArr[0].equals("1")) {
            str = fc.m9164a(this.f5466a.getApplicationContext(), "taskid", strArr[1], "vh_abortTask.php");
        } else {
            str = fc.m9164a(this.f5466a.getApplicationContext(), "taskid", strArr[1], "vh_finishTask.php");
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

    public String m9177a(String str) {
        return str.replace("\n", "").replace("\r", "").replace("\t", "").replace(" ", "");
    }

    protected void m9179b(String str) {
        String str2 = "";
        String a = m9177a(str);
        int i = -1;
        switch (a.hashCode()) {
            case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (a.equals("0")) {
                    i = 0;
                    break;
                }
                break;
            case R.AppCompatTheme_actionButtonStyle /*49*/:
                if (a.equals("1")) {
                    i = 1;
                    break;
                }
                break;
            case R.AppCompatTheme_buttonBarButtonStyle /*51*/:
                if (a.equals("3")) {
                    i = 2;
                    break;
                }
                break;
            case R.AppCompatTheme_selectableItemBackground /*52*/:
                if (a.equals("4")) {
                    i = 3;
                    break;
                }
                break;
            case R.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                if (a.equals("5")) {
                    i = 4;
                    break;
                }
                break;
            case R.AppCompatTheme_borderlessButtonStyle /*54*/:
                if (a.equals("6")) {
                    i = 5;
                    break;
                }
                break;
        }
        switch (i) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                new fq(this.f5466a).execute(new String[0]);
                Toast.makeText(this.f5466a, 2131165411, 1).show();
                this.f5466a.findViewById(2131558958).setVisibility(8);
                this.f5466a.findViewById(2131558950).setVisibility(8);
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f5466a.findViewById(2131558958).setVisibility(8);
                Toast.makeText(this.f5466a, 2131165281, 1).show();
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f5466a.findViewById(2131558958).setVisibility(8);
                Toast.makeText(this.f5466a, 2131165414, 1).show();
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                new fq(this.f5466a).execute(new String[0]);
                Toast.makeText(this.f5466a, 2131165413, 1).show();
                this.f5466a.findViewById(2131558958).setVisibility(8);
                this.f5466a.findViewById(2131558950).setVisibility(8);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                this.f5466a.findViewById(2131558958).setVisibility(8);
                Toast.makeText(this.f5466a, 2131165282, 1).show();
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f5466a.findViewById(2131558958).setVisibility(8);
                Toast.makeText(this.f5466a, 2131165376, 1).show();
                break;
        }
        this.f5466a.findViewById(2131558958).setVisibility(8);
    }
}
