package org.vhack.dev.vhack;

import java.util.TimerTask;

/* compiled from: BotnetActivity */
class ac extends TimerTask {
    public int f5257a;
    final /* synthetic */ ab f5258b;

    ac(ab abVar) {
        this.f5258b = abVar;
        this.f5257a = 0;
    }

    public void run() {
        this.f5257a++;
        if (this.f5257a > 99) {
            this.f5258b.f5256a.f5483a.runOnUiThread(new ad(this));
            this.f5258b.f5256a.f5483a.f5000v.cancel();
            return;
        }
        this.f5258b.f5256a.f5483a.runOnUiThread(new ae(this));
    }
}
