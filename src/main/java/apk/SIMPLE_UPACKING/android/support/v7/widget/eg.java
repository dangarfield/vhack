package android.support.v7.widget;

/* compiled from: RecyclerView */
class eg implements ee {
    final /* synthetic */ RecyclerView f2144a;

    private eg(RecyclerView recyclerView) {
        this.f2144a = recyclerView;
    }

    public void m4388a(ey eyVar) {
        eyVar.m4519a(true);
        if (eyVar.f2201g != null && eyVar.f2202h == null) {
            eyVar.f2201g = null;
        }
        eyVar.f2202h = null;
        if (!eyVar.m4501B() && !this.f2144a.m151h(eyVar.f2195a) && eyVar.m4538r()) {
            this.f2144a.removeDetachedView(eyVar.f2195a, false);
        }
    }
}
