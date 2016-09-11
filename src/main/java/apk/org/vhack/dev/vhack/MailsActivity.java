package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.a.u;
import android.widget.ListView;

public class MailsActivity extends u {
    public final String l;
    public SharedPreferences m;
    public String n;
    public String o;
    public String p;
    public cf q;
    public String[] r;
    public String[] s;
    public String[] t;
    public String[] u;
    public String[] v;
    public int w;
    ListView x;

    public MailsActivity() {
        this.l = "h2530114.stratoserver.net";
        this.p = "";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968613);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.m = getSharedPreferences("loginData.xml", 0);
        this.n = this.m.getString("strUser", "");
        this.o = this.m.getString("strPass", "");
        new cg(this).execute(new String[]{"http://vhack.biz/api/v3/vh_mails.php?action=list&user=" + this.n + "&pass=" + this.o});
    }
}
