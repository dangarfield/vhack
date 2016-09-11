package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.ListView;

public class ClusterActivity extends u {
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public bg q;
    String[] r;
    String[] s;
    String[] t;
    ListView u;

    public ClusterActivity() {
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.r = null;
        this.s = null;
        this.t = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968605);
        getWindow().addFlags(1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.l = sharedPreferences.getString("strUser", "");
        this.m = sharedPreferences.getString("strPass", "");
        new ax(this).execute(new String[]{""});
        Button button = (Button) findViewById(2131558641);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new ar(this));
        button = (Button) findViewById(2131558636);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new as(this));
        button = (Button) findViewById(2131558654);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new at(this));
        button = (Button) findViewById(2131558677);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new aw(this));
    }

    public void l() {
        if (this.n.equals("0")) {
            findViewById(2131558632).setVisibility(0);
            findViewById(2131558643).setVisibility(8);
            return;
        }
        findViewById(2131558643).setVisibility(0);
        findViewById(2131558632).setVisibility(8);
        new ax(this).equals("");
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
