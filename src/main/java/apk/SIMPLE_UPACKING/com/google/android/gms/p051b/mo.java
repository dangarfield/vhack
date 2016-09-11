package com.google.android.gms.p051b;

/* renamed from: com.google.android.gms.b.mo */
public final class mo {
    public static final int[] f4052a;
    public static final long[] f4053b;
    public static final float[] f4054c;
    public static final double[] f4055d;
    public static final boolean[] f4056e;
    public static final String[] f4057f;
    public static final byte[][] f4058g;
    public static final byte[] f4059h;

    static {
        f4052a = new int[0];
        f4053b = new long[0];
        f4054c = new float[0];
        f4055d = new double[0];
        f4056e = new boolean[0];
        f4057f = new String[0];
        f4058g = new byte[0][];
        f4059h = new byte[0];
    }

    static int m7193a(int i) {
        return i & 7;
    }

    static int m7194a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m7195a(mh mhVar, int i) {
        return mhVar.m7111b(i);
    }

    public static int m7196b(int i) {
        return i >>> 3;
    }

    public static final int m7197b(mh mhVar, int i) {
        int i2 = 1;
        int o = mhVar.m7129o();
        mhVar.m7111b(i);
        while (mhVar.m7107a() == i) {
            mhVar.m7111b(i);
            i2++;
        }
        mhVar.m7117e(o);
        return i2;
    }
}
