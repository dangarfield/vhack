package android.support.v7.widget;

import android.util.Log;
import android.view.View;

/* compiled from: RecyclerView */
public abstract class et {
    private int f2161a;
    private RecyclerView f2162b;
    private ei f2163c;
    private boolean f2164d;
    private boolean f2165e;
    private View f2166f;
    private final eu f2167g;

    protected abstract void m4454a(int i, int i2, ev evVar, eu euVar);

    protected abstract void m4455a(View view, ev evVar, eu euVar);

    protected abstract void m4460e();

    public void m4453a(int i) {
        this.f2161a = i;
    }

    protected final void m4452a() {
        if (this.f2165e) {
            m4460e();
            this.f2162b.f148g.f2176b = -1;
            this.f2166f = null;
            this.f2161a = -1;
            this.f2164d = false;
            this.f2165e = false;
            this.f2163c.m3485a(this);
            this.f2163c = null;
            this.f2162b = null;
        }
    }

    public boolean m4457b() {
        return this.f2164d;
    }

    public boolean m4458c() {
        return this.f2165e;
    }

    public int m4459d() {
        return this.f2161a;
    }

    private void m4449a(int i, int i2) {
        RecyclerView recyclerView = this.f2162b;
        if (!this.f2165e || this.f2161a == -1 || recyclerView == null) {
            m4452a();
        }
        this.f2164d = false;
        if (this.f2166f != null) {
            if (m4451a(this.f2166f) == this.f2161a) {
                m4455a(this.f2166f, recyclerView.f148g, this.f2167g);
                this.f2167g.m4461a(recyclerView);
                m4452a();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f2166f = null;
            }
        }
        if (this.f2165e) {
            m4454a(i, i2, recyclerView.f148g, this.f2167g);
            boolean a = this.f2167g.m4464a();
            this.f2167g.m4461a(recyclerView);
            if (!a) {
                return;
            }
            if (this.f2165e) {
                this.f2164d = true;
                recyclerView.ab.m4493a();
                return;
            }
            m4452a();
        }
    }

    public int m4451a(View view) {
        return this.f2162b.m193d(view);
    }

    protected void m4456b(View view) {
        if (m4451a(view) == m4459d()) {
            this.f2166f = view;
        }
    }
}
