package android.support.v4.app;

import android.os.Bundle;

/* compiled from: RemoteInputCompatJellybean */
class da {
    static Bundle m1059a(cy cyVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", cyVar.m1046a());
        bundle.putCharSequence("label", cyVar.m1047b());
        bundle.putCharSequenceArray("choices", cyVar.m1048c());
        bundle.putBoolean("allowFreeFormInput", cyVar.m1049d());
        bundle.putBundle("extras", cyVar.m1050e());
        return bundle;
    }

    static Bundle[] m1060a(cy[] cyVarArr) {
        if (cyVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[cyVarArr.length];
        for (int i = 0; i < cyVarArr.length; i++) {
            bundleArr[i] = m1059a(cyVarArr[i]);
        }
        return bundleArr;
    }
}
