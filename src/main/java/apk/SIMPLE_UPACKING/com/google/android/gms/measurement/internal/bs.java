package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.v4.p014g.ArrayMap;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.kf;
import com.google.android.gms.p051b.li;
import com.google.android.gms.p051b.lj;
import com.google.android.gms.p051b.lk;
import com.google.android.gms.p051b.mh;
import com.google.android.gms.p051b.mi;
import java.io.IOException;
import java.util.Map;

public class bs extends cl {
    private final Map f4827a;
    private final Map f4828b;
    private final Map f4829c;

    bs(bx bxVar) {
        super(bxVar);
        this.f4827a = new ArrayMap();
        this.f4828b = new ArrayMap();
        this.f4829c = new ArrayMap();
    }

    private Map m8671a(lj ljVar) {
        Map arrayMap = new ArrayMap();
        if (!(ljVar == null || ljVar.f3925d == null)) {
            for (lk lkVar : ljVar.f3925d) {
                if (lkVar != null) {
                    arrayMap.put(lkVar.f3929a, lkVar.f3930b);
                }
            }
        }
        return arrayMap;
    }

    private lj m8672b(String str, byte[] bArr) {
        if (bArr == null) {
            return new lj();
        }
        mh a = mh.m7104a(bArr);
        lj ljVar = new lj();
        try {
            ljVar.m7009a(a);
            m8695s().m8606z().m8609a("Parsed config. version, gmp_app_id", ljVar.f3922a, ljVar.f3923b);
            return ljVar;
        } catch (IOException e) {
            m8695s().m8583c().m8609a("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map m8673b(lj ljVar) {
        Map arrayMap = new ArrayMap();
        if (!(ljVar == null || ljVar.f3926e == null)) {
            for (li liVar : ljVar.f3926e) {
                if (liVar != null) {
                    arrayMap.put(liVar.f3920a, liVar.f3921b);
                }
            }
        }
        return arrayMap;
    }

    private void m8674b(String str) {
        m8225G();
        m8682f();
        bf.m7875a(str);
        if (!this.f4829c.containsKey(str)) {
            byte[] d = m8690n().m8423d(str);
            if (d == null) {
                this.f4827a.put(str, null);
                this.f4828b.put(str, null);
                this.f4829c.put(str, null);
                return;
            }
            lj b = m8672b(str, d);
            this.f4827a.put(str, m8671a(b));
            this.f4828b.put(str, m8673b(b));
            this.f4829c.put(str, b);
        }
    }

    protected lj m8675a(String str) {
        m8225G();
        m8682f();
        bf.m7875a(str);
        m8674b(str);
        return (lj) this.f4829c.get(str);
    }

    String m8676a(String str, String str2) {
        m8682f();
        m8674b(str);
        Map map = (Map) this.f4827a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected void m8677a() {
    }

    protected boolean m8678a(String str, byte[] bArr) {
        m8225G();
        m8682f();
        bf.m7875a(str);
        lj b = m8672b(str, bArr);
        if (b == null) {
            return false;
        }
        this.f4828b.put(str, m8673b(b));
        this.f4829c.put(str, b);
        this.f4827a.put(str, m8671a(b));
        m8683g().m8315a(str, b.f3927f);
        try {
            b.f3927f = null;
            byte[] bArr2 = new byte[b.m6966e()];
            b.m7010a(mi.m7134a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            m8695s().m8583c().m8608a("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        m8690n().m8407a(str, bArr);
        return true;
    }

    boolean m8679b(String str, String str2) {
        m8682f();
        m8674b(str);
        Map map = (Map) this.f4828b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    public /* bridge */ /* synthetic */ void m8680d() {
        super.m8205d();
    }

    public /* bridge */ /* synthetic */ void m8681e() {
        super.m8206e();
    }

    public /* bridge */ /* synthetic */ void m8682f() {
        super.m8207f();
    }

    public /* bridge */ /* synthetic */ ai m8683g() {
        return super.m8208g();
    }

    public /* bridge */ /* synthetic */ C0362d m8684h() {
        return super.m8209h();
    }

    public /* bridge */ /* synthetic */ ba m8685i() {
        return super.m8210i();
    }

    public /* bridge */ /* synthetic */ aq m8686j() {
        return super.m8211j();
    }

    public /* bridge */ /* synthetic */ C0367i m8687k() {
        return super.m8212k();
    }

    public /* bridge */ /* synthetic */ kf m8688l() {
        return super.m8213l();
    }

    public /* bridge */ /* synthetic */ Context m8689m() {
        return super.m8214m();
    }

    public /* bridge */ /* synthetic */ ak m8690n() {
        return super.m8215n();
    }

    public /* bridge */ /* synthetic */ ag m8691o() {
        return super.m8216o();
    }

    public /* bridge */ /* synthetic */ bs m8692p() {
        return super.m8217p();
    }

    public /* bridge */ /* synthetic */ C0379u m8693q() {
        return super.m8218q();
    }

    public /* bridge */ /* synthetic */ bt m8694r() {
        return super.m8219r();
    }

    public /* bridge */ /* synthetic */ bc m8695s() {
        return super.m8220s();
    }

    public /* bridge */ /* synthetic */ bn m8696t() {
        return super.m8221t();
    }

    public /* bridge */ /* synthetic */ aj m8697u() {
        return super.m8222u();
    }
}
