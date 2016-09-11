package com.google.android.gms.common.api.internal;

abstract class am {
    private final ak f4188a;

    protected am(ak akVar) {
        this.f4188a = akVar;
    }

    protected abstract void m7391a();

    public final void m7392a(al alVar) {
        alVar.f4181i.lock();
        try {
            if (alVar.f4186n == this.f4188a) {
                m7391a();
                alVar.f4181i.unlock();
            }
        } finally {
            alVar.f4181i.unlock();
        }
    }
}
