package org.vhack.dev.vhack;

import android.util.Log;
import android.widget.Toast;
import org.vhack.dev.vhack.a.i;
import org.vhack.dev.vhack.a.n;
import org.vhack.dev.vhack.a.o;

/* compiled from: BuyActivity */
class aj implements i {
    final /* synthetic */ BuyActivity a;

    aj(BuyActivity buyActivity) {
        this.a = buyActivity;
    }

    public void a(o oVar, n nVar) {
        if (nVar.b()) {
            Log.d("CONSUME", "SUCCESS");
            Toast.makeText(this.a, 2131165416, 1).show();
        }
    }
}
