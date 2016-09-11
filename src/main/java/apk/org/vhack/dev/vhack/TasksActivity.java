package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.Timer;

public class TasksActivity extends u {
    public String A;
    public String B;
    public fj C;
    public boolean D;
    public boolean E;
    public boolean F;
    ListView G;
    public String l;
    public String m;
    Timer n;
    final String o;
    public boolean p;
    public String q;
    public String r;
    public String[] s;
    public String[] t;
    public String[] u;
    public String[] v;
    public String[] w;
    public String[] x;
    public String[] y;
    public String[] z;

    public TasksActivity() {
        this.l = "";
        this.m = "";
        this.n = new Timer();
        this.o = "h2530114.stratoserver.net";
        this.p = false;
        this.s = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.t = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.u = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.D = true;
        this.E = false;
        this.F = false;
    }

    public void onResume() {
        super.onResume();
        this.D = true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968622);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.l = sharedPreferences.getString("strUser", "");
        this.m = sharedPreferences.getString("strPass", "");
        this.q = sharedPreferences.getString("netcoins", "0");
        l();
        new fq(this).execute(new String[0]);
        this.n.schedule(new fk(this), 1000, 1000);
    }

    public void l() {
        ((Button) findViewById(2131558953)).setOnClickListener(new fm(this));
        ((Button) findViewById(2131558957)).setOnClickListener(new fn(this));
        ((ImageButton) findViewById(2131558952)).setOnClickListener(new fo(this));
    }
}
