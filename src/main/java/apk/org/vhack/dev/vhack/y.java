package org.vhack.dev.vhack;

import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: BotnetActivity */
class y implements Runnable {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public void run() {
        ((TextView) this.a.b.a.a.findViewById(2131558611)).setText("Attacking.. " + this.a.a + "%");
        ProgressBar progressBar = (ProgressBar) this.a.b.a.a.findViewById(2131558610);
        progressBar.setProgress(progressBar.getProgress() + 1);
    }
}
