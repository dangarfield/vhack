package org.vhack.dev.vhack;

import java.util.TimerTask;

/* compiled from: BotnetActivity */
class ac extends TimerTask {
    public int a;
    final /* synthetic */ ab b;

    ac(ab abVar) {
        this.b = abVar;
        this.a = 0;
    }

    public void run() {
        this.a++;
        if (this.a > 99) {
            this.b.a.a.runOnUiThread(new ad(this));
            this.b.a.a.v.cancel();
            return;
        }
        this.b.a.a.runOnUiThread(new ae(this));
    }
}
