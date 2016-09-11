package org.vhack.dev.vhack;

import android.support.v7.b.g;
import android.text.Html;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/* compiled from: MainActivity */
class dv implements Runnable {
    final /* synthetic */ du a;

    dv(du duVar) {
        this.a = duVar;
    }

    public void run() {
        String str;
        new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        this.a.e.V = this.a.e.V.replace("<", "");
        this.a.e.V = this.a.e.V.replace(">", "");
        this.a.e.V = this.a.e.V.replace("'", "");
        String str2 = "";
        if (Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(this.a.e.V).find()) {
            str = "<font color=#cbcbcb>[</font><font color=#FF0000><b>Posting IPs in chat is against the rules!</b></font><font color=#cbcbcb>]</font>";
        } else {
            str = "<font color=#cbcbcb>[</font><font color=#7ca9b9><b>" + this.a.e.p + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.a.e.V + "</font>";
        }
        this.a.e.Z.setText(Html.fromHtml(str));
        this.a.e.aj += "<br>" + str;
        ((TextView) this.a.e.findViewById(2131558849)).setText(Html.fromHtml(this.a.e.x + this.a.e.aj));
        this.a.e.J = this.a.e.V;
        ScrollView scrollView = (ScrollView) this.a.e.findViewById(g.scrollView);
        scrollView.postDelayed(new dw(this, scrollView), 200);
    }
}
