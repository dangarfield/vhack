package org.vhack.dev.vhack;

import android.os.Bundle;
import android.support.v7.a.u;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class GameActivity extends u {
    final String l;
    public String m;
    public String n;
    public String o;
    public String p;
    RelativeLayout q;
    RelativeLayout r;
    Button s;
    EditText t;
    EditText u;
    EditText v;
    public Button w;
    Button x;

    public GameActivity() {
        this.l = "h2530114.stratoserver.net";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131558764);
        if (relativeLayout.getVisibility() == 0) {
            relativeLayout.setVisibility(8);
        } else {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968610);
        Log.d("WIEDERGAME", "HHEHE");
        this.t = (EditText) findViewById(2131558751);
        this.u = (EditText) findViewById(2131558753);
        this.v = (EditText) findViewById(2131558754);
        this.q = (RelativeLayout) findViewById(2131558757);
        this.r = (RelativeLayout) findViewById(2131558750);
        this.w = (Button) findViewById(2131558747);
        this.s = (Button) findViewById(2131558756);
        this.x = (Button) findViewById(2131558747);
        this.x.setOnClickListener(new bu(this));
        ((Button) findViewById(2131558762)).setOnClickListener(new bv(this));
        ((Button) findViewById(2131558768)).setOnClickListener(new bw(this));
        this.s.setOnClickListener(new bx(this));
        ((Button) findViewById(2131558758)).setOnClickListener(new by(this));
    }
}
