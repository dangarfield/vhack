package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class ad implements Runnable {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    public void run() {
        if (this.a.b.a.a.u == 1) {
            ((TextView) this.a.b.a.a.findViewById(2131558620)).setText("Attack successful! Reward: 1000 NetCoins");
        } else if (this.a.b.a.a.u == 2) {
            ((TextView) this.a.b.a.a.findViewById(2131558620)).setText("Attack blocked!");
        } else if (this.a.b.a.a.u == 3) {
            ((TextView) this.a.b.a.a.findViewById(2131558620)).setText("Attack blocked!");
        } else {
            ((TextView) this.a.b.a.a.findViewById(2131558620)).setText("You already attacked vHack Server.");
        }
        ((ProgressBar) this.a.b.a.a.findViewById(2131558617)).setProgress(100);
    }
}
