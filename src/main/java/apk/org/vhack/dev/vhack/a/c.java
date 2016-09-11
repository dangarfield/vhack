package org.vhack.dev.vhack.a;

/* compiled from: IabException */
public class c extends Exception {
    n a;

    public c(n nVar) {
        this(nVar, null);
    }

    public c(int i, String str) {
        this(new n(i, str));
    }

    public c(n nVar, Exception exception) {
        super(nVar.a(), exception);
        this.a = nVar;
    }

    public c(int i, String str, Exception exception) {
        this(new n(i, str), exception);
    }

    public n a() {
        return this.a;
    }
}
