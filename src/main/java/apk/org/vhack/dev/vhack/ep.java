package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class ep implements Runnable {
    final /* synthetic */ eo a;

    ep(eo eoVar) {
        this.a = eoVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a.a.runOnUiThread(new eq(this));
    }
}
