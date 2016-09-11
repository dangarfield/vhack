package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.c */
public class C0300c {
    public static int m7946a(Parcel parcel) {
        return C0300c.m7964b(parcel, 20293);
    }

    public static void m7947a(Parcel parcel, int i) {
        C0300c.m7967c(parcel, i);
    }

    public static void m7948a(Parcel parcel, int i, float f) {
        C0300c.m7965b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m7949a(Parcel parcel, int i, int i2) {
        C0300c.m7965b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m7950a(Parcel parcel, int i, long j) {
        C0300c.m7965b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m7951a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeBundle(bundle);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7952a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7953a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C0300c.m7964b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7954a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            C0300c.m7965b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7955a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0300c.m7965b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7956a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C0300c.m7965b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7957a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeString(str);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7958a(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = C0300c.m7964b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7959a(Parcel parcel, int i, boolean z) {
        C0300c.m7965b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m7960a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeByteArray(bArr);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7961a(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0300c.m7963a(parcel, parcelable, i2);
                }
            }
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    public static void m7962a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeStringArray(strArr);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    private static void m7963a(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m7964b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m7965b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m7966b(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = C0300c.m7964b(parcel, i);
            parcel.writeStringList(list);
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }

    private static void m7967c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m7968c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = C0300c.m7964b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0300c.m7963a(parcel, parcelable, 0);
                }
            }
            C0300c.m7967c(parcel, b);
        } else if (z) {
            C0300c.m7965b(parcel, i, 0);
        }
    }
}
