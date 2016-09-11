package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Timer;

/* compiled from: BotnetActivity */
class ab implements OnClickListener {
    final /* synthetic */ q a;

    ab(q qVar) {
        this.a = qVar;
    }

    public void onClick(View view) {
        this.a.a.w = 2;
        this.a.a.findViewById(2131558621).setEnabled(false);
        this.a.a.findViewById(2131558621).setClickable(false);
        this.a.a.v = new Timer();
        this.a.a.v.schedule(new ac(this), 5, 100);
        new ag(this.a.a).execute(new String[]{"2"});
    }
}
