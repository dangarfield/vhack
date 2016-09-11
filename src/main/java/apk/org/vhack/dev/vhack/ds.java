package org.vhack.dev.vhack;

import android.text.Html;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: MainActivity */
class ds implements Runnable {
    final /* synthetic */ dq a;

    ds(dq dqVar) {
        this.a = dqVar;
    }

    public void run() {
        new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        String str = "";
        if (this.a.a.H.equals("admin.vhack.biz")) {
            str = "<font color=#cbcbcb>[</font><font color=#FF0000><b>" + this.a.a.F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.a.a.G + "</font>";
        } else if (this.a.a.H.equals("mod.vhack.biz")) {
            str = "<font color=#cbcbcb>[</font><font color=#00FF00><b>" + this.a.a.F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.a.a.G + "</font>";
        } else {
            str = "<font color=#cbcbcb>[</font><font color=#7ca9b9><b>" + this.a.a.F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.a.a.G + "</font>";
        }
        this.a.a.aj += "<br>" + str;
        this.a.a.Z.setText(Html.fromHtml(str));
        if (this.a.a.aj.length() > 10000) {
            this.a.a.aj = this.a.a.aj.substring(this.a.a.aj.length() - 10000, this.a.a.aj.length());
        }
        ((TextView) this.a.a.findViewById(2131558849)).setText(Html.fromHtml(this.a.a.x + this.a.a.aj));
    }
}
