package org.vhack.dev.vhack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.p017a.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import org.vhack.dev.vhack.p053a.IabHelper;

public class BuyActivity extends AppCompatActivity {
    static final String[] f5004l;
    IabHelper f5005A;
    final String f5006B;
    public String f5007C;
    public String f5008D;
    public String f5009E;
    public SharedPreferences f5010F;
    public int f5011G;
    IabHelper f5012H;
    IabHelper f5013I;
    IabHelper f5014J;
    public String[] f5015m;
    public String[] f5016n;
    public String[] f5017o;
    public String[] f5018p;
    public String[] f5019q;
    public String[] f5020r;
    public Integer[] f5021s;
    public Integer[] f5022t;
    public String f5023u;
    public String f5024v;
    public fd f5025w;
    public fd f5026x;
    ListView f5027y;
    ListView f5028z;

    public BuyActivity() {
        this.f5015m = new String[]{"500 NetCoins", "1,000 NetCoins", "2,500 NetCoins", "5,000 NetCoins", "10,000 NetCoins", "20,000 NetCoins", "50,000 NetCoins"};
        this.f5016n = new String[]{"1mio v$", "2.4mio v$", "6mio v$", "14mio v$", "30mio (+10) v$", "64mio (+24) v$"};
        this.f5017o = new String[]{"+100 Bonus", "+300 Bonus", "+1,000 Bonus", "+2,500 Bonus", "+7,000 Bonus", "+18,000 Bonus", "+62,000 Bonus"};
        this.f5018p = new String[]{"(1.000.000)", "(2.400.000)", "(6.000.000)", "(14.000.000)", "(40.000.000)", "(88.000.000)"};
        this.f5019q = new String[]{"0,99\u20ac", "1,99\u20ac", "4,99\u20ac", "9,99\u20ac", "19,99\u20ac", "39,99\u20ac", "99,99\u20ac"};
        this.f5020r = new String[]{"0,99\u20ac", "1,99\u20ac", "4,99\u20ac", "9,99\u20ac", "19,99\u20ac", "39,99\u20ac"};
        this.f5021s = new Integer[]{Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619), Integer.valueOf(2130837619)};
        this.f5022t = new Integer[]{Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720), Integer.valueOf(2130837720)};
        this.f5023u = "";
        this.f5024v = "";
        this.f5006B = "h2530114.stratoserver.net";
        this.f5007C = "";
        this.f5008D = "";
        this.f5009E = "";
        this.f5012H = new aj(this);
        this.f5013I = new ak(this);
        this.f5014J = new al(this);
    }

    static {
        f5004l = new String[]{"org.vhack.dev.vhack.base1", "org.vhack.dev.vhack.base2", "org.vhack.dev.vhack.base3", "org.vhack.dev.vhack.base4", "org.vhack.dev.vhack.base5", "org.vhack.dev.vhack.base6", "org.vhack.dev.vhack.base7", "org.vhack.dev.vhack.base8", "org.vhack.dev.vhack.base9", "org.vhack.dev.vhack.base10", "org.vhack.dev.vhack.bigmoney", "org.vhack.dev.vhack.bigcoins", "org.vhack.dev.vhack.ipchange", "org.vhack.dev.vhack.verybigcoins"};
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f5005A != null) {
            Log.d("org.vhack.dev.vhack", "onActivityResult(" + i + "," + i2 + "," + intent);
            if (this.f5005A.m9051a(i, i2, intent)) {
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
                        this.f5010F = getSharedPreferences("loginData.xml", 0);
                        this.f5007C = this.f5010F.getString("strUser", "");
                        this.f5008D = this.f5010F.getString("strPass", "");
                        new aq(this).execute(new String[]{stringExtra, r1, this.f5011G + ""});
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
        if (this.f5005A != null) {
            this.f5005A.m9042a();
        }
        this.f5005A = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        setContentView(2130968604);
        this.f5010F = getSharedPreferences("loginData.xml", 0);
        this.f5007C = this.f5010F.getString("strUser", "");
        this.f5008D = this.f5010F.getString("strPass", "");
        ((TextView) findViewById(2131558630)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/HACKED.ttf"));
        Button button = (Button) findViewById(2131558626);
        button.setEnabled(true);
        button.setClickable(true);
        button.setOnClickListener(new am(this));
        this.f5025w = new fd(this, this.f5015m, this.f5017o, this.f5021s, this.f5019q);
        this.f5026x = new fd(this, this.f5016n, this.f5018p, this.f5022t, this.f5020r);
        this.f5027y = (ListView) findViewById(2131558628);
        this.f5027y.setAdapter(this.f5025w);
        this.f5027y.setOnItemClickListener(new an(this));
        this.f5028z = (ListView) findViewById(2131558629);
        this.f5028z.setAdapter(this.f5026x);
        this.f5028z.setOnItemClickListener(new ao(this));
        this.f5010F = getSharedPreferences("loginData.xml", 0);
        this.f5010F.getString("netcoins", "");
        this.f5005A = new IabHelper(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAteI8WMuJkXwUzIkKzZ7Hr/DN8K9YwW5E38YvGrRCUuJz8DwBUmqLT5UVhLGeYyZjYWXfXaIRnmiJaLuxiJpn1iWJfW+ozcyL8teHNdrzLUNZwlBcTb8byjRvYUZ/TKlETvYmmaXbTih2Ki3H7E2ezAtA+Y5PxedFjdrKjk+kflXPZQiuqAFxHmi1S0EeKPjDweNQyRVGPZtDnOARRbDfWfDk+LOInHMvCF7hTRaaNErgXeQHMw0+wgF0Bzs8gNtLXwqCUUCZXxXgmhR8nyhBLlW9gNokxH3IoTAU4YYa3Rr7Il2M/ysHHcp+DxiubdGYDchF7i9tc2xtR0wnzIlI2QIDAQAB");
        this.f5005A.m9050a(true, "TAG");
        this.f5005A.m9047a(new ap(this));
    }
}
