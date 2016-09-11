package android.support.v7.widget;

/* compiled from: RecyclerView */
class ds implements Runnable {
    final /* synthetic */ RecyclerView f2131a;

    ds(RecyclerView recyclerView) {
        this.f2131a = recyclerView;
    }

    public void run() {
        if (this.f2131a.f163x && !this.f2131a.isLayoutRequested()) {
            if (this.f2131a.f119A) {
                this.f2131a.f165z = true;
            } else {
                this.f2131a.m167t();
            }
        }
    }
}
