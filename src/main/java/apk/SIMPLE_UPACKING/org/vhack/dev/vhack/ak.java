package org.vhack.dev.vhack;

import android.util.Log;
import org.vhack.dev.vhack.p053a.IabHelper;
import org.vhack.dev.vhack.p053a.IabResult;
import org.vhack.dev.vhack.p053a.Purchase;

/* compiled from: BuyActivity */
class ak implements IabHelper {
    final /* synthetic */ BuyActivity f5270a;

    ak(BuyActivity buyActivity) {
        this.f5270a = buyActivity;
    }

    public void m9074a(IabResult iabResult, Purchase purchase) {
        if (iabResult.m9062c()) {
            Log.d("PURCHASEERROR", "FAILED");
        } else if (purchase.m9063a().equals(BuyActivity.f5004l[this.f5270a.f5011G - 1])) {
            this.f5270a.f5005A.m9049a(purchase, this.f5270a.f5012H);
            Log.d("PURCHASEERROR", "SUCCESS");
        }
    }
}
