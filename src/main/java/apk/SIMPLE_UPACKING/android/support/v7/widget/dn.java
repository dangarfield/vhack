package android.support.v7.widget;

import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.List;

/* compiled from: OpReorderer */
class dn {
    final OpReorderer f2128a;

    public dn(OpReorderer opReorderer) {
        this.f2128a = opReorderer;
    }

    void m4294a(List list) {
        while (true) {
            int b = m4292b(list);
            if (b != -1) {
                m4291a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    private void m4291a(List list, int i, int i2) {
        ak akVar = (ak) list.get(i);
        ak akVar2 = (ak) list.get(i2);
        switch (akVar2.f1864a) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                m4293c(list, i, akVar, i2, akVar2);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                m4295a(list, i, akVar, i2, akVar2);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                m4296b(list, i, akVar, i2, akVar2);
            default:
        }
    }

    void m4295a(List list, int i, ak akVar, int i2, ak akVar2) {
        int i3;
        ak akVar3;
        int i4 = 0;
        if (akVar.f1865b < akVar.f1867d) {
            i3 = (akVar2.f1865b == akVar.f1865b && akVar2.f1867d == akVar.f1867d - akVar.f1865b) ? 1 : 0;
        } else if (akVar2.f1865b == akVar.f1867d + 1 && akVar2.f1867d == akVar.f1865b - akVar.f1867d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (akVar.f1867d < akVar2.f1865b) {
            akVar2.f1865b--;
        } else if (akVar.f1867d < akVar2.f1865b + akVar2.f1867d) {
            akVar2.f1867d--;
            akVar.f1864a = 2;
            akVar.f1867d = 1;
            if (akVar2.f1867d == 0) {
                list.remove(i2);
                this.f2128a.m3916a(akVar2);
                return;
            }
            return;
        }
        if (akVar.f1865b <= akVar2.f1865b) {
            akVar2.f1865b++;
            akVar3 = null;
        } else if (akVar.f1865b < akVar2.f1865b + akVar2.f1867d) {
            akVar3 = this.f2128a.m3915a(2, akVar.f1865b + 1, (akVar2.f1865b + akVar2.f1867d) - akVar.f1865b, null);
            akVar2.f1867d = akVar.f1865b - akVar2.f1865b;
        } else {
            akVar3 = null;
        }
        if (i3 != 0) {
            list.set(i, akVar2);
            list.remove(i2);
            this.f2128a.m3916a(akVar);
            return;
        }
        if (i4 != 0) {
            if (akVar3 != null) {
                if (akVar.f1865b > akVar3.f1865b) {
                    akVar.f1865b -= akVar3.f1867d;
                }
                if (akVar.f1867d > akVar3.f1865b) {
                    akVar.f1867d -= akVar3.f1867d;
                }
            }
            if (akVar.f1865b > akVar2.f1865b) {
                akVar.f1865b -= akVar2.f1867d;
            }
            if (akVar.f1867d > akVar2.f1865b) {
                akVar.f1867d -= akVar2.f1867d;
            }
        } else {
            if (akVar3 != null) {
                if (akVar.f1865b >= akVar3.f1865b) {
                    akVar.f1865b -= akVar3.f1867d;
                }
                if (akVar.f1867d >= akVar3.f1865b) {
                    akVar.f1867d -= akVar3.f1867d;
                }
            }
            if (akVar.f1865b >= akVar2.f1865b) {
                akVar.f1865b -= akVar2.f1867d;
            }
            if (akVar.f1867d >= akVar2.f1865b) {
                akVar.f1867d -= akVar2.f1867d;
            }
        }
        list.set(i, akVar2);
        if (akVar.f1865b != akVar.f1867d) {
            list.set(i2, akVar);
        } else {
            list.remove(i2);
        }
        if (akVar3 != null) {
            list.add(i, akVar3);
        }
    }

    private void m4293c(List list, int i, ak akVar, int i2, ak akVar2) {
        int i3 = 0;
        if (akVar.f1867d < akVar2.f1865b) {
            i3 = -1;
        }
        if (akVar.f1865b < akVar2.f1865b) {
            i3++;
        }
        if (akVar2.f1865b <= akVar.f1865b) {
            akVar.f1865b += akVar2.f1867d;
        }
        if (akVar2.f1865b <= akVar.f1867d) {
            akVar.f1867d += akVar2.f1867d;
        }
        akVar2.f1865b = i3 + akVar2.f1865b;
        list.set(i, akVar2);
        list.set(i2, akVar);
    }

    void m4296b(List list, int i, ak akVar, int i2, ak akVar2) {
        Object obj;
        Object obj2 = null;
        if (akVar.f1867d < akVar2.f1865b) {
            akVar2.f1865b--;
            obj = null;
        } else if (akVar.f1867d < akVar2.f1865b + akVar2.f1867d) {
            akVar2.f1867d--;
            obj = this.f2128a.m3915a(4, akVar.f1865b, 1, akVar2.f1866c);
        } else {
            obj = null;
        }
        if (akVar.f1865b <= akVar2.f1865b) {
            akVar2.f1865b++;
        } else if (akVar.f1865b < akVar2.f1865b + akVar2.f1867d) {
            int i3 = (akVar2.f1865b + akVar2.f1867d) - akVar.f1865b;
            obj2 = this.f2128a.m3915a(4, akVar.f1865b + 1, i3, akVar2.f1866c);
            akVar2.f1867d -= i3;
        }
        list.set(i2, akVar);
        if (akVar2.f1867d > 0) {
            list.set(i, akVar2);
        } else {
            list.remove(i);
            this.f2128a.m3916a(akVar2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int m4292b(List list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((ak) list.get(size)).f1864a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
