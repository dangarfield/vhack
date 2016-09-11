package org.vhack.dev.vhack;

import android.text.Html;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: MainActivity */
class ds implements Runnable {
    final /* synthetic */ dq f5382a;

    ds(dq dqVar) {
        this.f5382a = dqVar;
    }

    public void run() {
        new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        String str = "";
        if (this.f5382a.f5380a.f5104H.equals("admin.vhack.biz")) {
            str = "<font color=#cbcbcb>[</font><font color=#FF0000><b>" + this.f5382a.f5380a.f5102F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.f5382a.f5380a.f5103G + "</font>";
        } else if (this.f5382a.f5380a.f5104H.equals("mod.vhack.biz")) {
            str = "<font color=#cbcbcb>[</font><font color=#00FF00><b>" + this.f5382a.f5380a.f5102F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.f5382a.f5380a.f5103G + "</font>";
        } else {
            str = "<font color=#cbcbcb>[</font><font color=#7ca9b9><b>" + this.f5382a.f5380a.f5102F + "</b></font><font color=#cbcbcb>]</font> <font color=#ffffff>" + this.f5382a.f5380a.f5103G + "</font>";
        }
        this.f5382a.f5380a.aj += "<br>" + str;
        this.f5382a.f5380a.f5122Z.setText(Html.fromHtml(str));
        if (this.f5382a.f5380a.aj.length() > 10000) {
            this.f5382a.f5380a.aj = this.f5382a.f5380a.aj.substring(this.f5382a.f5380a.aj.length() - 10000, this.f5382a.f5380a.aj.length());
        }
        ((TextView) this.f5382a.f5380a.findViewById(2131558849)).setText(Html.fromHtml(this.f5382a.f5380a.f5135x + this.f5382a.f5380a.aj));
    }
}
