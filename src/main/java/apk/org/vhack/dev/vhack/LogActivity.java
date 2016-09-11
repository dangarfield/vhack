package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.ListView;

public class LogActivity extends u {
    public String l;
    public String m;
    public ce n;
    public ListView o;
    public Integer[] p;
    public String[] q;
    public String[] r;
    public String[] s;
    public String[] t;
    public String[] u;
    public String v;
    public String[] w;
    public String[] x;

    public LogActivity() {
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = "";
        this.w = null;
        this.x = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968611);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.l = sharedPreferences.getString("strUser", "");
        this.m = sharedPreferences.getString("strPass", "");
        this.v = sharedPreferences.getString("myip", "");
        getWindow().setSoftInputMode(3);
        this.o = (ListView) findViewById(2131558772);
        new cc(this).execute(new String[]{""});
    }
}
