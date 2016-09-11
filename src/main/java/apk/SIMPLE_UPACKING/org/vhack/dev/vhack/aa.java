package org.vhack.dev.vhack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class aa implements OnClickListener {
    final /* synthetic */ BotnetActivity f5255a;

    aa(BotnetActivity botnetActivity) {
        this.f5255a = botnetActivity;
    }

    public void onClick(View view) {
        int i = 100;
        TextView textView = (TextView) this.f5255a.f5483a.findViewById(2131558620);
        int round = Math.round((float) ((this.f5255a.f5483a.f5002x * 100) / 28));
        if (round <= 100) {
            i = round;
        }
        textView.setText("Success chance: " + i + "%");
        this.f5255a.f5483a.findViewById(2131558614).setVisibility(0);
    }
}
