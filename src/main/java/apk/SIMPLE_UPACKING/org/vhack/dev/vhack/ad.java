package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class ad implements Runnable {
    final /* synthetic */ ac f5259a;

    ad(ac acVar) {
        this.f5259a = acVar;
    }

    public void run() {
        if (this.f5259a.f5258b.f5256a.f5483a.f4999u == 1) {
            ((TextView) this.f5259a.f5258b.f5256a.f5483a.findViewById(2131558620)).setText("Attack successful! Reward: 1000 NetCoins");
        } else if (this.f5259a.f5258b.f5256a.f5483a.f4999u == 2) {
            ((TextView) this.f5259a.f5258b.f5256a.f5483a.findViewById(2131558620)).setText("Attack blocked!");
        } else if (this.f5259a.f5258b.f5256a.f5483a.f4999u == 3) {
            ((TextView) this.f5259a.f5258b.f5256a.f5483a.findViewById(2131558620)).setText("Attack blocked!");
        } else {
            ((TextView) this.f5259a.f5258b.f5256a.f5483a.findViewById(2131558620)).setText("You already attacked vHack Server.");
        }
        ((ProgressBar) this.f5259a.f5258b.f5256a.f5483a.findViewById(2131558617)).setProgress(100);
    }
}
