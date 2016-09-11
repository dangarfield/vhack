package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.ListView;
import java.util.Timer;

public class BotnetActivity extends u {
    public String l;
    public String m;
    public String[] n;
    public String[] o;
    public String[] p;
    public String[] q;
    public SharedPreferences r;
    public ai s;
    public String t;
    public int u;
    Timer v;
    public int w;
    public int x;
    ListView y;

    public BotnetActivity() {
        this.u = 0;
        this.x = 0;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968603);
        getWindow().addFlags(1024);
        this.r = getSharedPreferences("loginData.xml", 0);
        this.l = this.r.getString("strUser", "");
        this.m = this.r.getString("strPass", "");
        getWindow().setSoftInputMode(3);
        new q(this).execute(new String[0]);
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
