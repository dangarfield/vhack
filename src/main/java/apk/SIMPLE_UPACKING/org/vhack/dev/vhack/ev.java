package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class ev implements Runnable {
    final /* synthetic */ eu f5421a;

    ev(eu euVar) {
        this.f5421a = euVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f5421a.f5420a.runOnUiThread(new ew(this));
    }
}
