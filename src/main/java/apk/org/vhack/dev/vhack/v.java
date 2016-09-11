package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Timer;

/* compiled from: BotnetActivity */
class v implements OnClickListener {
    final /* synthetic */ q a;

    v(q qVar) {
        this.a = qVar;
    }

    public void onClick(View view) {
        this.a.a.findViewById(2131558612).setEnabled(false);
        this.a.a.findViewById(2131558612).setClickable(false);
        this.a.a.w = 1;
        this.a.a.v = new Timer();
        this.a.a.v.schedule(new w(this), 5, 100);
        new ag(this.a.a).execute(new String[]{"1"});
    }
}
