package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class aa implements OnClickListener {
    final /* synthetic */ q a;

    aa(q qVar) {
        this.a = qVar;
    }

    public void onClick(View view) {
        int i = 100;
        TextView textView = (TextView) this.a.a.findViewById(2131558620);
        int round = Math.round((float) ((this.a.a.x * 100) / 28));
        if (round <= 100) {
            i = round;
        }
        textView.setText("Success chance: " + i + "%");
        this.a.a.findViewById(2131558614).setVisibility(0);
    }
}
