package org.vhack.dev.vhack;

import android.widget.Toast;
import org.vhack.dev.vhack.p053a.IabHelper;
import org.vhack.dev.vhack.p053a.IabResult;

/* compiled from: BuyActivity */
class ap implements IabHelper {
    final /* synthetic */ BuyActivity f5275a;

    ap(BuyActivity buyActivity) {
        this.f5275a = buyActivity;
    }

    public void m9075a(IabResult iabResult) {
        if (!iabResult.m9061b()) {
            Toast.makeText(this.f5275a, 2131165377, 1).show();
        }
    }
}
