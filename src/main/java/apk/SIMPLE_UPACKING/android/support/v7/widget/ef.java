package android.support.v7.widget;

import android.view.View;

/* compiled from: RecyclerView */
public class ef {
    public int f2140a;
    public int f2141b;
    public int f2142c;
    public int f2143d;

    public ef m4386a(ey eyVar) {
        return m4387a(eyVar, 0);
    }

    public ef m4387a(ey eyVar, int i) {
        View view = eyVar.f2195a;
        this.f2140a = view.getLeft();
        this.f2141b = view.getTop();
        this.f2142c = view.getRight();
        this.f2143d = view.getBottom();
        return this;
    }
}
