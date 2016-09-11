package org.vhack.dev.vhack.p053a;

/* renamed from: org.vhack.dev.vhack.a.c */
public class IabException extends Exception {
    IabResult f5216a;

    public IabException(IabResult iabResult) {
        this(iabResult, null);
    }

    public IabException(int i, String str) {
        this(new IabResult(i, str));
    }

    public IabException(IabResult iabResult, Exception exception) {
        super(iabResult.m9060a(), exception);
        this.f5216a = iabResult;
    }

    public IabException(int i, String str, Exception exception) {
        this(new IabResult(i, str), exception);
    }

    public IabResult m9037a() {
        return this.f5216a;
    }
}
