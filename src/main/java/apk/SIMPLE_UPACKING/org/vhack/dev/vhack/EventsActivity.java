package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {
    public String f5054l;
    public String f5055m;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968608);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.f5054l = sharedPreferences.getString("strUser", "");
        this.f5055m = sharedPreferences.getString("strPass", "");
        getWindow().setSoftInputMode(3);
        new bq(this).execute(new String[0]);
    }
}
