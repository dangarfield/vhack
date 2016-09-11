package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

public class ClusterActivity extends AppCompatActivity {
    public String f5029l;
    public String f5030m;
    public String f5031n;
    public String f5032o;
    public String f5033p;
    public bg f5034q;
    String[] f5035r;
    String[] f5036s;
    String[] f5037t;
    ListView f5038u;

    public ClusterActivity() {
        this.f5029l = "";
        this.f5030m = "";
        this.f5031n = "";
        this.f5032o = "";
        this.f5033p = "";
        this.f5035r = null;
        this.f5036s = null;
        this.f5037t = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968605);
        getWindow().addFlags(1024);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.f5029l = sharedPreferences.getString("strUser", "");
        this.f5030m = sharedPreferences.getString("strPass", "");
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

    public void m9009l() {
        if (this.f5031n.equals("0")) {
            findViewById(2131558632).setVisibility(0);
            findViewById(2131558643).setVisibility(8);
            return;
        }
        findViewById(2131558643).setVisibility(0);
        findViewById(2131558632).setVisibility(8);
        new ax(this).equals("");
    }

    public String m9008a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
