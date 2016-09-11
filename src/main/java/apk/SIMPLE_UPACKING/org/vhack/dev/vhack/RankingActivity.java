package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

public class RankingActivity extends AppCompatActivity {
    public fb f5156l;
    ListView f5157m;
    public String f5158n;
    public String f5159o;
    public SharedPreferences f5160p;
    public final String f5161q;

    public RankingActivity() {
        this.f5161q = "h2530114.stratoserver.net";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968618);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.f5160p = getSharedPreferences("loginData.xml", 0);
        this.f5158n = this.f5160p.getString("strUser", "");
        this.f5159o = this.f5160p.getString("strPass", "");
        Button button = (Button) findViewById(2131558919);
        Button button2 = (Button) findViewById(2131558920);
        button.setEnabled(true);
        button2.setEnabled(true);
        button.setOnClickListener(new ex(this, button, button2));
        button2.setOnClickListener(new ey(this, button, button2));
        new ez(this).execute(new String[]{"http://vhack.biz/api/v3/vh_ranking.php?user=" + this.f5158n + "&pass=" + this.f5159o});
    }

    public String m9029a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
