package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.ListView;

public class RankingActivity extends u {
    public fb l;
    ListView m;
    public String n;
    public String o;
    public SharedPreferences p;
    public final String q;

    public RankingActivity() {
        this.q = "h2530114.stratoserver.net";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968618);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.p = getSharedPreferences("loginData.xml", 0);
        this.n = this.p.getString("strUser", "");
        this.o = this.p.getString("strPass", "");
        Button button = (Button) findViewById(2131558919);
        Button button2 = (Button) findViewById(2131558920);
        button.setEnabled(true);
        button2.setEnabled(true);
        button.setOnClickListener(new ex(this, button, button2));
        button2.setOnClickListener(new ey(this, button, button2));
        new ez(this).execute(new String[]{"http://vhack.biz/api/v3/vh_ranking.php?user=" + this.n + "&pass=" + this.o});
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
