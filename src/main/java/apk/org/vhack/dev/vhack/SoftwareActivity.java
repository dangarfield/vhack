package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SoftwareActivity extends u {
    public String[] A;
    public String[] B;
    public String[] C;
    String[] D;
    String[] E;
    Integer[] F;
    String[] G;
    public int l;
    public MediaPlayer m;
    public int n;
    public String o;
    public long p;
    public SharedPreferences q;
    public String r;
    public String s;
    public String t;
    public int u;
    public Button v;
    public final String w;
    public bn x;
    ListView y;
    public String[] z;

    public SoftwareActivity() {
        this.l = 100;
        this.n = 0;
        this.o = "";
        this.p = 0;
        this.t = "";
        this.u = 0;
        this.w = "h2530114.stratoserver.net";
        this.D = new String[11];
        this.E = new String[]{"Internet", "Firewall", "Antivirus", "SDK", "IP-Spoofing", "Spam", "Scan", "AdWare", "CPU", "RAM", "HDD"};
        this.F = new Integer[]{Integer.valueOf(2130837744), Integer.valueOf(2130837674), Integer.valueOf(2130837584), Integer.valueOf(2130837764), Integer.valueOf(2130837707), Integer.valueOf(2130837779), Integer.valueOf(2130837761), Integer.valueOf(2130837761), Integer.valueOf(2130837664), Integer.valueOf(2130837756), Integer.valueOf(2130837677)};
        this.G = new String[]{"", "", "", "", "", "", "", "", "", "", "", ""};
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968620);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.m = MediaPlayer.create(this, 2131099648);
        float log = (float) (Math.log((double) 15) / Math.log((double) 50));
        this.m.setVolume(1.0f - log, 1.0f - log);
        this.z = new String[]{getString(2131165270), getString(2131165269), getString(2131165268), getString(2131165273), getString(2131165271), getString(2131165274), getString(2131165272), getString(2131165315), "Youmudda"};
        this.A = new String[]{getString(2131165305), getString(2131165306), getString(2131165307), getString(2131165308), getString(2131165309), getString(2131165310), getString(2131165311), getString(2131165312), getString(2131165313), getString(2131165314)};
        this.B = new String[]{getString(2131165380), getString(2131165385), getString(2131165386), getString(2131165387), getString(2131165388), getString(2131165389), getString(2131165390), getString(2131165391), getString(2131165392), getString(2131165381), getString(2131165382), getString(2131165383), getString(2131165384), getString(2131165393)};
        this.C = new String[]{getString(2131165335), getString(2131165336), getString(2131165337), getString(2131165338), getString(2131165339), getString(2131165340), getString(2131165341), getString(2131165342), getString(2131165343), getString(2131165344)};
        this.D[0] = getString(2131165320);
        this.D[1] = getString(2131165318);
        this.D[2] = getString(2131165316);
        this.D[3] = getString(2131165324);
        this.D[4] = getString(2131165321);
        this.D[5] = getString(2131165325);
        this.D[6] = getString(2131165323);
        this.D[7] = getString(2131165264);
        this.D[8] = getString(2131165317);
        this.D[9] = getString(2131165322);
        this.D[10] = getString(2131165319);
        this.q = getSharedPreferences("loginData.xml", 0);
        this.r = this.q.getString("strUser", "");
        this.s = this.q.getString("strPass", "");
        this.p = Long.parseLong(this.q.getString("money", "0"));
        this.G[0] = this.q.getString("inet", "");
        this.G[1] = this.q.getString("fw", "");
        this.G[2] = this.q.getString("av", "");
        this.G[3] = this.q.getString("sdk", "");
        this.G[4] = this.q.getString("ipsp", "");
        this.G[5] = this.q.getString("spam", "");
        this.G[6] = this.q.getString("scan", "");
        this.G[7] = this.q.getString("adw", "");
        this.G[8] = this.q.getString("cpu", "");
        this.G[9] = this.q.getString("ram", "");
        this.G[10] = this.q.getString("hdd", "");
        this.G[11] = this.p + "";
        this.x = new bn(this, this.E, this.F, this.G);
        ((TextView) findViewById(2131558937)).setText("$" + a(this.p + ""));
        this.v = (Button) findViewById(2131558935);
        this.v.setClickable(false);
        this.v.setOnClickListener(new fe(this));
        this.y = (ListView) findViewById(2131558938);
        this.y.setAdapter(this.x);
        this.v.setClickable(false);
        this.y.setOnItemClickListener(new ff(this));
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
