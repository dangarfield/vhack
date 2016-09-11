package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class u implements OnClickListener {
    final /* synthetic */ q a;

    u(q qVar) {
        this.a = qVar;
    }

    public void onClick(View view) {
        int i = 100;
        TextView textView = (TextView) this.a.a.findViewById(2131558611);
        int round = Math.round((float) ((this.a.a.x * 100) / 8));
        if (round <= 100) {
            i = round;
        }
        textView.setText("Success chance: " + i + "%");
        this.a.a.findViewById(2131558605).setVisibility(0);
    }
}
