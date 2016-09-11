package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.ListView;

public class AdWareActivity extends u {
    public String l;
    public String m;
    public k n;
    public String[] o;
    public String[] p;
    public String[] q;
    public String[] r;
    public String s;
    ListView t;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968601);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.l = sharedPreferences.getString("strUser", "");
        this.m = sharedPreferences.getString("strPass", "");
        Button button = (Button) findViewById(2131558548);
        button.setEnabled(false);
        button.setOnClickListener(new a(this));
        getWindow().setSoftInputMode(3);
        new b(this).execute(new String[0]);
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
