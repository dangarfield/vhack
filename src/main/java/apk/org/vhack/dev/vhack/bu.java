package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: GameActivity */
class bu implements OnClickListener {
    final /* synthetic */ GameActivity a;

    bu(GameActivity gameActivity) {
        this.a = gameActivity;
    }

    public void onClick(View view) {
        if (this.a.w.getText().toString().toLowerCase().equals(this.a.getString(2131165357).toLowerCase())) {
            this.a.w.setText(this.a.getString(2131165354));
            this.a.q.setVisibility(8);
            this.a.r.setVisibility(0);
            return;
        }
        this.a.w.setText(this.a.getString(2131165357));
        this.a.q.setVisibility(0);
        this.a.r.setVisibility(8);
    }
}
