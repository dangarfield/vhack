package com.google.android.gms.p051b;

import java.io.UnsupportedEncodingException;

/* renamed from: com.google.android.gms.b.c */
public class C0197c extends hy {
    private final jm f3512a;

    public C0197c(int i, String str, jm jmVar, jl jlVar) {
        super(i, str, jlVar);
        this.f3512a = jmVar;
    }

    public C0197c(String str, jm jmVar, jl jlVar) {
        this(0, str, jmVar, jlVar);
    }

    protected jk m6215a(fk fkVar) {
        Object str;
        try {
            str = new String(fkVar.f3634b, my.m7239a(fkVar.f3635c));
        } catch (UnsupportedEncodingException e) {
            str = new String(fkVar.f3634b);
        }
        return jk.m6885a(str, my.m7238a(fkVar));
    }

    protected /* synthetic */ void m6216a(Object obj) {
        m6217a((String) obj);
    }

    protected void m6217a(String str) {
        this.f3512a.m6607a(str);
    }
}
