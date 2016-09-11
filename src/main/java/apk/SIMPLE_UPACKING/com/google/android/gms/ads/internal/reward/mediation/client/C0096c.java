package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p047a.C0002a;

/* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.c */
class C0096c implements C0094a {
    private IBinder f3090a;

    C0096c(IBinder iBinder) {
        this.f3090a = iBinder;
    }

    public void m5615a(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5616a(C0002a c0002a, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            obtain.writeInt(i);
            this.f3090a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5617a(C0002a c0002a, RewardItemParcel rewardItemParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            if (rewardItemParcel != null) {
                obtain.writeInt(1);
                rewardItemParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3090a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3090a;
    }

    public void m5618b(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5619b(C0002a c0002a, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            obtain.writeInt(i);
            this.f3090a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5620c(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5621d(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5622e(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5623f(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void m5624g(C0002a c0002a) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            obtain.writeStrongBinder(c0002a != null ? c0002a.asBinder() : null);
            this.f3090a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
