package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator CREATOR;
    Messenger f4564a;
    C0348e f4565b;

    static {
        CREATOR = new C0346c();
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f4564a = new Messenger(iBinder);
        } else {
            this.f4565b = C0349f.m8144a(iBinder);
        }
    }

    public IBinder m8119a() {
        return this.f4564a != null ? this.f4564a.getBinder() : this.f4565b.asBinder();
    }

    public void m8120a(Message message) {
        if (this.f4564a != null) {
            this.f4564a.send(message);
        } else {
            this.f4565b.m8143a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = m8119a().equals(((MessengerCompat) obj).m8119a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return m8119a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f4564a != null) {
            parcel.writeStrongBinder(this.f4564a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f4565b.asBinder());
        }
    }
}
