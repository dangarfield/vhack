package android.support.v7.widget;

/* compiled from: DefaultItemAnimator */
class ci {
    public ey f2051a;
    public ey f2052b;
    public int f2053c;
    public int f2054d;
    public int f2055e;
    public int f2056f;

    private ci(ey eyVar, ey eyVar2) {
        this.f2051a = eyVar;
        this.f2052b = eyVar2;
    }

    private ci(ey eyVar, ey eyVar2, int i, int i2, int i3, int i4) {
        this(eyVar, eyVar2);
        this.f2053c = i;
        this.f2054d = i2;
        this.f2055e = i3;
        this.f2056f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f2051a + ", newHolder=" + this.f2052b + ", fromX=" + this.f2053c + ", fromY=" + this.f2054d + ", toX=" + this.f2055e + ", toY=" + this.f2056f + '}';
    }
}
