package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;

public class DailysActivity extends AppCompatActivity {
    public String f5048l;
    public String f5049m;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968607);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.f5048l = sharedPreferences.getString("strUser", "");
        this.f5049m = sharedPreferences.getString("strPass", "");
        getWindow().setSoftInputMode(3);
        new bo(this).execute(new String[0]);
    }
}
