package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.TextView;

public class BonusBoxActivity extends u {
    public String l;
    public String m;
    public SharedPreferences n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968602);
        getWindow().addFlags(1024);
        this.n = getSharedPreferences("loginData.xml", 0);
        this.l = this.n.getString("strUser", "");
        this.m = this.n.getString("strPass", "");
        ((TextView) findViewById(2131558562)).setText(a(this.n.getString("netcoins", "0")));
        ((TextView) findViewById(2131558560)).setText(a(this.n.getString("money", "0")));
        ((TextView) findViewById(2131558565)).setText(this.n.getString("bonus", "0"));
        Button button = (Button) findViewById(2131558566);
        Button button2 = (Button) findViewById(2131558567);
        ((Button) findViewById(2131558577)).setOnClickListener(new l(this));
        button.setOnClickListener(new m(this));
        button2.setOnClickListener(new n(this));
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
