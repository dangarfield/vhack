package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* compiled from: Fragment */
final class FragmentState implements Parcelable {
    public static final Creator CREATOR;
    final String f469a;
    final int f470b;
    final boolean f471c;
    final int f472d;
    final int f473e;
    final String f474f;
    final boolean f475g;
    final boolean f476h;
    final Bundle f477i;
    Bundle f478j;
    Fragment f479k;

    public FragmentState(Fragment fragment) {
        this.f469a = fragment.getClass().getName();
        this.f470b = fragment.f733p;
        this.f471c = fragment.f741x;
        this.f472d = fragment.f707F;
        this.f473e = fragment.f708G;
        this.f474f = fragment.f709H;
        this.f475g = fragment.f712K;
        this.f476h = fragment.f711J;
        this.f477i = fragment.f735r;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f469a = parcel.readString();
        this.f470b = parcel.readInt();
        this.f471c = parcel.readInt() != 0;
        this.f472d = parcel.readInt();
        this.f473e = parcel.readInt();
        this.f474f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f475g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f476h = z2;
        this.f477i = parcel.readBundle();
        this.f478j = parcel.readBundle();
    }

    public Fragment m740a(ac acVar, Fragment fragment) {
        if (this.f479k != null) {
            return this.f479k;
        }
        Context g = acVar.m801g();
        if (this.f477i != null) {
            this.f477i.setClassLoader(g.getClassLoader());
        }
        this.f479k = Fragment.m1124a(g, this.f469a, this.f477i);
        if (this.f478j != null) {
            this.f478j.setClassLoader(g.getClassLoader());
            this.f479k.f731n = this.f478j;
        }
        this.f479k.m1140a(this.f470b, fragment);
        this.f479k.f741x = this.f471c;
        this.f479k.f743z = true;
        this.f479k.f707F = this.f472d;
        this.f479k.f708G = this.f473e;
        this.f479k.f709H = this.f474f;
        this.f479k.f712K = this.f475g;
        this.f479k.f711J = this.f476h;
        this.f479k.f703B = acVar.f484d;
        if (af.f495a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f479k);
        }
        return this.f479k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f469a);
        parcel.writeInt(this.f470b);
        parcel.writeInt(this.f471c ? 1 : 0);
        parcel.writeInt(this.f472d);
        parcel.writeInt(this.f473e);
        parcel.writeString(this.f474f);
        if (this.f475g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f476h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f477i);
        parcel.writeBundle(this.f478j);
    }

    static {
        CREATOR = new ao();
    }
}
