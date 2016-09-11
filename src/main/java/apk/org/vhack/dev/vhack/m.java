package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BonusBoxActivity */
class m implements OnClickListener {
    final /* synthetic */ BonusBoxActivity a;

    m(BonusBoxActivity bonusBoxActivity) {
        this.a = bonusBoxActivity;
    }

    public void onClick(View view) {
        new o(this.a).execute(new String[0]);
    }
}
