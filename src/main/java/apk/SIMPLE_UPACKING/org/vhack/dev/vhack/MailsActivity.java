package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.ListView;

public class MailsActivity extends AppCompatActivity {
    public final String f5084l;
    public SharedPreferences f5085m;
    public String f5086n;
    public String f5087o;
    public String f5088p;
    public cf f5089q;
    public String[] f5090r;
    public String[] f5091s;
    public String[] f5092t;
    public String[] f5093u;
    public String[] f5094v;
    public int f5095w;
    ListView f5096x;

    public MailsActivity() {
        this.f5084l = "h2530114.stratoserver.net";
        this.f5088p = "";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968613);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.f5085m = getSharedPreferences("loginData.xml", 0);
        this.f5086n = this.f5085m.getString("strUser", "");
        this.f5087o = this.f5085m.getString("strPass", "");
        new cg(this).execute(new String[]{"http://vhack.biz/api/v3/vh_mails.php?action=list&user=" + this.f5086n + "&pass=" + this.f5087o});
    }
}
