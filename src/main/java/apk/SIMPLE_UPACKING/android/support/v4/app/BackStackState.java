package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Creator CREATOR;
    final int[] f455a;
    final int f456b;
    final int f457c;
    final String f458d;
    final int f459e;
    final int f460f;
    final CharSequence f461g;
    final int f462h;
    final CharSequence f463i;
    final ArrayList f464j;
    final ArrayList f465k;

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (BackStackRecord backStackRecord2 = backStackRecord.f651c; backStackRecord2 != null; backStackRecord2 = backStackRecord2.f686a) {
            if (backStackRecord2.f694i != null) {
                i += backStackRecord2.f694i.size();
            }
        }
        this.f455a = new int[(i + (backStackRecord.f653e * 7))];
        if (backStackRecord.f660l) {
            i = 0;
            for (BackStackRecord backStackRecord3 = backStackRecord.f651c; backStackRecord3 != null; backStackRecord3 = backStackRecord3.f686a) {
                int i2 = i + 1;
                this.f455a[i] = backStackRecord3.f688c;
                int i3 = i2 + 1;
                this.f455a[i2] = backStackRecord3.f689d != null ? backStackRecord3.f689d.f733p : -1;
                int i4 = i3 + 1;
                this.f455a[i3] = backStackRecord3.f690e;
                i2 = i4 + 1;
                this.f455a[i4] = backStackRecord3.f691f;
                i4 = i2 + 1;
                this.f455a[i2] = backStackRecord3.f692g;
                i2 = i4 + 1;
                this.f455a[i4] = backStackRecord3.f693h;
                if (backStackRecord3.f694i != null) {
                    int size = backStackRecord3.f694i.size();
                    i4 = i2 + 1;
                    this.f455a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f455a[i4] = ((Fragment) backStackRecord3.f694i.get(i2)).f733p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f455a[i2] = 0;
                }
            }
            this.f456b = backStackRecord.f658j;
            this.f457c = backStackRecord.f659k;
            this.f458d = backStackRecord.f662n;
            this.f459e = backStackRecord.f664p;
            this.f460f = backStackRecord.f665q;
            this.f461g = backStackRecord.f666r;
            this.f462h = backStackRecord.f667s;
            this.f463i = backStackRecord.f668t;
            this.f464j = backStackRecord.f669u;
            this.f465k = backStackRecord.f670v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f455a = parcel.createIntArray();
        this.f456b = parcel.readInt();
        this.f457c = parcel.readInt();
        this.f458d = parcel.readString();
        this.f459e = parcel.readInt();
        this.f460f = parcel.readInt();
        this.f461g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f462h = parcel.readInt();
        this.f463i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f464j = parcel.createStringArrayList();
        this.f465k = parcel.createStringArrayList();
    }

    public BackStackRecord m739a(af afVar) {
        BackStackRecord backStackRecord = new BackStackRecord(afVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f455a.length) {
            BackStackRecord backStackRecord2 = new BackStackRecord();
            int i3 = i2 + 1;
            backStackRecord2.f688c = this.f455a[i2];
            if (af.f495a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.f455a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f455a[i3];
            if (i2 >= 0) {
                backStackRecord2.f689d = (Fragment) afVar.f501f.get(i2);
            } else {
                backStackRecord2.f689d = null;
            }
            i3 = i4 + 1;
            backStackRecord2.f690e = this.f455a[i4];
            i4 = i3 + 1;
            backStackRecord2.f691f = this.f455a[i3];
            i3 = i4 + 1;
            backStackRecord2.f692g = this.f455a[i4];
            int i5 = i3 + 1;
            backStackRecord2.f693h = this.f455a[i3];
            i4 = i5 + 1;
            int i6 = this.f455a[i5];
            if (i6 > 0) {
                backStackRecord2.f694i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (af.f495a) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.f455a[i4]);
                    }
                    i5 = i4 + 1;
                    backStackRecord2.f694i.add((Fragment) afVar.f501f.get(this.f455a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            backStackRecord.m1113a(backStackRecord2);
            i++;
            i2 = i4;
        }
        backStackRecord.f658j = this.f456b;
        backStackRecord.f659k = this.f457c;
        backStackRecord.f662n = this.f458d;
        backStackRecord.f664p = this.f459e;
        backStackRecord.f660l = true;
        backStackRecord.f665q = this.f460f;
        backStackRecord.f666r = this.f461g;
        backStackRecord.f667s = this.f462h;
        backStackRecord.f668t = this.f463i;
        backStackRecord.f669u = this.f464j;
        backStackRecord.f670v = this.f465k;
        backStackRecord.m1112a(1);
        return backStackRecord;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f455a);
        parcel.writeInt(this.f456b);
        parcel.writeInt(this.f457c);
        parcel.writeString(this.f458d);
        parcel.writeInt(this.f459e);
        parcel.writeInt(this.f460f);
        TextUtils.writeToParcel(this.f461g, parcel, 0);
        parcel.writeInt(this.f462h);
        TextUtils.writeToParcel(this.f463i, parcel, 0);
        parcel.writeStringList(this.f464j);
        parcel.writeStringList(this.f465k);
    }

    static {
        CREATOR = new BackStackRecord();
    }
}
