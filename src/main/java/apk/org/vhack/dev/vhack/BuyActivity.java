package org.vhack.dev.vhack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.a.u;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import org.vhack.dev.vhack.a.d;
import org.vhack.dev.vhack.a.i;
import org.vhack.dev.vhack.a.k;
import org.vhack.dev.vhack.a.m;

public class BuyActivity extends u {
    static final String[] l;
    d A;
    final String B;
    public String C;
    public String D;
    public String E;
    public SharedPreferences F;
    public int G;
    i H;
    k I;
    m J;
    public String[] m;
    public String[] n;
    public String[] o;
    public String[] p;
    public String[] q;
    public String[] r;
    public Integer[] s;
    public Integer[] t;
    public String u;
    public String v;
    public fd w;
    public fd x;
    ListView y;
    ListView z;

    public BuyActivity() {
        this.m = new String[]{"500 NetCoins", "1,000 NetCoins", "2,500 NetCoins", "5,000 NetCoins", "10,000 NetCoins", "20,000 NetCoins", "50,000 NetCoins"};
        this.n = new String[]{"1mio v$", "2.4mio v$", "6mio v$", "14mio v$", "30mio (+10) v$", "64mio (+24) v$"};
        this.o = new String[]{"+100 Bonus", "+300 Bonus", "+1,000 Bonus", "+2,500 Bonus", "+7,000 Bonus", "+18,000 Bonus", "+62,000 Bonus"};
        this.p = new String[]{"(1.000.000)", "(2.400.000)", "(6.000.000)", "(14.000.000)", "(40.000.000)", "(88.000.000)"};
        this.q = new String[]{"0,99\u20ac", "1,99\u20ac", "4,99\u20ac", "9,99\u20ac", "19,99\u20ac", "39,99\u20ac", "99,99\u20ac"};
        this.r = new String[]{"0,99\u20ac", "1,99\u20ac", "4,99\u20ac", "9,99\u20ac", "19,99\u20ac", "39,99\u20ac"};
        this.s = new Integer[]{Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619)};
        this.t = new Integer[]{Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720)};
        this.u = "";
        this.v = "";
        this.B = "h2530114.stratoserver.net";
        this.C = "";
        this.D = "";
        this.E = "";
        this.H = new aj(this);
        this.I = new ak(this);
        this.J = new al(this);
    }

    static {
        l = new String[]{"org.vhack.dev.vhack.base1", "org.vhack.dev.vhack.base2", "org.vhack.dev.vhack.base3", "org.vhack.dev.vhack.base4", "org.vhack.dev.vhack.base5", "org.vhack.dev.vhack.base6", "org.vhack.dev.vhack.base7", "org.vhack.dev.vhack.base8", "org.vhack.dev.vhack.base9", "org.vhack.dev.vhack.base10", "org.vhack.dev.vhack.bigmoney", "org.vhack.dev.vhack.bigcoins", "org.vhack.dev.vhack.ipchange", "org.vhack.dev.vhack.verybigcoins"};
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.A != null) {
            Log.d("org.vhack.dev.vhack", "onActivityResult(" + i + "," + i2 + "," + intent);
            if (this.A.getUpdate(i, i2, intent)) {
                Log.d("org.vhack.dev.vhack", "onActivityResult handled by IABUtil.");
            } else {
                super.onActivityResult(i, i2, intent);
            }
            if (i == 10001) {
                intent.getIntExtra("RESPONSE_CODE", 0);
                String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
                Log.d("INAPP_PURCHASE_DATA", ">>>" + stringExtra);
                Log.d("INAPP_DATA_SIGNATURE", ">>>" + intent.getStringExtra("INAPP_DATA_SIGNATURE"));
                if (i2 == -1) {
                    try {
                        this.F = getSharedPreferences("loginData.xml", 0);
                        this.C = this.F.getString("strUser", "");
                        this.D = this.F.getString("strPass", "");
                        new aq(this).execute(new String[]{stringExtra, r1, this.G + ""});
                        Log.d("purchaseData", ">>>" + stringExtra);
                        new JSONObject(stringExtra).getString("productId");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (i2 == 0) {
                    Toast.makeText(this, 2131165378, 0).show();
                } else if (i2 == 7) {
                    Toast.makeText(this, "Item already owned", 0).show();
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.A != null) {
            this.A.a();
        }
        this.A = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        setContentView(2130968604);
        this.F = getSharedPreferences("loginData.xml", 0);
        this.C = this.F.getString("strUser", "");
        this.D = this.F.getString("strPass", "");
        ((TextView) findViewById(2131558630)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/HACKED.ttf"));
        Button button = (Button) findViewById(2131558626);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new am(this));
        this.w = new fd(this, this.m, this.o, this.s, this.q);
        this.x = new fd(this, this.n, this.p, this.t, this.r);
        this.y = (ListView) findViewById(2131558628);
        this.y.setAdapter(this.w);
        this.y.setOnItemClickListener(new an(this));
        this.z = (ListView) findViewById(2131558629);
        this.z.setAdapter(this.x);
        this.z.setOnItemClickListener(new ao(this));
        this.F = getSharedPreferences("loginData.xml", 0);
        this.F.getString("netcoins", "");
        this.A = new d(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAteI8WMuJkXwUzIkKzZ7Hr/DN8K9YwW5E38YvGrRCUuJz8DwBUmqLT5UVhLGeYyZjYWXfXaIRnmiJaLuxiJpn1iWJfW+ozcyL8teHNdrzLUNZwlBcTb8byjRvYUZ/TKlETvYmmaXbTih2Ki3H7E2ezAtA+Y5PxedFjdrKjk+kflXPZQiuqAFxHmi1S0EeKPjDweNQyRVGPZtDnOARRbDfWfDk+LOInHMvCF7hTRaaNErgXeQHMw0+wgF0Bzs8gNtLXwqCUUCZXxXgmhR8nyhBLlW9gNokxH3IoTAU4YYa3Rr7Il2M/ysHHcp+DxiubdGYDchF7i9tc2xtR0wnzIlI2QIDAQAB");
        this.A.a(true, "TAG");
        this.A.a(new ap(this));
    }
}
