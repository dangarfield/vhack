package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/* compiled from: RankingActivity */
class ex implements OnClickListener {
    final /* synthetic */ Button f5423a;
    final /* synthetic */ Button f5424b;
    final /* synthetic */ RankingActivity f5425c;

    ex(RankingActivity rankingActivity, Button button, Button button2) {
        this.f5425c = rankingActivity;
        this.f5423a = button;
        this.f5424b = button2;
    }

    public void onClick(View view) {
        this.f5423a.setEnabled(false);
        this.f5424b.setEnabled(false);
        new ez(this.f5425c).execute(new String[]{"http://vhack.biz/api/v3/vh_ranking.php?user=" + this.f5425c.f5158n + "&pass=" + this.f5425c.f5159o});
    }
}
