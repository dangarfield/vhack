package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/* compiled from: RankingActivity */
class ex implements OnClickListener {
    final /* synthetic */ Button a;
    final /* synthetic */ Button b;
    final /* synthetic */ RankingActivity c;

    ex(RankingActivity rankingActivity, Button button, Button button2) {
        this.c = rankingActivity;
        this.a = button;
        this.b = button2;
    }

    public void onClick(View view) {
        this.a.setEnabled(false);
        this.b.setEnabled(false);
        new ez(this.c).execute(new String[]{"http://vhack.biz/api/v3/vh_ranking.php?user=" + this.c.n + "&pass=" + this.c.o});
    }
}
