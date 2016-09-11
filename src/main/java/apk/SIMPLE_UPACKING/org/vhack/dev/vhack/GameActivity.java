package org.vhack.dev.vhack;

import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity {
    final String f5058l;
    public String f5059m;
    public String f5060n;
    public String f5061o;
    public String f5062p;
    RelativeLayout f5063q;
    RelativeLayout f5064r;
    Button f5065s;
    EditText f5066t;
    EditText f5067u;
    EditText f5068v;
    public Button f5069w;
    Button f5070x;

    public GameActivity() {
        this.f5058l = "h2530114.stratoserver.net";
        this.f5059m = "";
        this.f5060n = "";
        this.f5061o = "";
        this.f5062p = "";
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
        this.f5066t = (EditText) findViewById(2131558751);
        this.f5067u = (EditText) findViewById(2131558753);
        this.f5068v = (EditText) findViewById(2131558754);
        this.f5063q = (RelativeLayout) findViewById(2131558757);
        this.f5064r = (RelativeLayout) findViewById(2131558750);
        this.f5069w = (Button) findViewById(2131558747);
        this.f5065s = (Button) findViewById(2131558756);
        this.f5070x = (Button) findViewById(2131558747);
        this.f5070x.setOnClickListener(new bu(this));
        ((Button) findViewById(2131558762)).setOnClickListener(new bv(this));
        ((Button) findViewById(2131558768)).setOnClickListener(new bw(this));
        this.f5065s.setOnClickListener(new bx(this));
        ((Button) findViewById(2131558758)).setOnClickListener(new by(this));
    }
}
