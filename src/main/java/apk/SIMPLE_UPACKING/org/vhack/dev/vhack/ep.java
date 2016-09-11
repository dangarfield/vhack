package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class ep implements Runnable {
    final /* synthetic */ eo f5415a;

    ep(eo eoVar) {
        this.f5415a = eoVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f5415a.f5414a.runOnUiThread(new eq(this));
    }
}
