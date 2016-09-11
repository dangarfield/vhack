package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.lm;
import com.google.android.gms.p051b.ln;
import com.google.android.gms.p051b.lo;
import com.google.android.gms.p051b.lp;
import com.google.android.gms.p051b.lq;
import com.google.android.gms.p051b.lr;
import com.google.android.gms.p051b.ls;
import com.google.android.gms.p051b.mi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ag extends ck {
    ag(bx bxVar) {
        super(bxVar);
    }

    private Object m8253a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return null;
            }
            String valueOf = String.valueOf(obj);
            return valueOf.length() > i ? z ? valueOf.substring(0, i) : null : valueOf;
        }
    }

    private void m8254a(String str, String str2, int i, Object obj) {
        if (obj == null) {
            m8306s().m8603w().m8608a(str + " value can't be null. Ignoring " + str, str2);
        } else if (!(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.length() > i) {
                    m8306s().m8603w().m8609a("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(valueOf.length()));
                }
            }
        }
    }

    private static void m8255a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void m8256a(StringBuilder stringBuilder, int i, lq lqVar) {
        if (lqVar != null) {
            m8255a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            m8258a(stringBuilder, i, "protocol_version", lqVar.f3950a);
            m8258a(stringBuilder, i, "platform", lqVar.f3958i);
            m8258a(stringBuilder, i, "gmp_version", lqVar.f3966q);
            m8258a(stringBuilder, i, "uploading_gmp_version", lqVar.f3967r);
            m8258a(stringBuilder, i, "gmp_app_id", lqVar.f3974y);
            m8258a(stringBuilder, i, "app_id", lqVar.f3964o);
            m8258a(stringBuilder, i, "app_version", lqVar.f3965p);
            m8258a(stringBuilder, i, "dev_cert_hash", lqVar.f3971v);
            m8258a(stringBuilder, i, "app_store", lqVar.f3963n);
            m8258a(stringBuilder, i, "upload_timestamp_millis", lqVar.f3953d);
            m8258a(stringBuilder, i, "start_timestamp_millis", lqVar.f3954e);
            m8258a(stringBuilder, i, "end_timestamp_millis", lqVar.f3955f);
            m8258a(stringBuilder, i, "previous_bundle_start_timestamp_millis", lqVar.f3956g);
            m8258a(stringBuilder, i, "previous_bundle_end_timestamp_millis", lqVar.f3957h);
            m8258a(stringBuilder, i, "app_instance_id", lqVar.f3970u);
            m8258a(stringBuilder, i, "resettable_device_id", lqVar.f3968s);
            m8258a(stringBuilder, i, "limited_ad_tracking", lqVar.f3969t);
            m8258a(stringBuilder, i, "os_version", lqVar.f3959j);
            m8258a(stringBuilder, i, "device_model", lqVar.f3960k);
            m8258a(stringBuilder, i, "user_default_language", lqVar.f3961l);
            m8258a(stringBuilder, i, "time_zone_offset_minutes", lqVar.f3962m);
            m8258a(stringBuilder, i, "bundle_sequential_index", lqVar.f3972w);
            m8258a(stringBuilder, i, "service_upload", lqVar.f3975z);
            m8258a(stringBuilder, i, "health_monitor", lqVar.f3973x);
            m8262a(stringBuilder, i, lqVar.f3952c);
            m8259a(stringBuilder, i, lqVar.f3949A);
            m8260a(stringBuilder, i, lqVar.f3951b);
            m8255a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m8257a(StringBuilder stringBuilder, int i, String str, lr lrVar) {
        int i2 = 0;
        if (lrVar != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            m8255a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (lrVar.f3977b != null) {
                m8255a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = lrVar.f3977b;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (lrVar.f3976a != null) {
                m8255a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = lrVar.f3976a;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            m8255a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void m8258a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            m8255a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void m8259a(StringBuilder stringBuilder, int i, lm[] lmVarArr) {
        if (lmVarArr != null) {
            int i2 = i + 1;
            for (lm lmVar : lmVarArr) {
                if (lmVar != null) {
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    m8258a(stringBuilder, i2, "audience_id", lmVar.f3932a);
                    m8258a(stringBuilder, i2, "new_audience", lmVar.f3935d);
                    m8257a(stringBuilder, i2, "current_data", lmVar.f3933b);
                    m8257a(stringBuilder, i2, "previous_data", lmVar.f3934c);
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m8260a(StringBuilder stringBuilder, int i, ln[] lnVarArr) {
        if (lnVarArr != null) {
            int i2 = i + 1;
            for (ln lnVar : lnVarArr) {
                if (lnVar != null) {
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    m8258a(stringBuilder, i2, "name", lnVar.f3938b);
                    m8258a(stringBuilder, i2, "timestamp_millis", lnVar.f3939c);
                    m8258a(stringBuilder, i2, "previous_timestamp_millis", lnVar.f3940d);
                    m8258a(stringBuilder, i2, "count", lnVar.f3941e);
                    m8261a(stringBuilder, i2, lnVar.f3937a);
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m8261a(StringBuilder stringBuilder, int i, lo[] loVarArr) {
        if (loVarArr != null) {
            int i2 = i + 1;
            for (lo loVar : loVarArr) {
                if (loVar != null) {
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    m8258a(stringBuilder, i2, "name", loVar.f3943a);
                    m8258a(stringBuilder, i2, "string_value", loVar.f3944b);
                    m8258a(stringBuilder, i2, "int_value", loVar.f3945c);
                    m8258a(stringBuilder, i2, "float_value", loVar.f3946d);
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m8262a(StringBuilder stringBuilder, int i, ls[] lsVarArr) {
        if (lsVarArr != null) {
            int i2 = i + 1;
            for (ls lsVar : lsVarArr) {
                if (lsVar != null) {
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    m8258a(stringBuilder, i2, "set_timestamp_millis", lsVar.f3979a);
                    m8258a(stringBuilder, i2, "name", lsVar.f3980b);
                    m8258a(stringBuilder, i2, "string_value", lsVar.f3981c);
                    m8258a(stringBuilder, i2, "int_value", lsVar.f3982d);
                    m8258a(stringBuilder, i2, "float_value", lsVar.f3983e);
                    m8255a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean m8263a(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m8264a(Context context, Class cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m8265a(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    static boolean m8266a(String str) {
        bf.m7875a(str);
        return str.charAt(0) != '_';
    }

    public static boolean m8267a(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    public static boolean m8268a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] m8269a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String m8270b(lp lpVar) {
        if (lpVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (lpVar.f3947a != null) {
            for (lq lqVar : lpVar.f3947a) {
                if (lqVar != null) {
                    m8256a(stringBuilder, 1, lqVar);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long m8271c(byte[] bArr) {
        long j = null;
        bf.m7873a((Object) bArr);
        bf.m7877a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    static MessageDigest m8272e(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean m8273g(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private int m8274h(String str) {
        return "_ldl".equals(str) ? m8308u().m8378z() : m8308u().m8377y();
    }

    public Object m8275a(String str, Object obj) {
        return m8253a(m8273g(str) ? m8308u().m8376x() : m8308u().m8375w(), obj, false);
    }

    public void m8276a(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            m8306s().m8603w().m8609a("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public void m8277a(lo loVar, Object obj) {
        bf.m7873a(obj);
        loVar.f3944b = null;
        loVar.f3945c = null;
        loVar.f3946d = null;
        if (obj instanceof String) {
            loVar.f3944b = (String) obj;
        } else if (obj instanceof Long) {
            loVar.f3945c = (Long) obj;
        } else if (obj instanceof Float) {
            loVar.f3946d = (Float) obj;
        } else {
            m8306s().m8582b().m8608a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void m8278a(ls lsVar, Object obj) {
        bf.m7873a(obj);
        lsVar.f3981c = null;
        lsVar.f3982d = null;
        lsVar.f3983e = null;
        if (obj instanceof String) {
            lsVar.f3981c = (String) obj;
        } else if (obj instanceof Long) {
            lsVar.f3982d = (Long) obj;
        } else if (obj instanceof Float) {
            lsVar.f3983e = (Float) obj;
        } else {
            m8306s().m8582b().m8608a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    void m8279a(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        } else if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i2 = 1;
                while (i2 < str2.length()) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
                    }
                }
                if (str2.length() > i) {
                    throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
                }
                return;
            }
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
    }

    public boolean m8280a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(m8299l().m6913a() - j) > j2;
    }

    public byte[] m8281a(lp lpVar) {
        try {
            byte[] bArr = new byte[lpVar.m6966e()];
            mi a = mi.m7134a(bArr);
            lpVar.m7039a(a);
            a.m7168b();
            return bArr;
        } catch (IOException e) {
            m8306s().m8582b().m8608a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] m8282a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            m8306s().m8582b().m8608a("Failed to gzip content", e);
            throw e;
        }
    }

    public void m8283b(String str) {
        m8279a("event", m8308u().m8352c(), str);
    }

    public void m8284b(String str, Object obj) {
        if ("_ldl".equals(str)) {
            m8254a("user attribute referrer", str, m8274h(str), obj);
        } else {
            m8254a("user attribute", str, m8274h(str), obj);
        }
    }

    public byte[] m8285b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            m8306s().m8582b().m8608a("Failed to ungzip content", e);
            throw e;
        }
    }

    public Object m8286c(String str, Object obj) {
        return "_ldl".equals(str) ? m8253a(m8274h(str), obj, true) : m8253a(m8274h(str), obj, false);
    }

    public void m8287c(String str) {
        m8279a("user attribute", m8308u().m8374v(), str);
    }

    public long m8288d(byte[] bArr) {
        bf.m7873a((Object) bArr);
        MessageDigest e = m8272e("MD5");
        if (e != null) {
            return m8271c(e.digest(bArr));
        }
        m8306s().m8582b().m8607a("Failed to get MD5");
        return 0;
    }

    public /* bridge */ /* synthetic */ void m8289d() {
        super.m8205d();
    }

    public void m8290d(String str) {
        m8279a("event param", m8308u().m8374v(), str);
    }

    public /* bridge */ /* synthetic */ void m8291e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8292f() {
        super.m8207f();
    }

    public boolean m8293f(String str) {
        m8292f();
        if (m8300m().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        m8306s().m8605y().m8608a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ ai m8294g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8295h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8296i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8297j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8298k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8299l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8300m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8301n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8302o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8303p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8304q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8305r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8306s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8307t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8308u() {
        return super.m8222u();
    }
}
