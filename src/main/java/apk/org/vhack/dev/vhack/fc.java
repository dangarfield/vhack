package org.vhack.dev.vhack;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestHelper */
public class fc {
    public static String a;
    public static String b;
    public static String c;
    static final /* synthetic */ boolean d;
    private static final byte[] e;

    static {
        d = !fc.class.desiredAssertionStatus();
        a = "https://vhackxt.com/v/1/";
        b = "MD5";
        c = "aeffl";
        e = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3) {
        int i4 = 0;
        int i5 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        i4 |= i5;
        switch (i2) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = (byte) 61;
                bArr2[i3 + 3] = (byte) 61;
                break;
            case R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = (byte) 61;
                break;
            case R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = bArr3[i4 & 63];
                break;
        }
        return bArr2;
    }

    public static String a(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        byte[] a = a(bArr, i, i2, bArr2, Integer.MAX_VALUE);
        int length = a.length;
        while (!z && length > 0 && a[length - 1] == 61) {
            length--;
        }
        return new String(a, 0, length);
    }

    public static final String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(b);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                while (toHexString.length() < 2) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = ((i2 + 2) / 3) * 4;
        byte[] bArr3 = new byte[(i4 + (i4 / i3))];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < i5) {
            i4 = (((bArr[i8 + i] << 24) >>> 8) | ((bArr[(i8 + 1) + i] << 24) >>> 16)) | ((bArr[(i8 + 2) + i] << 24) >>> 24);
            bArr3[i7] = bArr2[i4 >>> 18];
            bArr3[i7 + 1] = bArr2[(i4 >>> 12) & 63];
            bArr3[i7 + 2] = bArr2[(i4 >>> 6) & 63];
            bArr3[i7 + 3] = bArr2[i4 & 63];
            i4 = i6 + 4;
            if (i4 == i3) {
                bArr3[i7 + 4] = (byte) 10;
                i7++;
                i4 = 0;
            }
            i8 += 3;
            i7 += 4;
            i6 = i4;
        }
        if (i8 < i2) {
            a(bArr, i8 + i, i2 - i8, bArr3, i7, bArr2);
            if (i6 + 4 == i3) {
                bArr3[i7 + 4] = (byte) 10;
                i7++;
            }
            i7 += 4;
        }
        if (d || r4 == bArr3.length) {
            return bArr3;
        }
        throw new AssertionError();
    }

    public static String a(Context context, String str, String str2, String str3) {
        String[] strArr = new String[2];
        String[] split = str.split("::::");
        String[] split2 = str2.split("::::");
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginData.xml", 0);
        String string = sharedPreferences.getString("strUser", "");
        String string2 = sharedPreferences.getString("strPass", "");
        String string3 = sharedPreferences.getString("uhash", "");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str4 = "{";
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < split.length; i++) {
            try {
                jSONObject.put(split[i], split2[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jSONObject.put("time", currentTimeMillis + "");
            jSONObject.put("user", string);
            jSONObject.put("pass", string2);
            jSONObject.put("uhash", string3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        str4 = jSONObject.toString();
        byte[] bytes = str4.getBytes();
        String a = a(bytes, 0, bytes.length, e, false);
        String a2 = a(str4.length() + a(currentTimeMillis + ""));
        String str5 = string + "" + a(a(string2));
        str4 = a(currentTimeMillis + "" + str4);
        byte[] bytes2 = a2.getBytes();
        byte[] bytes3 = str5.getBytes();
        byte[] bytes4 = str4.getBytes();
        a2 = a(c + a(a(a(bytes2, 0, bytes2.length, e, false))));
        str5 = a(bytes3, 0, bytes3.length, e, false);
        str4 = a(a(a2 + a(a(str5) + a(bytes4, 0, bytes4.length, e, false))));
        strArr[0] = a;
        strArr[1] = str4;
        return a + str3 + "?user=" + a + "&pass=" + str4;
    }
}
