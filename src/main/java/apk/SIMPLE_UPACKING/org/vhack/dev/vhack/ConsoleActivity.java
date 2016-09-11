package org.vhack.dev.vhack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.p017a.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConsoleActivity extends AppCompatActivity {
    public final String f5039l;
    public SharedPreferences f5040m;
    public TextView f5041n;
    public String f5042o;
    public String f5043p;
    public String f5044q;
    public String f5045r;
    public EditText f5046s;
    public String f5047t;

    public ConsoleActivity() {
        this.f5039l = "h2530114.stratoserver.net";
        this.f5045r = "";
        this.f5047t = "";
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
        this.f5040m = getSharedPreferences("loginData.xml", 0);
        this.f5042o = this.f5040m.getString("strUser", "");
        this.f5043p = this.f5040m.getString("strPass", "");
        this.f5044q = this.f5040m.getString("netcoins", "0");
        this.f5041n = (TextView) findViewById(2131558684);
        this.f5041n.setText(this.f5044q);
        this.f5046s = (EditText) findViewById(2131558692);
        this.f5046s.getText().toString();
        ((ImageButton) findViewById(2131558695)).setOnClickListener(new bh(this));
        ((Button) findViewById(2131558690)).setOnClickListener(new bi(this));
        ((Button) findViewById(2131558689)).setOnClickListener(new bj(this));
    }

    public String m9010a(String str) {
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

    public String m9011b(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
