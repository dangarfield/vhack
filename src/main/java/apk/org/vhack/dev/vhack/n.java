package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BonusBoxActivity */
class n implements OnClickListener {
    final /* synthetic */ BonusBoxActivity a;

    n(BonusBoxActivity bonusBoxActivity) {
        this.a = bonusBoxActivity;
    }

    public void onClick(View view) {
        new p(this.a).execute(new String[0]);
    }
}
