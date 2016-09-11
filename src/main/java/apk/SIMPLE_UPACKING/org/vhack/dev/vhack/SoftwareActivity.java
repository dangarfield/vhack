package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SoftwareActivity extends AppCompatActivity {
    public String[] f5162A;
    public String[] f5163B;
    public String[] f5164C;
    String[] f5165D;
    String[] f5166E;
    Integer[] f5167F;
    String[] f5168G;
    public int f5169l;
    public MediaPlayer f5170m;
    public int f5171n;
    public String f5172o;
    public long f5173p;
    public SharedPreferences f5174q;
    public String f5175r;
    public String f5176s;
    public String f5177t;
    public int f5178u;
    public Button f5179v;
    public final String f5180w;
    public bn f5181x;
    ListView f5182y;
    public String[] f5183z;

    public SoftwareActivity() {
        this.f5169l = 100;
        this.f5171n = 0;
        this.f5172o = "";
        this.f5173p = 0;
        this.f5177t = "";
        this.f5178u = 0;
        this.f5180w = "h2530114.stratoserver.net";
        this.f5165D = new String[11];
        this.f5166E = new String[]{"Internet", "Firewall", "Antivirus", "SDK", "IP-Spoofing", "Spam", "Scan", "AdWare", "CPU", "RAM", "HDD"};
        this.f5167F = new Integer[]{Integer.valueOf(2130837744), Integer.valueOf(2130837674), Integer.valueOf(2130837584), Integer.valueOf(2130837764), Integer.valueOf(2130837707), Integer.valueOf(2130837779), Integer.valueOf(2130837761), Integer.valueOf(2130837761), Integer.valueOf(2130837664), Integer.valueOf(2130837756), Integer.valueOf(2130837677)};
        this.f5168G = new String[]{"", "", "", "", "", "", "", "", "", "", "", ""};
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968620);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.f5170m = MediaPlayer.create(this, 2131099648);
        float log = (float) (Math.log((double) 15) / Math.log((double) 50));
        this.f5170m.setVolume(1.0f - log, 1.0f - log);
        this.f5183z = new String[]{getString(2131165270), getString(2131165269), getString(2131165268), getString(2131165273), getString(2131165271), getString(2131165274), getString(2131165272), getString(2131165315), "Youmudda"};
        this.f5162A = new String[]{getString(2131165305), getString(2131165306), getString(2131165307), getString(2131165308), getString(2131165309), getString(2131165310), getString(2131165311), getString(2131165312), getString(2131165313), getString(2131165314)};
        this.f5163B = new String[]{getString(2131165380), getString(2131165385), getString(2131165386), getString(2131165387), getString(2131165388), getString(2131165389), getString(2131165390), getString(2131165391), getString(2131165392), getString(2131165381), getString(2131165382), getString(2131165383), getString(2131165384), getString(2131165393)};
        this.f5164C = new String[]{getString(2131165335), getString(2131165336), getString(2131165337), getString(2131165338), getString(2131165339), getString(2131165340), getString(2131165341), getString(2131165342), getString(2131165343), getString(2131165344)};
        this.f5165D[0] = getString(2131165320);
        this.f5165D[1] = getString(2131165318);
        this.f5165D[2] = getString(2131165316);
        this.f5165D[3] = getString(2131165324);
        this.f5165D[4] = getString(2131165321);
        this.f5165D[5] = getString(2131165325);
        this.f5165D[6] = getString(2131165323);
        this.f5165D[7] = getString(2131165264);
        this.f5165D[8] = getString(2131165317);
        this.f5165D[9] = getString(2131165322);
        this.f5165D[10] = getString(2131165319);
        this.f5174q = getSharedPreferences("loginData.xml", 0);
        this.f5175r = this.f5174q.getString("strUser", "");
        this.f5176s = this.f5174q.getString("strPass", "");
        this.f5173p = Long.parseLong(this.f5174q.getString("money", "0"));
        this.f5168G[0] = this.f5174q.getString("inet", "");
        this.f5168G[1] = this.f5174q.getString("fw", "");
        this.f5168G[2] = this.f5174q.getString("av", "");
        this.f5168G[3] = this.f5174q.getString("sdk", "");
        this.f5168G[4] = this.f5174q.getString("ipsp", "");
        this.f5168G[5] = this.f5174q.getString("spam", "");
        this.f5168G[6] = this.f5174q.getString("scan", "");
        this.f5168G[7] = this.f5174q.getString("adw", "");
        this.f5168G[8] = this.f5174q.getString("cpu", "");
        this.f5168G[9] = this.f5174q.getString("ram", "");
        this.f5168G[10] = this.f5174q.getString("hdd", "");
        this.f5168G[11] = this.f5173p + "";
        this.f5181x = new bn(this, this.f5166E, this.f5167F, this.f5168G);
        ((TextView) findViewById(2131558937)).setText("$" + m9030a(this.f5173p + ""));
        this.f5179v = (Button) findViewById(2131558935);
        this.f5179v.setClickable(false);
        this.f5179v.setOnClickListener(new fe(this));
        this.f5182y = (ListView) findViewById(2131558938);
        this.f5182y.setAdapter(this.f5181x);
        this.f5179v.setClickable(false);
        this.f5182y.setOnItemClickListener(new ff(this));
    }

    public String m9030a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
