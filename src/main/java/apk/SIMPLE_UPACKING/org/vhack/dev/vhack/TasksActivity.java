package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.Timer;

public class TasksActivity extends AppCompatActivity {
    public String f5189A;
    public String f5190B;
    public fj f5191C;
    public boolean f5192D;
    public boolean f5193E;
    public boolean f5194F;
    ListView f5195G;
    public String f5196l;
    public String f5197m;
    Timer f5198n;
    final String f5199o;
    public boolean f5200p;
    public String f5201q;
    public String f5202r;
    public String[] f5203s;
    public String[] f5204t;
    public String[] f5205u;
    public String[] f5206v;
    public String[] f5207w;
    public String[] f5208x;
    public String[] f5209y;
    public String[] f5210z;

    public TasksActivity() {
        this.f5196l = "";
        this.f5197m = "";
        this.f5198n = new Timer();
        this.f5199o = "h2530114.stratoserver.net";
        this.f5200p = false;
        this.f5203s = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.f5204t = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.f5205u = new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        this.f5206v = null;
        this.f5207w = null;
        this.f5208x = null;
        this.f5209y = null;
        this.f5210z = null;
        this.f5192D = true;
        this.f5193E = false;
        this.f5194F = false;
    }

    public void onResume() {
        super.onResume();
        this.f5192D = true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968622);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.f5196l = sharedPreferences.getString("strUser", "");
        this.f5197m = sharedPreferences.getString("strPass", "");
        this.f5201q = sharedPreferences.getString("netcoins", "0");
        m9032l();
        new fq(this).execute(new String[0]);
        this.f5198n.schedule(new fk(this), 1000, 1000);
    }

    public void m9032l() {
        ((Button) findViewById(2131558953)).setOnClickListener(new fm(this));
        ((Button) findViewById(2131558957)).setOnClickListener(new fn(this));
        ((ImageButton) findViewById(2131558952)).setOnClickListener(new fo(this));
    }
}
