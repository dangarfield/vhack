package com.google.android.gms.p051b;

import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.b.lq */
public final class lq extends mm {
    private static volatile lq[] f3948C;
    public lm[] f3949A;
    public Integer f3950a;
    public ln[] f3951b;
    public ls[] f3952c;
    public Long f3953d;
    public Long f3954e;
    public Long f3955f;
    public Long f3956g;
    public Long f3957h;
    public String f3958i;
    public String f3959j;
    public String f3960k;
    public String f3961l;
    public Integer f3962m;
    public String f3963n;
    public String f3964o;
    public String f3965p;
    public Long f3966q;
    public Long f3967r;
    public String f3968s;
    public Boolean f3969t;
    public String f3970u;
    public Long f3971v;
    public Integer f3972w;
    public String f3973x;
    public String f3974y;
    public Boolean f3975z;

    public lq() {
        m7045b();
    }

    public static lq[] m7042a() {
        if (f3948C == null) {
            synchronized (mk.f4051a) {
                if (f3948C == null) {
                    f3948C = new lq[0];
                }
            }
        }
        return f3948C;
    }

    public lq m7043a(mh mhVar) {
        while (true) {
            int a = mhVar.m7107a();
            int b;
            Object obj;
            switch (a) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                    this.f3950a = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.Toolbar_collapseIcon /*18*/:
                    b = mo.m7197b(mhVar, 18);
                    a = this.f3951b == null ? 0 : this.f3951b.length;
                    obj = new ln[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3951b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ln();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new ln();
                    mhVar.m7109a(obj[a]);
                    this.f3951b = obj;
                    continue;
                case R.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = mo.m7197b(mhVar, 26);
                    a = this.f3952c == null ? 0 : this.f3952c.length;
                    obj = new ls[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3952c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ls();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new ls();
                    mhVar.m7109a(obj[a]);
                    this.f3952c = obj;
                    continue;
                case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.f3953d = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f3954e = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.f3955f = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_dividerHorizontal /*56*/:
                    this.f3957h = Long.valueOf(mhVar.m7116e());
                    continue;
                case R.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                    this.f3958i = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_dropDownListViewStyle /*74*/:
                    this.f3959j = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_colorPrimary /*82*/:
                    this.f3960k = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_controlBackground /*90*/:
                    this.f3961l = mhVar.m7122h();
                    continue;
                case R.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                    this.f3962m = Integer.valueOf(mhVar.m7118f());
                    continue;
                case R.AppCompatTheme_ratingBarStyle /*106*/:
                    this.f3963n = mhVar.m7122h();
                    continue;
                case 114:
                    this.f3964o = mhVar.m7122h();
                    continue;
                case 130:
                    this.f3965p = mhVar.m7122h();
                    continue;
                case 136:
                    this.f3966q = Long.valueOf(mhVar.m7116e());
                    continue;
                case 144:
                    this.f3967r = Long.valueOf(mhVar.m7116e());
                    continue;
                case 154:
                    this.f3968s = mhVar.m7122h();
                    continue;
                case 160:
                    this.f3969t = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case 170:
                    this.f3970u = mhVar.m7122h();
                    continue;
                case 176:
                    this.f3971v = Long.valueOf(mhVar.m7116e());
                    continue;
                case 184:
                    this.f3972w = Integer.valueOf(mhVar.m7118f());
                    continue;
                case 194:
                    this.f3973x = mhVar.m7122h();
                    continue;
                case 202:
                    this.f3974y = mhVar.m7122h();
                    continue;
                case 208:
                    this.f3956g = Long.valueOf(mhVar.m7116e());
                    continue;
                case 224:
                    this.f3975z = Boolean.valueOf(mhVar.m7121g());
                    continue;
                case 234:
                    b = mo.m7197b(mhVar, 234);
                    a = this.f3949A == null ? 0 : this.f3949A.length;
                    obj = new lm[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f3949A, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new lm();
                        mhVar.m7109a(obj[a]);
                        mhVar.m7107a();
                        a++;
                    }
                    obj[a] = new lm();
                    mhVar.m7109a(obj[a]);
                    this.f3949A = obj;
                    continue;
                default:
                    if (!mo.m7195a(mhVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void m7044a(mi miVar) {
        int i = 0;
        if (this.f3950a != null) {
            miVar.m7159a(1, this.f3950a.intValue());
        }
        if (this.f3951b != null && this.f3951b.length > 0) {
            for (mm mmVar : this.f3951b) {
                if (mmVar != null) {
                    miVar.m7161a(2, mmVar);
                }
            }
        }
        if (this.f3952c != null && this.f3952c.length > 0) {
            for (mm mmVar2 : this.f3952c) {
                if (mmVar2 != null) {
                    miVar.m7161a(3, mmVar2);
                }
            }
        }
        if (this.f3953d != null) {
            miVar.m7169b(4, this.f3953d.longValue());
        }
        if (this.f3954e != null) {
            miVar.m7169b(5, this.f3954e.longValue());
        }
        if (this.f3955f != null) {
            miVar.m7169b(6, this.f3955f.longValue());
        }
        if (this.f3957h != null) {
            miVar.m7169b(7, this.f3957h.longValue());
        }
        if (this.f3958i != null) {
            miVar.m7162a(8, this.f3958i);
        }
        if (this.f3959j != null) {
            miVar.m7162a(9, this.f3959j);
        }
        if (this.f3960k != null) {
            miVar.m7162a(10, this.f3960k);
        }
        if (this.f3961l != null) {
            miVar.m7162a(11, this.f3961l);
        }
        if (this.f3962m != null) {
            miVar.m7159a(12, this.f3962m.intValue());
        }
        if (this.f3963n != null) {
            miVar.m7162a(13, this.f3963n);
        }
        if (this.f3964o != null) {
            miVar.m7162a(14, this.f3964o);
        }
        if (this.f3965p != null) {
            miVar.m7162a(16, this.f3965p);
        }
        if (this.f3966q != null) {
            miVar.m7169b(17, this.f3966q.longValue());
        }
        if (this.f3967r != null) {
            miVar.m7169b(18, this.f3967r.longValue());
        }
        if (this.f3968s != null) {
            miVar.m7162a(19, this.f3968s);
        }
        if (this.f3969t != null) {
            miVar.m7163a(20, this.f3969t.booleanValue());
        }
        if (this.f3970u != null) {
            miVar.m7162a(21, this.f3970u);
        }
        if (this.f3971v != null) {
            miVar.m7169b(22, this.f3971v.longValue());
        }
        if (this.f3972w != null) {
            miVar.m7159a(23, this.f3972w.intValue());
        }
        if (this.f3973x != null) {
            miVar.m7162a(24, this.f3973x);
        }
        if (this.f3974y != null) {
            miVar.m7162a(25, this.f3974y);
        }
        if (this.f3956g != null) {
            miVar.m7169b(26, this.f3956g.longValue());
        }
        if (this.f3975z != null) {
            miVar.m7163a(28, this.f3975z.booleanValue());
        }
        if (this.f3949A != null && this.f3949A.length > 0) {
            while (i < this.f3949A.length) {
                mm mmVar3 = this.f3949A[i];
                if (mmVar3 != null) {
                    miVar.m7161a(29, mmVar3);
                }
                i++;
            }
        }
        super.m6962a(miVar);
    }

    public lq m7045b() {
        this.f3950a = null;
        this.f3951b = ln.m7025a();
        this.f3952c = ls.m7053a();
        this.f3953d = null;
        this.f3954e = null;
        this.f3955f = null;
        this.f3956g = null;
        this.f3957h = null;
        this.f3958i = null;
        this.f3959j = null;
        this.f3960k = null;
        this.f3961l = null;
        this.f3962m = null;
        this.f3963n = null;
        this.f3964o = null;
        this.f3965p = null;
        this.f3966q = null;
        this.f3967r = null;
        this.f3968s = null;
        this.f3969t = null;
        this.f3970u = null;
        this.f3971v = null;
        this.f3972w = null;
        this.f3973x = null;
        this.f3974y = null;
        this.f3975z = null;
        this.f3949A = lm.m7019a();
        this.B = -1;
        return this;
    }

    public /* synthetic */ mm m7046b(mh mhVar) {
        return m7043a(mhVar);
    }

    protected int m7047c() {
        int i;
        int i2 = 0;
        int c = super.m6964c();
        if (this.f3950a != null) {
            c += mi.m7140b(1, this.f3950a.intValue());
        }
        if (this.f3951b != null && this.f3951b.length > 0) {
            i = c;
            for (mm mmVar : this.f3951b) {
                if (mmVar != null) {
                    i += mi.m7141b(2, mmVar);
                }
            }
            c = i;
        }
        if (this.f3952c != null && this.f3952c.length > 0) {
            i = c;
            for (mm mmVar2 : this.f3952c) {
                if (mmVar2 != null) {
                    i += mi.m7141b(3, mmVar2);
                }
            }
            c = i;
        }
        if (this.f3953d != null) {
            c += mi.m7148c(4, this.f3953d.longValue());
        }
        if (this.f3954e != null) {
            c += mi.m7148c(5, this.f3954e.longValue());
        }
        if (this.f3955f != null) {
            c += mi.m7148c(6, this.f3955f.longValue());
        }
        if (this.f3957h != null) {
            c += mi.m7148c(7, this.f3957h.longValue());
        }
        if (this.f3958i != null) {
            c += mi.m7142b(8, this.f3958i);
        }
        if (this.f3959j != null) {
            c += mi.m7142b(9, this.f3959j);
        }
        if (this.f3960k != null) {
            c += mi.m7142b(10, this.f3960k);
        }
        if (this.f3961l != null) {
            c += mi.m7142b(11, this.f3961l);
        }
        if (this.f3962m != null) {
            c += mi.m7140b(12, this.f3962m.intValue());
        }
        if (this.f3963n != null) {
            c += mi.m7142b(13, this.f3963n);
        }
        if (this.f3964o != null) {
            c += mi.m7142b(14, this.f3964o);
        }
        if (this.f3965p != null) {
            c += mi.m7142b(16, this.f3965p);
        }
        if (this.f3966q != null) {
            c += mi.m7148c(17, this.f3966q.longValue());
        }
        if (this.f3967r != null) {
            c += mi.m7148c(18, this.f3967r.longValue());
        }
        if (this.f3968s != null) {
            c += mi.m7142b(19, this.f3968s);
        }
        if (this.f3969t != null) {
            c += mi.m7143b(20, this.f3969t.booleanValue());
        }
        if (this.f3970u != null) {
            c += mi.m7142b(21, this.f3970u);
        }
        if (this.f3971v != null) {
            c += mi.m7148c(22, this.f3971v.longValue());
        }
        if (this.f3972w != null) {
            c += mi.m7140b(23, this.f3972w.intValue());
        }
        if (this.f3973x != null) {
            c += mi.m7142b(24, this.f3973x);
        }
        if (this.f3974y != null) {
            c += mi.m7142b(25, this.f3974y);
        }
        if (this.f3956g != null) {
            c += mi.m7148c(26, this.f3956g.longValue());
        }
        if (this.f3975z != null) {
            c += mi.m7143b(28, this.f3975z.booleanValue());
        }
        if (this.f3949A != null && this.f3949A.length > 0) {
            while (i2 < this.f3949A.length) {
                mm mmVar3 = this.f3949A[i2];
                if (mmVar3 != null) {
                    c += mi.m7141b(29, mmVar3);
                }
                i2++;
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lq)) {
            return false;
        }
        lq lqVar = (lq) obj;
        if (this.f3950a == null) {
            if (lqVar.f3950a != null) {
                return false;
            }
        } else if (!this.f3950a.equals(lqVar.f3950a)) {
            return false;
        }
        if (!mk.m7179a(this.f3951b, lqVar.f3951b)) {
            return false;
        }
        if (!mk.m7179a(this.f3952c, lqVar.f3952c)) {
            return false;
        }
        if (this.f3953d == null) {
            if (lqVar.f3953d != null) {
                return false;
            }
        } else if (!this.f3953d.equals(lqVar.f3953d)) {
            return false;
        }
        if (this.f3954e == null) {
            if (lqVar.f3954e != null) {
                return false;
            }
        } else if (!this.f3954e.equals(lqVar.f3954e)) {
            return false;
        }
        if (this.f3955f == null) {
            if (lqVar.f3955f != null) {
                return false;
            }
        } else if (!this.f3955f.equals(lqVar.f3955f)) {
            return false;
        }
        if (this.f3956g == null) {
            if (lqVar.f3956g != null) {
                return false;
            }
        } else if (!this.f3956g.equals(lqVar.f3956g)) {
            return false;
        }
        if (this.f3957h == null) {
            if (lqVar.f3957h != null) {
                return false;
            }
        } else if (!this.f3957h.equals(lqVar.f3957h)) {
            return false;
        }
        if (this.f3958i == null) {
            if (lqVar.f3958i != null) {
                return false;
            }
        } else if (!this.f3958i.equals(lqVar.f3958i)) {
            return false;
        }
        if (this.f3959j == null) {
            if (lqVar.f3959j != null) {
                return false;
            }
        } else if (!this.f3959j.equals(lqVar.f3959j)) {
            return false;
        }
        if (this.f3960k == null) {
            if (lqVar.f3960k != null) {
                return false;
            }
        } else if (!this.f3960k.equals(lqVar.f3960k)) {
            return false;
        }
        if (this.f3961l == null) {
            if (lqVar.f3961l != null) {
                return false;
            }
        } else if (!this.f3961l.equals(lqVar.f3961l)) {
            return false;
        }
        if (this.f3962m == null) {
            if (lqVar.f3962m != null) {
                return false;
            }
        } else if (!this.f3962m.equals(lqVar.f3962m)) {
            return false;
        }
        if (this.f3963n == null) {
            if (lqVar.f3963n != null) {
                return false;
            }
        } else if (!this.f3963n.equals(lqVar.f3963n)) {
            return false;
        }
        if (this.f3964o == null) {
            if (lqVar.f3964o != null) {
                return false;
            }
        } else if (!this.f3964o.equals(lqVar.f3964o)) {
            return false;
        }
        if (this.f3965p == null) {
            if (lqVar.f3965p != null) {
                return false;
            }
        } else if (!this.f3965p.equals(lqVar.f3965p)) {
            return false;
        }
        if (this.f3966q == null) {
            if (lqVar.f3966q != null) {
                return false;
            }
        } else if (!this.f3966q.equals(lqVar.f3966q)) {
            return false;
        }
        if (this.f3967r == null) {
            if (lqVar.f3967r != null) {
                return false;
            }
        } else if (!this.f3967r.equals(lqVar.f3967r)) {
            return false;
        }
        if (this.f3968s == null) {
            if (lqVar.f3968s != null) {
                return false;
            }
        } else if (!this.f3968s.equals(lqVar.f3968s)) {
            return false;
        }
        if (this.f3969t == null) {
            if (lqVar.f3969t != null) {
                return false;
            }
        } else if (!this.f3969t.equals(lqVar.f3969t)) {
            return false;
        }
        if (this.f3970u == null) {
            if (lqVar.f3970u != null) {
                return false;
            }
        } else if (!this.f3970u.equals(lqVar.f3970u)) {
            return false;
        }
        if (this.f3971v == null) {
            if (lqVar.f3971v != null) {
                return false;
            }
        } else if (!this.f3971v.equals(lqVar.f3971v)) {
            return false;
        }
        if (this.f3972w == null) {
            if (lqVar.f3972w != null) {
                return false;
            }
        } else if (!this.f3972w.equals(lqVar.f3972w)) {
            return false;
        }
        if (this.f3973x == null) {
            if (lqVar.f3973x != null) {
                return false;
            }
        } else if (!this.f3973x.equals(lqVar.f3973x)) {
            return false;
        }
        if (this.f3974y == null) {
            if (lqVar.f3974y != null) {
                return false;
            }
        } else if (!this.f3974y.equals(lqVar.f3974y)) {
            return false;
        }
        if (this.f3975z == null) {
            if (lqVar.f3975z != null) {
                return false;
            }
        } else if (!this.f3975z.equals(lqVar.f3975z)) {
            return false;
        }
        return mk.m7179a(this.f3949A, lqVar.f3949A);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3974y == null ? 0 : this.f3974y.hashCode()) + (((this.f3973x == null ? 0 : this.f3973x.hashCode()) + (((this.f3972w == null ? 0 : this.f3972w.hashCode()) + (((this.f3971v == null ? 0 : this.f3971v.hashCode()) + (((this.f3970u == null ? 0 : this.f3970u.hashCode()) + (((this.f3969t == null ? 0 : this.f3969t.hashCode()) + (((this.f3968s == null ? 0 : this.f3968s.hashCode()) + (((this.f3967r == null ? 0 : this.f3967r.hashCode()) + (((this.f3966q == null ? 0 : this.f3966q.hashCode()) + (((this.f3965p == null ? 0 : this.f3965p.hashCode()) + (((this.f3964o == null ? 0 : this.f3964o.hashCode()) + (((this.f3963n == null ? 0 : this.f3963n.hashCode()) + (((this.f3962m == null ? 0 : this.f3962m.hashCode()) + (((this.f3961l == null ? 0 : this.f3961l.hashCode()) + (((this.f3960k == null ? 0 : this.f3960k.hashCode()) + (((this.f3959j == null ? 0 : this.f3959j.hashCode()) + (((this.f3958i == null ? 0 : this.f3958i.hashCode()) + (((this.f3957h == null ? 0 : this.f3957h.hashCode()) + (((this.f3956g == null ? 0 : this.f3956g.hashCode()) + (((this.f3955f == null ? 0 : this.f3955f.hashCode()) + (((this.f3954e == null ? 0 : this.f3954e.hashCode()) + (((this.f3953d == null ? 0 : this.f3953d.hashCode()) + (((((((this.f3950a == null ? 0 : this.f3950a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + mk.m7177a(this.f3951b)) * 31) + mk.m7177a(this.f3952c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3975z != null) {
            i = this.f3975z.hashCode();
        }
        return ((hashCode + i) * 31) + mk.m7177a(this.f3949A);
    }
}
