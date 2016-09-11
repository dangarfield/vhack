package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Timer;

/* compiled from: BotnetActivity */
class ab implements OnClickListener {
    final /* synthetic */ BotnetActivity f5256a;

    ab(BotnetActivity botnetActivity) {
        this.f5256a = botnetActivity;
    }

    public void onClick(View view) {
        this.f5256a.f5483a.f5001w = 2;
        this.f5256a.f5483a.findViewById(2131558621).setEnabled(false);
        this.f5256a.f5483a.findViewById(2131558621).setClickable(false);
        this.f5256a.f5483a.f5000v = new Timer();
        this.f5256a.f5483a.f5000v.schedule(new ac(this), 5, 100);
        new ag(this.f5256a.f5483a).execute(new String[]{"2"});
    }
}
