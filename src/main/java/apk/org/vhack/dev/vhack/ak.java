package org.vhack.dev.vhack;

import android.util.Log;
import org.vhack.dev.vhack.a.k;
import org.vhack.dev.vhack.a.n;
import org.vhack.dev.vhack.a.o;

/* compiled from: BuyActivity */
class ak implements k {
    final /* synthetic */ BuyActivity a;

    ak(BuyActivity buyActivity) {
        this.a = buyActivity;
    }

    public void a(n nVar, o oVar) {
        if (nVar.c()) {
            Log.d("PURCHASEERROR", "FAILED");
        } else if (oVar.a().equals(BuyActivity.l[this.a.G - 1])) {
            this.a.A.a(oVar, this.a.H);
            Log.d("PURCHASEERROR", "SUCCESS");
        }
    }
}
