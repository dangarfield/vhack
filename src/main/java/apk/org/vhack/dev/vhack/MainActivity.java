package org.vhack.dev.vhack;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.a.u;
import android.text.Html;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.Fyber;
import com.fyber.h.b;
import com.fyber.h.c;
import java.net.Socket;
import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends u {
    String A;
    boolean B;
    Timer C;
    String D;
    String E;
    String F;
    String G;
    String H;
    EditText I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    String P;
    String Q;
    String R;
    public boolean S;
    boolean T;
    String U;
    String V;
    public boolean W;
    public Intent X;
    TextView Y;
    TextView Z;
    TextView aa;
    TextView ab;
    TextView ac;
    TextView ad;
    TextView ae;
    TextView af;
    TextView ag;
    TextView ah;
    Thread ai;
    String aj;
    int[] ak;
    public Socket l;
    public MediaPlayer m;
    final String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    public String x;
    int y;
    String z;

    public MainActivity() {
        this.n = "h2530114.stratoserver.net";
        this.o = "953224029129";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = "";
        this.y = 0;
        this.z = "";
        this.A = "";
        this.B = false;
        this.C = new Timer();
        this.D = "";
        this.E = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = false;
        this.T = false;
        this.U = "";
        this.W = false;
        this.X = null;
        this.aj = "";
        this.ak = new int[]{2130837749, 2130837750, 2130837751, 2130837752, 2130837753};
    }

    protected void onDestroy() {
        super.onDestroy();
        this.B = false;
    }

    public void onBackPressed() {
        Builder builder = new Builder(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131558844);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2131558836);
        if (relativeLayout.getVisibility() == 0) {
            relativeLayout.setVisibility(8);
        } else if (relativeLayout2.getVisibility() == 0) {
            relativeLayout2.setVisibility(8);
        } else {
            builder.setCancelable(false);
            builder.setMessage(2131165433);
            builder.setPositiveButton(2131165262, new cm(this));
            builder.setNegativeButton(2131165261, new cx(this));
            builder.create().show();
        }
    }

    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.p = sharedPreferences.getString("strUser", "");
        this.q = sharedPreferences.getString("strPass", "");
        this.N = sharedPreferences.getString("memo", "");
        this.v = sharedPreferences.getString("id", "0");
        this.u = sharedPreferences.getString("hash", "0");
        this.r = sharedPreferences.getString("uhash", "0");
        this.S = true;
        new dx(this).execute(new String[]{this.p, this.q});
        o();
        l();
        getWindow().setSoftInputMode(3);
        if (this.p.equals("") || this.q.equals("")) {
            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            this.S = false;
            startActivity(intent);
        }
        this.w = Fyber.with("41239", this).start().getUserId();
        c diVar = new di(this);
        ((ImageButton) findViewById(2131558799)).setOnClickListener(new dk(this));
        ((ImageButton) findViewById(2131558801)).setOnClickListener(new dl(this));
        b.a(diVar).a(getApplicationContext());
    }

    public void l() {
        Editor edit = getSharedPreferences("ChatData.xml", 0).edit();
        edit.putString("msg", "");
        edit.commit();
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.p = sharedPreferences.getString("strUser", "");
        this.q = sharedPreferences.getString("strPass", "");
        this.t = sharedPreferences.getString("money", "0");
        this.P = sharedPreferences.getString("actadw", "");
        this.L = sharedPreferences.getString("urmail", "0");
        this.z = sharedPreferences.getString("spam", "1");
        this.D = sharedPreferences.getString("netcoins", "0");
        this.A = sharedPreferences.getString("pts", "0");
        this.E = sharedPreferences.getString("energy", "0");
        this.R = sharedPreferences.getString("myip", "0.0.0.0");
        this.O = sharedPreferences.getString("elo", "1000");
        this.U = sharedPreferences.getString("score", "0");
        this.K = sharedPreferences.getString("syslog", "");
        this.Q = sharedPreferences.getString("rank", "1000");
        String string = sharedPreferences.getString("bonus", "0");
        sharedPreferences.getString("mystery", "0");
        if (Integer.parseInt(string) > 0) {
            ((TextView) findViewById(2131558834)).setText(Integer.parseInt(string) + "");
        } else {
            ((TextView) findViewById(2131558834)).setText("");
        }
        if (Integer.parseInt(sharedPreferences.getString("event", "0")) > 0) {
            this.aa.setText("!");
        } else {
            this.aa.setText("");
        }
        TextView textView = (TextView) findViewById(2131558793);
        textView.setText(this.K);
        textView.setOnClickListener(new dm(this));
        ImageButton imageButton = (ImageButton) findViewById(2131558820);
        if (this.L.equals("1")) {
            imageButton.setBackground(getResources().getDrawable(2130837719));
        } else {
            imageButton.setBackground(getResources().getDrawable(2130837718));
        }
        this.ah.setText(a(this.O));
        this.ab.setText("$" + a(this.t + ""));
        this.ac.setText(a(this.A));
        this.ad.setText(a(this.D));
        this.af.setText(this.R);
        this.z = (Integer.parseInt(this.z) * 500) + "";
        this.z = String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(this.z))});
        this.z = this.z.replace(",", ".");
        this.z = "$" + this.z + " / h";
        this.ac.setText(a(this.U));
        this.ae.setText(this.z);
        ((TextView) findViewById(2131558813)).setText(this.P);
        this.Y.setText(this.Q + ".");
    }

    public void m() {
        Editor edit = getSharedPreferences("loginData.xml", 0).edit();
        edit.putString("strUser", "");
        edit.putString("strPass", "");
        this.p = "";
        this.q = "";
        edit.commit();
        this.S = false;
        startActivity(new Intent(getApplicationContext(), GameActivity.class));
    }

    private void a(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView(2130968614);
        this.S = true;
        this.m = MediaPlayer.create(this, 2131099648);
        float log = (float) (Math.log((double) 15) / Math.log((double) 50));
        this.m.setVolume(1.0f - log, 1.0f - log);
        SharedPreferences sharedPreferences = getSharedPreferences("loginData.xml", 0);
        this.p = sharedPreferences.getString("strUser", "");
        this.q = sharedPreferences.getString("strPass", "");
        this.r = sharedPreferences.getString("uhash", "null");
        this.x = "<b><font color=RED>1.</font><font color=#FFFFFF> Please do not type in All CAPS.</font><br><font color=RED>2.</font><font color=#FFFFFF> No profanity or offensive language (in ANY Language)</font><br><font color=RED>3.</font><font color=#FFFFFF> No discussion of or posting of links to hacking or pornographic content.</font><br><font color=RED>4.</font><font color=#FFFFFF> No harassment of other players that may be offensive to gender, ethnicity, religion, orientation, etc.</font><br><font color=RED>5.</font><font color=#FFFFFF> Do not spam or flood chat (this includes emoji's)</font><br><font color=RED>6.</font><font color=#FFFFFF> All languages are accepted, though English is preferred.</font><br><font color=RED>7.</font><font color=#FFFFFF> No IP address posting in chat.</b></font><br><br>";
        ((TextView) findViewById(2131558849)).setText(Html.fromHtml(this.x));
        getWindow().setSoftInputMode(3);
        new br(this, this.o).a(new dn(this));
        if (this.p.equals("")) {
            this.S = false;
            startActivity(new Intent(getApplicationContext(), GameActivity.class));
            return;
        }
        this.S = true;
        if (getIntent().getBooleanExtra("chat", false)) {
            this.B = false;
            this.ai = new dq(this);
            this.B = true;
            this.ai.start();
        }
        ((TextView) findViewById(2131558790)).setText(getString(2131165434) + ", " + this.p + "!");
        ((Button) findViewById(2131558852)).setOnClickListener(new do(this));
        ((TextView) findViewById(2131558812)).setOnClickListener(new dp(this));
        ((TextView) findViewById(2131558843)).setOnClickListener(new cn(this));
        ((TextView) findViewById(2131558830)).setOnClickListener(new co(this));
        ((ImageButton) findViewById(2131558829)).setOnClickListener(new cp(this));
        ((TextView) findViewById(2131558828)).setOnClickListener(new cq(this));
        ((ImageButton) findViewById(2131558832)).setOnClickListener(new cr(this));
        ((TextView) findViewById(2131558833)).setOnClickListener(new cs(this));
        ((ImageButton) findViewById(2131558827)).setOnClickListener(new ct(this));
        this.I = (EditText) findViewById(2131558841);
        if (!sharedPreferences.getString("notepad", "").equals("")) {
            this.I.setText(sharedPreferences.getString("notepad", ""));
        }
        ((Button) findViewById(2131558840)).setOnClickListener(new cu(this));
        ((ImageButton) findViewById(2131558821)).setOnClickListener(new cv(this));
        o();
        n();
        l();
        Calendar.getInstance();
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }

    public void n() {
        ((ImageButton) findViewById(2131558825)).setOnClickListener(new cw(this));
        ((ImageButton) findViewById(2131558816)).setOnClickListener(new cy(this));
        ((ImageButton) findViewById(2131558839)).setOnClickListener(new cz(this));
        ((ImageButton) findViewById(2131558824)).setOnClickListener(new da(this));
        ((ImageButton) findViewById(2131558826)).setOnClickListener(new db(this));
        ((ImageButton) findViewById(2131558819)).setOnClickListener(new dc(this));
        ((ImageButton) findViewById(2131558816)).setOnClickListener(new dd(this));
        ((ImageButton) findViewById(2131558822)).setOnClickListener(new de(this));
        ((ImageButton) findViewById(2131558823)).setOnClickListener(new df(this));
        ((ImageButton) findViewById(2131558820)).setOnClickListener(new dg(this));
        ((ImageButton) findViewById(2131558797)).setOnClickListener(new dh(this));
        ((TextView) findViewById(2131558815)).setOnClickListener(new dj(this));
    }

    public void o() {
        this.ab = (TextView) findViewById(2131558804);
        this.ac = (TextView) findViewById(2131558794);
        this.ae = (TextView) findViewById(2131558810);
        this.ad = (TextView) findViewById(2131558806);
        this.af = (TextView) findViewById(2131558792);
        this.ag = (TextView) findViewById(2131558784);
        this.ah = (TextView) findViewById(2131558796);
        this.Z = (TextView) findViewById(2131558815);
        this.Y = (TextView) findViewById(2131558808);
        this.aa = (TextView) findViewById(2131558831);
    }
}
