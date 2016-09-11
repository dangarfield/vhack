package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class x implements Runnable {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void run() {
        if (this.a.b.a.a.u == 1) {
            ((TextView) this.a.b.a.a.findViewById(2131558611)).setText("Attack successful! Reward: 300 NetCoins");
        } else if (this.a.b.a.a.u == 2) {
            ((TextView) this.a.b.a.a.findViewById(2131558611)).setText("Attack blocked!");
        } else if (this.a.b.a.a.u == 3) {
            ((TextView) this.a.b.a.a.findViewById(2131558611)).setText("Attack blocked!");
        } else {
            ((TextView) this.a.b.a.a.findViewById(2131558611)).setText("You already attacked KFM-Solutions.");
        }
        ((ProgressBar) this.a.b.a.a.findViewById(2131558610)).setProgress(100);
    }
}
