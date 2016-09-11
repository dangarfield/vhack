package android.support.v7.widget;

import android.util.SparseArray;

/* compiled from: RecyclerView */
public class ev {
    int f2175a;
    private int f2176b;
    private int f2177c;
    private SparseArray f2178d;
    private int f2179e;
    private int f2180f;
    private boolean f2181g;
    private boolean f2182h;
    private boolean f2183i;
    private boolean f2184j;
    private boolean f2185k;
    private boolean f2186l;

    public ev() {
        this.f2176b = -1;
        this.f2177c = 1;
        this.f2175a = 0;
        this.f2179e = 0;
        this.f2180f = 0;
        this.f2181g = false;
        this.f2182h = false;
        this.f2183i = false;
        this.f2184j = false;
        this.f2185k = false;
        this.f2186l = false;
    }

    static /* synthetic */ int m4466a(ev evVar, int i) {
        int i2 = evVar.f2180f + i;
        evVar.f2180f = i2;
        return i2;
    }

    void m4482a(int i) {
        if ((this.f2177c & i) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2177c));
        }
    }

    public boolean m4483a() {
        return this.f2182h;
    }

    public boolean m4484b() {
        return this.f2184j;
    }

    public int m4485c() {
        return this.f2176b;
    }

    public boolean m4486d() {
        return this.f2176b != -1;
    }

    public int m4487e() {
        return this.f2182h ? this.f2179e - this.f2180f : this.f2175a;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.f2176b + ", mData=" + this.f2178d + ", mItemCount=" + this.f2175a + ", mPreviousLayoutItemCount=" + this.f2179e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2180f + ", mStructureChanged=" + this.f2181g + ", mInPreLayout=" + this.f2182h + ", mRunSimpleAnimations=" + this.f2183i + ", mRunPredictiveAnimations=" + this.f2184j + '}';
    }
}
