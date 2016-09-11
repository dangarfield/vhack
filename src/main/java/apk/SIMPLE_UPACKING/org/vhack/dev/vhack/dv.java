package org.vhack.dev.vhack;

import android.support.v7.p018b.R;
import android.text.Html;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/* compiled from: MainActivity */
class dv implements Runnable {
    final /* synthetic */ du f5393a;

    dv(du duVar) {
        this.f5393a = duVar;
    }

    public void run() {
        String str;
        new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        this.f5393a.f5392e.f5118V = this.f5393a.f5392e.f5118V.replace("<", "");
        this.f5393a.f5392e.f5118V = this.f5393a.f5392e.f5118V.replace(">", "");
        this.f5393a.f5392e.f5118V = this.f5393a.f5392e.f5118V.replace("'", "");
        String str2 = "";
        if (Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(this.f5393a.f5392e.f5118V).find()) {
            str = "<font color=#cbcbcb>[</font><font color=#FF0000><b>Posting IPs in chat is against the rules!</b></font><font color=#cbcbcb>]</font>";
        } else {
            str = "<font color=#cbcbcb>[</font><font color=#7ca9b9><b>" + this.f5393a.f5392e.f5127p + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.f5393a.f5392e.f5118V + "</font>";
        }
        this.f5393a.f5392e.f5122Z.setText(Html.fromHtml(str));
        this.f5393a.f5392e.aj += "<br>" + str;
        ((TextView) this.f5393a.f5392e.findViewById(2131558849)).setText(Html.fromHtml(this.f5393a.f5392e.f5135x + this.f5393a.f5392e.aj));
        this.f5393a.f5392e.f5106J = this.f5393a.f5392e.f5118V;
        ScrollView scrollView = (ScrollView) this.f5393a.f5392e.findViewById(R.scrollView);
        scrollView.postDelayed(new dw(this, scrollView), 200);
    }
}
