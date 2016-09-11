package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.ListView;

public class LogActivity extends AppCompatActivity {
    public String f5071l;
    public String f5072m;
    public ce f5073n;
    public ListView f5074o;
    public Integer[] f5075p;
    public String[] f5076q;
    public String[] f5077r;
    public String[] f5078s;
    public String[] f5079t;
    public String[] f5080u;
    public String f5081v;
    public String[] f5082w;
    public String[] f5083x;

    public LogActivity() {
        this.f5075p = null;
        this.f5076q = null;
        this.f5077r = null;
        this.f5078s = null;
        this.f5079t = null;
        this.f5080u = null;
        this.f5081v = "";
        this.f5082w = null;
        this.f5083x = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968611);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.f5071l = sharedPreferences.getString("strUser", "");
        this.f5072m = sharedPreferences.getString("strPass", "");
        this.f5081v = sharedPreferences.getString("myip", "");
        getWindow().setSoftInputMode(3);
        this.f5074o = (ListView) findViewById(2131558772);
        new cc(this).execute(new String[]{""});
    }
}
