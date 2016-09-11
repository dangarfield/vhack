package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class ev implements Runnable {
    final /* synthetic */ eu a;

    ev(eu euVar) {
        this.a = euVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a.a.runOnUiThread(new ew(this));
    }
}
