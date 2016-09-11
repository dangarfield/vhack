package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;

/* renamed from: com.google.android.gms.measurement.internal.b */
class C0360b {
    private final bx f4723a;
    private final String f4724b;
    private String f4725c;
    private String f4726d;
    private String f4727e;
    private long f4728f;
    private long f4729g;
    private long f4730h;
    private String f4731i;
    private String f4732j;
    private long f4733k;
    private long f4734l;
    private boolean f4735m;
    private long f4736n;
    private long f4737o;
    private long f4738p;
    private long f4739q;
    private boolean f4740r;
    private long f4741s;
    private long f4742t;

    C0360b(bx bxVar, String str) {
        bf.m7873a((Object) bxVar);
        bf.m7875a(str);
        this.f4723a = bxVar;
        this.f4724b = str;
        this.f4723a.m8786y();
    }

    public void m8504a() {
        this.f4723a.m8786y();
        this.f4740r = false;
    }

    public void m8505a(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4729g != j ? 1 : 0) | this.f4740r;
        this.f4729g = j;
    }

    public void m8506a(String str) {
        this.f4723a.m8786y();
        this.f4740r |= ag.m8267a(this.f4725c, str);
        this.f4725c = str;
    }

    public void m8507a(boolean z) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4735m != z ? 1 : 0) | this.f4740r;
        this.f4735m = z;
    }

    public String m8508b() {
        this.f4723a.m8786y();
        return this.f4724b;
    }

    public void m8509b(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4730h != j ? 1 : 0) | this.f4740r;
        this.f4730h = j;
    }

    public void m8510b(String str) {
        this.f4723a.m8786y();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f4740r |= ag.m8267a(this.f4726d, str);
        this.f4726d = str;
    }

    public String m8511c() {
        this.f4723a.m8786y();
        return this.f4725c;
    }

    public void m8512c(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4733k != j ? 1 : 0) | this.f4740r;
        this.f4733k = j;
    }

    public void m8513c(String str) {
        this.f4723a.m8786y();
        this.f4740r |= ag.m8267a(this.f4727e, str);
        this.f4727e = str;
    }

    public String m8514d() {
        this.f4723a.m8786y();
        return this.f4726d;
    }

    public void m8515d(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4734l != j ? 1 : 0) | this.f4740r;
        this.f4734l = j;
    }

    public void m8516d(String str) {
        this.f4723a.m8786y();
        this.f4740r |= ag.m8267a(this.f4731i, str);
        this.f4731i = str;
    }

    public String m8517e() {
        this.f4723a.m8786y();
        return this.f4727e;
    }

    public void m8518e(long j) {
        int i = 1;
        bf.m7881b(j >= 0);
        this.f4723a.m8786y();
        boolean z = this.f4740r;
        if (this.f4728f == j) {
            i = 0;
        }
        this.f4740r = z | i;
        this.f4728f = j;
    }

    public void m8519e(String str) {
        this.f4723a.m8786y();
        this.f4740r |= ag.m8267a(this.f4732j, str);
        this.f4732j = str;
    }

    public long m8520f() {
        this.f4723a.m8786y();
        return this.f4729g;
    }

    public void m8521f(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4741s != j ? 1 : 0) | this.f4740r;
        this.f4741s = j;
    }

    public long m8522g() {
        this.f4723a.m8786y();
        return this.f4730h;
    }

    public void m8523g(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4742t != j ? 1 : 0) | this.f4740r;
        this.f4742t = j;
    }

    public String m8524h() {
        this.f4723a.m8786y();
        return this.f4731i;
    }

    public void m8525h(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4736n != j ? 1 : 0) | this.f4740r;
        this.f4736n = j;
    }

    public String m8526i() {
        this.f4723a.m8786y();
        return this.f4732j;
    }

    public void m8527i(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4737o != j ? 1 : 0) | this.f4740r;
        this.f4737o = j;
    }

    public long m8528j() {
        this.f4723a.m8786y();
        return this.f4733k;
    }

    public void m8529j(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4738p != j ? 1 : 0) | this.f4740r;
        this.f4738p = j;
    }

    public long m8530k() {
        this.f4723a.m8786y();
        return this.f4734l;
    }

    public void m8531k(long j) {
        this.f4723a.m8786y();
        this.f4740r = (this.f4739q != j ? 1 : 0) | this.f4740r;
        this.f4739q = j;
    }

    public boolean m8532l() {
        this.f4723a.m8786y();
        return this.f4735m;
    }

    public long m8533m() {
        this.f4723a.m8786y();
        return this.f4728f;
    }

    public long m8534n() {
        this.f4723a.m8786y();
        return this.f4741s;
    }

    public long m8535o() {
        this.f4723a.m8786y();
        return this.f4742t;
    }

    public void m8536p() {
        this.f4723a.m8786y();
        long j = this.f4728f + 1;
        if (j > 2147483647L) {
            this.f4723a.m8767f().m8583c().m8607a("Bundle index overflow");
            j = 0;
        }
        this.f4740r = true;
        this.f4728f = j;
    }

    public long m8537q() {
        this.f4723a.m8786y();
        return this.f4736n;
    }

    public long m8538r() {
        this.f4723a.m8786y();
        return this.f4737o;
    }

    public long m8539s() {
        this.f4723a.m8786y();
        return this.f4738p;
    }

    public long m8540t() {
        this.f4723a.m8786y();
        return this.f4739q;
    }
}
