package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.p051b.fi;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

@fi
/* renamed from: com.google.android.gms.ads.internal.purchase.j */
public class C0089j {
    public static PublicKey m5596a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            C0099b.m5639b("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean m5597a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return C0089j.m5598a(C0089j.m5596a(str), str2, str3);
        }
        C0099b.m5639b("Purchase verification failed: missing data.");
        return false;
    }

    public static boolean m5598a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            C0099b.m5639b("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            C0099b.m5639b("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            C0099b.m5639b("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            C0099b.m5639b("Signature exception.");
            return false;
        }
    }
}
