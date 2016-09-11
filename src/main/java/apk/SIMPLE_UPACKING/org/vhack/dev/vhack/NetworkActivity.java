package org.vhack.dev.vhack;

import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.p017a.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NetworkActivity extends AppCompatActivity {
    RelativeLayout[] f5138A;
    public final String f5139B;
    OnClickListener f5140C;
    public String[] f5141l;
    public String[] f5142m;
    public SharedPreferences f5143n;
    public String f5144o;
    public String f5145p;
    public String f5146q;
    public String f5147r;
    public DelayedVerticalScrollingTextView f5148s;
    public EditText f5149t;
    public String[] f5150u;
    public int f5151v;
    public String f5152w;
    LinearLayout[] f5153x;
    TextView[] f5154y;
    TextView[] f5155z;

    public NetworkActivity() {
        this.f5146q = "";
        this.f5152w = "";
        this.f5153x = new LinearLayout[9];
        this.f5154y = new TextView[9];
        this.f5155z = new TextView[9];
        this.f5138A = new RelativeLayout[9];
        this.f5139B = "h2530114.stratoserver.net";
        this.f5140C = new dy(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968615);
        getWindow().addFlags(1024);
        getWindow().setSoftInputMode(3);
        this.f5143n = getSharedPreferences("loginData.xml", 0);
        this.f5144o = this.f5143n.getString("strUser", "");
        this.f5145p = this.f5143n.getString("strPass", "");
        this.f5149t = (EditText) findViewById(2131558688);
        Button button = (Button) findViewById(2131558861);
        button.setClickable(true);
        this.f5148s = (DelayedVerticalScrollingTextView) findViewById(2131558902);
        this.f5148s.setMovementMethod(new ScrollingMovementMethod());
        this.f5153x[0] = (LinearLayout) findViewById(2131558864);
        this.f5153x[1] = (LinearLayout) findViewById(2131558868);
        this.f5153x[2] = (LinearLayout) findViewById(2131558872);
        this.f5153x[3] = (LinearLayout) findViewById(2131558876);
        this.f5153x[4] = (LinearLayout) findViewById(2131558880);
        this.f5153x[5] = (LinearLayout) findViewById(2131558884);
        this.f5153x[6] = (LinearLayout) findViewById(2131558888);
        this.f5153x[7] = (LinearLayout) findViewById(2131558892);
        this.f5153x[8] = (LinearLayout) findViewById(2131558896);
        this.f5154y[0] = (TextView) findViewById(2131558867);
        this.f5154y[1] = (TextView) findViewById(2131558871);
        this.f5154y[2] = (TextView) findViewById(2131558875);
        this.f5154y[3] = (TextView) findViewById(2131558879);
        this.f5154y[4] = (TextView) findViewById(2131558883);
        this.f5154y[5] = (TextView) findViewById(2131558887);
        this.f5154y[6] = (TextView) findViewById(2131558891);
        this.f5154y[7] = (TextView) findViewById(2131558895);
        this.f5154y[8] = (TextView) findViewById(2131558899);
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/HACKED.ttf");
        this.f5155z[0] = (TextView) findViewById(2131558866);
        this.f5155z[0].setTypeface(createFromAsset);
        this.f5155z[1] = (TextView) findViewById(2131558870);
        this.f5155z[1].setTypeface(createFromAsset);
        this.f5155z[2] = (TextView) findViewById(2131558874);
        this.f5155z[2].setTypeface(createFromAsset);
        this.f5155z[3] = (TextView) findViewById(2131558878);
        this.f5155z[3].setTypeface(createFromAsset);
        this.f5155z[4] = (TextView) findViewById(2131558882);
        this.f5155z[4].setTypeface(createFromAsset);
        this.f5155z[5] = (TextView) findViewById(2131558886);
        this.f5155z[5].setTypeface(createFromAsset);
        this.f5155z[6] = (TextView) findViewById(2131558890);
        this.f5155z[6].setTypeface(createFromAsset);
        this.f5155z[7] = (TextView) findViewById(2131558894);
        this.f5155z[7].setTypeface(createFromAsset);
        this.f5155z[8] = (TextView) findViewById(2131558898);
        this.f5155z[8].setTypeface(createFromAsset);
        this.f5138A[0] = (RelativeLayout) findViewById(2131558865);
        this.f5138A[1] = (RelativeLayout) findViewById(2131558869);
        this.f5138A[2] = (RelativeLayout) findViewById(2131558873);
        this.f5138A[3] = (RelativeLayout) findViewById(2131558877);
        this.f5138A[4] = (RelativeLayout) findViewById(2131558881);
        this.f5138A[5] = (RelativeLayout) findViewById(2131558885);
        this.f5138A[6] = (RelativeLayout) findViewById(2131558889);
        this.f5138A[7] = (RelativeLayout) findViewById(2131558893);
        this.f5138A[8] = (RelativeLayout) findViewById(2131558897);
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

    public String m9026a(String str) {
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

    public String m9027b(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
