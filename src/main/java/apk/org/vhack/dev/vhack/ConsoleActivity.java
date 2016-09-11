package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.a.u;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConsoleActivity extends u {
    public final String l;
    public SharedPreferences m;
    public TextView n;
    public String o;
    public String p;
    public String q;
    public String r;
    public EditText s;
    public String t;

    public ConsoleActivity() {
        this.l = "h2530114.stratoserver.net";
        this.r = "";
        this.t = "";
    }

    public void onResume() {
        super.onResume();
        CharSequence stringExtra = getIntent().getStringExtra("cmd");
        if (stringExtra != null && !stringExtra.equals("")) {
            ((EditText) findViewById(2131558688)).setText(stringExtra);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968606);
        getWindow().addFlags(1024);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.m = getSharedPreferences("loginData.xml", 0);
        this.o = this.m.getString("strUser", "");
        this.p = this.m.getString("strPass", "");
        this.q = this.m.getString("netcoins", "0");
        this.n = (TextView) findViewById(2131558684);
        this.n.setText(this.q);
        this.s = (EditText) findViewById(2131558692);
        this.s.getText().toString();
        ((ImageButton) findViewById(2131558695)).setOnClickListener(new bh(this));
        ((Button) findViewById(2131558690)).setOnClickListener(new bi(this));
        ((Button) findViewById(2131558689)).setOnClickListener(new bj(this));
    }

    public String a(String str) {
        long j;
        long j2;
        String str2;
        long parseLong = Long.parseLong(str);
        if (parseLong >= 3600) {
            j = parseLong % 3600;
            j2 = (parseLong - j) / 3600;
        } else {
            j = parseLong;
            j2 = 0;
        }
        if (j >= 60) {
            parseLong = j % 60;
            j = (j - parseLong) / 60;
        } else {
            parseLong = j;
            j = 0;
        }
        String str3 = "";
        if (j2 > 0) {
            str3 = str3 + Long.toString(j2) + "h ";
        }
        if (j > 0) {
            str2 = str3 + Long.toString(j) + "m ";
        } else {
            str2 = str3;
        }
        if (parseLong > 0) {
            return str2 + Long.toString(parseLong) + "s.";
        }
        return str2;
    }

    public String b(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
