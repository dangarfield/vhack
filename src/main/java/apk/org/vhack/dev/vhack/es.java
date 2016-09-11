package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class es implements Runnable {
    final /* synthetic */ er a;

    es(er erVar) {
        this.a = erVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a.a.runOnUiThread(new et(this));
    }
}
