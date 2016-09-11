package com.google.android.gms.p051b;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: com.google.android.gms.b.mh */
public final class mh {
    private final byte[] f4040a;
    private int f4041b;
    private int f4042c;
    private int f4043d;
    private int f4044e;
    private int f4045f;
    private int f4046g;
    private int f4047h;
    private int f4048i;
    private int f4049j;

    private mh(byte[] bArr, int i, int i2) {
        this.f4046g = Integer.MAX_VALUE;
        this.f4048i = 64;
        this.f4049j = 67108864;
        this.f4040a = bArr;
        this.f4041b = i;
        this.f4042c = i + i2;
        this.f4044e = i;
    }

    public static mh m7104a(byte[] bArr) {
        return mh.m7105a(bArr, 0, bArr.length);
    }

    public static mh m7105a(byte[] bArr, int i, int i2) {
        return new mh(bArr, i, i2);
    }

    private void m7106q() {
        this.f4042c += this.f4043d;
        int i = this.f4042c;
        if (i > this.f4046g) {
            this.f4043d = i - this.f4046g;
            this.f4042c -= this.f4043d;
            return;
        }
        this.f4043d = 0;
    }

    public int m7107a() {
        if (m7128n()) {
            this.f4045f = 0;
            return 0;
        }
        this.f4045f = m7123i();
        if (this.f4045f != 0) {
            return this.f4045f;
        }
        throw ml.m7183d();
    }

    public void m7108a(int i) {
        if (this.f4045f != i) {
            throw ml.m7184e();
        }
    }

    public void m7109a(mm mmVar) {
        int i = m7123i();
        if (this.f4047h >= this.f4048i) {
            throw ml.m7186g();
        }
        i = m7113c(i);
        this.f4047h++;
        mmVar.m6963b(this);
        m7108a(0);
        this.f4047h--;
        m7115d(i);
    }

    public void m7110b() {
        int a;
        do {
            a = m7107a();
            if (a == 0) {
                return;
            }
        } while (m7111b(a));
    }

    public boolean m7111b(int i) {
        switch (mo.m7193a(i)) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                m7118f();
                return true;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m7126l();
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m7120g(m7123i());
                return true;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m7110b();
                m7108a(mo.m7194a(mo.m7196b(i), 4));
                return true;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return false;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m7125k();
                return true;
            default:
                throw ml.m7185f();
        }
    }

    public float m7112c() {
        return Float.intBitsToFloat(m7125k());
    }

    public int m7113c(int i) {
        if (i < 0) {
            throw ml.m7181b();
        }
        int i2 = this.f4044e + i;
        int i3 = this.f4046g;
        if (i2 > i3) {
            throw ml.m7180a();
        }
        this.f4046g = i2;
        m7106q();
        return i3;
    }

    public long m7114d() {
        return m7124j();
    }

    public void m7115d(int i) {
        this.f4046g = i;
        m7106q();
    }

    public long m7116e() {
        return m7124j();
    }

    public void m7117e(int i) {
        if (i > this.f4044e - this.f4041b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f4044e - this.f4041b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f4044e = this.f4041b + i;
        }
    }

    public int m7118f() {
        return m7123i();
    }

    public byte[] m7119f(int i) {
        if (i < 0) {
            throw ml.m7181b();
        } else if (this.f4044e + i > this.f4046g) {
            m7120g(this.f4046g - this.f4044e);
            throw ml.m7180a();
        } else if (i <= this.f4042c - this.f4044e) {
            Object obj = new byte[i];
            System.arraycopy(this.f4040a, this.f4044e, obj, 0, i);
            this.f4044e += i;
            return obj;
        } else {
            throw ml.m7180a();
        }
    }

    public void m7120g(int i) {
        if (i < 0) {
            throw ml.m7181b();
        } else if (this.f4044e + i > this.f4046g) {
            m7120g(this.f4046g - this.f4044e);
            throw ml.m7180a();
        } else if (i <= this.f4042c - this.f4044e) {
            this.f4044e += i;
        } else {
            throw ml.m7180a();
        }
    }

    public boolean m7121g() {
        return m7123i() != 0;
    }

    public String m7122h() {
        int i = m7123i();
        if (i > this.f4042c - this.f4044e || i <= 0) {
            return new String(m7119f(i), "UTF-8");
        }
        String str = new String(this.f4040a, this.f4044e, i, "UTF-8");
        this.f4044e = i + this.f4044e;
        return str;
    }

    public int m7123i() {
        byte p = m7130p();
        if (p >= null) {
            return p;
        }
        int i = p & 127;
        byte p2 = m7130p();
        if (p2 >= null) {
            return i | (p2 << 7);
        }
        i |= (p2 & 127) << 7;
        p2 = m7130p();
        if (p2 >= null) {
            return i | (p2 << 14);
        }
        i |= (p2 & 127) << 14;
        p2 = m7130p();
        if (p2 >= null) {
            return i | (p2 << 21);
        }
        i |= (p2 & 127) << 21;
        p2 = m7130p();
        i |= p2 << 28;
        if (p2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m7130p() >= null) {
                return i;
            }
        }
        throw ml.m7182c();
    }

    public long m7124j() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte p = m7130p();
            j |= ((long) (p & 127)) << i;
            if ((p & 128) == 0) {
                return j;
            }
        }
        throw ml.m7182c();
    }

    public int m7125k() {
        return (((m7130p() & 255) | ((m7130p() & 255) << 8)) | ((m7130p() & 255) << 16)) | ((m7130p() & 255) << 24);
    }

    public long m7126l() {
        byte p = m7130p();
        byte p2 = m7130p();
        return ((((((((((long) p2) & 255) << 8) | (((long) p) & 255)) | ((((long) m7130p()) & 255) << 16)) | ((((long) m7130p()) & 255) << 24)) | ((((long) m7130p()) & 255) << 32)) | ((((long) m7130p()) & 255) << 40)) | ((((long) m7130p()) & 255) << 48)) | ((((long) m7130p()) & 255) << 56);
    }

    public int m7127m() {
        if (this.f4046g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f4046g - this.f4044e;
    }

    public boolean m7128n() {
        return this.f4044e == this.f4042c;
    }

    public int m7129o() {
        return this.f4044e - this.f4041b;
    }

    public byte m7130p() {
        if (this.f4044e == this.f4042c) {
            throw ml.m7180a();
        }
        byte[] bArr = this.f4040a;
        int i = this.f4044e;
        this.f4044e = i + 1;
        return bArr[i];
    }
}
