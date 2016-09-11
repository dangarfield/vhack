package org.vhack.dev.vhack;

import java.util.TimerTask;

/* compiled from: BotnetActivity */
class w extends TimerTask {
    public int a;
    final /* synthetic */ v b;

    w(v vVar) {
        this.b = vVar;
        this.a = 0;
    }

    public void run() {
        this.a++;
        if (this.a > 99) {
            this.b.a.a.runOnUiThread(new x(this));
            this.b.a.a.v.cancel();
            return;
        }
        this.b.a.a.runOnUiThread(new y(this));
    }
}
