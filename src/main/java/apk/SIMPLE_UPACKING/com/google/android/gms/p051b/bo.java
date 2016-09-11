package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.bo */
public class bo implements kt {
    private int f3480a;
    private int f3481b;
    private final int f3482c;
    private final float f3483d;

    public bo() {
        this(2500, 1, 1.0f);
    }

    public bo(int i, int i2, float f) {
        this.f3480a = i;
        this.f3482c = i2;
        this.f3483d = f;
    }

    public int m6161a() {
        return this.f3480a;
    }

    public void m6162a(lt ltVar) {
        this.f3481b++;
        this.f3480a = (int) (((float) this.f3480a) + (((float) this.f3480a) * this.f3483d));
        if (!m6164c()) {
            throw ltVar;
        }
    }

    public int m6163b() {
        return this.f3481b;
    }

    protected boolean m6164c() {
        return this.f3481b <= this.f3482c;
    }
}
