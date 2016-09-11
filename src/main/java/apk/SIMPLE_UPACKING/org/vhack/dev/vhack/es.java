package org.vhack.dev.vhack;

/* compiled from: NetworkActivity */
class es implements Runnable {
    final /* synthetic */ er f5418a;

    es(er erVar) {
        this.f5418a = erVar;
    }

    public void run() {
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f5418a.f5417a.runOnUiThread(new et(this));
    }
}
