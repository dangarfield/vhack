package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/* compiled from: RankingActivity */
class ey implements OnClickListener {
    final /* synthetic */ Button f5426a;
    final /* synthetic */ Button f5427b;
    final /* synthetic */ RankingActivity f5428c;

    ey(RankingActivity rankingActivity, Button button, Button button2) {
        this.f5428c = rankingActivity;
        this.f5426a = button;
        this.f5427b = button2;
    }

    public void onClick(View view) {
        this.f5426a.setEnabled(false);
        this.f5427b.setEnabled(false);
        new fa(this.f5428c).execute(new String[]{"http://vhack.biz/api/v3/vh_rankingCluster.php?user=" + this.f5428c.f5158n + "&pass=" + this.f5428c.f5159o});
    }
}
