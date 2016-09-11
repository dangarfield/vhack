package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0298a {
    public static int m7922a(int i) {
        return 65535 & i;
    }

    public static int m7923a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m7924a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static Parcelable m7925a(Parcel parcel, int i, Creator creator) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m7926a(Parcel parcel, int i, int i2) {
        int a = C0298a.m7924a(parcel, i);
        if (a != i2) {
            throw new C0299b("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m7927a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0299b("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static int m7928b(Parcel parcel) {
        int a = C0298a.m7923a(parcel);
        int a2 = C0298a.m7924a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C0298a.m7922a(a) != 20293) {
            throw new C0299b("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C0299b("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m7929b(Parcel parcel, int i) {
        parcel.setDataPosition(C0298a.m7924a(parcel, i) + parcel.dataPosition());
    }

    public static Object[] m7930b(Parcel parcel, int i, Creator creator) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static ArrayList m7931c(Parcel parcel, int i, Creator creator) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m7932c(Parcel parcel, int i) {
        C0298a.m7926a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m7933d(Parcel parcel, int i) {
        C0298a.m7926a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m7934e(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0298a.m7927a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m7935f(Parcel parcel, int i) {
        C0298a.m7926a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m7936g(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0298a.m7927a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static float m7937h(Parcel parcel, int i) {
        C0298a.m7926a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m7938i(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0298a.m7927a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static String m7939j(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m7940k(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m7941l(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m7942m(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static String[] m7943n(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList m7944o(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    public static ArrayList m7945p(Parcel parcel, int i) {
        int a = C0298a.m7924a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
