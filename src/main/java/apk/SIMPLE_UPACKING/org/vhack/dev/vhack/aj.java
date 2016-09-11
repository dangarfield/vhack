package org.vhack.dev.vhack;

import android.util.Log;
import android.widget.Toast;
import org.vhack.dev.vhack.p053a.IabHelper;
import org.vhack.dev.vhack.p053a.IabResult;
import org.vhack.dev.vhack.p053a.Purchase;

/* compiled from: BuyActivity */
class aj implements IabHelper {
    final /* synthetic */ BuyActivity f5269a;

    aj(BuyActivity buyActivity) {
        this.f5269a = buyActivity;
    }

    public void m9073a(Purchase purchase, IabResult iabResult) {
        if (iabResult.m9061b()) {
            Log.d("CONSUME", "SUCCESS");
            Toast.makeText(this.f5269a, 2131165416, 1).show();
        }
    }
}
