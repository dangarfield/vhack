package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: SnackbarManager */
class bh {
    private static bh f360a;
    private final Object f361b;
    private final Handler f362c;
    private bk f363d;
    private bk f364e;

    static bh m558a() {
        if (f360a == null) {
            f360a = new bh();
        }
        return f360a;
    }

    private bh() {
        this.f361b = new Object();
        this.f362c = new Handler(Looper.getMainLooper(), new bi(this));
    }

    public void m567a(bj bjVar, int i) {
        synchronized (this.f361b) {
            if (m564f(bjVar)) {
                m561a(this.f363d, i);
            } else if (m565g(bjVar)) {
                m561a(this.f364e, i);
            }
        }
    }

    public void m566a(bj bjVar) {
        synchronized (this.f361b) {
            if (m564f(bjVar)) {
                this.f363d = null;
                if (this.f364e != null) {
                    m562b();
                }
            }
        }
    }

    public void m568b(bj bjVar) {
        synchronized (this.f361b) {
            if (m564f(bjVar)) {
                m560a(this.f363d);
            }
        }
    }

    public void m569c(bj bjVar) {
        synchronized (this.f361b) {
            if (m564f(bjVar)) {
                this.f362c.removeCallbacksAndMessages(this.f363d);
            }
        }
    }

    public void m570d(bj bjVar) {
        synchronized (this.f361b) {
            if (m564f(bjVar)) {
                m560a(this.f363d);
            }
        }
    }

    public boolean m571e(bj bjVar) {
        boolean z;
        synchronized (this.f361b) {
            z = m564f(bjVar) || m565g(bjVar);
        }
        return z;
    }

    private void m562b() {
        if (this.f364e != null) {
            this.f363d = this.f364e;
            this.f364e = null;
            bj bjVar = (bj) this.f363d.f366a.get();
            if (bjVar != null) {
                bjVar.m572a();
            } else {
                this.f363d = null;
            }
        }
    }

    private boolean m561a(bk bkVar, int i) {
        bj bjVar = (bj) bkVar.f366a.get();
        if (bjVar == null) {
            return false;
        }
        this.f362c.removeCallbacksAndMessages(bkVar);
        bjVar.m573a(i);
        return true;
    }

    private boolean m564f(bj bjVar) {
        return this.f363d != null && this.f363d.m576a(bjVar);
    }

    private boolean m565g(bj bjVar) {
        return this.f364e != null && this.f364e.m576a(bjVar);
    }

    private void m560a(bk bkVar) {
        if (bkVar.f367b != -2) {
            int i = 2750;
            if (bkVar.f367b > 0) {
                i = bkVar.f367b;
            } else if (bkVar.f367b == -1) {
                i = 1500;
            }
            this.f362c.removeCallbacksAndMessages(bkVar);
            this.f362c.sendMessageDelayed(Message.obtain(this.f362c, 0, bkVar), (long) i);
        }
    }

    private void m563b(bk bkVar) {
        synchronized (this.f361b) {
            if (this.f363d == bkVar || this.f364e == bkVar) {
                m561a(bkVar, 2);
            }
        }
    }
}
