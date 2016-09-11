package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.C0001R;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.C0270c;
import com.google.android.gms.common.C0276h;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.C0316b;
import com.google.android.gms.p051b.C0204h;
import com.google.android.gms.p051b.C0205i;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    C0276h zzoS;
    C0204h zzoT;
    boolean zzoU;
    Object zzoV;
    zza zzoW;
    final long zzoX;

    public final class Info {
        private final String zzpc;
        private final boolean zzpd;

        public Info(String str, boolean z) {
            this.zzpc = str;
            this.zzpd = z;
        }

        public String getId() {
            return this.zzpc;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpd;
        }

        public String toString() {
            return "{" + this.zzpc + "}" + this.zzpd;
        }
    }

    class zza extends Thread {
        private WeakReference zzoY;
        private long zzoZ;
        CountDownLatch zzpa;
        boolean zzpb;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzoY = new WeakReference(advertisingIdClient);
            this.zzoZ = j;
            this.zzpa = new CountDownLatch(1);
            this.zzpb = false;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoY.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpb = true;
            }
        }

        public void cancel() {
            this.zzpa.countDown();
        }

        public void run() {
            try {
                if (!this.zzpa.await(this.zzoZ, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaK() {
            return this.zzpb;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzoV = new Object();
        bf.m7873a((Object) context);
        this.mContext = context;
        this.zzoU = false;
        this.zzoX = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static C0204h zza(Context context, C0276h c0276h) {
        try {
            return C0205i.m6796a(c0276h.m7681a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaJ() {
        synchronized (this.zzoV) {
            if (this.zzoW != null) {
                this.zzoW.cancel();
                try {
                    this.zzoW.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzoX > 0) {
                this.zzoW = new zza(this, this.zzoX);
            }
        }
    }

    static C0276h zzp(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C0268j.m7636b().m7638a(context)) {
                case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    ServiceConnection c0276h = new C0276h();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C0316b.m8032a().m8043a(context, intent, c0276h, 1)) {
                            return c0276h;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C0270c(9);
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    public void finish() {
        bf.m7883c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzoS == null) {
                return;
            }
            try {
                if (this.zzoU) {
                    C0316b.m8032a().m8041a(this.mContext, this.zzoS);
                }
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.zzoU = false;
            this.zzoT = null;
            this.zzoS = null;
        }
    }

    public Info getInfo() {
        Info info;
        bf.m7883c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzoU) {
                synchronized (this.zzoV) {
                    if (this.zzoW == null || !this.zzoW.zzaK()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoU) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            bf.m7873a(this.zzoS);
            bf.m7873a(this.zzoT);
            info = new Info(this.zzoT.m6622a(), this.zzoT.m6625a(true));
        }
        zzaJ();
        return info;
    }

    public void start() {
        zzb(true);
    }

    protected void zzb(boolean z) {
        bf.m7883c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoU) {
                finish();
            }
            this.zzoS = zzp(this.mContext);
            this.zzoT = zza(this.mContext, this.zzoS);
            this.zzoU = true;
            if (z) {
                zzaJ();
            }
        }
    }
}
