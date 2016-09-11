package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: GameActivity */
class bu implements OnClickListener {
    final /* synthetic */ GameActivity f5316a;

    bu(GameActivity gameActivity) {
        this.f5316a = gameActivity;
    }

    public void onClick(View view) {
        if (this.f5316a.f5069w.getText().toString().toLowerCase().equals(this.f5316a.getString(2131165357).toLowerCase())) {
            this.f5316a.f5069w.setText(this.f5316a.getString(2131165354));
            this.f5316a.f5063q.setVisibility(8);
            this.f5316a.f5064r.setVisibility(0);
            return;
        }
        this.f5316a.f5069w.setText(this.f5316a.getString(2131165357));
        this.f5316a.f5063q.setVisibility(0);
        this.f5316a.f5064r.setVisibility(8);
    }
}
