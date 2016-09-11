package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;

public class DailysActivity extends u {
    public String l;
    public String m;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968607);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.l = sharedPreferences.getString("strUser", "");
        this.m = sharedPreferences.getString("strPass", "");
        getWindow().setSoftInputMode(3);
        new bo(this).execute(new String[0]);
    }
}
