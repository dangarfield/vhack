package android.support.v4.app;

/* compiled from: FragmentManager */
class ah implements Runnable {
    final /* synthetic */ int f522a;
    final /* synthetic */ int f523b;
    final /* synthetic */ af f524c;

    ah(af afVar, int i, int i2) {
        this.f524c = afVar;
        this.f522a = i;
        this.f523b = i2;
    }

    public void run() {
        this.f524c.m850a(this.f524c.f510o.m802h(), null, this.f522a, this.f523b);
    }
}
