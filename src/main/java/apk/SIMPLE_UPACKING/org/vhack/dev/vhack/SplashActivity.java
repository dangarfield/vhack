package org.vhack.dev.vhack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    public String f5184l;
    public String f5185m;
    public String f5186n;
    public SharedPreferences f5187o;
    public final String f5188p;

    public SplashActivity() {
        this.f5188p = "h2530114.stratoserver.net";
    }

    public void m9031l() {
        this.f5187o = getSharedPreferences("loginData.xml", 0);
        Editor edit = this.f5187o.edit();
        edit.putString("strUser", "");
        edit.putString("strPass", "");
        edit.commit();
        this.f5184l = this.f5187o.getString("strUser", "");
        this.f5185m = this.f5187o.getString("strPass", "");
        this.f5186n = this.f5187o.getString("uhash", "null");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968621);
        this.f5187o = getSharedPreferences("loginData.xml", 0);
        this.f5184l = this.f5187o.getString("strUser", "");
        this.f5185m = this.f5187o.getString("strPass", "");
        this.f5186n = this.f5187o.getString("uhash", "null");
        if (this.f5184l.equals("") || this.f5185m.equals("")) {
            startActivity(new Intent(getApplicationContext(), GameActivity.class));
            return;
        }
        new fi(this).execute(new String[]{this.f5184l, this.f5185m});
    }
}
