package org.vhack.dev.vhack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.a.u;

public class SplashActivity extends u {
    public String l;
    public String m;
    public String n;
    public SharedPreferences o;
    public final String p;

    public SplashActivity() {
        this.p = "h2530114.stratoserver.net";
    }

    public void l() {
        this.o = getSharedPreferences("loginData.xml", 0);
        Editor edit = this.o.edit();
        edit.putString("strUser", "");
        edit.putString("strPass", "");
        edit.commit();
        this.l = this.o.getString("strUser", "");
        this.m = this.o.getString("strPass", "");
        this.n = this.o.getString("uhash", "null");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968621);
        this.o = getSharedPreferences("loginData.xml", 0);
        this.l = this.o.getString("strUser", "");
        this.m = this.o.getString("strPass", "");
        this.n = this.o.getString("uhash", "null");
        if (this.l.equals("") || this.m.equals("")) {
            startActivity(new Intent(getApplicationContext(), GameActivity.class));
            return;
        }
        new fi(this).execute(new String[]{this.l, this.m});
    }
}
