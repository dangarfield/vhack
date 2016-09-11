package com.google.android.gms.p051b;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C0094a;
import com.google.android.gms.p047a.C0002a;
import java.util.List;

/* renamed from: com.google.android.gms.b.dc */
public interface dc extends IInterface {
    C0002a m6269a();

    void m6270a(C0002a c0002a, AdRequestParcel adRequestParcel, String str, C0094a c0094a, String str2);

    void m6271a(C0002a c0002a, AdRequestParcel adRequestParcel, String str, df dfVar);

    void m6272a(C0002a c0002a, AdRequestParcel adRequestParcel, String str, String str2, df dfVar);

    void m6273a(C0002a c0002a, AdRequestParcel adRequestParcel, String str, String str2, df dfVar, NativeAdOptionsParcel nativeAdOptionsParcel, List list);

    void m6274a(C0002a c0002a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, df dfVar);

    void m6275a(C0002a c0002a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, df dfVar);

    void m6276a(AdRequestParcel adRequestParcel, String str);

    void m6277a(AdRequestParcel adRequestParcel, String str, String str2);

    void m6278b();

    void m6279c();

    void m6280d();

    void m6281e();

    void m6282f();

    boolean m6283g();

    dm m6284h();

    dp m6285i();

    Bundle m6286j();

    Bundle m6287k();

    Bundle m6288l();
}
