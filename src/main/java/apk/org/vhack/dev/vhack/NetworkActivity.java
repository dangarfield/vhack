package org.vhack.dev.vhack;

import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.a.u;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NetworkActivity extends u {
    RelativeLayout[] A;
    public final String B;
    OnClickListener C;
    public String[] l;
    public String[] m;
    public SharedPreferences n;
    public String o;
    public String p;
    public String q;
    public String r;
    public DelayedVerticalScrollingTextView s;
    public EditText t;
    public String[] u;
    public int v;
    public String w;
    LinearLayout[] x;
    TextView[] y;
    TextView[] z;

    public NetworkActivity() {
        this.q = "";
        this.w = "";
        this.x = new LinearLayout[9];
        this.y = new TextView[9];
        this.z = new TextView[9];
        this.A = new RelativeLayout[9];
        this.B = "h2530114.stratoserver.net";
        this.C = new dy(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968615);
        getWindow().addFlags(1024);
        getWindow().setSoftInputMode(3);
        this.n = getSharedPreferences("loginData.xml", 0);
        this.o = this.n.getString("strUser", "");
        this.p = this.n.getString("strPass", "");
        this.t = (EditText) findViewById(2131558688);
        Button button = (Button) findViewById(2131558861);
        button.setClickable(true);
        this.s = (DelayedVerticalScrollingTextView) findViewById(2131558902);
        this.s.setMovementMethod(new ScrollingMovementMethod());
        this.x[0] = (LinearLayout) findViewById(2131558864);
        this.x[1] = (LinearLayout) findViewById(2131558868);
        this.x[2] = (LinearLayout) findViewById(2131558872);
        this.x[3] = (LinearLayout) findViewById(2131558876);
        this.x[4] = (LinearLayout) findViewById(2131558880);
        this.x[5] = (LinearLayout) findViewById(2131558884);
        this.x[6] = (LinearLayout) findViewById(2131558888);
        this.x[7] = (LinearLayout) findViewById(2131558892);
        this.x[8] = (LinearLayout) findViewById(2131558896);
        this.y[0] = (TextView) findViewById(2131558867);
        this.y[1] = (TextView) findViewById(2131558871);
        this.y[2] = (TextView) findViewById(2131558875);
        this.y[3] = (TextView) findViewById(2131558879);
        this.y[4] = (TextView) findViewById(2131558883);
        this.y[5] = (TextView) findViewById(2131558887);
        this.y[6] = (TextView) findViewById(2131558891);
        this.y[7] = (TextView) findViewById(2131558895);
        this.y[8] = (TextView) findViewById(2131558899);
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/HACKED.ttf");
        this.z[0] = (TextView) findViewById(2131558866);
        this.z[0].setTypeface(createFromAsset);
        this.z[1] = (TextView) findViewById(2131558870);
        this.z[1].setTypeface(createFromAsset);
        this.z[2] = (TextView) findViewById(2131558874);
        this.z[2].setTypeface(createFromAsset);
        this.z[3] = (TextView) findViewById(2131558878);
        this.z[3].setTypeface(createFromAsset);
        this.z[4] = (TextView) findViewById(2131558882);
        this.z[4].setTypeface(createFromAsset);
        this.z[5] = (TextView) findViewById(2131558886);
        this.z[5].setTypeface(createFromAsset);
        this.z[6] = (TextView) findViewById(2131558890);
        this.z[6].setTypeface(createFromAsset);
        this.z[7] = (TextView) findViewById(2131558894);
        this.z[7].setTypeface(createFromAsset);
        this.z[8] = (TextView) findViewById(2131558898);
        this.z[8].setTypeface(createFromAsset);
        this.A[0] = (RelativeLayout) findViewById(2131558865);
        this.A[1] = (RelativeLayout) findViewById(2131558869);
        this.A[2] = (RelativeLayout) findViewById(2131558873);
        this.A[3] = (RelativeLayout) findViewById(2131558877);
        this.A[4] = (RelativeLayout) findViewById(2131558881);
        this.A[5] = (RelativeLayout) findViewById(2131558885);
        this.A[6] = (RelativeLayout) findViewById(2131558889);
        this.A[7] = (RelativeLayout) findViewById(2131558893);
        this.A[8] = (RelativeLayout) findViewById(2131558897);
        button.setOnClickListener(new ef(this));
        ((ImageButton) findViewById(2131558901)).setOnClickListener(new eg(this));
        TextView[] textViewArr = new TextView[]{(TextView) findViewById(2131558866), (TextView) findViewById(2131558870), (TextView) findViewById(2131558874), (TextView) findViewById(2131558878), (TextView) findViewById(2131558882), (TextView) findViewById(2131558886), (TextView) findViewById(2131558890), (TextView) findViewById(2131558894), (TextView) findViewById(2131558898)};
        textViewArr[0].setOnClickListener(new eh(this));
        textViewArr[1].setOnClickListener(new ei(this));
        textViewArr[2].setOnClickListener(new ej(this));
        textViewArr[3].setOnClickListener(new ek(this));
        textViewArr[4].setOnClickListener(new el(this));
        textViewArr[5].setOnClickListener(new em(this));
        textViewArr[6].setOnClickListener(new dz(this));
        textViewArr[7].setOnClickListener(new ea(this));
        textViewArr[8].setOnClickListener(new eb(this));
        ((Button) findViewById(2131558689)).setOnClickListener(new ec(this));
        ((Button) findViewById(2131558690)).setOnClickListener(new ed(this));
        ((Button) findViewById(2131558903)).setOnClickListener(new ee(this));
        new en(this).execute(new String[]{"http://vhack.biz/api/v3/vh_network.php?user="});
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
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
