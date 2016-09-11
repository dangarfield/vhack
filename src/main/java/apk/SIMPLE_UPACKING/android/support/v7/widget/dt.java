package android.support.v7.widget;

/* compiled from: RecyclerView */
class dt implements Runnable {
    final /* synthetic */ RecyclerView f2132a;

    dt(RecyclerView recyclerView) {
        this.f2132a = recyclerView;
    }

    public void run() {
        if (this.f2132a.f147f != null) {
            this.f2132a.f147f.m4148a();
        }
        this.f2132a.af = false;
    }
}
